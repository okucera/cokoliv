package cokoliv.components.wizzards;

import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import cokoliv.components.WizzardComponent;
import cokoliv.enumerate.EWizzardItems;
import cokoliv.enumerate.Forms;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.enumerate.WizzardActionEnum;
import cokoliv.flowdata.UploadFileData;
import cokoliv.support.Constants;
import cokoliv.support.StyleNames;

public class AddConcertTextWizzardItem extends WizzardItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3994571760199022961L;
	private Forms activeFormId;

	@Override
	protected void appendToStartTag() {
		// TODO Auto-generated method stub
		this.itemName = EWizzardItems.ADD_TEXT;
		if(this.getParent() instanceof WizzardComponent){
			((WizzardComponent)this.getParent()).addWizzardItem(this);
			this.activeFormId = ((WizzardComponent)this.getParent()).getActiveFormId();
		}
	}

	@Override
	protected void appendToEndTag() {
		// TODO Auto-generated method stub

	}
	
	public void drawContent() throws IOException {
		//load stored image
		String imgFilename = getImageFilename();
		UploadRepositories imgRepository = getRepository();
		
		out.println("			<form name=\"inputTextForm\" method=\"post\" action=\"servlet/ImportConcertServlet\">");
		out.println("				<table width=\"100%\">");
		out.println("					<tr>");
		out.println("						<td class=\"verticalSplitter\" width=\"220\">");
		//Image
		out.println("							<img src=\"servlet/GetImageServlet?image="+imgFilename+"&repo="+imgRepository.name()+"\" width=\"150px\"/>");
		//drawImageInfoTable();		
		out.println("						</td>");
		out.println("						<td valign=\"top\">");
		//Image info
		drawForm();
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
		out.println("							<input type=HIDDEN name=\""+Constants.FORM_ID_KEY+"\" value=\""+this.activeFormId.name()+"\"/>");		
		out.println("							<input type=HIDDEN name=\""+Constants.WIZZARD_ITEM_TYPE_KEY+"\" value=\""+this.itemName.name()+"\"/>");		
		out.println("							<input type=HIDDEN name=\""+Constants.WIZZARD_ACTION_KEY+"\" value=\""+WizzardActionEnum.FINISH.name()+"\"/>");		
		out.println("							<input type=HIDDEN name=\""+Constants.HIDDEN_ELEMENT_NEW_IMG_FILENAME+"\" value=\""+imgFilename+"\"/>");		
		out.println("							<input type=HIDDEN name=\""+Constants.HIDDEN_ELEMENT_UPLOAD_IMAGE_REPOSITORY+"\" value=\""+imgRepository.name()+"\"/>");		

		out.println("							<input type=SUBMIT value=\"Dokončit...\"/>");
		out.println("						</td>");
		out.println("					</tr>");

		out.println("				</table>");
		out.println("			</form>");
	}
	
	private void drawForm() throws IOException {
		out.println("				<table width=\"100%\">");
		out.println("					<tr>");
		out.println("						<td>");
		out.println("							<input type=TEXT class=\""+StyleNames.TEXT_INPUT_STYLE+"\" name=\""+Constants.FORM_NEWS_TITLE+"\" value=\"Titulek\">");		
		out.println("						</td>");
		out.println("					</tr>");
		out.println("					<tr>");
		out.println("						<td>");
		out.println("							<textarea cols=70 rows=10 name=\""+Constants.FORM_NEWS_DESCR+"\" class=\""+StyleNames.TEXT_AREA_STYLE+"\">");
		out.println("Obsah zprávy");
		out.println("							</textarea>");
		out.println("						</td>");
		out.println("					</tr>");

		out.println("					<tr>");
		out.println("						<td colspan=\"2\">");

		out.println("						</td>");
		out.println("					</tr>");

		out.println("				</table>");

	}
	
	private void drawImageInfoTable() throws IOException{
		FileItem item = getImageFileItem();
		
		String name = item.getName();
		long size = item.getSize();
		
		out.println("				<table width=\"100%\">");
		out.println("					<tr>");
		out.println("						<td>");
		out.println("							Jméno souboru: ");					
		out.println("						</td>");
		out.println("						<td>");
		out.println("							" + name);
		out.println("						</td>");
		out.println("					</tr>");
		out.println("					<tr>");
		out.println("						<td>");
		out.println("							Velikost souboru: ");
		out.println("						</td>");
		out.println("						<td>");
		out.println("							" + size / 1000);				
		out.println("						</td>");
		out.println("					</tr>");
		out.println("				</table>");

	}
	
	private String getImageFilename(){
		FileItem item = getImageFileItem();
		if(item != null)
			return item.getName();
		
		return null;
	}

	private FileItem getImageFileItem() {
		if(this.getFlowData() instanceof UploadFileData) {
			UploadFileData uploadFileData = (UploadFileData) this.getFlowData();
			List<FileItem> fileItems = uploadFileData.getUploadedItems();

			if(fileItems != null && fileItems.size() > 0)
				return (FileItem)fileItems.get(0);
		}		
		return null;
	}
	
	private UploadRepositories getRepository(){
		if(this.getFlowData() instanceof UploadFileData) {
			UploadFileData uploadFileData = (UploadFileData) this.getFlowData();
			UploadRepositories repository = uploadFileData.getRepository();
			return repository;
		}
		
		return null;
	}
	


}
