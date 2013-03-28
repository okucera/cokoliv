package cokoliv.components;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import cokoliv.enumerate.Forms;
import cokoliv.menu.vertical.IVerticalMenu;

public class VerticalMenuPanel extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6439780318302855328L;
	protected JspWriter out;
	protected IVerticalMenu verticalMenu;
	private Forms activeFormId;
	
	public int doStartTag(){
		try{
			out = pageContext.getOut();
			createTitlePanel();
			return EVAL_BODY_INCLUDE;
		}catch(Exception ex){
			throw new Error("Error in HorizontalMenu doStartTag.");
		}	
	}
	
	public void setVerticalMenu(IVerticalMenu verticalMenu){
		this.verticalMenu = verticalMenu;
	}
	
	public int doEndTag(){
		try{
			/*
			out.println("			<table border=\"0\" class=\"contentTable\" cellpadding=\"0\" cellspacing=\"0\">");
			out.println("				<tr>");
			out.println("					<td class=\"complexLeftInsideLine\">");
			out.println("						<table border=\"0\" align=\"center\" height=\"400\">");
			out.println("							<tr>");
			out.println("								<td>");
			out.println("									&nbsp;");
			out.println("								</td>");
			out.println("							</tr>");
			out.println("						</table>");			
			out.println("					</td>");
			out.println("					<td>");
			*/
			out.println("						<table border=\"0\" class=\"complexContentTable\" cellpadding=\"0\" cellspacing=\"0\">");			
			out.println("							<tr>");
			out.println("								<td class=\"verticalMenu\">");
			//minimalni rozmer vertikalniho menu
			out.println("									<table border=\"0\" align=\"center\" width=\"200\" class=\"verticalMenu_menu\">");
			out.println("										<tr>");
			out.println("											<td valign=\"top\">");
			
			if(verticalMenu!=null) {
				verticalMenu.renderMenu();
			}
			
			out.println("												&nbsp;");
			out.println("											</td>");
			out.println("										</tr>");
			out.println("									</table>");			
			out.println("									&nbsp;");
			out.println("								</td>");
			out.println("								<td class=\"complexContent-window\">");
			//RENDER CONTENT
			out.println("								</td>");
			out.println("							</tr>");
			out.println("						</table>");
			/*
			out.println("					</td>");						
			out.println("					<td class=\"complexRightInsideLine\">");
			out.println("						&nbsp;");
			out.println("					</td>");
			out.println("				</tr>");
			out.println("			</table>");
			*/
			getEndOfTag();

			return EVAL_PAGE;
		}catch(Exception ex){
			throw new Error("Error in HorizontalMenu doStartTag.");
		}	
	}
	private void createTitlePanel() throws Exception{
		out.println("<table class=\"insideCorners\" cellpadding=\"0\" cellspacing=\"0\" height=\"500\" width=\"100%\">");
		out.println("	<tr>");
		out.println("		<td class=\"leftColumn\"/>");
		out.println("		<td valign=\"top\">");
		createUpCorners();
		out.println("			<table class=\"contentTable\" cellpadding=\"0\" cellspacing=\"0\" height=\"90%\">");
		out.println("				<tr>");
		out.println("					<td colspan=\"3\">");
	}
	
	private void getEndOfTag() throws Exception {
		out.println("					</td>");
		
		out.println("				</tr>");			
		out.println("			</table>");
		createDownCorners();
		out.println("		</td>");
		out.println("		<td class=\"rightColumn\"/>");
		out.println("	</tr>");
		out.println("</table>");
		getFoot();
	}
	

	
	private void createUpCorners() throws Exception {
		out.println("			<table class=\"contentTable\" cellpadding=\"0\" cellspacing=\"0\">");
		out.println("				<tr>");
		out.println("					<td class=\"leftUpInsideCorner\"/>");	
		out.println("					&nbsp;");
		out.println("					</td>");
		out.println("					<td class=\"upLineInside\"/>");	
		out.println("					&nbsp;");
		out.println("					</td>");
		out.println("					<td class=\"rightUpInsideCorner\"/>");
		out.println("					&nbsp;");
		out.println("					</td>");
		out.println("				</tr>");	
		out.println("			</table>");

	}

	private void createDownCorners() throws Exception {
		out.println("			<table class=\"contentTable\" cellpadding=\"0\" cellspacing=\"0\">");
		out.println("				<tr>");
		out.println("					<td class=\"leftDownInsideCorner\">");
		out.println("					&nbsp;");
		out.println("					</td>");
		out.println("					<td class=\"downLineInside\">");
		out.println("					&nbsp;");
		out.println("					</td>");
		out.println("					<td class=\"rightDownInsideCorner\">");
		out.println("					&nbsp;");
		out.println("					</td>");
		out.println("				</tr>");
		out.println("			</table>");

	}
	
	private void getFoot() throws Exception{
		out.println("<table width=\"100%\" class=\"outsideCorners\" cellpadding=\"0\" cellspacing=\"0\">");
		out.println("	<tr>");
		out.println("		<td class=\"leftDownOutsideCorner\"/>");
		out.println("		<td class=\"downLine\"/>");
		out.println("		<td class=\"rightDownOutsideCorner\" align=\"right\"/>");
		out.println("	</tr>");
		out.println("</table>");

	}
	public Forms getActiveFormId() {
		return activeFormId;
	}

	public void setActiveFormId(Forms activeFormId) {
		this.activeFormId = activeFormId;
	}
}
