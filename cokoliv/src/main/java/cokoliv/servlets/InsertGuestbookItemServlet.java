package cokoliv.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cokoliv.databobjects.Captcha;
import cokoliv.databobjects.GuestbookItem;
import cokoliv.enumerate.EFlows;
import cokoliv.enumerate.Forms;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.flowdata.InsertGuestbookItemData;
import cokoliv.support.Constants;
import cokoliv.support.StringOperations;

/**
 * Servlet implementation class InsertGuestbookItemServlet
 */
public class InsertGuestbookItemServlet extends BasicAbstractServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InsertGuestbookItemServlet() {
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

		request.setCharacterEncoding(PAGE_DEFAULT_ENCODING);
		response.setCharacterEncoding(PAGE_DEFAULT_ENCODING);

		String nick = request.getParameter(Constants.FORM_USER_NICK);
		String msg = request.getParameter(Constants.FORM_TEXTAREA_GUESTBOOK_MSG);
		String rewrited = request.getParameter(Constants.FORM_CAPTCHA_TEXT);

		InsertGuestbookItemData flowData = new InsertGuestbookItemData();
		flowData.setNextFormId(Forms.FRM006);
		
		if(Captcha.getInstnace().isTextCaptcha(rewrited)){
			if(!StringOperations.getInstance().isNullOrEmpty(nick) && !StringOperations.getInstance().isNullOrEmpty(msg)){
				flowData.setGuestbookItem(new GuestbookItem());

				flowData.getGuestbookItem().setMessage(msg);
				flowData.getGuestbookItem().setNick(nick);
				flowData.getGuestbookItem().setImgRepository(UploadRepositories.GUESTBOOK_REPOSITORY);
				flowData.getGuestbookItem().setImgUrl("defaultImg.jpg");

				executeFlow(EFlows.FL011, flowData);

				if(flowData.getErrorMessage()==null){
					redirectToForm(Forms.FRM006);
				}else{
					redirectToError(flowData.getErrorMessage());
				}
			}
		} else {
			flowData.setCaptchaWrong(true);
			redirectWithFlowdata(flowData);
		}
	}

}
