package cokoliv.flowdata;

import cokoliv.databobjects.GuestbookItem;

public class GuestbookData extends FlowData {
	private GuestbookItem[] guestbookItems;

	public GuestbookItem[] getGuestbookItems() {
		return guestbookItems;
	}

	public void setGuestbookItems(GuestbookItem[] guestbookItems) {
		this.guestbookItems = guestbookItems;
	}
}
