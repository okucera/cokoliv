package cokoliv.support;

public class KeyManager extends PropertyManager {
	public KeyManager(){
		super("keys");
	}
	
	public String getKeyValue(String key){
		return this.getProperty(key);
	}
}
