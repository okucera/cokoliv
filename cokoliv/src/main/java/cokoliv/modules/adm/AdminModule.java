package cokoliv.modules.adm;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import cokoliv.dao.DbParamsDAO;
import cokoliv.dao.UsersDAO;
import cokoliv.databobjects.LoggedUser;
import cokoliv.databobjects.User;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.flowdata.ChangeUserDetailData;
import cokoliv.modules.adm.ftp.FTPModule;
import cokoliv.modules.adm.ftp.IFTPModule;
import cokoliv.support.Constants;

public class AdminModule implements IAdminModule {
	IFTPModule ftpModule = new FTPModule();
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
 	public List<FileItem> uploadFilesToRepository(List<FileItem> fileItems, UploadRepositories repository, List<FileItem> excludedItems) {
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
 		    			  file = new File(repository.getRealRepositoryPath() + File.separator + item.getName().substring(item.getName().lastIndexOf("\\"))) ;
 		    		  }else{
 		    			  file = new File(repository.getRealRepositoryPath() + File.separator + item.getName().substring(item.getName().lastIndexOf("\\")+1)) ;
 		    		  }
 		    		  item.write(file) ;
 		    		  response.add(item);
 		    	  }
 		      }
 		      
 		      //Add excluded items to response
 		      addExcludedItems(excludedItems, response);
 		}catch(Exception ex) {
 		       System.out.println(ex);
 		}
 
 
 		return response;
 	}
//	public List<FileItem> uploadFilesToRepository(List<FileItem> fileItems, UploadRepositories repository, List<FileItem> excludedItems) {
//		List<FileItem> response = new ArrayList<FileItem>();
//		Map<String, FileInputStream> filesToStore = new HashMap<String, FileInputStream>();
//		try{ 
//			// Process the uploaded file items
//			Iterator<FileItem> i = fileItems.iterator();
//			
//		      while ( i.hasNext () ) 
//		      {
//		    	  FileItem item = i.next();
//		    	  
//		    	  // Write the file only if it is not already exists
//		    	  if(!isExcludedItem(item, excludedItems)){
//		    		  String filename;
//		    		  if(item.getName().lastIndexOf("\\") >= 0 ){
//		    			  filename = item.getName().substring(item.getName().lastIndexOf("\\"));
//		    		  }else{
//		    			  filename = item.getName().substring(item.getName().lastIndexOf("\\")+1);
//		    		  }
//
//		    		  InputStream inputStream = item.getInputStream();
//		    		  FileInputStream fis = null;
//		    		  
//		    		  if(inputStream != null && inputStream instanceof FileInputStream && 
//		    		     filename!=null && filename.length() > 0) {
//		    			  
//		    			  fis = (FileInputStream) inputStream;
//		    			  filesToStore.put(filename, fis);
//		    		  }
//		    		  
//		    		  response.add(item);
//		    	  }
//		      }
//		      
//		      if(filesToStore.keySet().size() > 0) {
//		    	  ftpModule.uploadFiles(filesToStore, repository);
//		      }
//		      
//		      //Add excluded items to response
//		      addExcludedItems(excludedItems, response);
//		}catch(Exception ex) {
//		       System.out.println(ex);
//		}
//
//
//		return response;
//	}
	
	private void addExcludedItems(List<FileItem> excludedItems, List<FileItem> response){
		if(excludedItems.size() > 0){
			for(FileItem item : excludedItems){
				response.add(item);
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

	public void clearLoginCounter(String userId) throws CokolivApplicationException {
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
				file = new File(repository.getRealRepositoryPath() + File.separator + item.getName().substring(item.getName().lastIndexOf("\\"))) ;
			}else{
				file = new File(repository.getRealRepositoryPath() + File.separator + item.getName().substring(item.getName().lastIndexOf("\\")+1)) ;
			}
			
			//check whether this object exists in specified repository
			if(file.exists()){
				existingFileItems.add(item);
			}
		}

		return existingFileItems;
	}
	
	/*
	public void makeImagePreviewInRepository(List<FileItem> fileItems, UploadRepositories repository) throws CokolivApplicationException{
		try{ 
			// Process the uploaded file items
			Iterator<FileItem> i = fileItems.iterator();
			Map<String, FileInputStream> filesToStore = new HashMap<String, FileInputStream>();

		      while ( i.hasNext () ) 
		      {
		    	  FileItem item = (FileItem)i.next();
		    	  String targetFilename = repository.getRealRepositoryPath() + File.separator + "preview" + File.separator + item.getName();

		    	  BufferedImage sourceImage = ImageIO.read(item.getInputStream());
		    	  double oldWidth = sourceImage.getWidth();
		    	  double oldHeight = sourceImage.getHeight();
		    	  double coeficient = oldWidth / oldHeight;

		    	  int newWidth = 200; //size in px
		    	  int newHeight = (int) Math.round(newWidth / coeficient);
		    	  BufferedImage scaledImage = ImageResizer.BICUBIC.resize(sourceImage, newWidth, newHeight);
		    	  

	    		  
	    		  FileInputStream fis = (FileInputStream) item.getInputStream();
	    		  FileOutputStream fos = new FileOutputStream(fis.getFD());
	    		  ImageIO.write(scaledImage, "jpeg", fos);
	    		  
	    		  fis = new FileInputStream(fos.getFD());
	    		  if(fis!=null) {
	    			  filesToStore.put(targetFilename, fis);
	    		  }
		    	  //ImageIO.write(scaledImage, extension, targetFile);
		      }
		      
		      if(filesToStore.keySet().size() > 0) {
		    	  ftpModule.uploadFiles(filesToStore, repository);
		      }
		}catch(Exception ex) {
		       MessageCodes message = MessageCodes.HLA026;
		       message.setCustomMessage(ex.getMessage());
		       throw new CokolivApplicationException(message, ex.getMessage());
		}
	}
	*/
	
	public void deleteTempFilesInRepository(UploadRepositories repository){
		File folder = new File(repository.getRealRepositoryPath());
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
	
	public User getUserByUserId(String userId) throws CokolivApplicationException {
		UsersDAO dao = new UsersDAO();
		return dao.getUserById(userId);
	}
}
