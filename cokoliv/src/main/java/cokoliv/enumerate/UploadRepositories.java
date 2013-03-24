package cokoliv.enumerate;

import cokoliv.support.PropertyManager;

public enum UploadRepositories {
	DEFAULT_IMAGES_UPLOAD_REPOSITORY("DEFAULT_IMAGES_UPLOAD_REPOSITORY", 1000*1024, 4*1024),
	NEWS_IMAGES_UPLOAD_REPOSITORY("NEWS_IMAGES_UPLOAD_REPOSITORY",1000*1024,4*1024);
	
	private String repositoryPath;
	private int maxSizeInBytes;
	private int maxMemSize;
	
	private PropertyManager repositories = new PropertyManager("repositories.properties");
	
	UploadRepositories(String name, int maxSizeInBytes, int maxMemSize){
		this.repositoryPath = repositories.getProperty(name);
		this.maxSizeInBytes = maxSizeInBytes;
	}

	public String getRepositoryPath() {
		return repositoryPath;
	}
	
	public int getMaxSizeInBytes() {
		return this.maxSizeInBytes;
	}
	
	public int getMaxMemSize() {
		return maxMemSize;
	}
}
