package cokoliv.servlet;

import java.io.IOException;
import java.util.logging.*;

import cokoliv.support.Constants;
import cokoliv.support.PropertyManager;

public class ServletLogger {
	private Logger logger;
	private static ServletLogger instance = null;
	private PropertyManager property = new PropertyManager();
	
	private ServletLogger(){
		logger = Logger.getLogger(ServletLogger.class.getName());
		try {
			String filename = property.getProperty(Constants.SERVLET_LOG_FILE);
			FileHandler fh = new FileHandler(filename,true);
			fh.setFormatter(new SimpleFormatter());
			logger.addHandler(fh);			
		} catch (SecurityException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}				
	}
	
	public static synchronized ServletLogger getInstance(){
		if(instance==null){
			instance=new ServletLogger();
		}
		return instance;
	}
	
	public void logInfo(String infoText){
		logger.log(Level.INFO,infoText,"INFO");
	}
	
	public void logError(String errMsg){
		logger.log(Level.SEVERE,errMsg,"ERROR");
	}	
	
	
}
