package cokoliv.components;

import java.io.IOException;

import cokoliv.enumerate.EFlows;
import cokoliv.flowdata.GetConcertsFlowData;
import cokoliv.renderers.CokolivConcertsItemRenderer;
import cokoliv.support.UserHelper;


public class Concerts extends CokolivTag {

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
		GetConcertsFlowData flowData = new GetConcertsFlowData();
		
		executeFlow(EFlows.FL009, flowData);
		
		setItemRendererByUserRights();

		if(flowData.getErrorMessage()==null && this.itemRenderer != null){
			itemRenderer.renderItems(flowData.getConcerts(), out);
		}else{
			renderErrorMsg(flowData.getErrorMessage());
		}
	}
	
	private void setItemRendererByUserRights(){
		if(UserHelper.isLoggedUserAdminOrSuperuser(getLoggedUser())){
			itemRenderer = new CokolivConcertsItemRenderer(); //TODO - new CokolivAdminConcertsRenderer();
		}else{
			itemRenderer = new CokolivConcertsItemRenderer();
		}
		itemRenderer.setPageContext(this.pageContext.getServletContext());
	}
}
