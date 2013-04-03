package cokoliv.enumerate;

import javax.servlet.ServletContext;

import cokoliv.support.PropertyManager;

public enum UploadRepositories {
	DEFAULT_IMAGES_UPLOAD_REPOSITORY("DEFAULT_IMAGES_UPLOAD_REPOSITORY", 1000*1024, 4*1024),
	NEWS_IMAGES_UPLOAD_REPOSITORY("NEWS_IMAGES_UPLOAD_REPOSITORY",1000*1024,4*1024),
	CONCERTS_IMAGE_UPLOAD_REPOSITORY("CONCERTS_IMAGE_UPLOAD_REPOSITORY",1000*1024,4*1024),
	BAND_USERS_REPOSITORY("BAND_USERS_REPOSITORY",1000*1024,4*1024),
	GUESTBOOK_REPOSITORY("GUESTBOOK_REPOSITORY",1000*1024,4*1024),
	GUSETBOOK_CAPTCHA_FAKE_REPOSITORY("GUSETBOOK_CAPTCHA_FAKE_REPOSITORY",1000*1024,4*1024);
	
	private String repositoryPath;
	private int maxSizeInBytes;
	private int maxMemSize;
	private ServletContext servletContext;
	
	private PropertyManager repositories = new PropertyManager("repositories.properties");
	
	UploadRepositories(String name, int maxSizeInBytes, int maxMemSize){
		this.repositoryPath = repositories.getProperty(name);
		this.maxSizeInBytes = maxSizeInBytes;
	}

	public String getRealRepositoryPath() {
		if(servletContext != null){
			return servletContext.getRealPath(repositoryPath);
		}
		return repositoryPath;
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

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	public ServletContext getServletContext() {
		return this.servletContext;
	}
}
