package cokoliv.sql;

import cokoliv.support.PropertyManager;

public class SqlPropertyRepository extends PropertyManager{
	
	private static SqlPropertyRepository instance=null;
	
	private SqlPropertyRepository(){
		super("sql_public.properties");
	}
	
	public static synchronized SqlPropertyRepository getInstance(){
		if(instance==null){
			instance = new SqlPropertyRepository();
		}
		return instance;
	}
	
	public String getSqlQuery(String key){
		return properties.getProperty(key);
	}
	
	public String getSongQuery(String key, int id){
		return getSqlQuery(key)+" WHERE id="+id;
	}
	
	public String getDefaultPageQuery(String key,int id){
		return getSqlQuery(key)+" WHERE id="+id;
	}
}
