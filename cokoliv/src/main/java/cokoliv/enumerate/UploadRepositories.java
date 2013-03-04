package cokoliv.enumerate;

import cokoliv.support.PropertyManager;

public enum UploadRepositories {
	NEWS_IMAGES_UPLOAD_REPOSITORY("NEWS_IMAGES_UPLOAD_REPOSITORY");
	
	private String repositoryPath;
	private PropertyManager repositories = new PropertyManager("repositories.properties");
	
	UploadRepositories(String name){
		this.repositoryPath = repositories.getProperty(name);
	}

	public String getRepositoryPath() {
		return repositoryPath;
	}
}
