package cokoliv.flows;

import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.flowdata.IFlowData;
import cokoliv.flowdata.NewsFlowData;
import cokoliv.modules.news.NewsModule;


public class LoadCokolivNewsFlow extends BasicFlow implements IFlow{

	NewsModule news = new NewsModule();
	
	public void executeFlow(IFlowData flowData) {
		NewsFlowData data = (NewsFlowData)flowData;
		try{
			//NEWS001
			cokoliv.setNewItems(news.getListOfNews());
			data.setNews(cokoliv.getNewItems());
		}catch(CokolivApplicationException exception){
			data.setErrorMessage(exception.getEnumMessageCode());
		}
	}

}
