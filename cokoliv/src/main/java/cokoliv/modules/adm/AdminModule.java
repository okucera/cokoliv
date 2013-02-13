package cokoliv.modules.adm;

import cokoliv.dao.DbParamsDAO;
import cokoliv.dao.UsersDAO;
import cokoliv.databobjects.LoggedUser;
import cokoliv.databobjects.User;
import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.flowdata.ChangeUserDetailData;
import cokoliv.support.Constants;

public class AdminModule implements IAdminModule {
	/**
	 * ADM001: Ziskej prava uzivatele
	 * Pri loginu nacte prava uzivatele
	 * Mozne hodnoty jsou v enumu UserRightsEnum
	 * 	ADMIN
	 *	USER
	 *	SUPERUSER
	 */
	@Override
	public boolean checkAdminUserRights(LoggedUser user) {	
		return false;
	}

	@Override
	public User getUserByLogin(String login) throws CokolivApplicationException{
		UsersDAO dao = new UsersDAO();
		return dao.getUserByLogin(login);
	}

	@Override
	public boolean compareLoginPassword(User user, String login, String pwd){
		boolean match = user.getLogin().equals(login) && user.getPassword().equals(pwd);
		return match;
	}
	
	@Override
	public void incrementLoginCounter(User user) throws CokolivApplicationException{
		DbParamsDAO dao = new DbParamsDAO();
		dao.incrementLoginCounter(user);
	}

	@Override
	public void clearLoginCounter(int userId) throws CokolivApplicationException {
		DbParamsDAO dao = new DbParamsDAO();
		dao.clearLoginCounter(userId);
	}

	@Override
	public LoggedUser getLoggedUserInfo(User user) throws CokolivApplicationException {
		UsersDAO dao = new UsersDAO();
		return dao.getLoggedUserInfo(user);
	}

	@Override
	public boolean getFirstTimeLoginParametr(User user) throws CokolivApplicationException {
		DbParamsDAO dao = new DbParamsDAO();
		return dao.getFirstTimeLoginParam(user);
	}

	@Override
	public boolean isUserBlocked(User user) {
		int maxValue = Constants.MAX_FAIL_LOGIN_COUNT;
		return user.getLoginCounter() >= maxValue;
	}

	@Override
	public boolean newPasswordsMatch(String newPwd, String retypedNewPwd) {
		return newPwd.equals(retypedNewPwd);
	}

	@Override
	public void storeUser(ChangeUserDetailData user) throws CokolivApplicationException {
		UsersDAO dao = new UsersDAO();
		dao.storeUser(user);
	}

	




}
