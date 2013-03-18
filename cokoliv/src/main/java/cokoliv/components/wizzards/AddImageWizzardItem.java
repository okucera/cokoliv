package cokoliv.components.wizzards;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import cokoliv.components.WizzardComponent;
import cokoliv.enumerate.EWizzardItems;
import cokoliv.enumerate.Forms;
import cokoliv.enumerate.WizzardActionEnum;
import cokoliv.flowdata.IFlowData;
import cokoliv.support.Constants;
import cokoliv.support.PropertyManager;
import cokoliv.support.StyleNames;

public class AddImageWizzardItem extends WizzardItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7904878216687345947L;
	private PropertyManager properties = new PropertyManager();
	private String imageFilename = null;
	private Forms activeFormId;

	@Override
	protected void appendToStartTag() {
		initialize();
		if(this.getParent() instanceof WizzardComponent){
			((WizzardComponent)this.getParent()).addWizzardItem(this);
			this.activeFormId = ((WizzardComponent)this.getParent()).getActiveFormId();
		}
	}

	@Override
	protected void appendToEndTag() {
		// TODO Auto-generated method stub
		
	}
	
	private void initialize() {
		this.itemName = EWizzardItems.ADD_IMAGE;		
	}
	
	public void drawContent() throws IOException {
		out.println("<script>");
		out.println("	function fileChangedHandler() {");
		out.println("		document.uploadForm.submit();");
		out.println("	}");
		out.println("</script>");
		out.println("			<form name=\"uploadForm\" enctype=\"multipart/form-data\" method=\"post\" action=\"FileUploadServlet\">");
		out.println("				<table width=\"100%\">");
		out.println("					<tr>");
		out.println("						<td class=\"verticalSplitter\" width=\"220\">");
		//Image
		out.println("						<img src=\"UploadImageServlet?image=null\"/>");
		
		out.println("						</td>");
		out.println("						<td>");
		//Image info
		getImageInfo();
		out.println("						</td>");
		out.println("					</tr>");
		out.println("					<tr>");
		out.println("						<td class=\"verticalSplitter\" width=\"220\">");
		//Image
		out.println("							<input type=file size=\"15px\" name=\""+Constants.FILE_INPUT_IMAGE_NAME+"\" class=\""+StyleNames.INPUT_FILE_STYLE+"\"/>");
		out.println("							<input type=HIDDEN name=\""+Constants.FORM_ID_KEY+"\" value=\""+this.activeFormId.name()+"\"/>");		
		out.println("							<input type=HIDDEN name=\""+Constants.WIZZARD_ITEM_TYPE_KEY+"\" value=\""+this.itemName.name()+"\"/>");		
		out.println("							<input type=HIDDEN name=\""+Constants.WIZZARD_ACTION_KEY+"\" value=\""+WizzardActionEnum.NEXT.name()+"\"/>");		
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
	
	private void getImageInfo() throws IOException {
		//File file = new File(defaultImagePath);
		out.println("<table style=\"color:white\">");
		out.println("<tr>");
		out.println("<td>");
		out.println("Nazev souboru: ");
		out.println("</td>");
		out.println("<td>");
		out.println();
		out.println("</td>");
		out.println("<tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Velikost: ");
		out.println("</td>");
		out.println("<td>");
		out.println();
		out.println("</td>");
		out.println("<tr>");
		out.println("</table>");

	}

	public String getImageFilename() {
		return imageFilename;
	}

	public void setImageFilename(String imageFilename) {
		this.imageFilename = imageFilename;
	}

}
