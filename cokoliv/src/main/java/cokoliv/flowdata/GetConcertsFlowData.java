package cokoliv.flowdata;

import cokoliv.databobjects.ConcertItem;

public class GetConcertsFlowData extends FlowData {
	private ConcertItem[] concerts;

	public ConcertItem[] getConcerts() {
		return concerts;
	}

	public void setConcerts(ConcertItem[] concerts) {
		this.concerts = concerts;
	}
}
