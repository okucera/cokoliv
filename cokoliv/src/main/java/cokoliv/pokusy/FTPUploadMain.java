package cokoliv.pokusy;

import java.io.FileInputStream;
import java.io.IOException;

import cokoliv.modules.adm.ftp.CokolivFTPClient;

public class FTPUploadMain {
	static String hostname = "ftp.cokoliv-net.cz";
	static String login = "cokoliv-net.cz";
	static String pwd = "cz819465";
	
	public static void main(String[] args){
		CokolivFTPClient client = new CokolivFTPClient();
		try{
			System.out.println("logging in");
			client.connect();
			System.out.println("Storing file");
			String filename="c:/Users/Kuci/Pictures/Soukrome/celeb/Agata/ah_7760.JPG";
			FileInputStream fis = new FileInputStream(filename);
			
			client.storeFile("./www/pokus.jpg", fis);
			
			System.out.println("logging out");
			client.logout();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			try {
				client.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
