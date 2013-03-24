package cokoliv.flowdata;

import cokoliv.databobjects.NewItem;

public class ImportNewsData extends FlowData {
	NewItem newItem;

	public NewItem getNewItem() {
		return newItem;
	}

	public void setNewItem(NewItem newItem) {
		this.newItem = newItem;
	}
}
