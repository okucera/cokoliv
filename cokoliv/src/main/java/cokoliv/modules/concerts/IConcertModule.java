package cokoliv.modules.concerts;

import cokoliv.databobjects.ConcertItem;
import cokoliv.exceptions.CokolivApplicationException;

public interface IConcertModule {
	//CON001 - ziskej seznam konciku
	public ConcertItem[] getListOfConcerts() throws CokolivApplicationException;
	//CON002 - vloz koncert
	public void addNewConcertItem(ConcertItem item) throws CokolivApplicationException;
}
