package cokoliv.dao;

import cokoliv.databobjects.GuestbookItem;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.support.Constants;

public class GuestbookDAO extends BasicDAO {
	
	public GuestbookItem[] getGuestbook() throws CokolivApplicationException {
		GuestbookItem[] items = null;
		
		//Nacteni SQL dotazu	
		String query = repository.getSqlQuery(Constants.GET_GUESTBOOK_SQL_KEY);

		rs = sql.executeQuery(query);
		

		//Vyber dat pro novinky
		String id[] = sql.getColumnFromRS(rs, "id");
		String date[] = sql.getColumnFromRS(rs, "date");
		String time[] = sql.getColumnFromRS(rs, "time");
		String nick[]= sql.getColumnFromRS(rs, "nick");
		String msg[] = sql.getColumnFromRS(rs, "msg");
		String imgUrl[] = sql.getColumnFromRS(rs, "img_id");
		String strRepo[] = sql.getColumnFromRS(rs, "repo");
		
		items = new GuestbookItem[id.length];
		
		for(int i=0; i<id.length; i++){
			items[i] = new GuestbookItem();
			items[i].setId(id[i]);
			items[i].setGuestbookDate(date[i]);
			items[i].setGuestbookTime(time[i]);
			items[i].setNick(nick[i]);
			items[i].setMessage(msg[i]);
			items[i].setImgUrl(imgUrl[i]);
			
			UploadRepositories repository = UploadRepositories.valueOf(strRepo[i]);
			items[i].setImgRepository(repository);
		}		
		return items;
	}
	
	public void addGuestbookItem(GuestbookItem item) throws CokolivApplicationException{
		String[] keys = {Constants.REPLACE_NICK_KEY, Constants.REPLACE_MSG_KEY, Constants.REPLACE_IMAGE_KEY, Constants.REPLACE_NEW_REPO_NAME_KEY};
		String[] values = {item.getNick(), item.getMessage(), item.getImgUrl(), item.getImgRepository().name()};
		String query = getReplacedQuery(Constants.ADD_GUESTBOOK_ITEM_SQL_KEY, keys, values);
		
		sql.execute(query);
	}


}
