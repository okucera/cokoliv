package cokoliv.support;

//import java.sql.ResultSet;


public class HtmlGenerator {
	public static boolean ADMIN_VALUE=true;
	/**
	public HtmlGenerator(JspWriter jsp_out, PageContext jsp_page,HttpServletResponse resp){
		out=jsp_out;
		page=jsp_page;
		response = resp;
	}
	
	public void setFilename(String filename){
		this.filename=filename;
	}
	
	public void getHeader(){
		try{
			out.println("<!DOCTYPE HTML PUBLIC \\\\"-//W3C//DTD HTML 4.01 Transitional//EN\\\\" \\\\"http://www.w3.org/TR/html4/loose.dtd\\\\">");
			out.println("<html>");
			out.println("	<head>");
			out.println("		<title>Ofiko stránky chaos-pop-rockové kapely Cokol!v</title>");
			out.println("		<link rel=\\\\"stylesheet\\\\" type=\\\\"text/css\\\\" href=\\\\"styles/night.css\\\\" />");
			out.println("		<meta http-equiv=\\\\"Content-Type\\\\" content=\\\\"text/html; charset=UTF-8\\\\">");
			out.println("		<meta name=\\\\"GENERATOR\\\\" content=\\\\"Rational Application Developer\\\\">");
			out.println("	</head>");
		}catch(IOException e){
			//TODO - logovat
			e.printStackTrace();
		}
	}
	
	public void getEnd(){
		try{
			out.println("</html>");
		}catch(IOException e){
			//TODO - logovat
		}
	}
	
	public void getLogo(){

		try{
		}catch(IOException e){
			//TODO - logovat
		}

	}
	
	public void getUpperLineOfMainWindow(){
		try{
			out.println("<tr>");
			out.println("	<td class=\\\\"leftUpInsideCorner\\\\">");
			out.println("		&nbsp;");
			out.println("	</td>");
		
			out.println("	<td class=\\\\"upLineInside\\\\">");
			out.println("		&nbsp;");
			out.println("	</td>");
		
			out.println("	<td class=\\\\"rightUpInsideCorner\\\\">");
			out.println("		&nbsp;");
			out.println("	</td>");
			out.println("</tr>");
		}catch(IOException e){
			//TODO - logovat
		}		
	}
	
	public void getBottomLineOfMainWindow(){
		try{
			out.println("<tr>");
			out.println("	<td class=\\\\"leftDownInsideCorner\\\\">");
			out.println("		&nbsp;");
			out.println("	</td>");
		
			out.println("	<td class=\\\\"downLineInside\\\\">");
			out.println("		&nbsp;");
			out.println("	</td>");
			out.println("	<td class=\\\\"rightDownInsideCorner\\\\">");
			out.println("		&nbsp;");
			out.println("	</td>");
			out.println("	</tr>");
		}catch(IOException e){
			//TODO - logovat
		}
	}
	
	public void getMainComplexWindow(int verticalMenuOption, String actualUrl, String contentFile, boolean admin){
		try{
			out.println("<table class=\\\\"outsideCorners\\\\" cellpadding=\\\\"0\\\\" cellspacing=\\\\"0\\\\">");
			out.println("	<tr>");
			out.println("		<td class=\\\\"leftUpOutsideCorner\\\\">");
			out.println("		</td>			");
			out.println("		<td class=\\\\"upLine\\\\" valign=\\\\"bottom\\\\">");
			getMenu(actualUrl);
			out.println("		</td>			");
			out.println("		<td class=\\\\"rightUpOutsideCorner\\\\">");
			out.println("		</td>");
			out.println("	</tr>		");
			out.println("	<tr>");
			out.println("		<td class=\\\\"leftColumn\\\\">");
			out.println("		</td>");
			
			out.println("		<td class=\\\\"content\\\\">");
			out.println("			<table border=\\\\"0\\\\" class=\\\\"contentTable\\\\" cellpadding=\\\\"0\\\\" cellspacing=\\\\"0\\\\">");
			getUpperLineOfMainWindow();
							
			out.println("				<tr>");
			out.println("					<td class=\\\\"complexLeftInsideLine\\\\">");
			out.println("						<table border=\\\\"0\\\\" align=\\\\"center\\\\" height=\\\\"400\\\\">");
			out.println("							<tr>");
			out.println("								<td>");
			out.println("									&nbsp;");
			out.println("								</td>");
			out.println("							</tr>");
			out.println("						</table>");			
			out.println("					</td>");
			out.println("					<td>");
			out.println("						<table border=\\\\"0\\\\" class=\\\\"complexContentTable\\\\" cellpadding=\\\\"0\\\\" cellspacing=\\\\"0\\\\">");			
			out.println("							<tr>");
			out.println("								<td class=\\\\"verticalMenu\\\\">");
			//minimalni rozmer vertikalniho menu
			out.println("									<table border=\\\\"0\\\\" align=\\\\"center\\\\" width=\\\\"200\\\\" class=\\\\"verticalMenu_menu\\\\">");
			out.println("										<tr>");
			out.println("											<td valign=\\\\"top\\\\">");
			getVerticalMenu(verticalMenuOption,actualUrl,admin);
			out.println("												&nbsp;");
			out.println("											</td>");
			out.println("										</tr>");
			out.println("									</table>");			
			out.println("									&nbsp;");
			out.println("								</td>");
			out.println("								<td class=\\\\"complexContent-window\\\\">");
			page.include(contentFile);
			out.println("								</td>");
			out.println("							</tr>");
			out.println("						</table>");
			out.println("					</td>");						
			out.println("					<td class=\\\\"complexRightInsideLine\\\\">");
			out.println("						&nbsp;");
			out.println("					</td>");
			out.println("				</tr>");
			getBottomLineOfMainWindow();
			out.println("			</table>");
			out.println("		</td>");
			
			out.println("		<td class=\\\\"rightColumn\\\\">");
			out.println("		</td>");
			out.println("	</tr>");
			out.println("	<tr>");
			out.println("		<td class=\\\\"leftDownOutsideCorner\\\\">");
			out.println("		</td>			");
			out.println("		<td class=\\\\"downLine\\\\">");
			out.println("		</td>");
			
			out.println("		<td class=\\\\"rightDownOutsideCorner\\\\">");
			out.println("		</td>");
			out.println("	</tr>");
			out.println("</table>	");
		}catch(IOException e){
			//TODO - logovat
		}catch (ServletException e) {
			// TODO - logovat - chyba content file
			e.printStackTrace();
			
		}		
	}
	
	public void getMainSimpleWindow(String actualUrl, String contentFile){
		try{
/*			out.println("<table class=\\\\"outsideCorners\\\\" cellpadding=\\\\"0\\\\" cellspacing=\\\\"0\\\\">");
			out.println("	<tr>");
			out.println("		<td class=\\\\"leftUpOutsideCorner\\\\">");
			out.println("		</td>			");
			out.println("		<td class=\\\\"upLine\\\\" valign=\\\\"bottom\\\\">");
			getMenu(actualUrl);
			out.println("		</td>			");
			out.println("		<td class=\\\\"rightUpOutsideCorner\\\\">");
			out.println("		</td>");
			out.println("	</tr>		");*/
	/**
			out.println("	<tr>");
			out.println("		<td class=\\\\"leftColumn\\\\">");
			out.println("		</td>");
			
			out.println("		<td class=\\\\"content\\\\">");
			out.println("			<table class=\\\\"contentTable\\\\" cellpadding=\\\\"0\\\\" cellspacing=\\\\"0\\\\">");
			getUpperLineOfMainWindow();
							
			out.println("				<tr>");
			out.println("					<td class=\\\\"leftInsideLine\\\\">");
			out.println("						&nbsp;");
			out.println("					</td>		");				
			out.println("					<td class=\\\\"content-window\\\\">");
											//sem by mel prijit include contentFile
			page.include(contentFile);
			out.println("					</td>");						
			out.println("					<td class=\\\\"rightInsideLine\\\\">");
			out.println("						&nbsp;");
			out.println("					</td>");
			out.println("				</tr>");
			getBottomLineOfMainWindow();
			out.println("			</table>");
			out.println("		</td>");
			
			out.println("		<td class=\\\\"rightColumn\\\\">");
			out.println("		</td>");
			out.println("	</tr>");
			out.println("	<tr>");
			out.println("		<td class=\\\\"leftDownOutsideCorner\\\\">");
			out.println("		</td>			");
			out.println("		<td class=\\\\"downLine\\\\">");
			out.println("		</td>");
			
			out.println("		<td class=\\\\"rightDownOutsideCorner\\\\">");
			out.println("		</td>");
			out.println("	</tr>");
			out.println("</table>	");
		}catch(IOException e){
			//TODO - logovat
		}catch (ServletException e) {
			// TODO - logovat - chyba content file
			e.printStackTrace();
			
		}
	}
	
	//Na strance s novnikami metoda zobrazi 5 aktualnich novinek s databaze
	public void getNews(boolean admin, String thumbFilename, String imgFilename){
		SqlPropertyRepository repository = new SqlPropertyRepository(PropertyManager.getInstance().getProperty(Constants.SQL_PROPERTY_FILENAME));
		SqlManager sql = SqlManager.getInstance();
		ResultSet rs = null;
		
		String query = repository.getSqlQuery(Constants.GET_NEWS_SQL_KEY);
		rs = sql.executeQuery(query);
		
		String id[] = sql.getColumnFromRS(rs, "id");
		String date[] = sql.getColumnFromRS(rs, "date");
		String time[] = sql.getColumnFromRS(rs, "time");
		String title[]= sql.getColumnFromRS(rs, "title");
		String text[] = sql.getColumnFromRS(rs, "text");
		String imgUrl[] = sql.getColumnFromRS(rs, "img_url");		
		
		try {
			out.println("<h1 align=\\\\"center\\\\">");
			out.println("	Tož vitááj");
			out.println("</h1>");
			if(admin){
				out.println("<form action=\\\\"/Cokoliv/ControllServlet\\\\" method=\\\\"POST\\\\">");
			}
			out.println("<table class=\\\\"news_table\\\\">");
			for(int i=0;i<text.length;i++){
				String msg = "<div class=\\\\"title_news\\\\">"+title[i]+"</div><div class=\\\\"date_news\\\\">"+date[i]+", "+time[i]+"</div><br>"+text[i];
				out.println("	<tr>");
				if(admin){
					out.println("		<td width=\\\\"10\\\\">");
					out.println("			<input type=CHECKBOX name=\\\\""+id[i]+"\\\\">");
					out.println("		</td>");
				}
				out.println("		<td class=\\\\"news_img\\\\">");
				out.println("			<a href=\\\\""+imgUrl[i]+"\\\\">");
				out.println("				<img src=\\\\""+StringOperations.getInstance().convertFilenameToThumbFilename(imgUrl[i])+"\\\\" alt=\\\\"img\\\\" style=\\\\"border:0px;\\\\">");
				out.println("			</a>");
				out.println("		</td>");
				out.println("		<td class=\\\\"news_text\\\\">");
				out.println("			"+msg);
				out.println("		</td>");
				out.println("	</tr>");
				out.println("	<tr>");
				out.println("		<td colspan=\\\\"4\\\\">");
				out.println("			&nbsp;");
				out.println("		</td>");
				out.println("	</tr>");
				
			}
			if(admin){
				out.println("	<tr>");
				out.println("		<td colspan=\\\\"4\\\\" align=\\\\"center\\\\">");
				out.println("			<input type=HIDDEN name=\\\\""+Constants.HIDDEN_ACTION_STRING+"\\\\" value=\\\\""+Constants.HIDDEN_ACTION_DEL_NEWS+"\\\\">");
				out.println("			<input type=SUBMIT value=\\\\"Smazat oznacene\\\\">");
				out.println("		</td>");
				out.println("	</tr>");
				
			}
			out.println("</table>");
			if(admin){
				out.println("</form>");
				out.println("	<table class=\\\\"admin_control\\\\">");
				out.println("		<tr>");
				out.println("			<th colspan=\\\\"4\\\\">");
				out.println("				Přidat novinku<br><hr>");
				out.println("			</th>");
				out.println("		</tr>");
				out.println("		<tr>");
				out.println("			<th>");
				out.println("				Soubor s obrázkem");
				out.println("			</th>");
				out.println("			<th>");
				out.println("				&nbsp;");
				out.println("			</th>");
				out.println("			<th>");
				out.println("				&nbsp;");
				out.println("			</th>");
				out.println("			<th>");
				out.println("				&nbsp;");
				out.println("			</th>");
				out.println("		</tr>");
				out.println("		<tr>");
				out.println("			<th>");
				out.println("				<form action=\\\\"/Cokoliv/ControllServlet\\\\" method=\\\\"POST\\\\" enctype=\\\\""+Constants.MULTIPART_DATA_STR+"\\\\">");
				out.println("					<input type=\\\\"FILE\\\\" name=\\\\""+Constants.FORM_IMG_PATH+"\\\\"><br>");
				out.println("					<input type=\\\\"HIDDEN\\\\" name=\\\\""+Constants.HIDDEN_ACTION_STRING+"\\\\" value=\\\\""+Constants.HIDDEN_ACTION_UPLOAD_IMAGE_NEWS+"\\\\">");
				out.println("					<input type=\\\\"SUBMIT\\\\" value=\\\\"Nahrát obrázek\\\\">");
				out.println("				</form>");	
				if(thumbFilename!=null && !thumbFilename.equals("")){
					out.println("					<br>");			
					out.println("					<img src=\\\\""+thumbFilename+"\\\\">");
				}
				out.println("			</th>");
				out.println("			<th valign=\\\\"middle\\\\">");
				out.println("				<form action=\\\\"/Cokoliv/ControllServlet\\\\" method=\\\\"POST\\\\">");				
				out.println("					<table border=\\\\"0\\\\" width=\\\\"100%\\\\">");
				out.println("						<tr>");
				out.println("							<th>");
				out.println("								Titulek:");
				out.println("							</th>");
				out.println("							<th>");
				out.println("								Text:");
				out.println("							</th>");
				out.println("							<th>");
				out.println("								&nbsp;");		
				out.println("							</th>");
				out.println("						</tr>");
				out.println("						<tr>");
				out.println("							<td>");
				out.println("								<input type=\\\\"TEXT\\\\" name=\\\\""+Constants.FORM_NEWS_TITLE+"\\\\">");
				out.println("							</td>");
				out.println("							<td>");
				out.println("								<input type=\\\\"TEXT\\\\" name=\\\\""+Constants.FORM_NEWS_DESCR+"\\\\">");
				out.println("								<input type=\\\\"HIDDEN\\\\" name=\\\\""+Constants.HIDDEN_ACTION_STRING+"\\\\" value=\\\\""+Constants.HIDDEN_ACTION_ADD_NEW+"\\\\">");
				out.println("								<input type=\\\\"HIDDEN\\\\" name=\\\\""+Constants.HIDDEN_ELEMENT_NEW_IMG_FILENAME+"\\\\" value=\\\\""+imgFilename+"\\\\">");
				out.println("							</td>");
				out.println("							<td>");
				out.println("								<input type=\\\\"SUBMIT\\\\" value=\\\\"Přidat novinku\\\\">");		
				out.println("							</td>");
				out.println("						</tr>");
				out.println("					</table>");
				out.println("				</form>");	
				out.println("			</th>");
				out.println("		</tr>");
				out.println("	</table>");
				out.println("</form>");			
			}
		} catch (IOException e) {
			// TODO Automaticky generovaný zachytávací blok
			e.printStackTrace();
		}
	}
	
	//Na strance s novnikami metoda zobrazi 5 aktualnich novinek s databaze
	public void getConcerts(boolean admin,String thumbFilename,String imgFilename){
		SqlPropertyRepository repository = new SqlPropertyRepository(PropertyManager.getInstance().getProperty(Constants.SQL_PROPERTY_FILENAME));
		SqlManager sql = SqlManager.getInstance();
		ResultSet rs = null;
		
		String query = repository.getSqlQuery(Constants.GET_CONCERT_SQL_KEY);
		rs = sql.executeQuery(query);
		
		String id[] = sql.getColumnFromRS(rs, "id");
		String date[] = sql.getColumnFromRS(rs, "date");
		String time[] = sql.getColumnFromRS(rs, "time");
		String title[]= sql.getColumnFromRS(rs, "title");
		String text[] = sql.getColumnFromRS(rs, "text");
		String imgUrl[] = sql.getColumnFromRS(rs, "img_url");		
		
		try {
			out.println("<h1 align=\\\\"center\\\\">");
			out.println("	Večírky na Strahově");
			out.println("</h1>");
			if(admin){
				out.println("<form action=\\\\"/Cokoliv/ControllServlet\\\\" method=\\\\"POST\\\\">");
			}
			out.println("<table class=\\\\"news_table\\\\">");
			for(int i=0;i<text.length;i++){
				String msg = "<div class=\\\\"title_news\\\\">"+title[i]+"</div><div class=\\\\"date_news\\\\">"+date[i]+", "+time[i]+"</div><br>"+text[i];
				out.println("	<tr>");
				if(admin){
					out.println("		<td width=\\\\"10\\\\">");
					out.println("			<input type=CHECKBOX name=\\\\""+id[i]+"\\\\">");
					out.println("		</td>");
				}
				out.println("		<td class=\\\\"news_img\\\\">");
				out.println("			<a href=\\\\""+imgUrl[i]+"\\\\">");
				out.println("				<img src=\\\\""+StringOperations.getInstance().convertFilenameToThumbFilename(imgUrl[i])+"\\\\" alt=\\\\"img\\\\" style=\\\\"border:0px;\\\\">");
				out.println("			</a>");
				out.println("		</td>");
				out.println("		<td class=\\\\"news_text\\\\">");
				out.println("			"+msg);
				out.println("		</td>");
				out.println("	</tr>");
				out.println("	<tr>");
				out.println("		<td colspan=\\\\"4\\\\">");
				out.println("			&nbsp;");
				out.println("		</td>");
				out.println("	</tr>");
				
			}
			if(admin){
				out.println("	<tr>");
				out.println("		<td colspan=\\\\"4\\\\" align=\\\\"center\\\\">");
				out.println("			<input type=HIDDEN name=\\\\""+Constants.HIDDEN_ACTION_STRING+"\\\\" value=\\\\""+Constants.HIDDEN_ACTION_DEL_CONCERT+"\\\\">");
				out.println("			<input type=SUBMIT value=\\\\"Smazat oznacene\\\\">");
				out.println("		</td>");
				out.println("	</tr>");
				
			}
			out.println("</table>");
			if(admin){
				out.println("</form>");
				out.println("	<table class=\\\\"admin_control\\\\">");
				out.println("		<tr>");
				out.println("			<th colspan=\\\\"4\\\\">");
				out.println("				Přidat novinku<br><hr>");
				out.println("			</th>");
				out.println("		</tr>");
				out.println("		<tr>");
				out.println("			<th>");
				out.println("				Soubor s obrázkem");
				out.println("			</th>");
				out.println("			<th>");
				out.println("				&nbsp;");
				out.println("			</th>");
				out.println("			<th>");
				out.println("				&nbsp;");
				out.println("			</th>");
				out.println("			<th>");
				out.println("				&nbsp;");
				out.println("			</th>");
				out.println("		</tr>");
				out.println("		<tr>");
				out.println("			<th>");
				out.println("				<form action=\\\\"/Cokoliv/ControllServlet\\\\" method=\\\\"POST\\\\" enctype=\\\\""+Constants.MULTIPART_DATA_STR+"\\\\">");
				out.println("					<input type=\\\\"FILE\\\\" name=\\\\""+Constants.FORM_CONCERT_IMG_PATH+"\\\\"><br>");
				out.println("					<input type=\\\\"HIDDEN\\\\" name=\\\\""+Constants.HIDDEN_ACTION_STRING+"\\\\" value=\\\\""+Constants.HIDDEN_ACTION_UPLOAD_IMAGE_CONCERTS+"\\\\">");
				out.println("					<input type=\\\\"SUBMIT\\\\" value=\\\\"Nahrát obrázek\\\\">");
				out.println("				</form>");	
				if(thumbFilename!=null && !thumbFilename.equals("")){
					out.println("					<br>");			
					out.println("					<img src=\\\\""+thumbFilename+"\\\\">");
				}
				out.println("			</th>");
				out.println("			<th valign=\\\\"middle\\\\">");
				out.println("				<form action=\\\\"/Cokoliv/ControllServlet\\\\" method=\\\\"POST\\\\">");				
				out.println("					<table border=\\\\"0\\\\" width=\\\\"100%\\\\">");
				out.println("						<tr>");
				out.println("							<th>");
				out.println("								Titulek:");
				out.println("							</th>");
				out.println("							<th>");
				out.println("								Text:");
				out.println("							</th>");
				out.println("							<th>");
				out.println("								&nbsp;");		
				out.println("							</th>");
				out.println("						</tr>");
				out.println("						<tr>");
				out.println("							<td>");
				out.println("								<input type=\\\\"TEXT\\\\" name=\\\\""+Constants.FORM_CONCERT_TITLE+"\\\\">");
				out.println("							</td>");
				out.println("							<td>");
				out.println("								<input type=\\\\"TEXT\\\\" name=\\\\""+Constants.FORM_CONCERT_DESCR+"\\\\">");
				out.println("								<input type=\\\\"HIDDEN\\\\" name=\\\\""+Constants.HIDDEN_ACTION_STRING+"\\\\" value=\\\\""+Constants.HIDDEN_ACTION_ADD_CONCERT+"\\\\">");
				out.println("								<input type=\\\\"HIDDEN\\\\" name=\\\\""+Constants.HIDDEN_ELEMENT_CONCERT_IMG_FILENAME+"\\\\" value=\\\\""+imgFilename+"\\\\">");
				out.println("							</td>");
				out.println("							<td>");
				out.println("								<input type=\\\\"SUBMIT\\\\" value=\\\\"Přidat koncert\\\\">");		
				out.println("							</td>");
				out.println("						</tr>");
				out.println("					</table>");
				out.println("				</form>");	
				out.println("			</th>");
				out.println("		</tr>");
				out.println("	</table>");
				out.println("</form>");			
			}
		} catch (IOException e) {
			// TODO Automaticky generovaný zachytávací blok
			e.printStackTrace();
		}
	}

	//Na strance s novnikami metoda zobrazi 5 aktualnich novinek s databaze
	public void getGuestbook(boolean admin, int page){
		GuestbookManager guestbook = GuestbookManager.getInstance();
		Antispam antispam = new Antispam();
		String example = antispam.generateNum1()+" "+antispam.generateSign()+" "+antispam.generateNum2();
		
		SqlPropertyRepository repository = new SqlPropertyRepository(PropertyManager.getInstance().getProperty(Constants.SQL_PROPERTY_FILENAME));
		SqlManager sql = SqlManager.getInstance();
		ResultSet rs = null;
		
		String query = repository.getSqlQuery(Constants.GET_GUESTBOOK_SQL_KEY);
		rs = sql.executeQuery(query);
		
		guestbook.setId(sql.getColumnFromRS(rs, "id"));
		guestbook.setDate(sql.getColumnFromRS(rs, "date"));
		guestbook.setTime(sql.getColumnFromRS(rs, "time"));
		guestbook.setNick(sql.getColumnFromRS(rs, "nick"));
		guestbook.setMsg(sql.getColumnFromRS(rs, "msg"));
		guestbook.setImgUrl(sql.getColumnFromRS(rs, "img_id"));		
		
		try {
			out.println("<h1 align=\\\\"center\\\\">");
			out.println("	Mesidžis");
			out.println("</h1>");
			out.println("<form onSubmit=\\\\"return checkFields(this)\\\\" action=\\\\"/Cokoliv/ControllServlet\\\\" method=\\\\"POST\\\\">");
			out.println("	<table border=\\\\"0\\\\" align=\\\\"center\\\\" class=\\\\"guestbookPersonInfo\\\\">");
			out.println("		<tr>");
			out.println("			<td class=\\\\"guestbookPersonInfoTitle\\\\">");
			out.println("				Nick: ");
			out.println("			</td>");
			out.println("			<td>");
			out.println("				<input type=\\\\"TEXT\\\\" name=\\\\""+Constants.FORM_TEXTFIELD_GUESTBOOK_NICK+"\\\\" class=\\\\"guestbookPersonInfoTextField\\\\">");
			out.println("			</td>");
			out.println("		</tr>");
			out.println("		<tr>");
			out.println("			<td class=\\\\"guestbookPersonInfoTitle\\\\">");
			out.println("				Zpráva: ");
			out.println("			</td>");
			out.println("			<td>");
			out.println("				<textarea rows=\\\\"10\\\\" cols=\\\\"50\\\\" name=\\\\""+Constants.FORM_TEXTAREA_GUESTBOOK_MSG+"\\\\" class=\\\\"guestbookPersonInfoTextArea\\\\"></textarea>");
			out.println("			</td>");
			out.println("		</tr>");
			out.println("		<tr>");
			out.println("			<td class=\\\\"guestbookPersonInfoTitle\\\\">");
			out.println("				Antispam: ");
			out.println("			</td>");
			out.println("			<td>");
			out.println("			"+example+" = ");
			out.println("				<input type=\\\\"TEXT\\\\" name=\\\\""+Constants.FORM_TEXTFIELD_GUESTBOOK_ANTISPAM+"\\\\" class=\\\\"guestbookPersonInfoTextField\\\\">");
			out.println("				<input type=\\\\"HIDDEN\\\\" name=\\\\""+Constants.FORM_HIDDEN_GUESTBOOK_ANTISPAM+"\\\\" value=\\\\""+example+"\\\\">");
			out.println("			</td>");
			out.println("		</tr>");
			out.println("		<tr>");
			out.println("			<td colspan=\\\\"2\\\\" align=\\\\"center\\\\">");
			out.println("				<INPUT TYPE=\\\\"HIDDEN\\\\" name=\\\\""+Constants.HIDDEN_ACTION_STRING+"\\\\" value=\\\\""+Constants.HIDDEN_ACTION_GUESTBOOK_ADD_ITEM+"\\\\">");			
			out.println("				<input type=\\\\"SUBMIT\\\\" value=\\\\"Odeslat\\\\" class=\\\\"guestbookPersonInfoSubmit\\\\">");
			out.println("			</td>");
			out.println("		</tr>");
			out.println("	</table>");
			out.println("</form>");
			out.println("<hr class=\\\\"guestbookSplitter\\\\">");

			guestbook.getPageNumbers(out, page);

			out.println("<table border=\\\\"0\\\\" align=\\\\"center\\\\" width=\\\\"90%\\\\">");
			for(int i=guestbook.getStartPage(page); i<guestbook.getCount(page); i++){
				out.println("	<tr>");
				out.println("		<td>");
				guestbook.writeItem(out,i);
				out.println("		</td>");
				out.println("	</tr>");
			}
			out.println("</table>");

			guestbook.getPageNumbers(out, page);
			
			out.println("<script language=javascript type=\\\\"text/javascript\\\\">");
			out.println("function checkFields(guestbookForm){");
			out.println("	if(guestbookForm."+Constants.FORM_TEXTFIELD_GUESTBOOK_NICK+".value == \\\\"\\\\"){");
			out.println("		alert('"+ServletMessages.MISSING_NICK_MESSAGE+"');");
			out.println("		guestbookForm."+Constants.FORM_TEXTFIELD_GUESTBOOK_NICK+".focus();");
			out.println("		return false;");
			out.println("	}");
			out.println("	if(guestbookForm."+Constants.FORM_TEXTAREA_GUESTBOOK_MSG+".value == \\\\"\\\\"){");
			out.println("		alert('"+ServletMessages.MISSING_MSG_MESSAGE+"');");
			out.println("		guestbookForm."+Constants.FORM_TEXTAREA_GUESTBOOK_MSG+".focus();");
			out.println("		return false;");
			out.println("	}");
			out.println("	if(guestbookForm."+Constants.FORM_TEXTFIELD_GUESTBOOK_ANTISPAM+".value == \\\\"\\\\"){");
			out.println("		alert('"+ServletMessages.MISSING_ANTISPAM_MESSAGE+"');");
			out.println("		guestbookForm."+Constants.FORM_TEXTFIELD_GUESTBOOK_ANTISPAM+".focus();");
			out.println("		return false;");
			out.println("	}");
			out.println("	if(guestbookForm."+Constants.FORM_TEXTFIELD_GUESTBOOK_ANTISPAM+".value!=\\\\""+antispam.getResult(example.split(" "))+"\\\\"){");
			out.println("		alert('"+ServletMessages.MISSING_ANTISPAM_MESSAGE+"');");
			out.println("		guestbookForm."+Constants.FORM_TEXTFIELD_GUESTBOOK_ANTISPAM+".focus();");
			out.println("		return false;");
			out.println("	}");
			out.println("	return true;");
			out.println("}");
			out.println("</script>");
		} catch (IOException e) {
			// TODO Automaticky generovaný zachytávací blok
			e.printStackTrace();
		}
	}

	public void getPersonBand(boolean admin, int personId){
		if(personId>-1){
			getPersonById(admin,personId);
		}else if(personId==-2){
			createNewPerson();
		}
	}
	
	public void getSong(boolean admin, int songId){
		if(songId>-1){
			getSongById(admin,songId);
		}else if(songId==-1){
			getDefaultPage(Constants.PLAYLIST_DEFAULT_PAGE, admin);
		}else if(songId==-2){
			createNewSong();
		}
	}
	
	private void getDefaultPage(int pageId, boolean admin){
		SqlPropertyRepository repository = new SqlPropertyRepository(PropertyManager.getInstance().getProperty(Constants.SQL_PROPERTY_FILENAME));
		SqlManager sql = SqlManager.getInstance();
		ResultSet rs = null;
		
		String query = repository.getDefaultPageQuery(Constants.GET_DEFAULT_PAGE_SQL_KEY,pageId);
		rs = sql.executeQuery(query);
		
		String title = sql.getColumnFromRS(rs, "title")[0];
		String content = sql.getColumnFromRS(rs, "content")[0];
		try {
			out.println("<h1 align=\\\\"center\\\\">");
			out.println(title);
			out.println("</h1>");
			if(admin){
				out.println("<form action=\\\\"/Cokoliv/ControllServlet\\\\" method=\\\\"POST\\\\">");
			}
			if(admin){
				//out.println("		<td width=\\\\"10\\\\">");
				//out.println("			<input type=CHECKBOX name=\\\\""+id[i]+"\\\\">");
				//out.println("		</td>");
			}
			out.println(content);
			if(admin){
				/*
				out.println("	<tr>");
				out.println("		<td colspan=\\\\"4\\\\" align=\\\\"center\\\\">");
				out.println("			<input type=HIDDEN name=\\\\""+Constants.HIDDEN_ACTION_STRING+"\\\\" value=\\\\""+Constants.HIDDEN_ACTION_DEL_NEWS+"\\\\">");
				out.println("			<input type=SUBMIT value=\\\\"Smazat oznacene\\\\">");
				out.println("		</td>");
				out.println("	</tr>");
				*/
	
