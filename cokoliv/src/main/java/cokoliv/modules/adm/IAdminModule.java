package cokoliv.modules.adm;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

import cokoliv.databobjects.LoggedUser;
import cokoliv.databobjects.User;
import cokoliv.enumerate.UploadRepositories;
import cokoliv.exceptions.CokolivApplicationException;
import cokoliv.flowdata.ChangeUserDetailData;

public interface IAdminModule {
	//ADM001: Over admin prava uzivatele
	public boolean checkAdminUserRights(LoggedUser user);
	//ADM002: Uload souboru
	public List<FileItem> uploadFilesToRepository(List<FileItem> fileItems, UploadRepositories repository, List<FileItem> excludedItems);
	//ADM003: Ziskej seznam oznacenych ppolozek v novinkach
	
	//ADM004: Ziskej nasledujici akci
	//ADM005: Smazani souboru
	//ADM006: Ziskej uzivatele podle loginu
	public User getUserByLogin(String login) throws CokolivApplicationException;
	//ADM007: Porovnej login a heslo prihlasovaneho uzivatele
	public boolean compareLoginPassword(User user, String login, String pwd);
	//ADM008: Ziskej hodnotu citace poctu prihlaseni
	public void incrementLoginCounter(User user) throws CokolivApplicationException;
	//ADM009: Vynuluj citace prihlaseni
	public void clearLoginCounter(String userId) throws CokolivApplicationException;
	//ADM010: Ziskej informace o prihlasenem uzivateli
	public LoggedUser getLoggedUserInfo(User user) throws CokolivApplicationException;
	//ADM012: Ziskej parametr first time login
	public boolean getFirstTimeLoginParametr(User user) throws CokolivApplicationException;
	//ADM013: Porovnej hodnotu citace poctu neuspesnych prihlaseni s max. moznym poctem neusepesnych prihlaseni
	public boolean isUserBlocked(User user);
	//ADM014: Porovnej zadana nova hesla
	public boolean newPasswordsMatch(String newPwd, String retypedNewPwd);
	//ADM015: Uloz uzivatele do db
	public void storeUser(ChangeUserDetailData user) throws CokolivApplicationException;
	//ADM016: Ziskej seznam existujicich souboru
	public List<FileItem> getExistingFilesFromList(List<FileItem> list, UploadRepositories repository);
	//ADM017: Vytvor a uloz nahled k obrazku
	//public void makeImagePreviewInRepository(List<FileItem> fileItems, UploadRepositories repository) throws CokolivApplicationException;
	//ADM018: Vycisti repository od docasnych souboru
	public void deleteTempFilesInRepository(UploadRepositories repository);
	//ADM019: Ziskej uzivatele podle user_id
	public User getUserByUserId(String userId) throws CokolivApplicationException;
}
