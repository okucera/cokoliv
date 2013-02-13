package cokoliv.components.wizzards;

import cokoliv.components.WizzardComponent;
import cokoliv.enumerate.EWizzardItems;

public class AddImageWizzardItem extends WizzardItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7904878216687345947L;

	@Override
	protected void appendToStartTag() {
		// TODO Auto-generated method stub
		this.itemName = EWizzardItems.ADD_IMAGE;
		if(this.getParent() instanceof WizzardComponent){
			((WizzardComponent)this.getParent()).addWizzardItem(this.itemName);
		}
	}

	@Override
	protected void appendToEndTag() {
		// TODO Auto-generated method stub
		
	}

}
