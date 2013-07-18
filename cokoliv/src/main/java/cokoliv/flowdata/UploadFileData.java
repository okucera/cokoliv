package cokoliv.flowdata;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

import cokoliv.databobjects.LoggedUser;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.enumerate.WizzardActionEnum;

public class UploadFileData extends FlowData {
	//REQUIRED ATTRIBUTES
	private boolean onResultLoadAsStream = false;
	private UploadRepositories repository;
	private WizzardActionEnum wizzardAction;
	private List<FileItem> fileItems;
	private boolean makePreview;
	private LoggedUser loggedUser;
	
	//PARAMETERES TO SET IN FLOW
	private List<FileItem> excludedItems;
	private List<FileItem> uploadedItems;
	
	public boolean isOnResultLoadAsStream() {
		return onResultLoadAsStream;
	}
	public void setOnResultLoadAsStream(boolean onResultLoadAsStream) {
		this.onResultLoadAsStream = onResultLoadAsStream;
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
	public List<FileItem> getFileItems() {
		return fileItems;
	}
	public void setFileItems(List<FileItem> fileItems) {
		this.fileItems = fileItems;
	}
	public List<FileItem> getExcludedItems() {
		return excludedItems;
	}
	public void setExcludedItems(List<FileItem> excludedItems) {
		this.excludedItems = excludedItems;
	}
	public List<FileItem> getUploadedItems() {
		return uploadedItems;
	}
	public void setUploadedItems(List<FileItem> uploadedItems) {
		this.uploadedItems = uploadedItems;
	}
	public boolean isMakePreview() {
		return makePreview;
	}
	public void setMakePreview(boolean makePreview) {
		this.makePreview = makePreview;
	}
	public LoggedUser getLoggedUser() {
		return loggedUser;
	}
	public void setLoggedUser(LoggedUser loggedUser) {
		this.loggedUser = loggedUser;
	}
}
