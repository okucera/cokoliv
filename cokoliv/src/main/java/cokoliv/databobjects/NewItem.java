package cokoliv.databobjects;

import cokoliv.enumerate.UploadRepositories;


public class NewItem {
	private String newsDate = "";
	private String newsTime = "";
	private String title = "";
	private String message = "";
	private String imgUrl = ""; // TODO prejmenovat na imgFilename
	private String strId = "";
	private UploadRepositories imgRepository;
	
	public String getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getNewsTime() {
		return newsTime;
	}
	public void setNewsTime(String newsTime) {
		this.newsTime = newsTime;
	}
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public UploadRepositories getImgRepository() {
		return imgRepository;
	}
	public void setImgRepository(UploadRepositories imgRepository) {
		this.imgRepository = imgRepository;
	}

}
