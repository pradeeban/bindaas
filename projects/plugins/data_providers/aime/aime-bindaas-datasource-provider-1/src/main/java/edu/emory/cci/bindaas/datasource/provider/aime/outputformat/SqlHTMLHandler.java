package edu.emory.cci.bindaas.datasource.provider.aime.outputformat;

import java.io.ByteArrayInputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import edu.emory.cci.bindaas.framework.model.QueryResult;
import edu.emory.cci.bindaas.framework.util.StandardMimeType;
import edu.emory.cci.bindaas.datasource.provider.aime.bundle.Activator;
import edu.emory.cci.bindaas.datasource.provider.aime.model.OutputFormatProps;
import edu.emory.cci.bindaas.datasource.provider.aime.model.OutputFormatProps.OutputFormat;
import edu.emory.cci.bindaas.datasource.provider.aime.model.OutputFormatProps.QueryType;

public class SqlHTMLHandler implements IFormatHandler {
	
	private String headSectionContent;
	public String getHeadSectionContent() {
		return headSectionContent;
	}

	public void setHeadSectionContent(String headSectionContent) {
		this.headSectionContent = headSectionContent;
	}

	public SqlHTMLHandler()
	{
		Activator.getContext().registerService(IFormatHandler.class.getName(), this, null);
	}
	
	@Override
	public QueryResult format(OutputFormatProps outputFormatProps,
			ResultSet queryResult) throws Exception {
		QueryResult qr = new QueryResult();
		qr.setData( new ByteArrayInputStream(toHTML(queryResult).getBytes()));
		qr.setMimeType(StandardMimeType.HTML.toString());
		return qr;

	}

	@Override
	public QueryType getQueryType() {

		return QueryType.SQL;
	}

	@Override
	public OutputFormat getOutputFormat() {

		return OutputFormat.HTML;
	}
	private String toHTML(java.sql.ResultSet rs)
		    throws Exception {
		 
		 StringBuilder builder = new StringBuilder();
		 builder.append("<HTML>").append(headSectionContent).append("<BODY>");
		 builder.append("<P ALIGN='center'><TABLE id='data' BORDER=1>").append("\n");
		 ResultSetMetaData rsmd = rs.getMetaData();
		 int columnCount = rsmd.getColumnCount();
		 // table header
		 builder.append("<thead>");
		 builder.append("<TR>").append("\n");
		 for (int i = 0; i < columnCount; i++) {
		   builder.append("<TH>" + rsmd.getColumnLabel(i + 1) + "</TH>");
		   }
		 builder.append("</TR>").append("\n");
		 builder.append("</thead>");
		 builder.append("<tbody>");
		 // the data
		 while (rs.next()) {
		 
		  builder.append("<TR>").append("\n");
		  for (int i = 0; i < columnCount; i++) {
		    builder.append("<TD>" + rs.getString(i + 1) + "</TD>");
		    }
		  builder.append("</TR>").append("\n");
		  }
		 builder.append("</tbody>");
		 builder.append("</TABLE></P>");
		 builder.append("</BODY></HTML");
		 return builder.toString();
		}

	@Override
	public void validate(OutputFormatProps outputFormatProps) throws Exception {
		if(outputFormatProps.getOutputFormat()!=OutputFormat.HTML || outputFormatProps.getQueryType() != QueryType.SQL)
			throw new Exception("Incompatible OutputFormat and/or QueryType specified. Expected QueryType =[" + QueryType.SQL + "] and OutputFormat=["+ OutputFormat.HTML + "]");
		if (outputFormatProps.getRootElement() == null)
			throw new Exception("Root XML Element not provided");
	}

}
