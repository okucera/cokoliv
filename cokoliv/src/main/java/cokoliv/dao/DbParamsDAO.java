package cokoliv.dao;

import cokoliv.databobjects.User;
import cokoliv.enumerate.MessageCodes;
import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.support.Constants;
import cokoliv.support.StringOperations;

public class DbParamsDAO extends BasicDAO {
	public boolean getFirstTimeLoginParam(User user) throws CokolivApplicationException{
		String value = getDbParam(Constants.GET_FIRST_TIME_LOGIN_PARAM, Constants.REPLACE_LOGIN_KEY, user.getLogin(), "firstLogon");
		if(!StringOperations.getInstance().isNullOrEmpty(value) && value.equals("1")){
			return true;
		}
		return false;
	}
	
	public void clearLoginCounter(String userId) throws CokolivApplicationException{
		setDbParam(Constants.CLEAR_LOGIN_COUNTER_SQL, Constants.REPLACE_USER_ID_KEY, userId);
	}
	
	public void incrementLoginCounter(User user) throws CokolivApplicationException {
		user.setLoginCounter(user.getLoginCounter()+1);
		String[] keys = {Constants.REPLACE_LOGIN_COUNTER_VALUE_KEY, Constants.REPLACE_LOGIN_KEY};
		String[] values = {user.getLoginCounter()+"", user.getLogin()};
		setDbParams(Constants.SET_LOGIN_COUNTER_SQL, keys, values);
	}



	private String getDbParam(String sqlCode, String paramKey, String paramValue, String column) throws CokolivApplicationException {
		String[] keys = {paramKey};
		String[] values = {paramValue};
		String query = getReplacedQuery(sqlCode, keys, values);
		
		rs = sql.executeQuery(query);
		
		//Vyber dat pro konstrukci menu
		String[] param = sql.getColumnFromRS(rs, column);
			
		if(param.length > 0){
			return param[0];
		}

		//parametr nenalezen
		throw new CokolivApplicationException(MessageCodes.HLA017, "Empty column \""+column+"\" in query \""+query+"\".");
	}
	
	private void setDbParam(String sqlCode, String paramKey, String paramValue) throws CokolivApplicationException {
		String[] keys = {paramKey};
		String[] values = {paramValue};
		String query = getReplacedQuery(sqlCode, keys, values);
		
		sql.execute(query);
	}
	
	private void setDbParams(String sqlCode, String[] keys, String[] values) throws CokolivApplicationException {
		String query = getReplacedQuery(sqlCode, keys, values);
		
		sql.execute(query);
	}
}
