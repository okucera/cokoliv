package cokoliv.servlets;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadImageServlet
 */
public class UploadImageServlet extends BasicAbstractServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UploadImageServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reqFilename=request.getParameter("image");
		String defaultImagePath = "http://localhost:8080/cokoliv/img/defaultImg.jpg";
		if(reqFilename==null || reqFilename.equals("null"))
			reqFilename=defaultImagePath;
		try {
			URL url = new URL(reqFilename);
			BufferedInputStream bis = new BufferedInputStream(url.openStream());
			response.setContentType("image/jpg");
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			
			for(int data; (data = bis.read()) > -1;){
				bos.write(data);
			}
			
			bis.close();
			bos.close();
		}catch(IOException e){
			//TODO - file does not exists
			e.printStackTrace();
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
