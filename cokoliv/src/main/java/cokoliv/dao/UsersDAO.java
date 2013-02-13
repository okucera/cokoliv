package cokoliv.dao;

import cokoliv.databobjects.LoggedUser;
import cokoliv.databobjects.Role;
import cokoliv.databobjects.User;
import cokoliv.enumerate.MessageCodes;
import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.flowdata.ChangeUserDetailData;
import cokoliv.support.Constants;

public class UsersDAO extends BasicDAO {

	public User getUserByLogin(String login) throws CokolivApplicationException{
		User user = new User();
		
		String[] replacedKeys = {Constants.REPLACE_LOGIN_KEY};
		String[] replacedKeyValues = {login};
		
		//Vykonani SQL dotazu		
		String query = getReplacedQuery(Constants.GET_USER_SQL, replacedKeys, replacedKeyValues);

		rs = sql.executeQuery(query);
	
		//Vyber dat pro konstrukci menu
		String[] dbLogin = sql.getColumnFromRS(rs, "login");
		String[] dbPassword= sql.getColumnFromRS(rs, "password");
		String[] dbLoginCounter = sql.getColumnFromRS(rs, "loginCounter");
		
		if(dbLogin.length > 0){
			user.setLogin(dbLogin[0]);
		}else{
			//uzivatel nenalezen
			throw new CokolivApplicationException(MessageCodes.HLA015);
		}
		
		if(dbPassword.length > 0){
			user.setPassword(dbPassword[0]);
		}else{
			//TODO - heslo nenalzeno - je to vubec mozne ? 
		}
		
		if(dbLoginCounter.length > 0){
			int loginCounter = Integer.parseInt(dbLoginCounter[0]);
			user.setLoginCounter(loginCounter);
		}else{
			//TODO - parametr citace poctu neuspesnych prihlaseni nenalezen - je to vubec mozne ? 
		}
		return user;
	}
	
	public LoggedUser getLoggedUserInfo(User user) throws CokolivApplicationException{
		LoggedUser loggedUser = new LoggedUser();
		Role role = new Role();
		
		String[] replacedKeys = {Constants.REPLACE_LOGIN_KEY};
		String[] replacedKeyValues = {user.getLogin()};
		String query = getReplacedQuery(Constants.GET_LOGGED_USER_SQL, replacedKeys, replacedKeyValues);
		rs = sql.executeQuery(query);

		//Vyber dat pro konstrukci objektu prihlaseneho uzivatele
		String[] userIds = sql.getColumnFromRS(rs, "user_id");
		String[] firstNames = sql.getColumnFromRS(rs, "first_name");
		String[] lastNames = sql.getColumnFromRS(rs, "last_name");
		String[] nicks = sql.getColumnFromRS(rs, "nick");
		String[] infos = sql.getColumnFromRS(rs, "info");
		String[] imgUrls = sql.getColumnFromRS(rs, "img_url");
		String[] roleIds = sql.getColumnFromRS(rs, "role_id");
		String[] roles = sql.getColumnFromRS(rs, "role");
		String[] descriptions = sql.getColumnFromRS(rs, "description");
		
		int userId = Integer.parseInt(userIds[0]);
		loggedUser.setUserId(userId);
		loggedUser.setFirstName(firstNames[0]);
		loggedUser.setLastName(lastNames[0]);
		loggedUser.setNick(nicks[0]);
		loggedUser.setInfo(infos[0]);
		loggedUser.setImgUrl(imgUrls[0]);
		
		role.setRoleId(Integer.valueOf(roleIds[0]));
		role.setRole(roles[0]);
		role.setRoleDescription(descriptions[0]);
		
		loggedUser.setRole(role);
		
		return loggedUser;
	}
	
	public void storeUser(ChangeUserDetailData user) throws CokolivApplicationException {
		String sqlKey = Constants.UPDATE_USER_SQL;
		String[] replacedKeys = {Constants.REPLACE_USER_FIRST_NAME_KEY, Constants.REPLACE_USER_LAST_NAME_KEY,
				                 Constants.REPLACE_USER_NICK_KEY, Constants.REPLACE_PASSWORD_KEY,
				                 Constants.REPLACE_USER_ID_KEY};
		String[] replacedKeyValues = {user.getUserToStore().getFirstName(), user.getUserToStore().getLastName(), 
									  user.getUserToStore().getNick(), user.getNewPassword(), user.getUserToStore().getUserId()+""};
		String query = getReplacedQuery(sqlKey, replacedKeys, replacedKeyValues);
		
		sql.execute(query);
	}
}
