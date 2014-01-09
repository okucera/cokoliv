package cokoliv.modules.adm.ftp;

import cokoliv.support.PropertyManager;
import cokoliv.support.StringOperations;

public class FTPConfig extends PropertyManager {
	
	private String hostname;
	private String login;
	private String pwd;
	
	public FTPConfig(){
		super();
		
		hostname=this.getProperty("upload_cred_ftp");
		login=this.getProperty("upload_cred_login");
		pwd=this.getProperty("upload_cred_pwd");
	}
	
	public String getFtpHostname(){
		return StringOperations.getInstance().base64DecodedString(hostname);
	}
	
	public String getLogin(){
		return StringOperations.getInstance().base64DecodedString(login);
	}
	
	public String getPassword(){
		return StringOperations.getInstance().base64DecodedString(pwd);
	}
}
