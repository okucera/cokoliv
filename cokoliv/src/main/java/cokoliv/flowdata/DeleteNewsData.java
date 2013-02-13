package cokoliv.flowdata;

import cokoliv.databobjects.LoggedUser;
import cokoliv.databobjects.NewItem;

public class DeleteNewsData extends FlowData {
	NewItem[] items;
	LoggedUser user;
	
	public NewItem[] getItems() {
		return items;
	}
	public void setItems(NewItem[] items) {
		this.items = items;
	}
	public LoggedUser getLoggedUser() {
		return user;
	}
	public void setLoggedUser(LoggedUser user) {
		this.user = user;
	}
}
