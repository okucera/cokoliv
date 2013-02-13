package cokoliv.servlet;

public class ServletMessages {
	
	public static final String UPLOAD_FAILED = "Upload souboru selhal";
	public static final String INCORRECT_GUESTBOOK_ANTISPAM = "Antispamový příkládeček nebyl správně spočítán :-)";
	public static final String GUESTBOOK_MESSAGE_ADDED = "Váš vzkaz byl úspěšně přidán";
	public static final String MISSING_NICK_MESSAGE = "Nebylo zadáno jméno...";
	public static final String MISSING_MSG_MESSAGE = "Zpráva neobsahuje ... žádnou zprávu :-D";
	public static final String MISSING_ANTISPAM_MESSAGE = "Antispam postrádá správnou odpověď :-)";
	public static final String ADMIN_ENTRANCE_TITLE = "Vstup pro Admins";
	
	
	public static String uploadDirFailed(String uploadDir){
		return "doPost()| Nepovedlo se nastavit adresar uloziste "+uploadDir+".\\\\n";
	}
}
