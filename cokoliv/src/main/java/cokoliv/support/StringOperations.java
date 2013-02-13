package cokoliv.support;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

public class StringOperations {
	
	private static StringOperations instance = null;
	
	protected StringOperations(){
		
	}
	
	public static synchronized StringOperations getInstance(){
		if(instance==null){
			instance = new StringOperations();
		}
		return instance;
	}
	
	public String replaceMap(String str, HashMap<String, String> map){
		for(String key : map.keySet()){
			String value = (String) map.get(key);
			str = str.replaceAll(key, value);
		}
		return str;
	}
	
	
	public String base64EncodedString(String text){
		BASE64Encoder code = new BASE64Encoder();
		return code.encode(text.getBytes());
	}
	
	public String base64DecodedString(String text){
		String decoded="";
		BASE64Decoder decode = new BASE64Decoder();
		try{
			decoded = new String(decode.decodeBuffer(text));
		}catch(IOException e){
			e.printStackTrace();
		}		
		return decoded.equals("")?null:decoded;
	}
	
	public boolean isNullOrEmpty(String str){
		return (str==null || str.equals(""));
	}	
	
	public boolean isArrayNullOrEmpty(String[] strings){
		boolean retValue = true;
		for(String str:strings){
			retValue &= isNullOrEmpty(str);
		}
		
		return retValue;
	}
	
	public String makeThumbFilename(String origFilename){
		String ext = origFilename.substring(origFilename.lastIndexOf(".")+1,origFilename.length());
		String noExtFilename = origFilename.substring(0,origFilename.lastIndexOf("."));
		String newFilename = noExtFilename+"thumb."+ext;
		return newFilename;
	}
	
	public String convertFilenameToThumbFilename(String filename){
		if (!filename.equals("null")) {
			String file = filename.substring(filename.lastIndexOf(File.separator) + 1, filename.length());
			String dirs = filename.substring(0, filename.lastIndexOf(File.separator));
			String retPath = dirs + "" + File.separator + "" + Constants.UPLOAD_THUMB_DIR + File.separator + makeThumbFilename(file);
			return retPath;
		}
		return "";
	}
	
	public String getExt(String filename){
		String ext = filename.substring(filename.lastIndexOf(".")+1,filename.length());
		return ext;
	}
	
	public String getFormattedText(String text){
		String retVal="";
		char splitter = (char)13;
		
		String[] lines=text.split(String.valueOf(splitter));
		for(int i=0;i<lines.length;i++){
			String line=lines[i];
			line.replace("\"", "\\\"");
			retVal+=line+"<br>";
		}
		return retVal;
	}	
}
