package cokoliv.flowdata;

import cokoliv.databobjects.BandMenuItem;

public class LoadBandMenuFlowData extends FlowData {
	private BandMenuItem[] bandMenuItems;

	public BandMenuItem[] getBandMenuItems() {
		return bandMenuItems;
	}

	public void setBandMenuItems(BandMenuItem[] bandMenuItems) {
		this.bandMenuItems = bandMenuItems;
	}
}
