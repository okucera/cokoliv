package cokoliv.components;

import java.io.IOException;

import cokoliv.databobjects.LoggedUser;
import cokoliv.enumerate.MessageCodes;
import cokoliv.support.Constants;

public class ChangeUserDetailPanel extends CokolivTag{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6559879866956439061L;
	private LoggedUser user;
	private String msgCode;
	
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

	public LoggedUser getUser() {
		return user;
	}

	public void setUser(LoggedUser user) {
		this.user = user;
	}	

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}
	
	private void getContent() throws IOException{
		out.println("<form action=\"servlet/UserOperationServlet\" method=\"POST\">");
		out.println("	<table style=\"color:white\">");
		out.println("		<tr>");
		out.println("			<td>");
		out.println("				Jméno*");
		out.println("			</td>");
		out.println("			<td>");
		out.println("				<input type=TEXT name=\""+Constants.FORM_USER_FIRST_NAME+"\" value=\""+(user.getFirstName()==null?"":user.getFirstName())+"\">");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>");
		out.println("				Příjmení*");
		out.println("			</td>");
		out.println("			<td>");
		out.println("				<input type=TEXT name=\""+Constants.FORM_USER_LAST_NAME+"\" value=\""+(user.getLastName()==null?"":user.getLastName())+"\">");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>");
		out.println("				Přezdívka*");
		out.println("			</td>");
		out.println("			<td>");
		out.println("				<input type=TEXT name=\""+Constants.FORM_USER_NICK+"\" value=\""+(user.getNick()==null?"":user.getNick())+"\">");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>");
		out.println("				Zadej nové heslo");
		out.println("			</td>");
		out.println("			<td>");
		out.println("				<input type=PASSWORD name=\""+Constants.FORM_USER_NEW_PWD+"\">");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>");
		out.println("				Znovu zadej nové heslo");
		out.println("			</td>");
		out.println("			<td>");
		out.println("				<input type=PASSWORD name=\""+Constants.FORM_USER_NEW_PWD_RETYPED+"\">");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<th colspan=\"2\">");
		out.println("				<input type=SUBMIT value=\"Odeslat\">");
		out.println("			</th>");
		out.println("		</tr>");
		out.println("	</table>");
		out.println("</form>");
		showMessage();

	}
	
	private void showMessage() throws IOException {
		if(this.msgCode!=null && this.msgCode.length()>0){
			MessageCodes message = MessageCodes.valueOf(msgCode);
			out.println("<hr>");
			out.println(message.getErrorMessage());
		}
	}

	
}