	/**
			}
			//out.println("</table>");
			if(admin){
				out.println("</form>");
			}
		} catch (IOException e) {
			// TODO Automaticky generovaný zachytávací blok
			e.printStackTrace();
		}
	}
	
	private void createNewPerson(){
		SqlPropertyRepository repository = new SqlPropertyRepository(PropertyManager.getInstance().getProperty(Constants.SQL_PROPERTY_FILENAME));
		SqlManager sql = SqlManager.getInstance();
		ResultSet rs = null;
		
		try {
			String formPreElement = "<INPUT TYPE=text name=\\\\""+Constants.FORM_PERSON_NICK+"\\\\" value=\\\\"";
			String formPostElement = "\\\\">";
			
			
			out.println("<table border=\\\\"0\\\\" class=\\\\"newPersonTable\\\\">");
			out.println("<tr>");
			out.println("<td width=\\\\"60%\\\\" class=\\\\"newPersonTableVerticalSplitter\\\\">");
			out.println("<form action=\\\\"/Cokoliv/ControllServlet\\\\" method=\\\\"POST\\\\">");
			out.println("<h1>");
			out.println("Nick: "+formPreElement+formPostElement);
			out.println("</h1>");
			formPreElement = "<textarea name=\\\\""+Constants.FORM_PERSON_INFO+"\\\\" cols=\\\\"60\\\\" rows=\\\\"10\\\\">";
			formPostElement = "</textarea>";
			out.println("Další informace:<br>"+formPreElement+formPostElement);
			out.println("<br><br><hr width=\\\\"90%\\\\">");
			out.println("			<input type=HIDDEN name=\\\\""+Constants.HIDDEN_ACTION_STRING+"\\\\" value=\\\\""+Constants.HIDDEN_ACTION_CREATE_NEW_PERSON+"\\\\">");
			out.println("<INPUT TYPE=\\\\"HIDDEN\\\\" name=\\\\""+Constants.HIDDEN_ELEMENT_PERSON_IMG_FILENAME+"\\\\" value=\\\\""+this.filename+"\\\\">");			
			out.println("			<center><input type=SUBMIT value=\\\\"Vložit nového člena\\\\"></center>");
			out.println("</form>");			
			out.println("</td>");
			out.println("<td width=\\\\"40%\\\\" valign=\\\\"top\\\\">");
			out.println("<form action=\\\\"/Cokoliv/ControllServlet\\\\" method=\\\\"POST\\\\" enctype=\\\\""+Constants.MULTIPART_DATA_STR+"\\\\">");
			out.println("Fotka: &nbsp; &nbsp; <INPUT TYPE=\\\\"FILE\\\\" name=\\\\""+Constants.FORM_IMG_PATH+"\\\\">");
			out.println("<INPUT TYPE=\\\\"HIDDEN\\\\" name=\\\\""+Constants.HIDDEN_ACTION_STRING+"\\\\" value=\\\\""+Constants.HIDDEN_ACTION_UPLOAD_PERSON_IMAGE+"\\\\">");
			out.println("<center><INPUT TYPE=\\\\"SUBMIT\\\\" value=\\\\"Nahrát fotku\\\\"></center>");
			out.println("</form>");
			out.println("<hr width=\\\\"90%\\\\">");
			if(!this.filename.equals("")){
				out.println("<center>");
				out.println("<img src=\\\\""+this.filename+"\\\\">");
				out.println("</center>");
			}
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
		} catch (IOException e) {
			// TODO Automaticky generovaný zachytávací blok
			e.printStackTrace();
		}

	}
	private void createNewSong(){
		SqlPropertyRepository repository = new SqlPropertyRepository(PropertyManager.getInstance().getProperty(Constants.SQL_PROPERTY_FILENAME));
		SqlManager sql = SqlManager.getInstance();
		ResultSet rs = null;
		
		try {
			String formPreElement = "<INPUT TYPE=text name=\\\\""+Constants.FORM_SONG_NAME+"\\\\" value=\\\\"";
			String formPostElement = "\\\\">";

			out.println("<form action=\\\\"/Cokoliv/ControllServlet\\\\" method=\\\\"POST\\\\">");
			out.println("<h1>");
			out.println("Název: "+formPreElement+formPostElement);
			out.println("</h1>");
			
			
			formPreElement = "<center><textarea name=\\\\""+Constants.FORM_SONG_TEXT+"\\\\" cols=\\\\"100\\\\" rows=\\\\"10\\\\">";
			formPostElement = "</textarea></center>";
			out.println("Text písně:<br>"+formPreElement+formPostElement);
			out.println("<br><br><hr width=\\\\"90%\\\\">");
			formPreElement = "<center><textarea name=\\\\""+Constants.FORM_SONG_DESCR+"\\\\" cols=\\\\"100\\\\" rows=\\\\"10\\\\">";
			formPostElement = "</textarea></center>";
			out.println("Dodatečné info k písni:<br>"+formPreElement+formPostElement);
			out.println("			<input type=HIDDEN name=\\\\""+Constants.HIDDEN_ACTION_STRING+"\\\\" value=\\\\""+Constants.HIDDEN_ACTION_CREATE_NEW_SONG+"\\\\">");
			out.println("			<center><input type=SUBMIT value=\\\\"Update\\\\"></center>");
			out.println("</form>");			
		} catch (IOException e) {
			// TODO Automaticky generovaný zachytávací blok
			e.printStackTrace();
		}

	}
	
	private void getPersonById(boolean admin, int id){
		SqlPropertyRepository repository = new SqlPropertyRepository(PropertyManager.getInstance().getProperty(Constants.SQL_PROPERTY_FILENAME));
		SqlManager sql = SqlManager.getInstance();
		ResultSet rs = null;
		
		String query = repository.getSongQuery(Constants.GET_PERSON_SQL_KEY,id);
		rs = sql.executeQuery(query);
		
		String title = sql.getColumnFromRS(rs, Constants.FORM_PERSON_NICK)[0];
		String info="";
		if(admin){
			info = sql.getColumnFromRS(rs, Constants.FORM_PERSON_INFO)[0];
		}else{
			info = StringOperations.getInstance().getFormattedText(sql.getColumnFromRS(rs, Constants.FORM_PERSON_INFO)[0]);
		}
		String img=sql.getColumnFromRS(rs, Constants.FORM_PERSON_IMG)[0];
		
		try {
			String formPreElement = admin?"<INPUT TYPE=text name=\\\\""+Constants.FORM_PERSON_NICK+"\\\\" value=\\\\"":"";
			String formPostElement = admin?"\\\\">":"";
			
			out.println("<table border=\\\\"0\\\\" align=\\\\"center\\\\" width=\\\\"100%\\\\">");
			out.println("<tr>");
			out.println("<td width=\\\\"210\\\\" class=\\\\"newPersonTableVerticalSplitter\\\\">");
			out.println("<center><img src=\\\\""+img+"\\\\"></center><br>");//obrazek
			if(admin){
				out.println("<hr>Změnit fotku: ");
				out.println("<form action=\\\\"/Cokoliv/ControllServlet\\\\" method=\\\\"POST\\\\" enctype=\\\\""+Constants.MULTIPART_DATA_STR+"\\\\">");
				out.println("<INPUT TYPE=\\\\"FILE\\\\" name=\\\\""+Constants.FORM_IMG_PATH+"\\\\">");
				out.println("<INPUT TYPE=\\\\"HIDDEN\\\\" name=\\\\""+Constants.HIDDEN_ACTION_STRING+"\\\\" value=\\\\""+Constants.HIDDEN_ACTION_UPDATE_PERSON_IMAGE+"\\\\">");
				out.println("<INPUT TYPE=\\\\"HIDDEN\\\\" name=\\\\""+Constants.HIDDEN_ELEMENT_PERSON_ID+"\\\\" value=\\\\""+id+"\\\\">");
				out.println("<center><INPUT TYPE=\\\\"SUBMIT\\\\" value=\\\\"Update\\\\"></center>");
				out.println("</form>");
			}
			out.println("</td>");
			out.println("<td style=\\\\"vertical-align:top; padding-left:20px;\\\\">");
			if(admin){
				out.println("<form action=\\\\"/Cokoliv/ControllServlet\\\\" method=\\\\"POST\\\\">");
			}
			out.println("<h1>");
			out.println(formPreElement+title+formPostElement);
			out.println("</h1>");

			formPreElement = admin?"<center><textarea name=\\\\""+Constants.FORM_PERSON_INFO+"\\\\" cols=\\\\"60\\\\" rows=\\\\"10\\\\">":"";
			formPostElement = admin?"</textarea></center>":"";
			out.println(formPreElement+info+formPostElement);
			out.println("<br><br><hr width=\\\\"90%\\\\">");
			if(admin){
				out.println("			<input type=HIDDEN name=\\\\""+Constants.HIDDEN_ELEMENT_PERSON_ID+"\\\\" value=\\\\""+id+"\\\\">");				
				out.println("			<input type=HIDDEN name=\\\\""+Constants.HIDDEN_ACTION_STRING+"\\\\" value=\\\\""+Constants.HIDDEN_ACTION_UPDATE_PERSON+"\\\\">");
				out.println("			<center><input type=SUBMIT value=\\\\"Update\\\\"></center>");
				out.println("</form>");
			}
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");

		} catch (IOException e) {
			// TODO Automaticky generovaný zachytávací blok
			e.printStackTrace();
		}

	}

	
	private void getSongById(boolean admin, int id){
		SqlPropertyRepository repository = new SqlPropertyRepository(PropertyManager.getInstance().getProperty(Constants.SQL_PROPERTY_FILENAME));
		SqlManager sql = SqlManager.getInstance();
		ResultSet rs = null;
		
		String query = repository.getSongQuery(Constants.GET_SONG_SQL_KEY,id);
		rs = sql.executeQuery(query);
		
		String title = sql.getColumnFromRS(rs, Constants.FORM_SONG_NAME)[0];
		String text="";
		if(admin){
			text = sql.getColumnFromRS(rs, Constants.FORM_SONG_TEXT)[0];
		}else{
			text = StringOperations.getInstance().getFormattedText(sql.getColumnFromRS(rs, Constants.FORM_SONG_TEXT)[0]);
		}
		String descr= sql.getColumnFromRS(rs, Constants.FORM_SONG_DESCR)[0];
		String mp3 = sql.getColumnFromRS(rs, "mp3_url")[0];
		String video = sql.getColumnFromRS(rs, "video_url")[0];	
		String uploadButtonTitle="";
		if(!mp3.equals("")){
			uploadButtonTitle="Update";
		}else{
			uploadButtonTitle="Nahrát píseň";
		}

		try {
			String formPreElement = admin?"<INPUT TYPE=text name=\\\\""+Constants.FORM_SONG_NAME+"\\\\" value=\\\\"":"";
			String formPostElement = admin?"\\\\">":"";
			
			if(admin){
				out.println("<form action=\\\\"/Cokoliv/ControllServlet\\\\" method=\\\\"POST\\\\" enctype=\\\\""+Constants.MULTIPART_DATA_STR+"\\\\">");
				out.println("<INPUT TYPE=\\\\"FILE\\\\" name=\\\\""+Constants.FORM_MP3_PATH+"\\\\">");
				out.println("<INPUT TYPE=\\\\"HIDDEN\\\\" name=\\\\""+Constants.HIDDEN_ACTION_STRING+"\\\\" value=\\\\""+Constants.HIDDEN_ACTION_UPDATE_MP3+"\\\\">");
				out.println("<INPUT TYPE=\\\\"HIDDEN\\\\" name=\\\\""+Constants.HIDDEN_ELEMENT_SONG_ID+"\\\\" value=\\\\""+id+"\\\\">");
				out.println("<INPUT TYPE=\\\\"SUBMIT\\\\" value=\\\\""+uploadButtonTitle+"\\\\">");
				out.println("</form>");
				out.println("<div class=\\\\"poznamka\\\\">Nedoporučuje se používat soubory, v jejichž názvu jsou háčky a čárky.</div>");
				out.println("<form action=\\\\"/Cokoliv/ControllServlet\\\\" method=\\\\"POST\\\\">");
			}
			out.println("<h1>");
			out.println(formPreElement+title+formPostElement);
			
			if(!mp3.equals("")){
				out.println("<object type=\\\\"application/x-shockwave-flash\\\\" data=\\\\"audio/player/player.swf\\\\" id=\\\\"audioplayer2\\\\" height=\\\\"24\\\\" width=\\\\"290\\\\">");
				out.println("<param name=\\\\"movie\\\\" value=\\\\"audio/player/player.swf\\\\">");
				out.println("<param name=\\\\"FlashVars\\\\" value=\\\\"playerID=2&amp;soundFile="+mp3+"\\\\">");
				out.println("<param name=\\\\"quality\\\\" value=\\\\"high\\\\">");
				out.println("<param name=\\\\"menu\\\\" value=\\\\"true\\\\">");
				out.println("<param name=\\\\"wmode\\\\" value=\\\\"transparent\\\\">");
				out.println("</object>");
			}
			out.println("</h1>");

			

			formPreElement = admin?"<center><textarea name=\\\\""+Constants.FORM_SONG_TEXT+"\\\\" cols=\\\\"100\\\\" rows=\\\\"60\\\\">":"";
			formPostElement = admin?"</textarea></center>":"";
			out.println(formPreElement+text+formPostElement);
			out.println("<br><br><hr width=\\\\"90%\\\\">");
			formPreElement = admin?"<center><textarea name=\\\\""+Constants.FORM_SONG_DESCR+"\\\\" cols=\\\\"100\\\\" rows=\\\\"10\\\\">":"";
			formPostElement = admin?"</textarea></center>":"";
			out.println(formPreElement+descr+formPostElement);
			if(admin){
				out.println("			<input type=HIDDEN name=\\\\""+Constants.HIDDEN_ELEMENT_SONG_ID+"\\\\" value=\\\\""+id+"\\\\">");				
				out.println("			<input type=HIDDEN name=\\\\""+Constants.HIDDEN_ACTION_STRING+"\\\\" value=\\\\""+Constants.HIDDEN_ACTION_UPDATE_SONG+"\\\\">");
				out.println("			<center><input type=SUBMIT value=\\\\"Update\\\\"></center>");
				out.println("</form>");
			}
		} catch (IOException e) {
			// TODO Automaticky generovaný zachytávací blok
			e.printStackTrace();
		}

	}
	
	public void getVerticalMenu(int menuOption, String actUrl, boolean admin) throws IOException{
		String query="";
		String menuTitleImgUrl="";
		String idStr[]=new String[0];
		String items[]=new String[0];
		String idStrName = "";
		String itemStrName = "";
		String delActionValue= "";
		String addNewActionValue= "";
		SqlPropertyRepository repository = new SqlPropertyRepository(PropertyManager.getInstance().getProperty(Constants.SQL_PROPERTY_FILENAME));
		SqlManager sql = SqlManager.getInstance();		
		ResultSet rs = null;		
		
		switch(menuOption){
			case Constants.VERTICAL_MENU_MUSIC:
				query = repository.getSqlQuery(Constants.GET_MUSIC_MENU_SQL_KEY);
				menuTitleImgUrl="img/night/playlist-menu-title.png";
				idStrName="id";
				itemStrName="song_name";
				delActionValue=Constants.HIDDEN_ACTION_DELETE_SONG;
				addNewActionValue=Constants.HIDDEN_ACTION_ADD_NEW_SONG;
				break;
			case Constants.VERTICAL_MENU_BAND:
				query = repository.getSqlQuery(Constants.GET_PERSON_SQL_KEY);
				menuTitleImgUrl="img/night/kapela-title.png";
				idStrName="id";
				itemStrName="nick";
				delActionValue=Constants.HIDDEN_ACTION_DELETE_PERSON;
				addNewActionValue=Constants.HIDDEN_ACTION_ADD_NEW_PERSON;
				break;
		}
		rs = sql.executeQuery(query);
		idStr = sql.getColumnFromRS(rs, idStrName);
		items = sql.getColumnFromRS(rs, itemStrName);
		
		out.println("<img src=\\\\""+menuTitleImgUrl+"\\\\">");
		if(admin){
			out.println("<form action=\\\\"/Cokoliv/ControllServlet\\\\" method=\\\\"POST\\\\">");			
		}
		out.println("<table border=\\\\"0\\\\" align=\\\\"center\\\\" valign=\\\\"top\\\\" width=\\\\"90%\\\\">");
		
		for(int i=0;i<idStr.length;i++){
			String adminElement = admin?"<INPUT TYPE=checkbox name=\\\\"item"+idStr[i]+"\\\\">":"";
			out.println("<tr><br><td>"+adminElement+"</td>");
			out.println("<td><a href=\\\\""+actUrl+"?id="+idStr[i]+"\\\\">&nbsp;&nbsp;"+items[i]+"</a></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		if(admin){
			out.println("			<input type=HIDDEN name=\\\\""+Constants.HIDDEN_ACTION_STRING+"\\\\" value=\\\\""+delActionValue+"\\\\">");
			out.println("			<center><input type=SUBMIT value=\\\\"Vybrané smazat\\\\"></center>");
			out.println("</form>");
			out.println("<form action=\\\\"/Cokoliv/ControllServlet\\\\" method=\\\\"POST\\\\">");
			out.println("			<input type=HIDDEN name=\\\\""+Constants.HIDDEN_ACTION_STRING+"\\\\" value=\\\\""+addNewActionValue+"\\\\">");
			out.println("			<center><input type=SUBMIT value=\\\\"Vložit nový záznam\\\\"></center>");
			out.println("</form>");
		}
		
	}
	
	public void getMenu(String actualPage){
		SqlPropertyRepository repository = new SqlPropertyRepository(PropertyManager.getInstance().getProperty(Constants.SQL_PROPERTY_FILENAME));
		
		SqlManager sql = SqlManager.getInstance();		
		ResultSet rs = null;		
		String query = repository.getSqlQuery(Constants.GET_MENU_SQL_KEY);		
		rs = sql.executeQuery(query);

		String link[] = sql.getColumnFromRS(rs, "link");
		String img_url[]=sql.getColumnFromRS(rs, "img_url");
		int size = -1;
		
		if(link.length==img_url.length){
			size = link.length;
		}else{
			//TODO - v databazi neni stejny pocet url a img linku - je to vubec mozne ? 
		}
		
		actualPage = actualPage.substring(actualPage.lastIndexOf('/')+1,actualPage.length());
		
		try{
			out.println("<table class=\\\\"hMenu\\\\" align=\\\\"center\\\\" cellpadding=\\\\"0\\\\" cellspacing=\\\\"0\\\\">");
			out.println("	<tr>");

			for(int i=0;i<size;i++){
				String className = "";
				if(link[i].equals(actualPage)){
					className=Constants.ACTIVE_ITEM_CLASS_NAME;
				}else{
					className=Constants.FREE_ITEM_CLASS_NAME;
				}
				out.println("		<td class=\\\\""+className+"\\\\">");
				out.println("			<a href=\\\\""+link[i]+"\\\\"><img src=\\\\""+img_url[i]+"\\\\"></a>");
				out.println("		</td>");				
			}
			out.println("	</tr>");
			out.println("</table>");
			
		}catch(IOException e){
			//TODO - logovat
			e.printStackTrace();
		}
	
	}
	
	public void getBody(String url, String contentFile, int window_type, int vMenuType, boolean admin){
		try{
			out.println("<body>");
			out.println("	<table class=\\\\"screen\\\\">");
			getLogo();
			out.println("		<tr>");
			out.println("			<td class=\\\\"main\\\\">");
			
			if(window_type==Constants.SIMPLE_MAIN_WINDOW){
				getMainSimpleWindow(url,contentFile);
			}else{
				getMainComplexWindow(vMenuType,url,contentFile,admin);
			}
			
			out.println("			</td>");
			out.println("		</tr>");
			out.println("	</table>");
			out.println("</body>");
			getEnd();
		}catch(IOException e){
			//TODO - logovat
			e.printStackTrace();
		}
	}
	*/
}
