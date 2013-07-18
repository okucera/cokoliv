package cokoliv.support;

import cokoliv.databobjects.LoggedUser;
import cokoliv.enumerate.UserRightsEnum;

public class UserHelper {
	public static String LOGGED_USER = "loggedUser";
	public static boolean isLoggedUserAdminOrSuperuser(LoggedUser user){
		return user!=null && UserRightsEnum.checkAdminSuperUserRights(user.getRole());
	}
	
	
}
