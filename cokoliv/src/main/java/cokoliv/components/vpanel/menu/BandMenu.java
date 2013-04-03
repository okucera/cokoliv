package cokoliv.components.vpanel.menu;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

import cokoliv.components.CokolivTag;
import cokoliv.databobjects.BandMenuItem;
import cokoliv.databobjects.LoggedUser;
import cokoliv.enumerate.EFlows;
import cokoliv.flowdata.LoadBandMenuFlowData;
import cokoliv.renderers.CokolivAdminBandMenuItemRenderer;
import cokoliv.renderers.CokolivBandMenuItemRenderer;
import cokoliv.support.CokolivContext;

public class BandMenu extends CokolivTag {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -258828099386104157L;
	private LoggedUser loggedUser;
	private JspWriter out;
	private LoadBandMenuFlowData menuData;
	
	public int doStartTag(){
		this.loggedUser = CokolivContext.getContext().getLoggedUser();
		try{
			loadBandMenu();
			drawMenuItems();
			return SKIP_BODY;
		} catch (Exception ex){
			throw new Error("Error in BandMenu doStartTag.");
		}
	}
	
	private void drawMenuItems() throws IOException{
		//Klasicky pohled - standardni uzivatel
		if(loggedUser==null) {
			itemRenderer = new CokolivBandMenuItemRenderer();
		}else{
			//administratorsky pohled
			itemRenderer = new CokolivAdminBandMenuItemRenderer();
		}
		itemRenderer.renderItems(menuData.getBandMenuItems(), out);
		
	}
	
	private void loadBandMenu() {
		this.executeFlow(EFlows.FL007, menuData);
	}
	
	public int doEndTag(){
		try{
			@SuppressWarnings("unused")
			JspWriter out = pageContext.getOut();
		} catch (Exception ex){
			throw new Error("Error in BandMenu doEndTag.");
		}
		return EVAL_PAGE;
	}
}
