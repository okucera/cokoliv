package cokoliv.renderers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspWriter;

public interface ICokolivItemRenderer {
	public void renderItems(Object[] items, JspWriter out) throws IOException;
}
