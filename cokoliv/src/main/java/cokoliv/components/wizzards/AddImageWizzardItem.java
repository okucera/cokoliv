package cokoliv.components.wizzards;

import java.io.File;
import java.io.IOException;

import cokoliv.components.WizzardComponent;
import cokoliv.enumerate.EWizzardItems;
import cokoliv.support.Constants;
import cokoliv.support.StyleNames;

public class AddImageWizzardItem extends WizzardItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7904878216687345947L;
	private static final String DEFAULT_IMAGE_FILENAME = "img/defaultImg.jpg";

	@Override
	protected void appendToStartTag() {
		// TODO Auto-generated method stub
		this.itemName = EWizzardItems.ADD_IMAGE;
		if(this.getParent() instanceof WizzardComponent){
			((WizzardComponent)this.getParent()).addWizzardItem(this);
		}
	}

	@Override
	protected void appendToEndTag() {
		// TODO Auto-generated method stub
		
	}
	
	public void drawContent() throws IOException {
		out.println("			<form enctype=\"multipart/form-data\" method=\"post\" action=\"#\">");
		out.println("<table width=\"100%\">");
		out.println("	<tr>");
		out.println("		<td class=\"verticalSplitter\" width=\"220\">");
		//Image
		out.println("			<img src=\""+DEFAULT_IMAGE_FILENAME+"\"/>");
		out.println("		</td>");
		out.println("		<td>");
		//Image info
		getImageInfo();
		out.println("		</td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td class=\"verticalSplitter\" width=\"220\">");
		//Image
		out.println("				<input type=file size=\"15px\" name=\""+Constants.FILE_INPUT_IMAGE_NAME+"\" class=\""+StyleNames.INPUT_FILE_STYLE+"\"/>");

		out.println("		</td>");
		out.println("		<td>");
		//Image info
		out.println("		</td>");
		out.println("	</tr>");

		out.println("	<tr>");
		out.println("		<td colspan=\"2\">");
		//next					
		out.println("			<input type=SUBMIT value=\"Pokracovat\"/>");
		out.println("		</td>");
		out.println("	</tr>");

		out.println("</table>");
		out.println("			</form>");
	}
	
	private void getImageInfo() throws IOException {
		File file = new File(DEFAULT_IMAGE_FILENAME);
		out.println("<table style=\"color:white\">");
		out.println("<tr>");
		out.println("<td>");
		out.println("Nazev souboru: ");
		out.println("</td>");
		out.println("<td>");
		out.println(file.getName());
		out.println("</td>");
		out.println("<tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Velikost: ");
		out.println("</td>");
		out.println("<td>");
		out.println(file.length());
		out.println("</td>");
		out.println("<tr>");
		out.println("</table>");

	}

}
