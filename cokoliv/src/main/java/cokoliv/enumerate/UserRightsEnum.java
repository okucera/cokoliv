package cokoliv.enumerate;

import cokoliv.databobjects.Role;

public enum UserRightsEnum {
	ADMIN,
	USER,
	SUPERADMIN;
	
	public static boolean checkAdminSuperUserRights(Role role){
		UserRightsEnum value = valueOf(role.getRole().toUpperCase());
		return value == UserRightsEnum.ADMIN || value == UserRightsEnum.SUPERADMIN;
	}
	
	
}
