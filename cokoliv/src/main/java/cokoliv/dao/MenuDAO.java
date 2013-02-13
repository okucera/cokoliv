package cokoliv.dao;

import cokoliv.databobjects.MenuItem;
import cokoliv.enumerate.Forms;
import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.support.Constants;

public class MenuDAO extends BasicDAO{
	
	public MenuItem[] getMenuItems(){
		MenuItem[] items=null;
		
		//Vykonani SQL dotazu		
		String query = repository.getSqlQuery(Constants.GET_MENU_SQL_KEY);
		
		try{
			rs = sql.executeQuery(query);
		
			//Vyber dat pro konstrukci menu
			String link[] = sql.getColumnFromRS(rs, "link");
			String img_url[]= sql.getColumnFromRS(rs, "img_url");
			String formId[] = sql.getColumnFromRS(rs, "form_id");
		
		
			//Kontrola zda pocet obrazku odpovida poctu polozek
			if(link.length==img_url.length){
				items = new MenuItem[link.length];
				for(int itemIndex=0; itemIndex < items.length; itemIndex++){
					Forms form = Forms.valueOf(formId[itemIndex]);
					items[itemIndex] = new MenuItem(link[itemIndex], img_url[itemIndex], form);  
				}
			}else{
			//TODO: Zalogovat nekorektni data na db 
			}
		}catch(CokolivApplicationException exception){
			items = new MenuItem[0];
		}
		
		return items;
	}
}
