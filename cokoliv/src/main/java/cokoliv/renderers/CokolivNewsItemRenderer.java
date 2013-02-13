package cokoliv.renderers;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

import cokoliv.databobjects.NewItem;
import cokoliv.support.StringOperations;

public class CokolivNewsItemRenderer extends CokolivAbstractItemRenderer {
	
	@Override
	public void renderItems(Object[] items, JspWriter out) throws IOException {
		this.out = out;
		
		out.println("<table class=\"news_table\">");
		
		for(Object item:items){
			renderItem(item);
		}	
		
		out.println("</table>");

	}
	
	@Override
	public void renderItem(Object item) throws IOException{
		NewItem newItem = (NewItem) item;
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<tr>");
		stringBuilder.append("		<td class=\"news_img\">");
		stringBuilder.append("			<a href=\"");
		stringBuilder.append(newItem.getImgUrl());
		stringBuilder.append("\">");
		stringBuilder.append("				<img src=\"");
		stringBuilder.append(StringOperations.getInstance().convertFilenameToThumbFilename(newItem.getImgUrl()));
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
