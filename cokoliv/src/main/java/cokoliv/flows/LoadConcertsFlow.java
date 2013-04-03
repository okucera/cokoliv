package cokoliv.flows;

import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.flowdata.GetConcertsFlowData;
import cokoliv.flowdata.IFlowData;
import cokoliv.modules.concerts.ConcertModule;
import cokoliv.modules.concerts.IConcertModule;

public class LoadConcertsFlow extends BasicFlow implements IFlow {

	IConcertModule concerts = new ConcertModule();
	
	public void executeFlow(IFlowData flowData) {
		GetConcertsFlowData data = (GetConcertsFlowData)flowData;
		try{
			data.setConcerts(concerts.getListOfConcerts());
		}catch(CokolivApplicationException exception){
			data.setErrorMessage(exception.getEnumMessageCode());
		}
	}

}
