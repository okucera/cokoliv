package cokoliv.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cokoliv.enumerate.MessageCodes;
import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.support.Constants;
import cokoliv.support.StringOperations;

public class SqlManager {
	public Connection con;
	private String url,username,pwd;
	//private Messages messages = new Messages();
	
	public SqlManager(String url, String username, String pwd){
		this.url = url;
		this.username = username;
		this.pwd=pwd;
	}

	public SqlManager(){		
		SqlAccountManager sqlAcc = new SqlAccountManager();		
		StringOperations str = StringOperations.getInstance();
		
		this.url = sqlAcc.getProperty("JDBC_URL");
		this.username = sqlAcc.getProperty("USERNAME");
		
		this.pwd = str.base64DecodedString(sqlAcc.getProperty("PWD"));
				
	}
	
	public void close(){
		try {
			this.con.close();
		} catch (SQLException e) {
			SqlLogger.getInstance().logError("close| "+MessageCodes.HLA011.getErrorMessage());
		}
	}
	
	public String[] getColumnFromRS(ResultSet rs, String colName){
		ArrayList<String> list = new ArrayList<String>();
		try{
			while(rs.next()){
				if(rs.getObject(colName)!=null){
					list.add(rs.getObject(colName).toString());
				}else{
					list.add("");
				}
			}
			//rs.beforeFirst();
		}catch(SQLException e){
			SqlLogger.getInstance().logError("getColumnFromRS| Chyba při převodu sloupce: "+colName+" na pole hodnot.");
		}catch(NullPointerException e){
			list.add("");			
		}finally{
			try {
				rs.beforeFirst();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list.toArray(new String[list.size()]); 
	}

	
	public boolean execute(String sql) throws CokolivApplicationException{
		Statement stmt=null;
		boolean retValue=false;
		
		if(sqlConnect()){
			try {
				stmt = this.con.createStatement();
				stmt.execute(sql);
				retValue=true;
			} catch (SQLException e) {
				SqlLogger.getInstance().logError("execute| "+MessageCodes.HLA012.getErrorMessage()+" "+sql+": "+e.getMessage());
				throw new CokolivApplicationException(MessageCodes.HLA012, sql);
			}
		}
		return retValue;
		
	}
	
	public ResultSet executeQuery(String sql) throws CokolivApplicationException{
		Statement stmt=null;
		ResultSet rs=null;
		
		if(sqlConnect()){
			try {
				stmt = this.con.createStatement();
				rs = stmt.executeQuery(sql);
				return rs;
			} catch (SQLException e) {				
				SqlLogger.getInstance().logError("executeQuery| "+MessageCodes.HLA012.getErrorMessage()+" "+sql+": "+e.getMessage());
				throw new CokolivApplicationException(MessageCodes.HLA012, sql);
			}
		}else{
			throw new CokolivApplicationException(MessageCodes.HLA013, sql);
		}
	}
	
	private boolean sqlConnect(){
		boolean retValue=false;
		try {			
			Class.forName("com.mysql.jdbc.Driver");
			this.con = DriverManager.getConnection(this.url,this.username,this.pwd);
			
		    //Display URL and connection information
		    System.out.println("URL: " + this.url);
		    System.out.println("Connection: " + this.con);
		    
		    retValue=true;
		}catch(Exception e){
			SqlLogger.getInstance().logError("sqlConnect| "+MessageCodes.HLA013.getErrorMessage()+" "+this.url+". "+MessageCodes.HLA014.getErrorMessage());			
		}
		
		return retValue;
	}
	

	public boolean writeSql(String[] params, int option) throws CokolivApplicationException{
		String query="";
		
		switch(option){
		case Constants.SQL_QUERY_INSERT_NEWS_OPTION:
			if(params.length==3)
				query = "INSERT INTO novinky(date,time,title,text,img_url) VALUES (CURDATE(),CURTIME(),'"+params[0]+"','"+params[1]+"','"+params[2]+"')";
			break;
		case Constants.SQL_QUERY_INSERT_CONCERT_OPTION:
			if(params.length==3)
				query = "INSERT INTO concerts(date,time,title,text,img_url) VALUES (CURDATE(),CURTIME(),'"+params[0]+"','"+params[1]+"','"+params[2]+"')";
			break;
			
		}
		if(!StringOperations.getInstance().isNullOrEmpty(query))
			return execute(query);
		else
			return false;
	}	
}
