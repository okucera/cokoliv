package cokoliv.enumerate;

public enum Forms {
	FRM001("FRM001","index.jsp"), //USERS NEWS PAGE
	FRM002("FRM002","newPwd.jsp"), //PASSWORD CHANGE FORM
	FRM003("FRM003","koncerts.jsp"), //CONCERTS PAGE
	FRM004("FRM004","hudba.jsp"), //MUSIV PAGE
	FRM005("FRM005","down.jsp"), //DOWNLOAD PAGE
	FRM006("FRM006","vzkazy.jsp"), //GUESTBOOK
	FRM007("FRM007","newPwd.jsp"), //USERS FIRST LOGIN PAGE
	FRM008("FRM008","error.jsp"), //ERROR PAGE
	FRM009("FRM009","kapela.jsp");
	
	private String formId;
	private String url;
	
	Forms(String formId, String url){
		this.formId = formId;
		this.url = url;
	}
	
	@Override
	public String toString(){
		return this.formId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
