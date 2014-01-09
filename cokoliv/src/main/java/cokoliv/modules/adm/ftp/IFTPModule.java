package cokoliv.modules.adm.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import cokoliv.enumerate.UploadRepositories;

public interface IFTPModule {
	//public boolean uploadFile(FileInputStream file, UploadRepositories repository);
	public boolean uploadFiles(Map<String, FileInputStream> files, UploadRepositories repository);
	public File downloadFile();
}
