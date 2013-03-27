package cokoliv.flows;

import cokoliv.flowdata.IFlowData;
import cokoliv.flowdata.LoadBandMenuFlowData;
import cokoliv.modules.usr.IUserModule;
import cokoliv.modules.usr.UserModule;

public class LoadBandMenuFlow extends BasicFlow implements IFlow {
	
	IUserModule users = new UserModule();
	
	public void executeFlow(IFlowData flowData) {
		if(flowData instanceof LoadBandMenuFlowData){
			LoadBandMenuFlowData data = (LoadBandMenuFlowData) flowData;
			data.setBandMenuItems(users.getBandMenuItems());
		}
	}

}
