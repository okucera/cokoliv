package cokoliv.flowdata;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;

import cokoliv.databobjects.LoggedUser;
import cokoliv.enumerate.UploadRepositories;

public class UploadFileData extends FlowData {
	//REQUIRED ATTRIBUTES
	private boolean onResultLoadAsStream = false;
	private int maxFileSize = 50*1024;	// maximum file size to be uploaded.
	private int maxMemSize = 4*1024;   	// maximum size that will be stored in memory
	private UploadRepositories repository;
	private HttpServletRequest request;
	
	//PARAMETERES TO SET IN FLOW
	private String filename;
	private String fileType;
	private long fileSize;
	
	public boolean isOnResultLoadAsStream() {
		return onResultLoadAsStream;
	}
	public void setOnResultLoadAsStream(boolean onResultLoadAsStream) {
		this.onResultLoadAsStream = onResultLoadAsStream;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public int getMaxFileSize() {
		return maxFileSize;
	}
	public void setMaxFileSize(int maxFileSize) {
		this.maxFileSize = maxFileSize;
	}
	public int getMaxMemSize() {
		return maxMemSize;
	}
	public void setMaxMemSize(int maxMemSize) {
		this.maxMemSize = maxMemSize;
	}
	public UploadRepositories getRepository() {
		return repository;
	}
	public void setRepository(UploadRepositories repository) {
		this.repository = repository;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
