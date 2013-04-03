package cokoliv.dao;

import cokoliv.databobjects.ConcertItem;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.support.Constants;

public class ConcertDAO extends BasicDAO {
	public ConcertItem[] getListOfConcerts() throws CokolivApplicationException {
		ConcertItem[] items = null;
		
		//Nacteni SQL dotazu	
		String query = repository.getSqlQuery(Constants.GET_CONCERT_SQL_KEY);

		rs = sql.executeQuery(query);
		

		//Vyber dat pro novinky
		String id[] = sql.getColumnFromRS(rs, "id");
		String date[] = sql.getColumnFromRS(rs, "date");
		String time[] = sql.getColumnFromRS(rs, "time");
		String title[]= sql.getColumnFromRS(rs, "title");
		String text[] = sql.getColumnFromRS(rs, "text");
		String strRepo[] = sql.getColumnFromRS(rs, "repo");
		String imgUrl[] = sql.getColumnFromRS(rs, "img_url");
		
		items = new ConcertItem[id.length];
		
		for(int i=0; i<id.length; i++){
			items[i] = new ConcertItem();
			items[i].setStrId(id[i]);
			items[i].setImgUrl(imgUrl[i]);
			items[i].setMessage(text[i]);
			items[i].setTitle(title[i]);
			items[i].setConcertDate(date[i]);
			items[i].setConcertTime(time[i]);
			
			UploadRepositories repository = UploadRepositories.valueOf(strRepo[i]);
			items[i].setImgRepository(repository);
		}		
		return items;
	}
	
	public void addConcertItem(ConcertItem item) throws CokolivApplicationException{
		String[] keys = {Constants.REPLACE_CONCERT_TITLE_KEY, Constants.REPLACE_CONCERT_TEXT_KEY, Constants.REPLACE_CONCERT_REPO_NAME_KEY, Constants.REPLACE_CONCERT_IMG_FILENAME_KEY};
		String[] values = {item.getTitle(), item.getMessage(), item.getImgRepository().name(), item.getImgUrl()};
		String query = getReplacedQuery(Constants.ADD_CONCERT_ITEM_SQL, keys, values);
		
		sql.execute(query);
	}
}
