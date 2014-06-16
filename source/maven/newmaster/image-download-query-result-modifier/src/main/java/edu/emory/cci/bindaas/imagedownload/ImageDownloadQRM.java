package edu.emory.cci.bindaas.imagedownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleContext;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.Expose;

import edu.emory.cci.bindaas.framework.api.IQueryResultModifier;
import edu.emory.cci.bindaas.framework.model.ModifierException;
import edu.emory.cci.bindaas.framework.model.QueryResult;
import edu.emory.cci.bindaas.framework.model.QueryResult.Callback;
import edu.emory.cci.bindaas.framework.model.RequestContext;
import edu.emory.cci.bindaas.framework.model.ResultSetIterator;
import edu.emory.cci.bindaas.framework.provider.exception.AbstractHttpCodeException;
import edu.emory.cci.bindaas.framework.provider.exception.ModifierExecutionFailedException;
import edu.emory.cci.bindaas.framework.util.DocumentationUtil;
import edu.emory.cci.bindaas.framework.util.GSONUtil;
import edu.emory.cci.bindaas.framework.util.StandardMimeType;
import edu.emory.cci.bindaas.imagedownload.bundle.Activator;

public class ImageDownloadQRM implements IQueryResultModifier {

	private static final String IMAGE_LOCATION = "images";
	private Log log = LogFactory.getLog(getClass());
	private static final String DOCUMENTATION_RESOURCES_LOCATION = "documentation";
	private JsonObject documentation;
	
	
	@Override
	public JsonObject getDocumentation() {
		
		return documentation;
	}

	@Override
	public void validate() throws ModifierException {
		
	}
	
	public void init() throws Exception
	{
		BundleContext context = Activator.getContext();
		documentation = DocumentationUtil.getProviderDocumentation(context, DOCUMENTATION_RESOURCES_LOCATION);
		Dictionary<String, String> props = new Hashtable<String, String>();
		props.put("class", getClass().getName());
		context.registerService(IQueryResultModifier.class.getName(), this, props);
	}

	@Override
	public QueryResult modifyQueryResult(final QueryResult queryResult,
			JsonObject dataSource, RequestContext requestContext, final  JsonObject modifierProperties ,  Map<String,String> queryParams)
			throws AbstractHttpCodeException {
		final ImageDownloadQRMProperties props = GSONUtil.getGSONInstance().fromJson(modifierProperties, ImageDownloadQRMProperties.class);
		final ResultSetIterator iterator = queryResult.getIntermediateResult();
		
		
		queryResult.setMimeType(StandardMimeType.ZIP.toString());
		
		Map<String,Object> responseHeaders = new HashMap<String, Object>();
		responseHeaders.put("imageCount", iterator.size() + ""); // Add image count to the responseHeader to provide better heuristic about the download size expected
		responseHeaders.put("Content-Disposition","attachment;filename=\"images-" + iterator.size() + ".zip\"");
		queryResult.setResponseHeaders(responseHeaders);
		
		
		queryResult.setCallback(new Callback() {
			
			@Override
			public void callback(OutputStream servletOutputStream, Properties context) throws AbstractHttpCodeException{
				try{
					
					ZipOutputStream zos = new ZipOutputStream(servletOutputStream);
					ZipEntry imagedDirectory = new ZipEntry(IMAGE_LOCATION + "/");
					zos.putNextEntry(imagedDirectory);
					int counter = 0;
					JsonArray jsonArray = new JsonArray();
					while(iterator.hasNext())
					{
						JsonObject currentRecord = iterator.next();
						
						String imageLink = currentRecord.has(props.imageLinkAttribute) ? currentRecord.get(props.imageLinkAttribute).getAsString() : null;
						if(imageLink!=null)
						{
							File file = new File(imageLink);
							if(file.isFile() && file.canRead())
							{
								String name = counter++  + ".dcm";
								
								String locationToSave = IMAGE_LOCATION + "/"  + name  ;
								// do your magic here
								packImage(file, zos, locationToSave);
								currentRecord.add(props.imageLinkAttribute, new JsonPrimitive(locationToSave));
							}
							else
							{
								currentRecord.add(props.imageLinkAttribute, new JsonPrimitive("error retrieving file"));
							}
						}
						
						jsonArray.add(currentRecord);
					}
					zos.closeEntry();
					
					
					writeBytes(jsonArray.toString(), zos, "results.json");
					zos.close();
				}catch(Exception e)
				{
					log.error(e);
					throw new ModifierExecutionFailedException(getClass().getName(), 1 , e);
				}finally{
					try {
						iterator.close();
					} catch (IOException e) {
						log.fatal("Unable to close ResultSetIterator" , e);
					}
				}
							
			}
		});
		
		return queryResult;
	}

	private void writeBytes(String content, ZipOutputStream zos , String name )
	{
		try {
			ZipEntry entry = new ZipEntry(name);
			zos.putNextEntry(entry);
			
			zos.write(content.getBytes());
			zos.closeEntry();
					} catch (IOException e) {
				log.error(e);
		}
	}
	private void packImage(File image , ZipOutputStream zos , String locationToSave)
	{
		
		try {
			ZipEntry entry = new ZipEntry(locationToSave);
			zos.putNextEntry(entry);
			byte[] buffer = new byte[1024 * 5];

			FileInputStream fis = new FileInputStream(image);
			int bytesRead = -1;
			while ((bytesRead = fis.read(buffer)) != -1) {
				zos.write(buffer, 0, bytesRead);
			}

			zos.closeEntry();
			fis.close();

		} catch (Exception e) {
				log.error(e);
		}

		
	}
	
	public static class ImageDownloadQRMProperties
	{
		@Expose private String imageLinkAttribute;
	}

	@Override
	public String getDescriptiveName() {
		
		return "Stream DICOM images from ResultSet";
	}
}
