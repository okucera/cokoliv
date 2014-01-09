package cokoliv.modules.adm.ftp;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

public class CokolivFTPClient extends FTPClient {
	private FTPConfig config;
	
	public CokolivFTPClient(){
		super();
		config = new FTPConfig();
	}
	
	public void connect() throws IOException {
		super.connect(config.getFtpHostname());
		super.login(config.getLogin(), config.getPassword());
	}
	
	
}
