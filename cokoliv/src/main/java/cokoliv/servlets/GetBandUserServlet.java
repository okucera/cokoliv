package cokoliv.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cokoliv.databobjects.User;
import cokoliv.enumerate.EFlows;
import cokoliv.enumerate.Forms;
import cokoliv.flowdata.LoadBandUserFlowData;
import cokoliv.support.Constants;
import cokoliv.support.StringOperations;

/**
 * Servlet implementation class GetBandUserServlet
 */
public class GetBandUserServlet extends BasicAbstractServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetBandUserServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.request = request;
		this.response = response;
		
		request.setCharacterEncoding(PAGE_DEFAULT_ENCODING);
		response.setCharacterEncoding(PAGE_DEFAULT_ENCODING);
		
		String bandUserId = request.getParameter(Constants.BAND_USER_ID);
		
		if(!StringOperations.getInstance().isNullOrEmpty(bandUserId)){
			User user = new User();
			user.setUserId(bandUserId);
			
			LoadBandUserFlowData flowData = new LoadBandUserFlowData();
			flowData.setUser(user);
			
			//execute flow here
			EFlows.FL008.executeFlow(flowData);
			
			flowData.setNextFormId(Forms.FRM009);
			
			if(flowData.getErrorMessage() == null){
				redirectWithFlowdata(flowData);
			}else{
				redirectToError(flowData.getErrorMessage());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
