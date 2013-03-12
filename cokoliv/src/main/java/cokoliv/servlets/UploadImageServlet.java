package cokoliv.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cokoliv.enumerate.UploadRepositories;

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
		String reqFilename=request.getParameter("image");
		String strRepository = request.getParameter("repo");
		UploadRepositories imgRepo = null;

		if(strRepository!=null){
			imgRepo = UploadRepositories.valueOf(strRepository);
		}
		
		//TODO - zjistit obecne z contextu cestu k defaultImage
		String defaultImagePath = "http://localhost:8082/cokoliv/img/defaultImg.jpg";
		//String sampleDefaultImagePath = pageContext.getRequest().getScheme() + "://" + pageContext.getRequest().getServerName() + ":" + pageContext.getRequest().getServerPort() +"/cokoliv/"+ imgHomeDir +"/"+ defaultImgFilename;

		if(reqFilename==null || reqFilename.equals("null"))
			reqFilename=defaultImagePath;
		else
			reqFilename=imgRepo.getRepositoryPath() + "preview" + File.separator + reqFilename;
		try {
			/*
			URL url = new URL(reqFilename);
			BufferedInputStream bis = new BufferedInputStream(url.openStream());
			*/
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(reqFilename));
			
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
