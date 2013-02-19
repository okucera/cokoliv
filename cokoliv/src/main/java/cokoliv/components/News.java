package cokoliv.components;

import java.io.IOException;

import cokoliv.databobjects.LoggedUser;
import cokoliv.enumerate.EFlows;
import cokoliv.flowdata.NewsFlowData;
import cokoliv.renderers.CokolivAdminNewsRenderer;
import cokoliv.renderers.CokolivNewsItemRenderer;
import cokoliv.support.Constants;
import cokoliv.support.UserHelper;


public class News extends CokolivTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3009044853092614915L;
	private LoggedUser loggedUser;

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
			if(UserHelper.isLoggedUserAdminOrSuperuser(loggedUser)){
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
		if(UserHelper.isLoggedUserAdminOrSuperuser(loggedUser)){
			itemRenderer = new CokolivAdminNewsRenderer();
		}else{
			itemRenderer = new CokolivNewsItemRenderer();
		}
	}
	
	

	public LoggedUser getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(LoggedUser loggedUser) {
		this.loggedUser = loggedUser;
	}
}
