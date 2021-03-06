package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cokoliv.databobjects.NewItem;
import cokoliv.enumerate.EFlows;
import cokoliv.enumerate.EWizzardItems;
import cokoliv.enumerate.Forms;
import cokoliv.enumerate.MessageCodes;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.enumerate.WizzardActionEnum;
import cokoliv.flowdata.ImportNewsData;
import cokoliv.support.Constants;

/**
 * Servlet implementation class ImportNewsServlet
 */
public class ImportNewsServlet extends BasicAbstractServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ImportNewsServlet() {
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

		
		String title = request.getParameter(Constants.FORM_NEWS_TITLE);
		String text = request.getParameter(Constants.FORM_NEWS_DESCR);
		String imgFilename = request.getParameter(Constants.HIDDEN_ELEMENT_NEW_IMG_FILENAME);
		String strImgRepo = request.getParameter(Constants.HIDDEN_ELEMENT_UPLOAD_IMAGE_REPOSITORY);
		
		//String formId = request.getParameter(Constants.FORM_ID_KEY);
		String strWizzardAction = request.getParameter(Constants.WIZZARD_ACTION_KEY); 
		String strWizzardItem = request.getParameter(Constants.WIZZARD_ITEM_TYPE_KEY);

		
		UploadRepositories repository = strImgRepo == null ? null : UploadRepositories.valueOf(strImgRepo.toString());
		
		WizzardActionEnum wizzardAction = strWizzardAction == null ? null : WizzardActionEnum.valueOf(strWizzardAction.toString());
		EWizzardItems wizzardItem = strWizzardItem == null ? null : EWizzardItems.valueOf(strWizzardItem.toString());
		
		if(!strOp.isNullOrEmpty(title) &&
		   !strOp.isNullOrEmpty(text) &&
		   !strOp.isNullOrEmpty(imgFilename) &&
		   repository != null &&
		   wizzardAction != null &&
		   wizzardItem != null) {
			
			ImportNewsData flowData = new ImportNewsData();
			
			NewItem item = new NewItem();
			item.setTitle(title);
			item.setMessage(text);
			item.setImgUrl(imgFilename);
			item.setImgRepository(repository);
			
			flowData.setNewItem(item);
			flowData.setLoggedUser(getLoggedUser());
			
			context.setActiveWizzardItem(wizzardItem);
			context.setWizzardAction(wizzardAction);
			
			executeFlow(EFlows.FL006, flowData);
			//EFlows.FL006.executeFlow(flowData);
			
			if(flowData.getErrorMessage()==null){
				redirectToForm(Forms.FRM001);
			}else{
				redirectToError(flowData.getErrorMessage());
			}
		}else{
			redirectToError(MessageCodes.HLA025);
		}
		
		
	}

}
