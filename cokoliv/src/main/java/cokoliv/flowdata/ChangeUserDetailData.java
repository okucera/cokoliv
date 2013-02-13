package cokoliv.flowdata;

import cokoliv.databobjects.LoggedUser;

public class ChangeUserDetailData extends FlowData {
	private LoggedUser userToStore;
	private String newPassword;
	private String retypedNewPassword;

	public LoggedUser getUserToStore() {
		return userToStore;
	}

	public void setUserToStore(LoggedUser userToStore) {
		this.userToStore = userToStore;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRetypedNewPassword() {
		return retypedNewPassword;
	}

	public void setRetypedNewPassword(String retypedNewPassword) {
		this.retypedNewPassword = retypedNewPassword;
	}
	
	
}
