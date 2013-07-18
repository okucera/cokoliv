package cokoliv.components;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import cokoliv.databobjects.LoggedUser;
import cokoliv.enumerate.EFlows;
import cokoliv.enumerate.MessageCodes;
import cokoliv.flowdata.IFlowData;
import cokoliv.renderers.CokolivAbstractItemRenderer;
import cokoliv.support.UserHelper;

public class CokolivTag extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4591560413361312157L;
	
	protected JspWriter out;
	protected CokolivAbstractItemRenderer itemRenderer;

	public void executeFlow(EFlows flow, IFlowData flowData) {
		flow.executeFlow(flowData);
	}
	
	public void renderErrorMsg(MessageCodes msg) throws IOException {
		out.println(msg.getErrorMessage());
	}
	
	protected LoggedUser getLoggedUser() {
		return (LoggedUser) pageContext.getSession().getAttribute(UserHelper.LOGGED_USER);
	}
}
