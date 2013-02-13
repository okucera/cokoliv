package cokoliv.flows;

import cokoliv.enumerate.Forms;
import cokoliv.enumerate.MessageCodes;
import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.flowdata.ChangeUserDetailData;
import cokoliv.flowdata.IFlowData;
import cokoliv.modules.adm.AdminModule;
import cokoliv.modules.adm.IAdminModule;

public class ChangeUserDetailFlow extends BasicFlow implements IFlow {

	private IAdminModule admin = new AdminModule();
	@Override
	public void executeFlow(IFlowData flowData) {
		ChangeUserDetailData data = (ChangeUserDetailData) flowData;
		
		boolean passwordsMatch = admin.newPasswordsMatch(data.getNewPassword(), data.getRetypedNewPassword());
		if(passwordsMatch){
			try{
				//ADM015: Store user to database
				admin.storeUser(data);
				//ADM009: clear fail login counter
				admin.clearLoginCounter(data.getUserToStore().getUserId());
				//set next page
				data.setNextFormId(Forms.FRM001);
			}catch(CokolivApplicationException exception){
				data.setErrorMessage(exception.getEnumMessageCode());
			}
		}else{
			data.setNextFormId(Forms.FRM002);
			data.setMessage(MessageCodes.HLA022);
		}
	}

}
