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
	
	private static final String ACTIVE_WIZZARD_ITEM_TITLE_STYLE="activeWizzardHeaderItem";
	private static final String INACTIVE_WIZZARD_ITEM_TITLE_STYLE="inactiveWizzardHeaderItem";
	private static final String ACTIVE_WIZZARD_ITEM_CONTENT_STYLE="activeWizzardContentItem";
	private static final String INACTIVE_WIZZARD_ITEM_CONTENT_STYLE="inactiveWizzardContentItem";
	
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
				out.println("<table class=\"wizzardHeader\" align=\"center\">");
				out.println("<tr>");
				createWizzardHeaders();
				out.println("</tr>");
				out.println("<tr>");
				createWizzardContents();
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
			EWizzardItems item = items.get(itemIndex);
			createHeader(item, itemIndex);
		}
	}
	
	private void createHeader(EWizzardItems item, int itemIndex) throws IOException{
		if(itemIndex == activeItemIndex) {
			drawActiveItem(item);
		}else{
			drawInactiveItem(item);
		}
	}
	
	private void createWizzardContents() throws IOException{
		for(int itemIndex = 0; itemIndex < items.size(); itemIndex++){
			EWizzardItems item = items.get(itemIndex);
			createContent(item, itemIndex);
		}
	}
	
	private void createContent(EWizzardItems item, int itemIndex) throws IOException{
		if(itemIndex == activeItemIndex) {
			drawActiveContent(item);
		}else{
			drawInactiveContent(item);
		}
	}
	
	private void drawActiveItem(EWizzardItems item) throws IOException{
		out.println("<td class=\""+ACTIVE_WIZZARD_ITEM_TITLE_STYLE+"\">");
		out.println(item.getItemTitle());
		out.println("</td>");
	}
	
	private void drawInactiveItem(EWizzardItems item) throws IOException{
		out.println("<td class=\""+INACTIVE_WIZZARD_ITEM_TITLE_STYLE+"\">");
		out.println(item.getItemTitle());
		out.println("</td>");
	}
	
	private void drawActiveContent(EWizzardItems item) throws IOException{
		out.println("<td class=\""+ACTIVE_WIZZARD_ITEM_CONTENT_STYLE+"\">");
		out.println("Tokyo");
		out.println("</td>");
	}
	
	private void drawInactiveContent(EWizzardItems item) throws IOException{
		out.println("<td class=\""+INACTIVE_WIZZARD_ITEM_CONTENT_STYLE+"\">");
		out.println("Marui");
		out.println("</td>");
	}
	

	public LoggedUser getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(LoggedUser loggedUser) {
		this.loggedUser = loggedUser;
	}
}
