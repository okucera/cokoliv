package cokoliv.flows;

import cokoliv.databobjects.User;
import cokoliv.enumerate.Forms;
import cokoliv.enumerate.MessageCodes;
import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.flowdata.IFlowData;
import cokoliv.flowdata.LoginUserFlowData;
import cokoliv.modules.adm.AdminModule;
import cokoliv.modules.adm.IAdminModule;

public class LoginUserFlow extends BasicFlow implements IFlow {

	IAdminModule admin = new AdminModule();
	
	public void executeFlow(IFlowData flowData) {
		LoginUserFlowData data = (LoginUserFlowData) flowData;
		
		try{
			//ADM006: Get user by taken login
			User user = admin.getUserByLogin(data.getUsername());

			//ADM013 - is user blocked ?
			boolean isUserBlocked = admin.isUserBlocked(user);

			if(isUserBlocked){
				data.setErrorMessage(MessageCodes.HLA018);
			}else{
				//ADM007
				boolean match = admin.compareLoginPassword(user, data.getUsername(), data.getPassword64());
				//DE-credential match
				if(match){
					//ADM010: Get logged user info
					data.setUser(admin.getLoggedUserInfo(user));
					
					//ADM012 - Get parameter "first time login"
					boolean firstTimeLogin = admin.getFirstTimeLoginParametr(user);
					if(firstTimeLogin){
						//Redirect to change password page
						data.setNextFormId(Forms.FRM002);
					}else{
						//ADM009: Clear login counter (set it to 0);
						admin.clearLoginCounter(data.getUser().getUserId());
					}
				}else{
					//ADM008 - increment login counter
					admin.incrementLoginCounter(user);
					data.setErrorMessage(MessageCodes.HLA019);
				}
			}
		}catch(CokolivApplicationException exception){
			data.setErrorMessage(exception.getEnumMessageCode());
		}
	}

}
