package cokoliv.sql;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import cokoliv.support.Constants;
import cokoliv.support.PropertyManager;

public class SqlLogger {
	private Logger logger;
	private static SqlLogger instance = null;
	private PropertyManager properties = new PropertyManager();
	
	private SqlLogger(){
		logger = Logger.getLogger(SqlLogger.class.getName());
		try {
			String filename = this.properties.getProperty(Constants.SQL_LOG_FILE);
			FileHandler fh = new FileHandler(filename,true);
			fh.setFormatter(new SimpleFormatter());
			logger.addHandler(fh);			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized SqlLogger getInstance(){
		if(instance==null){
			instance=new SqlLogger();
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
