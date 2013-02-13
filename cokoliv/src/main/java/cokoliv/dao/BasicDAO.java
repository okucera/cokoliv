package cokoliv.dao;

import java.sql.ResultSet;
import java.util.HashMap;

import cokoliv.sql.SqlManager;
import cokoliv.sql.SqlPropertyRepository;
import cokoliv.support.StringOperations;

public class BasicDAO {
	//Nastaveni komunikace s DB
	SqlPropertyRepository repository = SqlPropertyRepository.getInstance();
	SqlManager sql = new SqlManager();
	ResultSet rs = null;
	
	protected String getReplacedQuery(String sqlCode, String paramKey, String paramValue){
		String[] param = {paramKey};
		String[] val = {paramValue};
		return getReplacedQuery(sqlCode,param,val);
	}
	
	protected String getReplacedQuery(String sqlCode, String paramKey[], String paramValue[]){
		String query = repository.getSqlQuery(sqlCode);

		HashMap<String, String> replaceMap = new HashMap<String, String>();
		
		for(int i=0; i < paramKey.length; i++){
			String key = paramKey[i];
			String value = paramValue[i];
			
			replaceMap.put(key, value);
		}
		query = StringOperations.getInstance().replaceMap(query, replaceMap);
		return query;
	}
}
