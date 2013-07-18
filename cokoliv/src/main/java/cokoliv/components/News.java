package cokoliv.components;

import java.io.IOException;

import cokoliv.enumerate.EFlows;
import cokoliv.flowdata.NewsFlowData;
import cokoliv.renderers.CokolivAdminNewsRenderer;
import cokoliv.renderers.CokolivNewsItemRenderer;
import cokoliv.support.UserHelper;


public class News extends CokolivTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3009044853092614915L;

	public int doStartTag(){
		try {
			this.out = pageContext.getOut();
			getContent();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	
	public int doEndTag(){
		return -1;
	}
	
	private void getContent() throws IOException{
		NewsFlowData flowData = new NewsFlowData();
		executeFlow(EFlows.FL001, flowData);
		setItemRendererByUserRights();

		if(flowData.getErrorMessage()==null && this.itemRenderer != null){
			if(UserHelper.isLoggedUserAdminOrSuperuser(getLoggedUser())){
				//render form for add new News
				renderNewItemForm();
			}
			itemRenderer.renderItems(flowData.getNews(), out);
		}else{
			renderErrorMsg(flowData.getErrorMessage());
		}
	}
	
	private void renderNewItemForm() throws IOException{

	}
	
	private void setItemRendererByUserRights(){
		if(UserHelper.isLoggedUserAdminOrSuperuser(getLoggedUser())){
			itemRenderer = new CokolivAdminNewsRenderer();
		}else{
			itemRenderer = new CokolivNewsItemRenderer();
		}
		itemRenderer.setPageContext(this.pageContext.getServletContext());
	}
}
