package cokoliv.flowdata;

import cokoliv.databobjects.GuestbookItem;

public class InsertGuestbookItemData extends FlowData {
	
	private GuestbookItem guestbookItem;
	private boolean isCaptchaWrong = false;

	public GuestbookItem getGuestbookItem() {
		return guestbookItem;
	}

	public void setGuestbookItem(GuestbookItem guestbookItem) {
		this.guestbookItem = guestbookItem;
	}

	public boolean isCaptchaWrong() {
		return isCaptchaWrong;
	}

	public void setCaptchaWrong(boolean isCaptchaWrong) {
		this.isCaptchaWrong = isCaptchaWrong;
	}
}
