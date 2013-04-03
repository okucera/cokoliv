package cokoliv.modules.concerts;

import cokoliv.dao.ConcertDAO;
import cokoliv.databobjects.ConcertItem;
import cokoliv.exceptions.CokolivApplicationException;

public class ConcertModule implements IConcertModule {

	public ConcertItem[] getListOfConcerts() throws CokolivApplicationException{
		ConcertDAO dao = new ConcertDAO();
		return dao.getListOfConcerts();
	}

	public void addNewConcertItem(ConcertItem item) throws CokolivApplicationException {
		ConcertDAO dao = new ConcertDAO();
		dao.addConcertItem(item);
	}
}
