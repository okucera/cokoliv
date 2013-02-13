package cokoliv.support;

public class Messages extends PropertyManager {
	public Messages(){
		super("messages");
	}
	
	public String getMessage(String messageCode){
		return this.getProperty(messageCode);
	}
}
