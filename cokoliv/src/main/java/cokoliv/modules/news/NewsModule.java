package cokoliv.modules.news;

import cokoliv.dao.NewsDAO;
import cokoliv.databobjects.NewItem;
import cokoliv.exceptions.CokolivApplicationException;

public class NewsModule implements INewsModule {
	
	//NEWS001: Ziskej seznam novinek
	public NewItem[] getListOfNews() throws CokolivApplicationException{
		NewsDAO newsDao = new NewsDAO();
		NewItem[] items = newsDao.getNewItems();
		return items;
	}
	
	//NEWS002: Uozeni novinky do DB
	public void addNewNews(NewItem item) throws CokolivApplicationException {
		NewsDAO newsDao = new NewsDAO();
		newsDao.addNews(item);
	}
	
	//NEWS003: Smazani seznamu novinek	
	public void deleteNews(NewItem[] items) throws CokolivApplicationException {
		NewsDAO newsDao = new NewsDAO();
		newsDao.deleteNews(items);
	}
	
	//NEWS004
	public NewItem[] getFilteredNewsByIds(NewItem[] listOfItems, NewItem[] filteredItems) throws CokolivApplicationException {
		for(int i=0; i<filteredItems.length; i++){
			String itemId = filteredItems[i].getStrId();
			filteredItems[i] = getFilteredItemById(listOfItems, itemId);
		}
		return filteredItems;
	}
	
	private NewItem getFilteredItemById(NewItem[] listOfItems, String itemId) {
		for(NewItem item : listOfItems){
			if(item.getStrId().equals(itemId)){
				return item;
			}
		}
		return null;
	}
}
