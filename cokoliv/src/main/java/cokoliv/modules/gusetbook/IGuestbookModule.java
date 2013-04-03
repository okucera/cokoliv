package cokoliv.modules.gusetbook;

import cokoliv.databobjects.GuestbookItem;
import cokoliv.exceptions.CokolivApplicationException;

public interface IGuestbookModule {
	//GUE001 - ziskej seznam konciku
	public GuestbookItem[] getGuestbook() throws CokolivApplicationException;
	//GUE002 - vloz novinku do seznamu
	public void addNewGuestbookItem(GuestbookItem item) throws CokolivApplicationException;

}
