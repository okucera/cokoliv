package cokoliv.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cokoliv.databobjects.LoggedUser;
import cokoliv.databobjects.NewItem;
import cokoliv.enumerate.EFlows;
import cokoliv.enumerate.Forms;
import cokoliv.flowdata.DeleteNewsData;

/**
 * Servlet implementation class NewsServlet
 */
public class NewsServlet extends BasicAbstractServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NewsServlet() {
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
		this.session = request.getSession();
		
		this.request = request;
		this.response = response;

		request.setCharacterEncoding(PAGE_DEFAULT_ENCODING);
		response.setCharacterEncoding(PAGE_DEFAULT_ENCODING);

		String[] newsItems = request.getParameterValues("newsItem");
		LoggedUser loggedUser = context.getLoggedUser();
		
		if(newsItems != null && newsItems.length > 0 && loggedUser != null){
			DeleteNewsData flowData = new DeleteNewsData();
			flowData.setLoggedUser(loggedUser);
			flowData.setItems(createItems(newsItems));
			executeFlow(EFlows.FL004, flowData);
			redirectToForm(Forms.FRM001);
		}
	}
	
	private NewItem[] createItems(String[] itemIds){
		NewItem[] items = new NewItem[itemIds.length];
		
		for(int i = 0; i < itemIds.length; i++){
			items[i] = new NewItem();
			items[i].setStrId(itemIds[i]);
		}
		
		return items;
	}

}
