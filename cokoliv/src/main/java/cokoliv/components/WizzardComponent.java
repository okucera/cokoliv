package cokoliv.components;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import cokoliv.components.wizzards.IWizzardItem;
import cokoliv.databobjects.LoggedUser;
import cokoliv.enumerate.EWizzardItems;
import cokoliv.support.StyleNames;

public class WizzardComponent extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7960288566490944015L;
	protected JspWriter out;
	private ArrayList<IWizzardItem> items;
	private int activeItemIndex = 0;
	private LoggedUser loggedUser;
	
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
	
	public void addWizzardItem(IWizzardItem item){
		if(items==null)
			items = new ArrayList<IWizzardItem>();
		
		items.add(item);
	}
	
	private void clearWizzardItems(){
		items = new ArrayList<IWizzardItem>();
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
				out.println("<table class=\"wizzardHeader\" align=\"center\">");
				out.println("<tr>");
				createWizzardHeaders();
				out.println("</tr>");
				out.println("<tr>");
				createWizzardContent();
				out.println("</tr>");
				out.println("</table>");
			}
		} catch (IOException ioException) {
			System.out.println("WizzardComponent.drawWizzardItems: Promenna \"out\" nebo jeji pageContext nebyly inicializovany/");
			ioException.printStackTrace();
		}
	}
	
	private void createWizzardHeaders() throws IOException{
		for(int itemIndex = 0; itemIndex < items.size(); itemIndex++){
			IWizzardItem item = items.get(itemIndex);
			createHeader(item, itemIndex);
		}
	}
	
	private void createHeader(IWizzardItem item, int itemIndex) throws IOException{
		if(itemIndex == activeItemIndex) {
			drawActiveItemHeader(item);
		}else{
			drawInactiveItemHeader(item);
		}
	}
	
	private void createWizzardContent() throws IOException{
			IWizzardItem item = items.get(activeItemIndex);
			createContent(item);
	}
	
	private void createContent(IWizzardItem item) throws IOException{
		out.println("<td class=\""+StyleNames.WIZZARD_ITEM_CONTENT_STYLE+"\" colspan=\""+items.size()+"\">");
		item.drawContent();
		out.println("</td>");
	}
	
	private void drawActiveItemHeader(IWizzardItem item) throws IOException{
		out.println("<td class=\""+StyleNames.ACTIVE_WIZZARD_ITEM_TITLE_STYLE+"\">");
		out.println(item.getType().getItemTitle());
		out.println("</td>");
	}
	
	private void drawInactiveItemHeader(IWizzardItem item) throws IOException{
		out.println("<td class=\""+StyleNames.INACTIVE_WIZZARD_ITEM_TITLE_STYLE+"\">");
		out.println(item.getType().getItemTitle());
		out.println("</td>");
	}

	public LoggedUser getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(LoggedUser loggedUser) {
		this.loggedUser = loggedUser;
	}
}
