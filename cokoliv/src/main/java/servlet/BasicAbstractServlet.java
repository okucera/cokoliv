package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cokoliv.databobjects.LoggedUser;
import cokoliv.enumerate.EFlows;
import cokoliv.enumerate.EWizzardItems;
import cokoliv.enumerate.Forms;
import cokoliv.enumerate.MessageCodes;
import cokoliv.flowdata.IFlowData;
import cokoliv.flowdata.manager.FlowDataManager;
import cokoliv.flowdata.manager.IFlowDataManager;
import cokoliv.support.CokolivContext;
import cokoliv.support.Constants;
import cokoliv.support.StringOperations;
import cokoliv.support.UserHelper;

public abstract class BasicAbstractServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -720282034437076223L;
	protected HttpSession session;
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	
	protected final String PAGE_DEFAULT_ENCODING="UTF-8";

	protected StringOperations strOp = StringOperations.getInstance();
	protected CokolivContext context = CokolivContext.getContext();
	private IFlowDataManager flowDataManager = FlowDataManager.getInstance();
	protected final ServletLogger logger = ServletLogger.getInstance();
	
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
			this.response.sendRedirect("../"+url+"?msg="+messageCode);
		}
	}

	/*
	 * Presmerovani na <code>form</code> s wizzardem na polozku wizzardu <code>item</code>
	 */
	protected void redirectToFormWizzard(Forms form, EWizzardItems item) throws IOException{
		String url = form.getUrl();
		this.response.sendRedirect("../"+url);		
	}
	
	/*
	 * Presmerovani na <code>form</code>
	 */
	protected void redirectToForm(Forms form) throws IOException{
		String url = form.getUrl();
		this.response.sendRedirect("../"+url);
	}
	
	/*
	 * Presmerovani na <code>form</code> s flow data
	 */
	protected void redirectWithFlowdata(IFlowData flowData) throws IOException, ServletException {
		String url = flowData.getNextFormId().getUrl();
		String key = flowDataManager.storeFlowData(flowData);
		url += "?"+Constants.FLOW_DATA_KEY+"="+key;
		this.response.sendRedirect("../"+url);
	}
	
	/*
	 * Presmerovani na <code>ErrorPage</code>
	 */
	protected void redirectToError(MessageCodes messageCode) throws IOException {
		this.response.sendRedirect("../error.jsp?errCode="+messageCode.getErrorCode()+"&errTrace="+messageCode.getCustomMessage());
	}

	protected void storeToSession(String key, Object object) {
		this.session.setAttribute(key, object);
	}
	
	protected LoggedUser getLoggedUser() {
		if(this.session.getAttribute(UserHelper.LOGGED_USER)==null){
			return null;
		} else {
			return (LoggedUser) this.session.getAttribute(UserHelper.LOGGED_USER);
		}
	}
}
