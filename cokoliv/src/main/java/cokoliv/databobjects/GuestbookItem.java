package cokoliv.databobjects;

import cokoliv.enumerate.UploadRepositories;


public class GuestbookItem {
	private String id="";
	private String guestbookDate = "";
	private String guestbookTime = "";
	private String nick = "";
	private String message = "";
	private String imgUrl = ""; // TODO prejmenovat na imgFilename
	private UploadRepositories imgRepository;
	
	public String getGuestbookDate() {
		return guestbookDate;
	}
	public void setGuestbookDate(String guestbookDate) {
		this.guestbookDate = guestbookDate;
	}
	public String getGuestbookTime() {
		return guestbookTime;
	}
	public void setGuestbookTime(String guestbookTime) {
		this.guestbookTime = guestbookTime;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
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
	public UploadRepositories getImgRepository() {
		return imgRepository;
	}
	public void setImgRepository(UploadRepositories imgRepository) {
		this.imgRepository = imgRepository;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
