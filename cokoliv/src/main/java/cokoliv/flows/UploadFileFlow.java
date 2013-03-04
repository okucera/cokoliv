package cokoliv.flows;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cokoliv.flowdata.IFlowData;
import cokoliv.flowdata.UploadFileData;
import cokoliv.modules.adm.AdminModule;
import cokoliv.support.UserHelper;

public class UploadFileFlow extends BasicFlow implements IFlow {
	
	AdminModule admin = new AdminModule();
	
	public void executeFlow(IFlowData flowData) {
		if(flowData instanceof UploadFileData){
			UploadFileData data = (UploadFileData) flowData;
			
			if(this.cokoliv.getLoggedUser() != null && UserHelper.isLoggedUserAdminOrSuperuser(this.cokoliv.getLoggedUser())){
				if(ServletFileUpload.isMultipartContent(data.getRequest())){
					//TODO - Check if uploading filename does not exists
					admin.uploadFileFromForm(data.getRequest(), data.getRepository(), data.getMaxMemSize(), data.getMaxFileSize());
				}else{
					//TODO - wrong type of form data
				}
			} else {
				//TODO - nemate dostatecna opravneni
			}
		}
		
	}

}
