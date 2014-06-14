package edu.emory.cci.bindaas.commons.cxf.bundle;

import java.util.logging.Level;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.common.logging.Log4jLogger;
import org.apache.cxf.common.logging.LogUtils;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private Log log = LogFactory.getLog(getClass());

	public static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		log.debug(String.format("Starting Bundle [%s]", context.getBundle().getSymbolicName()));
		configureCXFLogger() ;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}
	
	private void configureCXFLogger(){
		LogUtils.setLoggerClass( Log4jLogger.class);
		LogUtils.getLogger(getClass()).setLevel(Level.ALL);
	}

}
