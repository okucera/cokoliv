package cokoliv.flows;

import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.flowdata.IFlowData;
import cokoliv.flowdata.ImportNewsData;
import cokoliv.modules.adm.AdminModule;
import cokoliv.modules.adm.IAdminModule;
import cokoliv.modules.news.INewsModule;
import cokoliv.modules.news.NewsModule;
import cokoliv.support.UserHelper;

public class ImportNewsFlow extends BasicFlow implements IFlow {
	IAdminModule admin = new AdminModule();
	INewsModule news = new NewsModule();
	
	public void executeFlow(IFlowData flowData) {
		if(flowData instanceof ImportNewsData){
			ImportNewsData data = (ImportNewsData) flowData;
			
			try {
				if(this.cokoliv.getLoggedUser() != null && UserHelper.isLoggedUserAdminOrSuperuser(this.cokoliv.getLoggedUser())){
					news.addNewNews(data.getNewItem());
				}
			}catch(CokolivApplicationException exception){
				data.setErrorMessage(exception.getEnumMessageCode());
			}
		}
	}
}
