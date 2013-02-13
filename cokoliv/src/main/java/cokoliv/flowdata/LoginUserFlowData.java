package cokoliv.flowdata;

import cokoliv.databobjects.LoggedUser;

public class LoginUserFlowData extends FlowData {
	private LoggedUser user = null;
	private String username = null;
	private String password64 = null;

	public LoggedUser getUser() {
		return user;
	}

	public void setUser(LoggedUser user) {
		this.user = user;
	}

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
	
}
