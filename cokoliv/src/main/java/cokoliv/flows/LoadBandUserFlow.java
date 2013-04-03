package cokoliv.flows;

import cokoliv.databobjects.User;
import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.flowdata.IFlowData;
import cokoliv.flowdata.LoadBandUserFlowData;
import cokoliv.modules.adm.AdminModule;
import cokoliv.modules.adm.IAdminModule;

public class LoadBandUserFlow extends BasicFlow implements IFlow {

	IAdminModule admin = new AdminModule();
	
	public void executeFlow(IFlowData flowData) {
		if(flowData instanceof LoadBandUserFlowData){
			LoadBandUserFlowData data = (LoadBandUserFlowData) flowData;
			
			User user;
			try {
				user = admin.getUserByUserId(data.getUser().getUserId());
				data.setUser(user);			
			} catch (CokolivApplicationException e) {
				data.setErrorMessage(e.getEnumMessageCode());
			}
		}
	}

}
