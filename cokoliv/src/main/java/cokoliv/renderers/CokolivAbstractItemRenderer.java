package cokoliv.renderers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspWriter;

public abstract class CokolivAbstractItemRenderer implements ICokolivItemRenderer {

	protected JspWriter out;
	protected ServletContext context;

	public void renderItems(Object[] items, JspWriter out) throws IOException {
		this.out = out;
		
		for(Object item:items){
			renderItem(item);
		}	

	}
	
	public void setPageContext(ServletContext context) {
		this.context = context;
	}
	
	public ServletContext getPageContext(){
		return this.context;
	}
	
	protected abstract void renderItem(Object item) throws IOException;

}
