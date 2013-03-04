package cokoliv.support;


import cokoliv.dao.MenuDAO;
import cokoliv.databobjects.LoggedUser;
import cokoliv.databobjects.MenuItem;
import cokoliv.databobjects.NewItem;

public class CokolivContext {
	private static CokolivContext cokolivContext = null;
	
	//Polozky menu
	private MenuItem[] menuItems;
	
	//Polozky novinek
	private NewItem[] newItems;
	
	//Prihlaseny uzivatel
	private LoggedUser loggedUser;
		
	private CokolivContext(){		
		if(menuItems==null){
			MenuDAO dao = new MenuDAO();
			this.menuItems = dao.getMenuItems();			
		}

	}
	
	public static synchronized CokolivContext getContext(){
		if(cokolivContext==null){
			cokolivContext = new CokolivContext();
		}
		return cokolivContext;
	}

	public MenuItem[] getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(MenuItem[] menuItems) {
		this.menuItems = menuItems;
	}

	public NewItem[] getNewItems() {
		return newItems;
	}

	public void setNewItems(NewItem[] newItems) {
		this.newItems = newItems;
	}

	public LoggedUser getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(LoggedUser loggedUser) {
		this.loggedUser = loggedUser;
	}
}
