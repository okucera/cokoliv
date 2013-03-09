package cokoliv.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cokoliv.databobjects.LoggedUser;
import cokoliv.enumerate.EFlows;
import cokoliv.enumerate.EWizzardItems;
import cokoliv.enumerate.Forms;
import cokoliv.enumerate.MessageCodes;
import cokoliv.flowdata.IFlowData;
import cokoliv.support.CokolivContext;
import cokoliv.support.Constants;
import cokoliv.support.StringOperations;

public abstract class BasicAbstractServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -720282034437076223L;
	protected HttpSession session;
	protected HttpServletResponse response;
	protected StringOperations strOp = StringOperations.getInstance();
	protected CokolivContext context = CokolivContext.getContext();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected abstract void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	protected abstract void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	protected void executeFlow(EFlows flow, IFlowData flowData){
		flow.executeFlow(flowData);
	}
	
	protected void redirectToFormWithMessage(Forms form, MessageCodes message) throws IOException {
		clearRequestParameters();
		if(message==null){
			redirectToForm(form);
		}else{
			String url = form.getUrl();
			String messageCode = message.getErrorCode();
			this.response.sendRedirect(url+"?msg="+messageCode);
		}
	}

	/*
	 * Presmerovani na <code>form</code> s wizzardem na polozku wizzardu <code>item</code>
	 */
	protected void redirectToFormWizzard(Forms form, EWizzardItems item) throws IOException{
		clearRequestParameters();
		String url = form.getUrl();
		this.response.sendRedirect(url);		
	}
	
	/*
	 * Presmerovani na <code>form</code>
	 */
	protected void redirectToForm(Forms form) throws IOException{
		clearRequestParameters();
		String url = form.getUrl();
		this.response.sendRedirect(url);
	}
	
	/*
	 * Presmerovani na <code>ErrorPage</code>
	 */
	protected void redirectToError(MessageCodes messageCode) throws IOException {
		clearRequestParameters();
		this.response.sendRedirect("error.jsp?errCode="+messageCode.getErrorCode());
	}
	
	/*
	 * getParameter nad multipart-form daty
	 */
	protected List<FileItem> items;
	protected List<File> files;
	
	protected String getParameterFromMultipartRequest(HttpServletRequest request, String paramName) {
		try {
			if(items==null){
				items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			}
			
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
		} catch (FileUploadException e) {
			return null;
		}
		return null;
	}
	
	private void clearRequestParameters() {
		this.items = null;
	}
}
