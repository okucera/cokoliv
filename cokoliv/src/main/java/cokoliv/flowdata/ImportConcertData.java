package cokoliv.flowdata;

import cokoliv.databobjects.ConcertItem;
import cokoliv.databobjects.LoggedUser;

public class ImportConcertData extends FlowData {
	private ConcertItem concertItem;
	private LoggedUser loggedUser;
	

	public ConcertItem getConcertItem() {
		return concertItem;
	}

	public void setConcertItem(ConcertItem concertItem) {
		this.concertItem = concertItem;
	}

	public LoggedUser getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(LoggedUser loggedUser) {
		this.loggedUser = loggedUser;
	}
}
