package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cokoliv.enumerate.EFlows;
import cokoliv.enumerate.EWizzardItems;
import cokoliv.enumerate.Forms;
import cokoliv.enumerate.MessageCodes;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.enumerate.WizzardActionEnum;
import cokoliv.flowdata.UploadFileData;
import cokoliv.support.Constants;
import cokoliv.support.HttpServletUtils;

/**
 * Servlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends BasicAbstractServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FileUploadServlet() {
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
		this.response = response;
		this.request = request;
		this.session = request.getSession();
		
		if(ServletFileUpload.isMultipartContent(request)){
			UploadRepositories parseUploadRepository = UploadRepositories.DEFAULT_IMAGES_UPLOAD_REPOSITORY;
			List<FileItem> multipartItems = HttpServletUtils.parseMultipartFormHttpServletRequest(request, parseUploadRepository);
			
			String strFormId = HttpServletUtils.getParameterFromMultipartRequestItems(multipartItems, Constants.FORM_ID_KEY);
			String strWizzardAction = HttpServletUtils.getParameterFromMultipartRequestItems(multipartItems, Constants.WIZZARD_ACTION_KEY); 
			String strWizzardItem = HttpServletUtils.getParameterFromMultipartRequestItems(multipartItems, Constants.WIZZARD_ITEM_TYPE_KEY);
			String strUploadRepository = HttpServletUtils.getParameterFromMultipartRequestItems(multipartItems, Constants.HIDDEN_ELEMENT_UPLOAD_IMAGE_REPOSITORY);
			
			if(!strOp.isNullOrEmpty(strFormId) && !strOp.isNullOrEmpty(strWizzardAction) && !strOp.isNullOrEmpty(strWizzardItem) && !strOp.isNullOrEmpty(strUploadRepository)) {
				//set forms and wizzards
				logger.logError("FileUploadServlet upload new file: strFormId="+strFormId+", strWizzardAction="+strWizzardAction+", strWizzardItem="+strWizzardItem+", strUploadRepository="+strUploadRepository);
				Forms formId = Forms.valueOf(strFormId);
				WizzardActionEnum wizzardAction = WizzardActionEnum.valueOf(strWizzardAction);
				EWizzardItems wizzardItem = EWizzardItems.valueOf(strWizzardItem);
				UploadRepositories uploadRepository = UploadRepositories.valueOf(strUploadRepository);
				
				//set flow data - load uploaded image as stream, repository for uploaded data and form from which request comes
				UploadFileData flowData = new UploadFileData();
				flowData.setOnResultLoadAsStream(true);
				flowData.setNextFormId(formId);
				flowData.setFileItems(HttpServletUtils.getNonFormFileItems(multipartItems));
				flowData.setRepository(uploadRepository);
				//flowData.setMakePreview(true);
				flowData.setLoggedUser(getLoggedUser());
				
				context.setActiveWizzardItem(wizzardItem);
				context.setWizzardAction(wizzardAction);
				
				EFlows.FL005.executeFlow(flowData);

				if(flowData.getErrorMessage()==null){
					redirectWithFlowdata(flowData);
				}else{
					redirectToError(flowData.getErrorMessage());
				}
			}else{
				logger.logError("FileUploadServlet required params are not set: strFormId="+strFormId+", strWizzardAction="+strWizzardAction+", strWizzardItem="+strWizzardItem+", strUploadRepository="+strUploadRepository);
				redirectToError(MessageCodes.HLA025);
			}
		}else{
			redirectToError(MessageCodes.HLA023);
		}
	}

	

}
