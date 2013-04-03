package cokoliv.renderers;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

import cokoliv.databobjects.ConcertItem;
import cokoliv.support.StringOperations;
import cokoliv.support.StyleNames;

public class CokolivConcertsItemRenderer extends CokolivAbstractItemRenderer {

	@Override
	public void renderItems(Object[] items, JspWriter out) throws IOException {
		this.out = out;
		
		out.println("<table class=\""+StyleNames.CONCERT_TABLE_STYLE+"\">");
		
		for(Object item:items){
			renderItem(item);
		}	
		
		out.println("</table>");

	}
	@Override
	protected void renderItem(Object item) throws IOException {
		if(item!=null && item instanceof ConcertItem){
			ConcertItem concertItem = (ConcertItem) item;

			String imgUrl = concertItem.getImgRepository().getRepositoryPath() + "defaultImg.jpg";
			if(!concertItem.getImgUrl().equals("null"))
				imgUrl = concertItem.getImgRepository().getRepositoryPath() + concertItem.getImgUrl();

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("<tr>");
			stringBuilder.append("		<td class=\""+StyleNames.ITEM_RENDERER_IMG_STYLE+"\">");
			stringBuilder.append("			<a href=\"");
			stringBuilder.append(imgUrl);
			stringBuilder.append("\">");
			stringBuilder.append("				<img src=\"");
			stringBuilder.append(StringOperations.getInstance().convertFilenameToThumbFilename(imgUrl));
			stringBuilder.append("\" alt=\"img\" style=\"border:0px;\">");
			stringBuilder.append("			</a>");
			stringBuilder.append("		</td>");
			stringBuilder.append("		<td class=\""+StyleNames.ITEM_RENDERER_TEXT_STYLE+"\">");
			stringBuilder.append("<div class=\"item_renderer_title\">");
			stringBuilder.append(concertItem.getTitle());
			stringBuilder.append("</div><div class=\""+StyleNames.ITEM_RENDERER_DATE_TEXT_STYLE+"\">");
			stringBuilder.append(concertItem.getConcertDate()+", "+concertItem.getConcertTime());
			stringBuilder.append("</div><br>");
			stringBuilder.append(concertItem.getMessage());
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

}
