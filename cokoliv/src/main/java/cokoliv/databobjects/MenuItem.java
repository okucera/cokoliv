package cokoliv.databobjects;

import cokoliv.enumerate.Forms;

public class MenuItem {
	private String menuLink=null;
	private String menuImgUrl=null;
	private Forms formId=null;
	
	public MenuItem(String menuLink, String menuImgUrl, Forms formId){
		this.menuLink = menuLink;
		this.menuImgUrl = menuImgUrl;
		this.formId = formId;
	}

	public String getMenuLink() {
		return menuLink;
	}

	public String getMenuImgUrl() {
		return menuImgUrl;
	}
	
	public Forms getFormId() {
		return formId;
	}
}
