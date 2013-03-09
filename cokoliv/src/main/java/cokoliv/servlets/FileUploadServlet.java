package cokoliv.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cokoliv.enumerate.EFlows;
import cokoliv.enumerate.EWizzardItems;
import cokoliv.enumerate.Forms;
import cokoliv.enumerate.MessageCodes;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.enumerate.WizzardActionEnum;
import cokoliv.flowdata.UploadFileData;
import cokoliv.support.Constants;

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
		
		if(ServletFileUpload.isMultipartContent(request)){			
			String strFormId = getParameterFromMultipartRequest(request, Constants.FORM_ID_KEY);
			String strWizzardAction = getParameterFromMultipartRequest(request, Constants.WIZZARD_ACTION_KEY); 
			String strWizzardItem = getParameterFromMultipartRequest(request, Constants.WIZZARD_ITEM_TYPE_KEY);
			
			if(!strOp.isNullOrEmpty(strFormId) && !strOp.isNullOrEmpty(strWizzardAction) && !strOp.isNullOrEmpty(strWizzardItem)) {
				//Get repository
				UploadRepositories repository = UploadRepositories.NEWS_IMAGES_UPLOAD_REPOSITORY;
				
				//set forms and wizzards
				Forms formId = Forms.valueOf(strFormId);
				WizzardActionEnum wizzardAction = WizzardActionEnum.valueOf(strWizzardAction);
				EWizzardItems wizzardItem = EWizzardItems.valueOf(strWizzardItem);
				
				//set flow data - load uploaded image as stream, repository for uploaded data and form from which request comes
				UploadFileData flowData = new UploadFileData();
				flowData.setOnResultLoadAsStream(true);
				flowData.setRepository(repository);
				flowData.setNextFormId(formId);
				flowData.setFiles(getFiles());
				
				context.setActiveWizzardItem(wizzardItem);
				context.setWizzardAction(wizzardAction);
				
				EFlows.FL005.executeFlow(flowData);
				if(flowData.getErrorMessage()==null){
					redirectToForm(flowData.getNextFormId());
				}else{
					redirectToError(flowData.getErrorMessage());
				}
			}else{
				redirectToError(MessageCodes.HLA025);
			}
		}
	}
	
	private File[] getFiles(){
		
		return null;
	}
}
