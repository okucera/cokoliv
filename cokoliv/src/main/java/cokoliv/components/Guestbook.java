package cokoliv.components;

import java.io.IOException;

import cokoliv.databobjects.Captcha;
import cokoliv.databobjects.LoggedUser;
import cokoliv.enumerate.EFlows;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.flowdata.GuestbookData;
import cokoliv.flowdata.IFlowData;
import cokoliv.flowdata.InsertGuestbookItemData;
import cokoliv.renderers.CokolivGuestbookItemRenderer;
import cokoliv.support.CokolivContext;
import cokoliv.support.Constants;
import cokoliv.support.StyleNames;
import cokoliv.support.UserHelper;


public class Guestbook extends CokolivTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3009044853092614915L;
	private LoggedUser loggedUser;
	private IFlowData flowData;

	public int doStartTag(){
		try {
			this.out = pageContext.getOut();
			loggedUser = CokolivContext.getContext().getLoggedUser();
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
		initializeRepository();
		getInputPanel();
		GuestbookData flowData = new GuestbookData();
		executeFlow(EFlows.FL010, flowData);
		setItemRendererByUserRights();

		if(flowData.getErrorMessage()==null && this.itemRenderer != null){
			if(UserHelper.isLoggedUserAdminOrSuperuser(loggedUser)){
				//render form for add new News
				renderNewItemForm();
			}
			itemRenderer.renderItems(flowData.getGuestbookItems(), out);
		}else{
			renderErrorMsg(flowData.getErrorMessage());
		}
	}
	
	private void initializeRepository(){
		UploadRepositories.GUSETBOOK_CAPTCHA_FAKE_REPOSITORY.setServletContext(this.pageContext.getServletContext());
	}
	
	private void getInputPanel() throws IOException {
		InsertGuestbookItemData data = null;
		if(flowData instanceof InsertGuestbookItemData) {
			data = (InsertGuestbookItemData) flowData;
		}
		out.println("			<form name=\"insertGuestbookItemForm\" method=\"post\" action=\"InsertGuestbookItemServlet\">");

		out.println("<table align=\"center\">");
		out.println("	<tr>");
		out.println("		<td>");
		out.println("			<input type=TEXT class=\""+StyleNames.TEXT_INPUT_STYLE+"\" name=\""+Constants.FORM_USER_NICK+"\" value=\"Jméno\">");
		out.println("		</td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>");
		out.println("			<textarea cols=70 class=\""+StyleNames.TEXT_AREA_STYLE+"\" rows=10 name=\""+Constants.FORM_TEXTAREA_GUESTBOOK_MSG+"\">");
		out.println("Text zprávy...");
		out.println("			</textarea>");
		out.println("		</td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td colspan=\"2\" valign=\"middle\">");
		out.println("				<table align=\"center\" width=\"100%\">");
		out.println("					<tr>");
		out.println("						<td valign=\"middle\" align=\"center\">");
		out.println("							<img src=\"GetImageServlet?image="+Captcha.getInstnace().getCpatchaImg()+"&repo="+UploadRepositories.GUSETBOOK_CAPTCHA_FAKE_REPOSITORY.name()+"\">");
		out.println("						</td>");
		out.println("						<td valign=\"middle\" align=\"center\" rowspan=\"2\">");
		out.println("							<input type=submit value=\"Odeslat...\" style=\"width:200px\">");
		out.println("						</td>");
		out.println("					</tr>");
		out.println("					<tr>");
		out.println("						<td valign=\"middle\" align=\"center\">");
		out.println("							<input type=TEXT name=\""+Constants.FORM_CAPTCHA_TEXT+"\" value=\"Opište text z obrázku\" style=\"width:200px\">");
		out.println("						</td>");
		out.println("					</tr>");
		if(data!=null && data.isCaptchaWrong()){
			out.println("					<tr>");
			out.println("						<td valign=\"middle\" align=\"center\">");
			out.println("							Kontrolní obrázek nebyl správně přepsán. Opište prosím správně kontrolní obrázek.");
			out.println("						</td>");
			out.println("					</tr>");
		}
		out.println("				</table>");
		out.println("		</td>");
		out.println("	</tr>");
		
		out.println("</table>");
		out.println("			</form>");
	}
	
	
	private void renderNewItemForm() throws IOException{

	}
	
	private void setItemRendererByUserRights(){
		if(UserHelper.isLoggedUserAdminOrSuperuser(loggedUser)){
			itemRenderer = new CokolivGuestbookItemRenderer();//TODO - new CokolivAdminGuestbookItemRenderer();
		}else{
			itemRenderer = new CokolivGuestbookItemRenderer();
		}
		itemRenderer.setPageContext(this.pageContext.getServletContext());
	}

	public IFlowData getFlowData() {
		return flowData;
	}

	public void setFlowData(IFlowData flowData) {
		this.flowData = flowData;
	}
}
