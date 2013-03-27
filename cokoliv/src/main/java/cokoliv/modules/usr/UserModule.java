package cokoliv.modules.usr;

import cokoliv.dao.BandMenuDAO;
import cokoliv.databobjects.BandMenuItem;

public class UserModule implements IUserModule{
	public BandMenuItem[] getBandMenuItems(){
		BandMenuDAO dao = new BandMenuDAO();
		return dao.getBandMenuItems();
	}
}
