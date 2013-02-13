package cokoliv.support;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import cokoliv.servlet.ServletLogger;

public class PropertyManager {
	protected Properties properties;
	private String filename = "props.properties";
	private final String FILE_NOT_FOUND_ERROR = "Soubor nebyl nalezen.";
	private final String PROPERTY_LOADING_ERROR = "Během otevírání souboru s nastavením došlo k chybě.";
	
	public PropertyManager(){
		loadDefaultPropertyFile();
	}
	
	public PropertyManager(String filename){
		loadPropertyFile(filename);
	}
	
	private void loadPropertyFile(String filename){
		properties = new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream(filename));
		} catch (FileNotFoundException e) {
			ServletLogger.getInstance().logError(this.FILE_NOT_FOUND_ERROR+filename);	
		} catch (IOException e) {
			ServletLogger.getInstance().logError(this.PROPERTY_LOADING_ERROR+filename);
		}		
	}
	
	private void loadDefaultPropertyFile(){
		properties = new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream(this.filename));
		} catch (FileNotFoundException e) {
			ServletLogger.getInstance().logError(this.FILE_NOT_FOUND_ERROR+this.filename);	
		} catch (IOException e) {
			ServletLogger.getInstance().logError(this.PROPERTY_LOADING_ERROR+this.filename);
		}		
	}
		
	public String getProperty(String key){
		return properties.getProperty(key);
	}
}
