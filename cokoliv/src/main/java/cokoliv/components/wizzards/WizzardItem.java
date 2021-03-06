package cokoliv.components.wizzards;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import cokoliv.enumerate.EWizzardItems;
import cokoliv.flowdata.IFlowData;

public abstract class WizzardItem extends TagSupport implements IWizzardItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -827355697196928686L;
	protected EWizzardItems itemName;
	protected IFlowData flowData;
	
	protected JspWriter out;

	public int doStartTag(){
		try{
			out = pageContext.getOut();
			appendToStartTag();
			return EVAL_BODY_INCLUDE;
		}catch(Exception ex){
			throw new Error("Error in HorizontalMenu doStartTag.");
		}	
	}
	
	public int doEndTag(){
		try{
			appendToEndTag();
			return EVAL_PAGE;
		}catch(Exception ex){
			throw new Error("Error in HorizontalMenu doStartTag.");
		}	
	}
	
	public EWizzardItems getType() {
		return this.itemName;
	}
	
	protected abstract void appendToStartTag();
	protected abstract void appendToEndTag();

	public IFlowData getFlowData() {
		return flowData;
	}

	public void setFlowData(IFlowData flowData) {
		this.flowData = flowData;
	}

}
