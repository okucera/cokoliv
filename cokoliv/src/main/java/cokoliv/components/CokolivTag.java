package cokoliv.components;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import cokoliv.enumerate.EFlows;
import cokoliv.enumerate.MessageCodes;
import cokoliv.flowdata.IFlowData;
import cokoliv.renderers.ICokolivItemRenderer;

public class CokolivTag extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4591560413361312157L;
	
	protected JspWriter out;
	protected ICokolivItemRenderer itemRenderer;

	public void executeFlow(EFlows flow, IFlowData flowData) {
		flow.executeFlow(flowData);
	}
	
	public void renderErrorMsg(MessageCodes msg) throws IOException {
		out.println(msg.getErrorMessage());
	}
}
