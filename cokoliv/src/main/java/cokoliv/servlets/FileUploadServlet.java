package cokoliv.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cokoliv.enumerate.EFlows;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.flowdata.UploadFileData;

/**
 * Servlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends BasicAbstractServlet {
	private static final long serialVersionUID = 1L;
	private boolean isMultipart=false;
	private int maxFileSize = 1000*1024;
	private int maxMemSize = 4*1024;
	
	private String filePath;
	private File file;

    /**
     * Default constructor. 
     */
    public FileUploadServlet() {
        // TODO Auto-generated constructor stub
    }

    public void init( ){
        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("newsImageUpload"); 
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
		if(ServletFileUpload.isMultipartContent(request)){
			UploadFileData flowData = new UploadFileData();
			flowData.setRequest(request);
			flowData.setMaxFileSize(maxFileSize);
			flowData.setMaxMemSize(maxMemSize);
			flowData.setOnResultLoadAsStream(true);
			flowData.setRepository(UploadRepositories.NEWS_IMAGES_UPLOAD_REPOSITORY);
			
			EFlows.FL005.executeFlow(flowData);
		}
		
		/*
		this.isMultipart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");
		
		//TODO check multipart branch
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);
		
		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("E:\\SW\\Development\\repo\\cokoliv\\cokoliv\\src\\main\\webapp\\img\\upload\\news"));
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// maximum file size to be uploaded.
		upload.setSizeMax( maxFileSize );
		
		try{ 
			// Parse the request to get file items.
			List<FileItem> fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator<FileItem> i = fileItems.iterator();
			
		      while ( i.hasNext () ) 
		      {
		         FileItem fi = (FileItem)i.next();
		         if ( !fi.isFormField () )	
		         {
		            // Get the uploaded file parameters
		            String fieldName = fi.getFieldName();
		            String fileName = fi.getName();
		            String contentType = fi.getContentType();
		            boolean isInMemory = fi.isInMemory();
		            long sizeInBytes = fi.getSize();
		            // Write the file
		            if( fileName.lastIndexOf("\\") >= 0 ){
		               file = new File( filePath + 
		               fileName.substring( fileName.lastIndexOf("\\"))) ;
		            }else{
		               file = new File( filePath + 
		               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
		            }
		            fi.write( file ) ;
		         }
		      }
		}catch(Exception ex) {
		       System.out.println(ex);
		}
		*/
	}

}
