package cokoliv.menu.vertical;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import cokoliv.enumerate.EFlows;
import cokoliv.flowdata.IFlowData;
import cokoliv.renderers.CokolivAbstractItemRenderer;

public abstract class VerticalMenu extends TagSupport implements IVerticalMenu {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4648610564044454443L;
	
	protected JspWriter out;
	protected CokolivAbstractItemRenderer itemRenderer;

	public void executeFlow(EFlows flow, IFlowData flowData) {
		flow.executeFlow(flowData);
	}
	
	public abstract void renderMenu() throws IOException;
}
