package cokoliv.components.vpanel.content;

import java.io.IOException;

import cokoliv.components.CokolivTag;
import cokoliv.components.VerticalMenuPanel;
import cokoliv.databobjects.User;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.support.StyleNames;

public class VBandUserContent extends CokolivTag implements IVerticalPanelContent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6990244867779218440L;
	
	private User user;
	private UploadRepositories repository = UploadRepositories.BAND_USERS_REPOSITORY;
	
	public int doStartTag(){
		this.out = pageContext.getOut();
		if(this.getParent() instanceof VerticalMenuPanel){
			((VerticalMenuPanel) this.getParent()).setVerticalPanelContent(this);
		}
		return EVAL_PAGE;
	}
	
	public int doEndTag(){
		return -1;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void rendnerContent() throws IOException {
		//Hlavni panel - rozdeleno na dva horizontalni - prvni obrazek, druhy info
		out.println("<table align=\"left\">");
		out.println("	<tr>");
		out.println("		<td>");
		//OBRAZEK
		if(user!=null){
			out.println("			<img src=\""+repository.getRepositoryPath() + user.getImgUrl()+"\">");
		}
		out.println("		</td>");
		out.println("		<td valign=\"top\">");
		if(user!=null){
			//Informace - rozdeleno na dva vertikalni
			out.println("<table align=\"left\" class=\""+StyleNames.BAND_TEXT_STYLE+"\">");
			out.println("	<tr>");
			out.println("		<td>");
			out.println("Přezdívka: ");
			out.println("		</td>");
			out.println("		<td>");
			out.println(user.getNick());
			out.println("		</td>");
			out.println("	</tr>");
			out.println("	<tr>");
			out.println("		<td>");
			out.println("Jméno: ");
			out.println("		</td>");
			out.println("		<td>");
			out.println(user.getFirstName() + " " + user.getLastName());
			out.println("		</td>");
			out.println("	</tr>");
			out.println("	<tr>");
			out.println("		<td colspan=\"2\">");
			out.println("&nbsp;");
			out.println("		</td>");
			out.println("	</tr>");
			out.println("	<tr>");
			out.println("		<td colspan=\"2\">");
			out.println(user.getInfo());
			out.println("		</td>");
			out.println("	</tr>");
			out.println("</table>");
			out.println("<br><br>");
		}
		out.println("		</td>");
		out.println("	</tr>");
		out.println("</table>");
	}

}
