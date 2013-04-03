package cokoliv.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cokoliv.enumerate.EFlows;
import cokoliv.enumerate.Forms;
import cokoliv.enumerate.MessageCodes;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.flowdata.LoginUserFlowData;
import cokoliv.support.Constants;
import cokoliv.support.StringOperations;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends BasicAbstractServlet {
	private static final long serialVersionUID = 1L;
	
	


       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
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
		this.session = request.getSession();
		this.request = request;
		this.response = response;
		
		request.setCharacterEncoding(PAGE_DEFAULT_ENCODING);
		response.setCharacterEncoding(PAGE_DEFAULT_ENCODING);


		String username = request.getParameter(Constants.FORM_TEXTFIELD_USERNAME);
		String password = request.getParameter(Constants.FORM_TEXTFIELD_PWD);
		String strFormId = request.getParameter(Constants.FORM_ID_KEY);
		
		if(!strOp.isNullOrEmpty(username) && !strOp.isNullOrEmpty(password) && !strOp.isNullOrEmpty(strFormId)){
			String password64 = StringOperations.getInstance().base64EncodedString(password);
			Forms formId = Forms.valueOf(strFormId);
			
			LoginUserFlowData flowData = new LoginUserFlowData();
			flowData.setUsername(username);
			flowData.setPassword64(password64);
			flowData.setNextFormId(formId);
			executeFlow(EFlows.FL002, flowData);
			if(flowData.getErrorMessage()==null){
				initializeRepositories();
				redirectToForm(flowData.getNextFormId());
			}else{
				redirectToError(flowData.getErrorMessage());
			}
		}else{
			redirectToError(MessageCodes.HLA020);
		}
	}
	
	private void initializeRepositories(){
		for(UploadRepositories repository : UploadRepositories.values()){
			repository.setServletContext(this.getServletContext());
		}
	}
	
	/*
	private void setLoggedUserSession(LoggedUser user){
		this.session.setAttribute(Constants.LOGGED_USER_KEY, user);
	}
	*/
}
