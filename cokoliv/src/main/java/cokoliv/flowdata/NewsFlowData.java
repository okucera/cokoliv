package cokoliv.flowdata;

import cokoliv.databobjects.NewItem;

public class NewsFlowData extends FlowData{
	private NewItem[] news;

	public NewItem[] getNews() {
		return news;
	}

	public void setNews(NewItem[] news) {
		this.news = news;
	}
}
