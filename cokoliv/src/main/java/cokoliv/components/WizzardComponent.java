package cokoliv.components;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import cokoliv.databobjects.LoggedUser;
import cokoliv.enumerate.EWizzardItems;

public class WizzardComponent extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7960288566490944015L;
	protected JspWriter out;
	private ArrayList<EWizzardItems> items;
	private int activeItemIndex = 0;
	private LoggedUser loggedUser;
	
	private static final String ACTIVE_WIZZARD_ITEM_STYLE="activeWizzardItem";
	private static final String INACTIVE_WIZZARD_ITEM_STYLE="inactiveWizzardItem";
	
	public int doStartTag(){
		try{
			out = pageContext.getOut();
			clearWizzardItems();
			return EVAL_BODY_INCLUDE;
		}catch(Exception ex){
			throw new Error("Error in WizzardComponent doStartTag.");
		}	
	}
	
	public int doEndTag(){
		try{
			drawWizzardItems();
			return EVAL_PAGE;
		}catch(Exception ex){
			throw new Error("Error in WizzardComponent doStartTag.");
		}	
	}
	
	public void addWizzardItem(EWizzardItems item){
		if(items==null)
			items = new ArrayList<EWizzardItems>();
		
		items.add(item);
	}
	
	private void clearWizzardItems(){
		items = new ArrayList<EWizzardItems>();
	}
	
	public void setActiveItem(EWizzardItems item){
		if(items != null){
			int index = items.indexOf(item);
			if(index>-1) {
				activeItemIndex = index;
			} else {
				System.out.println("Wizzard item "+item.name()+" cannot be found - let's set active item to 0.");
				activeItemIndex = 0;
			}
			drawWizzardItems();	
		}
	}
	
	public void setActiveItem(int itemIndex) {
		if(itemIndex > -1 && itemIndex < items.size()){
			activeItemIndex = itemIndex;
		}else{
			System.out.println("Wizzard item index "+itemIndex+" is out of range ("+items.size()+"} - let's set active item to 0.");
			activeItemIndex = 0;			
		}
		drawWizzardItems();
	}
	
	private void drawWizzardItems(){
		try {
			if(this.loggedUser != null) {
				out.println("<table class=\"wizzardHeader\">");
				out.println("<tr>");
				for(int itemIndex = 0; itemIndex < items.size(); itemIndex++){
					EWizzardItems item = items.get(itemIndex);
					if(itemIndex == activeItemIndex) {
						drawActiveItem(item);
					}else{
						drawInactiveItem(item);
					}
				}
				out.println("</tr>");
				out.println("</table>");
			}
		} catch (IOException ioException) {
			System.out.println("WizzardComponent.drawWizzardItems: Promenna \"out\" nebo jeji pageContext nebyly inicializovany/");
			ioException.printStackTrace();
		}
	}
	
	private void drawActiveItem(EWizzardItems item) throws IOException{
		out.println("<td class=\""+ACTIVE_WIZZARD_ITEM_STYLE+"\">");
		out.println(item.getItemTitle());
		out.println("</td>");
	}
	
	private void drawInactiveItem(EWizzardItems item) throws IOException{
		out.println("<td class=\""+INACTIVE_WIZZARD_ITEM_STYLE+"\">");
		out.println(item.getItemTitle());
		out.println("</td>");
	}
	

	public LoggedUser getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(LoggedUser loggedUser) {
		this.loggedUser = loggedUser;
	}
}
