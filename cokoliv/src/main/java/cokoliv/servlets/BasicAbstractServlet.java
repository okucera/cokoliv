package cokoliv.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cokoliv.databobjects.LoggedUser;
import cokoliv.enumerate.EFlows;
import cokoliv.enumerate.Forms;
import cokoliv.enumerate.MessageCodes;
import cokoliv.flowdata.IFlowData;
import cokoliv.support.Constants;
import cokoliv.support.StringOperations;

public abstract class BasicAbstractServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -720282034437076223L;
	protected HttpSession session;
	protected HttpServletResponse response;
	protected StringOperations strOp = StringOperations.getInstance();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected abstract void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	protected abstract void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	protected void executeFlow(EFlows flow, IFlowData flowData){
		flow.executeFlow(flowData);
	}
	
	protected void redirectToFormWithMessage(Forms form, MessageCodes message) throws IOException {
		if(message==null){
			redirectToForm(form);
		}else{
			String url = form.getUrl();
			String messageCode = message.getErrorCode();
			this.response.sendRedirect(url+"?msg="+messageCode);
		}
	}

	protected void redirectToForm(Forms form) throws IOException{
		String url = form.getUrl();
		this.response.sendRedirect(url);
	}

	protected void redirectToError(MessageCodes messageCode) throws IOException {
		this.response.sendRedirect("error.jsp?errCode="+messageCode.getErrorCode());
	}
	
	protected LoggedUser getRequestLoggedUser(HttpServletRequest request){
		return (LoggedUser) request.getSession().getAttribute(Constants.LOGGED_USER_KEY);
	}

}
