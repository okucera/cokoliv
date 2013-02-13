package cokoliv.flows;

import cokoliv.databobjects.NewItem;
import cokoliv.enumerate.EFlows;
import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.flowdata.DeleteNewsData;
import cokoliv.flowdata.IFlowData;
import cokoliv.flowdata.NewsFlowData;
import cokoliv.modules.news.INewsModule;
import cokoliv.modules.news.NewsModule;

public class DeleteSelectedNewsFlow extends BasicFlow implements IFlow {

	private INewsModule news = new NewsModule();
	
	public void executeFlow(IFlowData flowData) {
		if(flowData instanceof DeleteNewsData){
			DeleteNewsData data = (DeleteNewsData) flowData;
			try {
				NewItem[] itemsToDelete = news.getFilteredNewsByIds(cokoliv.getNewItems(), data.getItems());
				//delete image files from filesystem
				//delete items from db
				news.deleteNews(itemsToDelete);
				//-->reload news in context
				executeNextFlow(EFlows.FL001, new NewsFlowData());
			} catch (CokolivApplicationException e) {
				//TODO ???
			}			
		}
	}

}
