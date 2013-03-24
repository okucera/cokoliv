package cokoliv.dao;

import cokoliv.databobjects.NewItem;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.support.Constants;

public class NewsDAO extends BasicDAO {
	public NewItem[] getNewItems() throws CokolivApplicationException{
		NewItem[] items = null;
		
		//Nacteni SQL dotazu	
		String query = repository.getSqlQuery(Constants.GET_NEWS_SQL_KEY);

		rs = sql.executeQuery(query);
		

		//Vyber dat pro novinky
		String id[] = sql.getColumnFromRS(rs, "id");
		String date[] = sql.getColumnFromRS(rs, "date");
		String time[] = sql.getColumnFromRS(rs, "time");
		String title[]= sql.getColumnFromRS(rs, "title");
		String text[] = sql.getColumnFromRS(rs, "text");
		String strRepo[] = sql.getColumnFromRS(rs, "repo");
		String imgUrl[] = sql.getColumnFromRS(rs, "filename");
		
		items = new NewItem[id.length];
		
		for(int i=0; i<id.length; i++){
			items[i] = new NewItem();
			items[i].setStrId(id[i]);
			items[i].setImgUrl(imgUrl[i]);
			items[i].setMessage(text[i]);
			items[i].setTitle(title[i]);
			items[i].setNewsDate(date[i]);
			items[i].setNewsTime(time[i]);
			
			UploadRepositories repository = UploadRepositories.valueOf(strRepo[i]);
			items[i].setImgRepository(repository);
		}		
		return items;
	}
	
	public void deleteNews(NewItem[] items) throws CokolivApplicationException{
		//Nacteni SQL dotazu	
		String values = getItemsIdAsString(items);
		String query = getReplacedQuery(Constants.DEL_NEWS_SQL_KEY, Constants.REPLACE_ARRAY_KEY, values);
		
		sql.execute(query);
	}
	
	public void addNews(NewItem item) throws CokolivApplicationException{
		String[] keys = {Constants.REPLACE_NEW_TITLE_KEY, Constants.REPLACE_NEW_TEXT_KEY, Constants.REPLACE_NEW_REPO_NAME_KEY, Constants.REPLACE_NEW_IMG_FILENAME_KEY};
		String[] values = {item.getTitle(), item.getMessage(), item.getImgRepository().name(), item.getImgUrl()};
		String query = getReplacedQuery(Constants.ADD_NEW_ITEM_SQL, keys, values);
		
		sql.execute(query);
	}
	
	private String getItemsIdAsString(NewItem[] items) {
		String id="";
		for(NewItem item:items){
			id += item.getStrId()+",";
		}
		return id.substring(0,id.length()-1);
	}
}
