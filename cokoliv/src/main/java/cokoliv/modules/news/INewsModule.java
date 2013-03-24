package cokoliv.modules.news;

import cokoliv.databobjects.NewItem;
import cokoliv.exceptions.CokolivApplicationException;

public interface INewsModule {
	//NEWS001: Ziskej seznam novinek
	public NewItem[] getListOfNews() throws CokolivApplicationException;
	//NEWS002: Uozeni novinky do DB
	public void addNewNews(NewItem item) throws CokolivApplicationException;
	//NEWS003: Smazani seznamu novinek	
	public void deleteNews(NewItem[] items) throws CokolivApplicationException;
	//NEWS004: Ziskej seznam novinek dle seznamu id-cek
	public NewItem[] getFilteredNewsByIds(NewItem[] listOfItems, NewItem[] filteredItems) throws CokolivApplicationException;
}
