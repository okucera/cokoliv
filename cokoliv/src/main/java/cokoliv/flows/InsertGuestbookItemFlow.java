package cokoliv.flows;

import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.flowdata.IFlowData;
import cokoliv.flowdata.InsertGuestbookItemData;
import cokoliv.modules.gusetbook.GuestbookModule;
import cokoliv.modules.gusetbook.IGuestbookModule;

public class InsertGuestbookItemFlow extends BasicFlow implements IFlow {

	IGuestbookModule guestbook = new GuestbookModule();
	
	public void executeFlow(IFlowData flowData) {
		if(flowData instanceof InsertGuestbookItemData){
			InsertGuestbookItemData data = (InsertGuestbookItemData) flowData;
			//TODO - udelat kontrolu captcha na urovni flow (zatim vlozeno do javascriptu na klientovi
			try {
				guestbook.addNewGuestbookItem(data.getGuestbookItem());
			} catch (CokolivApplicationException e) {
				data.setErrorMessage(e.getEnumMessageCode());
			}
		}
	}

}
