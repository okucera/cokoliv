package cokoliv.components.wizzards;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import cokoliv.components.WizzardComponent;
import cokoliv.enumerate.EWizzardItems;
import cokoliv.support.Constants;
import cokoliv.support.PropertyManager;
import cokoliv.support.StyleNames;

public class AddImageWizzardItem extends WizzardItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7904878216687345947L;
	private PropertyManager properties = new PropertyManager();
	private BufferedImage image = null;

	@Override
	protected void appendToStartTag() {
		initialize();
		if(this.getParent() instanceof WizzardComponent){
			((WizzardComponent)this.getParent()).addWizzardItem(this);
		}
	}

	@Override
	protected void appendToEndTag() {
		// TODO Auto-generated method stub
		
	}
	
	private void initialize() {
		this.itemName = EWizzardItems.ADD_IMAGE;
		String imgHomeDir = properties.getProperty(Constants.IMG_DIR);
		String defaultImgFilename = properties.getProperty(Constants.DEFAULT_UPLOAD_IMG_FILE);
		String defaultImagePath = pageContext.getRequest().getScheme() + "://" + pageContext.getRequest().getServerName() + ":" + pageContext.getRequest().getServerPort() +"/cokoliv/"+ imgHomeDir +"/"+ defaultImgFilename;
		 
		try {
			URL imageUrl = new URL(defaultImagePath);
			image = ImageIO.read(imageUrl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void drawContent() throws IOException {
		out.println("			<form enctype=\"multipart/form-data\" method=\"post\" action=\"#\">");
		out.println("<table width=\"100%\">");
		out.println("	<tr>");
		out.println("		<td class=\"verticalSplitter\" width=\"220\">");
		//Image
		out.println("			<img src=\"/UploadImageServlet\"/>");
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

}
