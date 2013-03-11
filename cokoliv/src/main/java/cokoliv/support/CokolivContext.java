package cokoliv.support;


import cokoliv.dao.MenuDAO;
import cokoliv.databobjects.LoggedUser;
import cokoliv.databobjects.MenuItem;
import cokoliv.databobjects.NewItem;
import cokoliv.enumerate.EWizzardItems;
import cokoliv.enumerate.WizzardActionEnum;
import cokoliv.flowdata.FlowDataHolder;

public class CokolivContext {
	private static CokolivContext cokolivContext = null;
	
	//Polozky menu
	private MenuItem[] menuItems;
	
	//Polozky novinek
	private NewItem[] newItems;
	
	//Prihlaseny uzivatel
	private LoggedUser loggedUser;
	
	//Aktualni wizzard item
	private EWizzardItems activeWizzardItem = EWizzardItems.NONE;
	//Akce provadena nad aktualnim wizzard itemem
	private WizzardActionEnum wizzardAction = WizzardActionEnum.NONE;
	
	private FlowDataHolder flowDataHolder = null;
		
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
	
	public EWizzardItems getActiveWizzardItem() {
		return activeWizzardItem;
	}

	public void setActiveWizzardItem(EWizzardItems activeWizzardItem) {
		this.activeWizzardItem = activeWizzardItem;
	}

	public WizzardActionEnum getWizzardAction() {
		return wizzardAction;
	}

	public void setWizzardAction(WizzardActionEnum wizzardAction) {
		this.wizzardAction = wizzardAction;
	}

	public FlowDataHolder getFlowDataHolder() {
		return flowDataHolder;
	}

	public void setFlowDataHolder(FlowDataHolder flowDataHolder) {
		this.flowDataHolder = flowDataHolder;
	}
}
