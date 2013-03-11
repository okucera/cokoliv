package cokoliv.flows;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

import cokoliv.enumerate.MessageCodes;
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
				//Check if uploading filename does not exists
				List<FileItem> excludedItems = admin.getExistingFilesFromList(data.getFileItems(), data.getRepository());				
				List<FileItem> uploadedItems = admin.uploadFileFromForm(data.getFileItems(), data.getRepository(), excludedItems);
				
				if(uploadedItems != null && uploadedItems.size() > 0) {
					data.setUploadedItems(uploadedItems);
				}
				
				if(excludedItems != null && excludedItems.size() > 0) {
					data.setExcludedItems(excludedItems);
				}
			} else {
				//nemate dostatecna opravneni
				data.setErrorMessage(MessageCodes.HLA024);
			}
		}
		
	}
}
