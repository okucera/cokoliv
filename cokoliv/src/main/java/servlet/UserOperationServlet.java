package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cokoliv.databobjects.LoggedUser;
import cokoliv.enumerate.EFlows;
import cokoliv.enumerate.MessageCodes;
import cokoliv.flowdata.ChangeUserDetailData;
import cokoliv.support.Constants;

/**
 * Servlet implementation class UserOperationServlet
 */
public class UserOperationServlet extends BasicAbstractServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserOperationServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		
		request.setCharacterEncoding(PAGE_DEFAULT_ENCODING);
		response.setCharacterEncoding(PAGE_DEFAULT_ENCODING);

		this.session = request.getSession();

		//test
		String logfile = request.getParameter("logfile");
		if(!strOp.isNullOrEmpty(logfile)){
			ServletLogger logger = new ServletLogger(logfile);
			logger.logInfo("Yeap, I'm here...");
			response.sendRedirect("../logTest.html");
			return;
		}
		
		String firstName = request.getParameter(Constants.FORM_USER_FIRST_NAME);
		String lastName = request.getParameter(Constants.FORM_USER_LAST_NAME);
		String nick = request.getParameter(Constants.FORM_USER_NICK);
		String newPwd = request.getParameter(Constants.FORM_USER_NEW_PWD);
		String retypedNewPwd = request.getParameter(Constants.FORM_USER_NEW_PWD_RETYPED);
		
		String[] params = {firstName, lastName, nick, newPwd, retypedNewPwd};
		if(!strOp.isArrayNullOrEmpty(params)){
			
			//Object loggedUserObj = this.session.getAttribute(Constants.LOGGED_USER_KEY);
			String newPwd64 = strOp.base64EncodedString(newPwd);
			String retypedNewPwd64 = strOp.base64EncodedString(retypedNewPwd);
			LoggedUser loggedUser = getLoggedUser();
			
			if(loggedUser!=null){
				loggedUser.setFirstName(firstName);
				loggedUser.setLastName(lastName);
				loggedUser.setNick(nick);
				ChangeUserDetailData data = new ChangeUserDetailData();
				data.setUserToStore(loggedUser);
				data.setNewPassword(newPwd64);
				data.setRetypedNewPassword(retypedNewPwd64);
				executeFlow(EFlows.FL003, data);

				redirectToFormWithMessage(data.getNextFormId(), data.getMessage());
			}else{
				//TODO: V session nenalezen zadny zalogovany uzivatel
			}
		}else{
			redirectToError(MessageCodes.HLA020);
		}
	}

}
