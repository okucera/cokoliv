package cokoliv.support;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cokoliv.enumerate.UploadRepositories;

public class HttpServletUtils {
	public static List<FileItem> parseMultipartFormHttpServletRequest(HttpServletRequest request, UploadRepositories repository) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(repository.getMaxMemSize());

		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File(repository.getRealRepositoryPath()));
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// maximum file size to be uploaded.
		upload.setSizeMax(repository.getMaxSizeInBytes());

		try{ 
			// Parse the request to get file items.
			@SuppressWarnings("unchecked")
			List<FileItem> fileItems = upload.parseRequest(request);
			return fileItems;
		}catch(Exception ex) {
		       System.out.println(ex);
		}


		return null;
	}

	public static String getParameterFromMultipartRequestItems(List<FileItem> items, String paramName){

		if(items!=null){
			for (FileItem item : items) {
				if (item.isFormField()) {
					// Process regular form field (input type="text|radio|checkbox|etc", select, etc).
					String fieldName = item.getFieldName();
					String fieldValue = item.getString();

					if(paramName.equals(fieldName)){
						return fieldValue;
					}
				}
			}
		}
		return null;
	}
	
	public static List<FileItem> getNonFormFileItems(List<FileItem> items){
		List<FileItem> itemsToReturn = new ArrayList<FileItem>();

		// Process the uploaded file items
		Iterator<FileItem> i = items.iterator();
		
	      while ( i.hasNext () ) 
	      {
	         FileItem item = (FileItem)i.next();
	         if (!item.isFormField() && item.getName() != null && !item.getName().equals("") && item.getSize() > 0 )	
	         {	        	 
	        	 itemsToReturn.add(item);
	         }
	      }
	      
	      return itemsToReturn;
	}
}
