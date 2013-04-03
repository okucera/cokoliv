package cokoliv.modules.gusetbook;

import cokoliv.dao.GuestbookDAO;
import cokoliv.databobjects.GuestbookItem;
import cokoliv.exceptions.CokolivApplicationException;

public class GuestbookModule implements IGuestbookModule {

	public GuestbookItem[] getGuestbook() throws CokolivApplicationException {
		GuestbookDAO dao = new GuestbookDAO();
		return dao.getGuestbook();
	}

	public void addNewGuestbookItem(GuestbookItem item) throws CokolivApplicationException {
		GuestbookDAO dao = new GuestbookDAO();
		dao.addGuestbookItem(item);
	}
}
