package cokoliv.modules.adm;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import cokoliv.dao.DbParamsDAO;
import cokoliv.dao.UsersDAO;
import cokoliv.databobjects.LoggedUser;
import cokoliv.databobjects.User;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.flowdata.ChangeUserDetailData;
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
	public List<FileItem> uploadFileFromForm(List<FileItem> fileItems, UploadRepositories repository, List<FileItem> excludedItems) {
		List<FileItem> response = new ArrayList<FileItem>();
		try{ 
			// Process the uploaded file items
			Iterator<FileItem> i = fileItems.iterator();
			
		      while ( i.hasNext () ) 
		      {
		    	  FileItem item = (FileItem)i.next();
		    	  
		    	  // Write the file only if it is not already exists
		    	  if(!isExcludedItem(item, excludedItems)){
		    		  File file;
		    		  if(item.getName().lastIndexOf("\\") >= 0 ){
		    			  file = new File(repository.getRepositoryPath() + item.getName().substring(item.getName().lastIndexOf("\\"))) ;
		    		  }else{
		    			  file = new File(repository.getRepositoryPath() + item.getName().substring(item.getName().lastIndexOf("\\")+1)) ;
		    		  }
		    		  item.write(file) ;
		    		  response.add(item);
		    	  }
		      }
		      //delete all temporary files from repository
		      deleteTempFilesInRepository(repository);
		}catch(Exception ex) {
		       System.out.println(ex);
		}


		return response;
	}
	
	private void deleteTempFilesInRepository(UploadRepositories repository){
		File folder = new File(repository.getRepositoryPath());
		if(folder.isDirectory()){
			File[] files = folder.listFiles();
			for(File file:files){
				if(file.isFile()) {
					String filename = file.getName();
					int indexOfDot = filename.lastIndexOf('.')+1;
					String ext = filename.substring(indexOfDot);
					if(ext.toLowerCase().equals("tmp")){
						file.delete();
					}
				}
			}
		}
	}
	
	private boolean isExcludedItem(FileItem item, List<FileItem> excludedItems){
		// Process the uploaded file items
		Iterator<FileItem> i = excludedItems.iterator();

		while ( i.hasNext () ) 
		{
			FileItem excludedItem = (FileItem)i.next();
			// Get the uploaded file parameters
			String fileName = excludedItem.getName();

			if(fileName.equals(item.getName()))
				return true;
		}
		return false;
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
	
	public List<FileItem> getExistingFilesFromList(List<FileItem> list, UploadRepositories repository) {
		List<FileItem> existingFileItems = new ArrayList<FileItem>();
		
		// Process the uploaded file items
		Iterator<FileItem> i = list.iterator();

		while ( i.hasNext () ) 
		{
			FileItem item = (FileItem)i.next();

			// Make file object
			File file;
			if(item.getName().lastIndexOf("\\") >= 0 ){
				file = new File(repository.getRepositoryPath() + item.getName().substring(item.getName().lastIndexOf("\\"))) ;
			}else{
				file = new File(repository.getRepositoryPath() + item.getName().substring(item.getName().lastIndexOf("\\")+1)) ;
			}
			
			//check whether this object exists in specified repository
			if(file.exists()){
				existingFileItems.add(item);
			}
		}

		return existingFileItems;
	}
}
