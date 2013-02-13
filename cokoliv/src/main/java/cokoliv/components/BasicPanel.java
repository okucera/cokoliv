package cokoliv.components;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import cokoliv.enumerate.Forms;

public class BasicPanel extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4228365267484911555L;
	
	private String title;
	private Forms activeFormId;

	protected JspWriter out;

	public int doStartTag(){
		try{
			out = pageContext.getOut();
			createTitlePanel();
			return EVAL_BODY_INCLUDE;
		}catch(Exception ex){
			throw new Error("Error in HorizontalMenu doStartTag.");
		}	
	}
	
	public int doEndTag(){
		try{
			out.println("					</td>");
			
			out.println("				</tr>");			
			out.println("			</table>");
			createDownCorners();
			out.println("		</td>");
			out.println("		<td class=\"rightColumn\"/>");
			out.println("	</tr>");
			out.println("</table>");
			getFoot();
			return EVAL_PAGE;
		}catch(Exception ex){
			throw new Error("Error in HorizontalMenu doStartTag.");
		}	
	}
	
	private void createTitlePanel() throws Exception{
		out.println("<table class=\"outsideCorners\" cellpadding=\"0\" cellspacing=\"0\">");
		out.println("	<tr>");
		out.println("		<td class=\"leftColumn\"/>");
		out.println("		<td>");
		createUpCorners();
		out.println("			<table class=\"contentTable\" cellpadding=\"0\" cellspacing=\"0\">");
		out.println("				<tr>");
		out.println("					<td class=\"content-window\" colspan=\"3\">");
		createTitle();

	}
	
	private void createTitle() throws Exception{
		out.println("						<h1 align=\"left\">");
		out.println(							title);
		out.println("						</h1>");
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
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Forms getActiveFormId() {
		return this.activeFormId;
	}

	public void setActiveFormId(Forms activeFormId) {
		this.activeFormId = activeFormId;
	}
}
