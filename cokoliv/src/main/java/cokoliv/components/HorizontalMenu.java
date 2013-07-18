package cokoliv.components;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import cokoliv.databobjects.MenuItem;
import cokoliv.enumerate.Forms;
import cokoliv.support.CokolivContext;
import cokoliv.support.Constants;

public class HorizontalMenu extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2063367103458286661L;
	
	private JspWriter out;
	private CokolivContext context = CokolivContext.getContext();
	private Forms activeFormId;
	
	public int doStartTag(){
		try{
			out = pageContext.getOut();
			createMenu();
			return EVAL_BODY_INCLUDE;
		}catch(Exception ex){
			throw new Error("Error in HorizontalMenu doStartTag.");
		}
	}
	
	private void createMenu() throws Exception{
		out.println("<table class=\"outsideCorners\" cellpadding=\"0\" cellspacing=\"0\">");
		out.println("	<tr>");
		out.println("		<td class=\"leftUpOutsideCorner\">");
		out.println("			&nbsp;");
		out.println("		</td>");
		out.println("		<td class=\"upLine\" valign=\"bottom\">");
		getMenu("myActualUrl");
		out.println("		</td>			");
		out.println("		<td class=\"rightUpOutsideCorner\">");
		out.println("			&nbsp;");
		out.println("		</td>");
		out.println("	</tr>		");
		out.println("</table>");					
	}
	
	private void getMenu(String actualUrl){
		MenuItem[] items = context.getMenuItems();
		
		try {
			out.println("<table class=\"hMenu\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">");
			out.println("	<tr>");
			for(MenuItem item:items){
				String className = "";
				
				if(item.getFormId() == this.activeFormId){
					className=Constants.ACTIVE_ITEM_CLASS_NAME;
				}else{
					className=Constants.FREE_ITEM_CLASS_NAME;
				}
				out.println("		<td class=\""+className+"\">");
				out.println("			<a href=\""+item.getMenuLink()+"\"><img src=\""+item.getMenuImgUrl()+"\"></a>");
				out.println("		</td>");				
			}
			out.println("	</tr>");
			out.println("</table>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Forms getActiveFormId() {
		return this.activeFormId;
	}

	public void setActiveFormId(Forms activeFormId) {
		this.activeFormId = activeFormId;
	}
	
	public int doEndTag(){
		try{
			@SuppressWarnings("unused")
			JspWriter out = pageContext.getOut();
			return EVAL_PAGE;
		}catch(Exception ex){
			throw new Error("Error in HorizontalMenu doStartTag.");
		}	
	}

}
