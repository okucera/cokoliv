package cokoliv.databobjects;

import cokoliv.enumerate.UploadRepositories;

public class ConcertItem {
	private String concertDate = "";
	private String concertTime = "";
	private String title = "";
	private String message = "";
	private String imgUrl = ""; // TODO prejmenovat na imgFilename
	private String strId = "";
	private UploadRepositories imgRepository;
	
	public String getConcertDate() {
		return concertDate;
	}
	public void setConcertDate(String concertDate) {
		this.concertDate = concertDate;
	}
	public String getConcertTime() {
		return concertTime;
	}
	public void setConcertTime(String concertTime) {
		this.concertTime = concertTime;
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
