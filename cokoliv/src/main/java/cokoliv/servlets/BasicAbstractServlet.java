package cokoliv.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cokoliv.enumerate.EFlows;
import cokoliv.enumerate.EWizzardItems;
import cokoliv.enumerate.Forms;
import cokoliv.enumerate.MessageCodes;
import cokoliv.flowdata.IFlowData;
import cokoliv.support.CokolivContext;
import cokoliv.support.Constants;
import cokoliv.support.StringOperations;

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

	/*
	 * Presmerovani na <code>form</code> s wizzardem na polozku wizzardu <code>item</code>
	 */
	protected void redirectToFormWizzard(Forms form, EWizzardItems item) throws IOException{
		String url = form.getUrl();
		this.response.sendRedirect(url);		
	}
	
	/*
	 * Presmerovani na <code>form</code>
	 */
	protected void redirectToForm(Forms form) throws IOException{
		String url = form.getUrl();
		this.response.sendRedirect(url);
	}
	
	/*
	 * Presmerovani na <code>form</code> s flow data
	 */
	protected void redirectWithFlowdata(IFlowData flowdata) throws IOException, ServletException {
		String url = flowdata.getNextFormId().getUrl();
		ServletContext sc = getServletContext();
		RequestDispatcher dispatcher = sc.getRequestDispatcher("/"+url);
		
		this.request.setAttribute(Constants.FLOW_DATA, flowdata);
		dispatcher.forward(request, response);
	}
	
	/*
	 * Presmerovani na <code>ErrorPage</code>
	 */
	protected void redirectToError(MessageCodes messageCode) throws IOException {
		this.response.sendRedirect("error.jsp?errCode="+messageCode.getErrorCode());
	}

}
