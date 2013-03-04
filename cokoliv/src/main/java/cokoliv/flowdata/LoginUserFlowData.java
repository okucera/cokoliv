package cokoliv.flowdata;

public class LoginUserFlowData extends FlowData {
	private String username = null;
	private String password64 = null;

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
