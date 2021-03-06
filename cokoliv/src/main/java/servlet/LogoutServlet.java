package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cokoliv.enumerate.Forms;
import cokoliv.support.UserHelper;
/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends BasicAbstractServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogoutServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		
		request.setCharacterEncoding(PAGE_DEFAULT_ENCODING);
		response.setCharacterEncoding(PAGE_DEFAULT_ENCODING);

		
		storeToSession(UserHelper.LOGGED_USER, null);
		redirectToForm(Forms.FRM001);
	}

}
