package cokoliv.renderers;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

import cokoliv.databobjects.BandMenuItem;
import cokoliv.support.Constants;

public class CokolivBandMenuItemRenderer extends CokolivAbstractItemRenderer {

	@Override
	public void renderItems(Object[] items, JspWriter out) throws IOException {
		this.out = out;
		out.println("	<table border=\"0\" align=\"center\" valign=\"top\" width=\"90%\">");
		
		for(Object item:items){
			renderItem(item);
		}
		
		out.println("	</table>");
		

	}
	
	@Override
	protected void renderItem(Object item) throws IOException {
		if(item instanceof BandMenuItem) {
			BandMenuItem menuItem = (BandMenuItem) item; 
			out.println("<tr>");
			out.println("<td><a href=\"servlet/GetBandUserServlet?"+Constants.BAND_USER_ID+"="+menuItem.getId()+"\">&nbsp;&nbsp;"+menuItem.getNick()+"</a></td>");
			out.println("</tr>");
		}
	}

}
