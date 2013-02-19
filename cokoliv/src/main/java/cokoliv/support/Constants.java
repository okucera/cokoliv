package cokoliv.support;

public class Constants {
	//pouzito v novych strankach
	public static final String GET_MENU_SQL_KEY = "GET_MENU_SQL";
	public static final String GET_USER_SQL = "GET_USER_SQL";
	public static final String GET_FIRST_TIME_LOGIN_PARAM = "GET_FIRST_TIME_LOGIN_PARAM";
	public static final String CLEAR_LOGIN_COUNTER_SQL = "CLEAR_LOGIN_COUNTER";
	public static final String GET_LOGGED_USER_SQL = "GET_LOGGED_USER_SQL";
	public static final String GET_LOGIN_COUNTER_SQL = "GET_LOGIN_COUNTER";
	public static final String SET_LOGIN_COUNTER_SQL = "SET_LOGIN_COUNTER";
	public static final String UPDATE_USER_SQL = "UPDATE_USER"; 

	//Pro pouziti prepsani hodnot v hash mapach
	public static final String REPLACE_USER_ID_KEY = "%USER_ID%";
	public static final String REPLACE_LOGIN_KEY = "%LOGIN%";
	public static final String REPLACE_LOGIN_COUNTER_VALUE_KEY = "%LOGIN_COUNTER_VALUE%";
	public static final String REPLACE_USER_FIRST_NAME_KEY = "%USER_FIRST_NAME%";
	public static final String REPLACE_USER_LAST_NAME_KEY = "%USER_LAST_NAME%";
	public static final String REPLACE_USER_NICK_KEY = "%USER_NICK%";
	public static final String REPLACE_PASSWORD_KEY = "%PASSWORD%";
	public static final String REPLACE_ARRAY_KEY = "%ARRAY%";
	
	//MAX pocet neuspesnych prihlaseni do aplikace
	public static final int MAX_FAIL_LOGIN_COUNT = 3;
	
	//FormId aktualne nactene stranky
	public static final String FORM_ID_KEY = "formId";
	
	//Klic pro ziskani objektu LoggedUser v HttpSEssion
	public static final String LOGGED_USER_KEY = "sessionLoggedUser";
	
	//nazvy formularovych prvku
	public static final String FORM_TEXTFIELD_USERNAME = "username";
	public static final String FORM_TEXTFIELD_PWD = "password";
	public static final String FORM_USER_FIRST_NAME = "firstName";
	public static final String FORM_USER_LAST_NAME = "lastName";
	public static final String FORM_USER_NICK = "nick";
	public static final String FORM_USER_NEW_PWD = "newPassword";
	public static final String FORM_USER_NEW_PWD_RETYPED = "retypedNewPAssword";
	public static final String FORM_HIDDEN_ACTION_STRING = "action";
	public static final String FORM_HIDDEN_ACTION_DEL_NEWS = "del_news";

	
	//AddImageWizzardItem.java
	public static final String FILE_INPUT_IMAGE_NAME = "fileInputImage";
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static final int SIMPLE_MAIN_WINDOW = 0;
	public static final int COMPLEX_MAIN_WINDOW = 1;
	
	//Typy vertikalnich menu
	public static final int VERTICAL_MENU_NULL = -1;
	public static final int VERTICAL_MENU_BAND = 0;
	public static final int VERTICAL_MENU_MUSIC = 1;
	public static final int VERTICAL_MENU_DOWNLOAD = 2;

	
	public static final String SQL_LOG_FILE = "SQL_LOG_FILE";
	public static final String SERVLET_LOG_FILE = "SERVLET_LOG_FILE";
	public static final String ERROR_LOG_FILE = "ERROR_LOG_FILE";
	
	public static final String UPLOAD_DIR = "UPLOAD_DIR";
	public static final String UPLOAD_HOME = "UPLOAD_HOME";
	public static final String UPLOAD_PERSONS_DIR = "UPLOAD_PERSONS_DIR";
	public static final String UPLOAD_PERSONS_HOME = "UPLOAD_PERSONS_HOME";
	public static final String UPLOAD_MP3_DIR = "UPLOAD_MP3_DIR";
	public static final String UPLOAD_MP3_HOME = "UPLOAD_MP3_HOME";
	public static final String UPLOAD_CONCERT_DIR = "UPLOAD_CONCERT_DIR";
	public static final String UPLOAD_CONCERT_HOME = "UPLOAD_CONCERT_HOME";
	public static final String UPLOAD_THUMB_DIR = "Thumbs";
	public static final String MESSAGE_NUMBER_PER_PAGE = "MESSAGE_NUMBER_PER_PAGE";
		
	public static final String GET_NEWS_SQL_KEY = "GET_NEWS_SQL";
	public static final String DEL_NEWS_SQL_KEY = "DEL_NEWS_SQL";
	public static final String GET_MUSIC_MENU_SQL_KEY = "GET_MUSIC_MENU_SQL";
	public static final String GET_SONG_SQL_KEY = "GET_SONG_SQL";
	public static final String GET_DEFAULT_PAGE_SQL_KEY = "GET_DEFAULT_PAGE_SQL";
	public static final String GET_CONCERT_SQL_KEY = "GET_CONCERT_SQL";
	public static final String GET_GUESTBOOK_SQL_KEY = "GET_GUESTBOOK_SQL";
	
