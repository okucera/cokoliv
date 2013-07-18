package cokoliv.flowdata;

import cokoliv.databobjects.LoggedUser;
import cokoliv.databobjects.NewItem;

public class ImportNewsData extends FlowData {
	private NewItem newItem;
	private LoggedUser loggedUser;

	public NewItem getNewItem() {
		return newItem;
	}

	public void setNewItem(NewItem newItem) {
		this.newItem = newItem;
	}

	public LoggedUser getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(LoggedUser loggedUser) {
		this.loggedUser = loggedUser;
	}
	


}
