package cokoliv.enumerate;

public enum EWizzardItems {

	NONE("NONE"),
	ADD_IMAGE("Obrázek"),
	ADD_TEXT("Texty");
	
	private String title;
	
	EWizzardItems(String title){
		this.title=title;
	}
	
	public String getItemTitle(){
		return this.title;
	}
}