	public static final String FREE_ITEM_CLASS_NAME = "freeItem";
	public static final String ACTIVE_ITEM_CLASS_NAME = "activeItem";
	
	//idcka pro metodu POST formularu
	public static final String POST_ID_STRING = "post_id";


	public static final String HIDDEN_ACTION_DEL_CONCERT = "del_concert";
	public static final String HIDDEN_ACTION_UPLOAD_IMAGE_NEWS = "img_upload";
	public static final String HIDDEN_ACTION_ADD_NEW = "addNew";
	public static final String HIDDEN_ACTION_ADD_CONCERT = "addConcert";
	public static final String HIDDEN_ACTION_UPLOAD_IMAGE_CONCERTS = "concert_img_upload";
	public static final String HIDDEN_ACTION_UPDATE_SONG = "updateSong";
	public static final String HIDDEN_ACTION_DELETE_SONG = "deleteSong";
	public static final String HIDDEN_ACTION_DELETE_PERSON = "deletePerson";	
	public static final String HIDDEN_ACTION_ADD_NEW_SONG = "addNewSong";
	public static final String HIDDEN_ACTION_ADD_NEW_PERSON = "addNewPerson";
	public static final String HIDDEN_ACTION_CREATE_NEW_SONG = "createNewSong";
	public static final String HIDDEN_ACTION_CREATE_NEW_PERSON = "createNewPerson";
	public static final String HIDDEN_ELEMENT_SONG_ID="song_id";
	public static final String HIDDEN_ELEMENT_PERSON_ID="personId";
	public static final String HIDDEN_ELEMENT_PERSON_IMG_FILENAME="personImgPath";
	public static final String HIDDEN_ELEMENT_NEW_IMG_FILENAME="newImgPath";
	public static final String HIDDEN_ELEMENT_CONCERT_IMG_FILENAME="concertImgPath";
	public static final String HIDDEN_ACTION_UPDATE_PERSON = "updatePerson";
	public static final String HIDDEN_ACTION_UPLOAD_PERSON_IMAGE="uploadPersonsImage";
	public static final String HIDDEN_ACTION_UPDATE_PERSON_IMAGE="updatePersonsImage";
	public static final String HIDDEN_ACTION_UPLOAD_MP3="uploadMp3";
	public static final String HIDDEN_ACTION_UPDATE_MP3="updateMp3";
	public static final String HIDDEN_ACTION_GUESTBOOK_ADD_ITEM = "addItem";
	public static final int POST_ADD_NEWS_ID = 0;


	//upload options
	public static final int UPLOAD_NEWS_IMAGE_OPTION = 0;
	public static final int UPLOAD_PERSONS_IMAGE_OPTION = 1;
	public static final int UPLOAD_MP3_OPTION = 2;
	public static final int UPLOAD_CONCERT_IMAGE_OPTION = 3;
	
	//nazvy formularovych prvku
	public static final String MULTIPART_DATA_STR = "multipart/form-data";
	public static final String FORM_IMG_PATH = "imgPath";
	public static final String FORM_CONCERT_IMG_PATH = "concertImgPath";
	public static final String FORM_MP3_PATH = "mp3path";
	public static final String FORM_NEWS_TITLE = "newsTitle";
	public static final String FORM_CONCERT_TITLE = "concertTitle";
	public static final String FORM_NEWS_DESCR = "newsDescription";
	public static final String FORM_CONCERT_DESCR = "concertDescription";
	
	
	public static final String FORM_SONG_ID="id";
	public static final String FORM_SONG_NAME="song_name";
	public static final String FORM_SONG_TEXT="song_text";
	public static final String FORM_SONG_DESCR="song_descr";

	public static final String FORM_PERSON_NICK="nick";
	public static final String FORM_PERSON_INFO="info";
	public static final String FORM_PERSON_IMG="img_url";

	public static final String FORM_BUTTON_MENU_SONG="menu_song_action";
	
	public static final String FORM_TEXTFIELD_GUESTBOOK_NICK = "nick_value";
	public static final String FORM_TEXTFIELD_GUESTBOOK_ANTISPAM = "antispam_value";
	public static final String FORM_HIDDEN_GUESTBOOK_ANTISPAM = "antispam_class";
	public static final String FORM_TEXTAREA_GUESTBOOK_MSG = "msg_value";
	public static final String FORM_PAGE_ATTRIBUTE = "page";
	

	
	//SQL OPTIONS
	public static final int SQL_QUERY_INSERT_NEWS_OPTION = 0;
	public static final int SQL_QUERY_INSERT_NEW_PERSON_OPTION = 1;
	public static final int SQL_QUERY_INSERT_CONCERT_OPTION = 2;
	
	//Default pages
	public static final int PLAYLIST_DEFAULT_PAGE = 0;
	
	
	
	//Context
	public static final String MENU_VAR_CTX = "HorizontalMenu";
	
}
