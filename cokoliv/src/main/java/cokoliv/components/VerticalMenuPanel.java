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
			if(verticalMenu!=null) {
				verticalMenu.renderMenu();
			}
			return EVAL_PAGE;
		}catch(Exception ex){
			throw new Error("Error in HorizontalMenu doStartTag.");
		}	
	}

	public Forms getActiveFormId() {
		return activeFormId;
	}

	public void setActiveFormId(Forms activeFormId) {
		this.activeFormId = activeFormId;
	}
}
