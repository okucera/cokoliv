package cokoliv.exceptions;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import cokoliv.enumerate.MessageCodes;
import cokoliv.support.Constants;
import cokoliv.support.PropertyManager;

public class CokolivApplicationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5264853549893723226L;
	
	private MessageCodes error;
	private String errLoggerFilename;
	private Object data;
	
	public CokolivApplicationException(MessageCodes errCode){
		super(errCode.getErrorMessage());
		initException(errCode,null);
		logError();		
	}
	
	public CokolivApplicationException(MessageCodes errCode, Object data){
		super(errCode.getErrorMessage());
		initException(errCode,data);
		logError();		
	}
	
	private void initException(MessageCodes errCode, Object data){
		PropertyManager props = new PropertyManager();
		this.errLoggerFilename = props.getProperty(Constants.ERROR_LOG_FILE);
		this.data = data;
		this.error = errCode;
	}
	
	private void logError(){
		Logger errLogger = Logger.getLogger("ErrorLogger");
		try {
			FileHandler fh = new FileHandler(errLoggerFilename,true);
			fh.setFormatter(new SimpleFormatter());
			errLogger.addHandler(fh);
			errLogger.log(Level.SEVERE, "Error| code="+this.error.getErrorCode());
			errLogger.log(Level.SEVERE, "Message| "+this.error.getErrorMessage());
			errLogger.log(Level.SEVERE, "Data| "+this.data.toString());
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public MessageCodes getEnumMessageCode(){
		return this.error;
	}
}
