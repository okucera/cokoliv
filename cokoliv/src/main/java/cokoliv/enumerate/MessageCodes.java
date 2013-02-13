package cokoliv.enumerate;

import cokoliv.support.Messages;

public enum MessageCodes {
	HLA001("HLA001"),
	HLA010("HLA010"),
	HLA011("HLA011"),
	HLA012("HLA012"),
	HLA013("HLA013"),
	HLA014("HLA014"),
	HLA015("HLA015"),
	HLA016("HLA016"),
	HLA017("HLA017"),
	HLA018("HLA018"),
	HLA019("HLA019"),
	HLA020("HLA020"),
	HLA021("HLA021"),
	HLA022("HLA022");
	
	
	private String errCode;
	private String msg;
	private Messages errorProperties = new Messages();

	
	
	MessageCodes(String errCode){		
		this.errCode = errCode;
		this.msg = errorProperties.getProperty(errCode);
	}
	
	public String getErrorCode(){
		return this.errCode;
	}
	
	public String getErrorMessage(){
		return this.msg;
	}
	

}
