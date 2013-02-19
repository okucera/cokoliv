package cokoliv.components.wizzards;

import cokoliv.components.WizzardComponent;
import cokoliv.enumerate.EWizzardItems;

public class AddNewsTextWizzardItem extends WizzardItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3994571760199022961L;

	@Override
	protected void appendToStartTag() {
		// TODO Auto-generated method stub
		this.itemName = EWizzardItems.ADD_TEXT;
		if(this.getParent() instanceof WizzardComponent){
			((WizzardComponent)this.getParent()).addWizzardItem(this);
		}
	}

	@Override
	protected void appendToEndTag() {
		// TODO Auto-generated method stub

	}
	
	public void drawContent(){
		
	}

}
