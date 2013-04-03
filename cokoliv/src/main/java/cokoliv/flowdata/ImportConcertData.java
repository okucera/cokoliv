package cokoliv.flowdata;

import cokoliv.databobjects.ConcertItem;

public class ImportConcertData extends FlowData {
	ConcertItem concertItem;

	public ConcertItem getConcertItem() {
		return concertItem;
	}

	public void setConcertItem(ConcertItem concertItem) {
		this.concertItem = concertItem;
	}
}
