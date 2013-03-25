package cokoliv.renderers;

import java.io.File;
import java.io.IOException;

import javax.servlet.jsp.JspWriter;

import cokoliv.databobjects.NewItem;
import cokoliv.support.Constants;
import cokoliv.support.StringOperations;

public class CokolivAdminNewsRenderer extends CokolivAbstractItemRenderer {

	@Override
	public void renderItems(Object[] items, JspWriter out) throws IOException {
		this.out = out;
		out.println("<form action=\"NewsServlet\" method=\"POST\">");
		out.println("	<table class=\"news_table\">");
		
		for(Object item:items){
			renderItem(item);
		}
		
		out.println("		<tr>");
		out.println("			<td colspan=\"4\" align=\"left\">");
		out.println("				<input type=HIDDEN name=\""+Constants.FORM_HIDDEN_ACTION_STRING+"\" value=\""+Constants.FORM_HIDDEN_ACTION_DEL_NEWS+"\">");
		out.println("				<input type=SUBMIT value=\"Smazat označené\">");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("	</table>");
		out.println("</form>");
		

	}
	
	@Override
	public void renderItem(Object item) throws IOException{
		NewItem newItem = (NewItem) item;
		
		String imgUrl = newItem.getImgRepository().getRepositoryPath() + "defaultImg.jpg";
		if(!newItem.getImgUrl().equals("null"))
			imgUrl = newItem.getImgRepository().getRepositoryPath() + newItem.getImgUrl();

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("	<tr>");
		stringBuilder.append("		<td width=\"10\">");
		stringBuilder.append("			<input type=CHECKBOX name=\"newsItem\" value=\"");
		stringBuilder.append(newItem.getStrId());
		stringBuilder.append("\">");
		stringBuilder.append("		</td>");
		stringBuilder.append("		<td class=\"news_img\">");
		stringBuilder.append("			<a href=\"");
		stringBuilder.append(imgUrl);
		stringBuilder.append("\">");
		stringBuilder.append("				<img src=\"");
		stringBuilder.append(StringOperations.getInstance().convertFilenameToThumbFilename(imgUrl));
		stringBuilder.append("\" alt=\"img\" style=\"border:0px;\">");
		stringBuilder.append("			</a>");
		stringBuilder.append("		</td>");
		stringBuilder.append("		<td class=\"news_text\">");
		stringBuilder.append("<div class=\"title_news\">");
		stringBuilder.append(newItem.getTitle());
		stringBuilder.append("</div><div class=\"date_news\">");
		stringBuilder.append(newItem.getNewsDate()+", "+newItem.getNewsTime());
		stringBuilder.append("</div><br>");
		stringBuilder.append(newItem.getMessage());
		stringBuilder.append("		</td>");
		stringBuilder.append("	</tr>");
		stringBuilder.append("	<tr>");
		stringBuilder.append("		<td colspan=\"4\">");
		stringBuilder.append("			&nbsp;");
		stringBuilder.append("		</td>");
		stringBuilder.append("	</tr>");
		out.print(stringBuilder.toString());		

	}

}
