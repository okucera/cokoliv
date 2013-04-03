package cokoliv.flows;

import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.flowdata.GuestbookData;
import cokoliv.flowdata.IFlowData;
import cokoliv.modules.gusetbook.GuestbookModule;
import cokoliv.modules.gusetbook.IGuestbookModule;

public class LoadGuestbooksFlow extends BasicFlow implements IFlow {

	IGuestbookModule guestbook = new GuestbookModule();
	
	public void executeFlow(IFlowData flowData) {
		GuestbookData data = (GuestbookData)flowData;
		try{
			data.setGuestbookItems(guestbook.getGuestbook());
		}catch(CokolivApplicationException exception){
			data.setErrorMessage(exception.getEnumMessageCode());
		}
	}

}
