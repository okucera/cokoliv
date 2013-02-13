package cokoliv.renderers;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

public abstract class CokolivAbstractItemRenderer implements ICokolivItemRenderer {

	protected JspWriter out;

	@Override
	public void renderItems(Object[] items, JspWriter out) throws IOException {
		this.out = out;
		
		for(Object item:items){
			renderItem(item);
		}	

	}
	
	protected abstract void renderItem(Object item) throws IOException;

}
