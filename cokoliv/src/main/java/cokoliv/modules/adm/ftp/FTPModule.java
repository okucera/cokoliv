package cokoliv.modules.adm.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import cokoliv.enumerate.UploadRepositories;

public class FTPModule implements IFTPModule {
	private CokolivFTPClient ftp;
	
	public boolean uploadFiles(Map<String, FileInputStream> files, UploadRepositories repository) {
		boolean fileUploadedSuccess = true;
		if(files.keySet().size() > 0) {
			//TODO - log connection
			try{
				ftp = new CokolivFTPClient();
				ftp.connect();

				for(String key : files.keySet()){
					FileInputStream file = files.get(key);
					String filename = repository.getRepositoryPath() + key;
					fileUploadedSuccess &= uploadFile(file, filename);
				}
				ftp.logout();
				//TODO - log file uploaded
			}catch(IOException ioe){
				ioe.printStackTrace();
			}finally{				
				try {
					ftp.disconnect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ftp=null;
		}
		return fileUploadedSuccess;
	}
	
	private boolean uploadFile(FileInputStream file, String filename) throws IOException{
		if(ftp.isConnected()){
			return ftp.storeFile(filename, file);
		}
		return false;
	}
	
	public File downloadFile() {
		// TODO Auto-generated method stub
		return null;
	}

}
