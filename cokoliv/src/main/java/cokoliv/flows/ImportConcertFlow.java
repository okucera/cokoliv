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
				if(data.getLoggedUser() != null && UserHelper.isLoggedUserAdminOrSuperuser(data.getLoggedUser())){
					concerts.addNewConcertItem(data.getConcertItem());
				}
			}catch(CokolivApplicationException exception){
				data.setErrorMessage(exception.getEnumMessageCode());
			}
		}
	}
}
