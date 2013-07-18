package cokoliv.flowdata;

import cokoliv.databobjects.LoggedUser;

public class LoginUserFlowData extends FlowData {
	private String username = null;
	private String password64 = null;
	private LoggedUser loggedUser = null;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword64() {
		return password64;
	}

	public void setPassword64(String password64) {
		this.password64 = password64;
	}

	public LoggedUser getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(LoggedUser loggedUser) {
		this.loggedUser = loggedUser;
	}
	
}
