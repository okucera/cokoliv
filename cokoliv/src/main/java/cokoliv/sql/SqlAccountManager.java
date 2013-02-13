package cokoliv.sql;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

import cokoliv.support.PropertyManager;

public class SqlAccountManager extends PropertyManager{	
	public SqlAccountManager(){
		super("sql_private.properties");
	}
			
	@SuppressWarnings("unchecked")
	public Enumeration<String> getPropertyKeys(){
		Enumeration<String> keys = (Enumeration<String>) this.properties.propertyNames();
		Vector<String> keyList = new Vector<String>();
		while(keys.hasMoreElements()){
			keyList.add(keys.nextElement().toString());
		}
		Collections.sort(keyList);
		
		return keyList.elements();
	}
	
}
