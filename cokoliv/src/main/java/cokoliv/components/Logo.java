package cokoliv.components;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

import cokoliv.enumerate.Forms;
import cokoliv.support.Constants;
import cokoliv.support.KeyManager;
import cokoliv.support.StyleNames;

public class Logo extends CokolivTag {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 8227898944354380741L;
	private KeyManager keyManager = new KeyManager();
	private JspWriter out;
	private Forms nextFormId;
	
	public int doStartTag(){
		try{
			out = pageContext.getOut();
			out.println("<table class=\"screen-width-max-limit\" align=\"right\">");
			out.println("	<tr>");
			out.println("		<td>");
			if(getLoggedUser()==null){
				loginComponent();
			}else{
				loggedUserComponent();
			}
			out.println("		</td>");
			out.println("	</tr>");
			out.println("</table>");				
			return SKIP_BODY;
		} catch (Exception ex){
			throw new Error("Error in Logo doStartTag.");
		}
	}
	
	public int doEndTag(){
		try{
			@SuppressWarnings("unused")
			JspWriter out = pageContext.getOut();
		} catch (Exception ex){
			throw new Error("Error in Logo doEndTag.");
		}
		return EVAL_PAGE;
	}
	
	private void loginComponent() throws IOException{
		out.println("			<form action=\"servlet/LoginServlet\" method=\"POST\">");
		out.println("				<table class=\"log-in-table\" align=\"right\">");
		out.println("					<tr>");
		out.println("						<td>");
		out.println("							Přihlašovací jméno: ");
		out.println("						</td>");
		out.println("						<td>");
		out.println("							<input type=TEXT class=\""+StyleNames.TEXT_INPUT_STYLE+"\" name=\""+Constants.FORM_TEXTFIELD_USERNAME+"\">");
		out.println("						</td>");
		out.println("					</tr>");
		out.println("					<tr>");
		out.println("						<td>");
		out.println("							Heslo: ");
		out.println("						</td>");
		out.println("						<td>");
		out.println("							<input type=PASSWORD class=\""+StyleNames.TEXT_INPUT_STYLE+"\" name=\""+Constants.FORM_TEXTFIELD_PWD+"\">");
		out.println("							<input type=HIDDEN name=\""+Constants.FORM_ID_KEY+"\" value=\""+this.nextFormId+"\">");		
		out.println("						</td>");
		out.println("							</tr>");
		out.println("					<tr>");
		out.println("						<td colspan=\"2\" align=\"center\">");
		out.println("							<input type=SUBMIT class=\""+StyleNames.BUTTON_STYLE+"\" value=\""+this.keyManager.getKeyValue("ADMIN_LOGIN_BUTTON_TITLE")+"\">");
		out.println("						</td>");
		out.println("					</tr>");
		out.println("				</table>");
		out.println("			</form>");
	}
	
	private void loggedUserComponent() throws IOException{
		out.println("			<form action=\"servlet/LogoutServlet\" method=\"POST\">");
		out.println("				<table class=\"log-in-table\" align=\"right\">");
		out.println("					<tr>");
		out.println("						<td>");
		out.println("							Byl jsi přihlášen jako "+getLoggedUser().getNick());
		out.println("						</td>");
		out.println("					</tr>");
		out.println("					<tr>");
		out.println("						<td>");
		out.println("							<input type=SUBMIT value=\"Odhlásit\">");		
		out.println("						</td>");
		out.println("					</tr>");
		out.println("				</table>");
		out.println("			</form>");
	}

	public Forms getNextFormId() {
		return nextFormId;
	}

	public void setNextFormId(Forms nextFormId) {
		this.nextFormId = nextFormId;
	}
}
