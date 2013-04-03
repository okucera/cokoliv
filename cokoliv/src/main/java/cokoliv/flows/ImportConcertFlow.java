package cokoliv.flows;

import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.flowdata.IFlowData;
import cokoliv.flowdata.ImportConcertData;
import cokoliv.modules.adm.AdminModule;
import cokoliv.modules.adm.IAdminModule;
import cokoliv.modules.concerts.ConcertModule;
import cokoliv.modules.concerts.IConcertModule;
import cokoliv.support.UserHelper;

public class ImportConcertFlow extends BasicFlow implements IFlow {
	IAdminModule admin = new AdminModule();
	IConcertModule concerts = new ConcertModule();
	
	public void executeFlow(IFlowData flowData) {
		if(flowData instanceof ImportConcertData){
			ImportConcertData data = (ImportConcertData) flowData;
			
			try {
				if(this.cokoliv.getLoggedUser() != null && UserHelper.isLoggedUserAdminOrSuperuser(this.cokoliv.getLoggedUser())){
					concerts.addNewConcertItem(data.getConcertItem());
				}
			}catch(CokolivApplicationException exception){
				data.setErrorMessage(exception.getEnumMessageCode());
			}
		}
	}
}
