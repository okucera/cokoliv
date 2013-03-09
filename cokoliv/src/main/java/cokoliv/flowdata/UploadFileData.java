package cokoliv.flowdata;

import java.io.File;

import cokoliv.enumerate.UploadRepositories;
import cokoliv.enumerate.WizzardActionEnum;

public class UploadFileData extends FlowData {
	//REQUIRED ATTRIBUTES
	private boolean onResultLoadAsStream = false;
	private UploadRepositories repository;
	private WizzardActionEnum wizzardAction;
	private File[] files;
	
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
	public UploadRepositories getRepository() {
		return repository;
	}
	public void setRepository(UploadRepositories repository) {
		this.repository = repository;
	}
	public WizzardActionEnum getWizzardAction() {
		return wizzardAction;
	}
	public void setWizzardAction(WizzardActionEnum wizzardAction) {
		this.wizzardAction = wizzardAction;
	}
	public File[] getFiles() {
		return files;
	}
	public void setFiles(File[] files) {
		this.files = files;
	}
}
