package cokoliv.flows;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

import cokoliv.enumerate.MessageCodes;
import cokoliv.flowdata.IFlowData;
import cokoliv.flowdata.UploadFileData;
import cokoliv.modules.adm.AdminModule;
import cokoliv.modules.adm.IAdminModule;
import cokoliv.support.UserHelper;

public class UploadFileFlow extends BasicFlow implements IFlow {
	
	IAdminModule admin = new AdminModule();
	
	public void executeFlow(IFlowData flowData) {
		if(flowData instanceof UploadFileData){
			UploadFileData data = (UploadFileData) flowData;
			
			if(this.cokoliv.getLoggedUser() != null && UserHelper.isLoggedUserAdminOrSuperuser(this.cokoliv.getLoggedUser())){
				//Check if uploading filename does not exists
				List<FileItem> excludedItems = admin.getExistingFilesFromList(data.getFileItems(), data.getRepository());
				
				//upload files stored in flow data except the files which already exists
				List<FileItem> uploadedItems = admin.uploadFilesToRepository(data.getFileItems(), data.getRepository(), excludedItems);
				
				//If making preview is enabled then make preview for uploaded files only (not for excluded files)
				if(data.isMakePreview()){
					admin.makeImagePreviewInRepository(uploadedItems, data.getRepository());
				}
				
				if(uploadedItems != null && uploadedItems.size() > 0) {
					data.setUploadedItems(uploadedItems);
				}
				
				if(excludedItems != null && excludedItems.size() > 0) {
					data.setExcludedItems(excludedItems);
				}
				
				//Delete temporary files in selected repository
				admin.deleteTempFilesInRepository(data.getRepository());
			} else {
				//nemate dostatecna opravneni
				data.setErrorMessage(MessageCodes.HLA024);
			}
		}
		
	}
}
