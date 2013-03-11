package cokoliv.components.wizzards;

import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import cokoliv.components.WizzardComponent;
import cokoliv.enumerate.EWizzardItems;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.flowdata.UploadFileData;

public class AddNewsTextWizzardItem extends WizzardItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3994571760199022961L;

	@Override
	protected void appendToStartTag() {
		// TODO Auto-generated method stub
		this.itemName = EWizzardItems.ADD_TEXT;
		if(this.getParent() instanceof WizzardComponent){
			((WizzardComponent)this.getParent()).addWizzardItem(this);
		}
	}

	@Override
	protected void appendToEndTag() {
		// TODO Auto-generated method stub

	}
	
	public void drawContent() throws IOException {
		//load stored image
		String imgFilename = getImageFilenameFromContext();
		UploadRepositories imgRepository = getRepositoryFromContext();
		
		out.println("			<form name=\"inputTextForm\" method=\"post\" action=\"IportNewsServlet\">");
		out.println("				<table width=\"100%\">");
		out.println("					<tr>");
		out.println("						<td class=\"verticalSplitter\" width=\"220\">");
		//Image
		out.println("						<img src=\"UploadImageServlet?image="+imgFilename+"&repo="+imgRepository.name()+"\"/>");
		
		out.println("						</td>");
		out.println("						<td>");
		//Image info
		out.println("						</td>");
		out.println("					</tr>");
		out.println("					<tr>");
		out.println("						<td class=\"verticalSplitter\" width=\"220\">");
		//Image
		out.println("						</td>");
		out.println("						<td>");
		//Image info
		out.println("						</td>");
		out.println("					</tr>");

		out.println("					<tr>");
		out.println("						<td colspan=\"2\">");
		//next					
		out.println("							<input type=SUBMIT value=\"Pokracovat\"/>");
		out.println("						</td>");
		out.println("					</tr>");

		out.println("				</table>");
		out.println("			</form>");
	}
	
	private String getImageFilenameFromContext() {
		if(this.getFlowDataFromContext() instanceof UploadFileData) {
			UploadFileData uploadFileData = (UploadFileData) this.getFlowDataFromContext();
			List<FileItem> fileItems = uploadFileData.getUploadedItems();
			
			if(fileItems != null && fileItems.size() > 0)
				return ((FileItem)fileItems.get(0)).getName();
		}
		
		return null;
	}
	
	private UploadRepositories getRepositoryFromContext() {
		if(this.getFlowDataFromContext() instanceof UploadFileData) {
			UploadFileData uploadFileData = (UploadFileData) this.getFlowDataFromContext();
			UploadRepositories repository = uploadFileData.getRepository();
			return repository;
		}
		
		return null;
	}

}
