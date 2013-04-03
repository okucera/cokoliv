package cokoliv.databobjects;

public class Captcha {
	private static Captcha instance = null;
	private String text;
	private String[] fakeCaptchas = {"AkL9g","A3qPB"};
	private int captchaId;
	
	private Captcha(){
		
	}
	
	public static synchronized Captcha getInstnace(){
		if(instance==null)
			instance = new Captcha();
		return instance;
	}
	
	public String getCpatchaImg(){
		this.captchaId = Integer.parseInt(Math.round((this.fakeCaptchas.length-1)*Math.random())+"");
		this.text = this.fakeCaptchas[captchaId];
		return this.text+".png";
	}
	
	public String getOriginalText(){
		return this.fakeCaptchas[captchaId];
	}
	public boolean isTextCaptcha(String rewritedText){
		return rewritedText.equals(this.text);
	}
}
