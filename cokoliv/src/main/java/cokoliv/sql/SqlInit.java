package cokoliv.sql;

import java.util.Enumeration;

import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.support.Messages;
import cokoliv.support.StringOperations;

public class SqlInit {
	SqlAccountManager sqlAcc = null;
	Messages messages = new Messages();
	StringOperations str = null;
	
	public SqlInit(){
		sqlAcc = new SqlAccountManager();
		str = StringOperations.getInstance();
	}
	
	public boolean createDefaultDatabase(){
		String url = sqlAcc.getProperty("JDBC_URL");
		String uname = sqlAcc.getProperty("USERNAME");
		String pwd = str.base64DecodedString(sqlAcc.getProperty("PWD"));
		
		SqlManager sql=new SqlManager(url,uname,pwd);
		
		boolean retValue = true;
		Enumeration<String> keys = sqlAcc.getPropertyKeys();		
		while(keys.hasMoreElements()){
			String key = keys.nextElement().toString();
			if(key.length() >= SqlConstants.SQL_INIT_STRING.length() && 
			  (key.substring(0,SqlConstants.SQL_INIT_STRING.length())).equals(SqlConstants.SQL_INIT_STRING)){
				System.out.println("provadim: "+key);
				String sql_cmd = sqlAcc.getProperty(key);
				try {
					retValue&=sql.execute(sql_cmd);
				} catch (CokolivApplicationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
		
		sql.close();
		if(!retValue){
			SqlLogger.getInstance().logError("createDefaultDatabase| "+"HLA010");			
		}
		return retValue;
	}
}
