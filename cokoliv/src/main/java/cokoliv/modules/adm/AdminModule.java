package cokoliv.modules.adm;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cokoliv.dao.DbParamsDAO;
import cokoliv.dao.UsersDAO;
import cokoliv.databobjects.LoggedUser;
import cokoliv.databobjects.User;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.flowdata.ChangeUserDetailData;
import cokoliv.flowdata.UploadFileData;
import cokoliv.support.Constants;

public class AdminModule implements IAdminModule {
	/**
	 * ADM001: Ziskej prava uzivatele
	 * Pri loginu nacte prava uzivatele
	 * Mozne hodnoty jsou v enumu UserRightsEnum
	 * 	ADMIN
	 *	USER
	 *	SUPERUSER
	 */
	public boolean checkAdminUserRights(LoggedUser user) {	
		return false;
	}
	
	/**
	 * ADM002: Upload souboru z formulare
	 * List<FileItem> fileItems - seznam formularovych prvku naparsovany z HttpServletRequestu
	 *  - Enum pro dane uloziste
	 * 
	 */
	public UploadFileData uploadFileFromForm(HttpServletRequest request, UploadRepositories repository, int maxMemSize, int maxFileSize) {
		UploadFileData response = new UploadFileData();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);

		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File(repository.getRepositoryPath()));
		
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
		            response.setFilename(fi.getName());
		            String contentType = fi.getContentType();
		            boolean isInMemory = fi.isInMemory();
		            response.setFileSize(fi.getSize());
		            // Write the file
		            File file;
		            if(response.getFilename().lastIndexOf("\\") >= 0 ){
		               file = new File(repository.getRepositoryPath() + response.getFilename().substring(response.getFilename().lastIndexOf("\\"))) ;
		            }else{
		               file = new File(repository.getRepositoryPath() + response.getFilename().substring(response.getFilename().lastIndexOf("\\")+1)) ;
		            }
		            fi.write(file) ;
		         }
		      }
		}catch(Exception ex) {
		       System.out.println(ex);
		}


		return null;
	}

	public User getUserByLogin(String login) throws CokolivApplicationException{
		UsersDAO dao = new UsersDAO();
		return dao.getUserByLogin(login);
	}

	public boolean compareLoginPassword(User user, String login, String pwd){
		boolean match = user.getLogin().equals(login) && user.getPassword().equals(pwd);
		return match;
	}
	
	public void incrementLoginCounter(User user) throws CokolivApplicationException{
		DbParamsDAO dao = new DbParamsDAO();
		dao.incrementLoginCounter(user);
	}

	public void clearLoginCounter(int userId) throws CokolivApplicationException {
		DbParamsDAO dao = new DbParamsDAO();
		dao.clearLoginCounter(userId);
	}

	public LoggedUser getLoggedUserInfo(User user) throws CokolivApplicationException {
		UsersDAO dao = new UsersDAO();
		return dao.getLoggedUserInfo(user);
	}

	public boolean getFirstTimeLoginParametr(User user) throws CokolivApplicationException {
		DbParamsDAO dao = new DbParamsDAO();
		return dao.getFirstTimeLoginParam(user);
	}

	public boolean isUserBlocked(User user) {
		int maxValue = Constants.MAX_FAIL_LOGIN_COUNT;
		return user.getLoginCounter() >= maxValue;
	}

	public boolean newPasswordsMatch(String newPwd, String retypedNewPwd) {
		return newPwd.equals(retypedNewPwd);
	}

	public void storeUser(ChangeUserDetailData user) throws CokolivApplicationException {
		UsersDAO dao = new UsersDAO();
		dao.storeUser(user);
	}
}
