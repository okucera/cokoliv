package cokoliv.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cokoliv.enumerate.UploadRepositories;

/**
 * Servlet implementation class GetImageServlet
 */
public class GetImageServlet extends BasicAbstractServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetImageServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqFilename=request.getParameter("image");
		String strRepository = request.getParameter("repo");
		UploadRepositories imgRepo = null;
		/*
		request.getContextPath();//=/cokoliv
		request.getLocalAddr();//127.0.0.1 / localhost
		request.getLocalPort();//8082
		*/
	
		if(strRepository!=null && reqFilename!=null && !reqFilename.equals("null")){
			imgRepo = UploadRepositories.valueOf(strRepository);
		} else {
			imgRepo = UploadRepositories.DEFAULT_IMAGES_UPLOAD_REPOSITORY;
		}
		
		//TODO - zjistit obecne z contextu cestu k defaultImage
		String defaultImagePath = imgRepo.getRealRepositoryPath() + File.separator + "defaultImg.jpg";
		
		//String sampleDefaultImagePath = pageContext.getRequest().getScheme() + "://" + pageContext.getRequest().getServerName() + ":" + pageContext.getRequest().getServerPort() +"/cokoliv/";

		if(reqFilename==null || reqFilename.equals("null"))
			reqFilename=defaultImagePath;
		else
			reqFilename=imgRepo.getRealRepositoryPath() + File.separator + "preview" + File.separator + reqFilename;
		try {

			//reqFilename = this.getServletContext().getRealPath(reqFilename);
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
