package cokoliv.menu.vertical;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

import cokoliv.components.VerticalMenuPanel;
import cokoliv.enumerate.EFlows;
import cokoliv.flowdata.LoadBandMenuFlowData;
import cokoliv.renderers.CokolivBandMenuItemRenderer;

public class VerticalBandMenu extends VerticalMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -258828099386104157L;
	private LoadBandMenuFlowData menuData;
	
	public int doStartTag(){
		out = pageContext.getOut();
		try{
			loadBandMenu();
			if(this.getParent() instanceof VerticalMenuPanel){
				((VerticalMenuPanel)this.getParent()).setVerticalMenu(this);
			}
			return SKIP_BODY;
		} catch (Exception ex){
			throw new Error("Error in BandMenu doStartTag.");
		}
	}
	
	public void renderMenu() throws IOException {
		//nadpis
		createTitle();
		//Klasicky pohled - standardni uzivatel
		if(getLoggedUser()==null) {
			itemRenderer = new CokolivBandMenuItemRenderer();
		}else{
			//administratorsky pohled
			itemRenderer = new CokolivBandMenuItemRenderer();//TODO - new CokolivAdminBandMenuItemRenderer();
		}
		itemRenderer.renderItems(menuData.getBandMenuItems(), out);
		
	}
	
	private void createTitle() throws IOException{
		out.println("<table border=\"0\" width=\"100%\">");
		out.println("<tr>");
		out.println("<td align=\"center\">");
		out.println("<img src=\"img/night/kapela-title.png\">");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
	}
	
	private void loadBandMenu() {
		menuData = new LoadBandMenuFlowData();
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
