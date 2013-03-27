package cokoliv.dao;

import cokoliv.databobjects.BandMenuItem;
import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.support.Constants;

public class BandMenuDAO extends BasicDAO {
	
	public BandMenuItem[] getBandMenuItems(){
		BandMenuItem[] items=null;
		
		//Vykonani SQL dotazu		
		String query = repository.getSqlQuery(Constants.GET_PERSON_SQL_KEY);
		
		try{
			rs = sql.executeQuery(query);
		
			//Vyber dat pro konstrukci menu
			String nicks[] = sql.getColumnFromRS(rs, "nick");
			String ids[]= sql.getColumnFromRS(rs, "user_id");
		
		
			items = new BandMenuItem[ids.length];
			for(int itemIndex=0; itemIndex < items.length; itemIndex++){
				items[itemIndex] = new BandMenuItem();
				items[itemIndex].setId(ids[itemIndex]);
				items[itemIndex].setNick(nicks[itemIndex]);
			}
		}catch(CokolivApplicationException exception){
			items = new BandMenuItem[0];
		}
		
		return items;
	}
}
