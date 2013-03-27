package cokoliv.modules.usr;

import cokoliv.databobjects.BandMenuItem;

public interface IUserModule {
	//USR001: Ziskej seznam clenu kapely z DB
	public BandMenuItem[] getBandMenuItems();
	//USR002: Nacti detail clena kapely z DB
	//USR003: Uloz clena kapely do DB
	//USR004: Uloz zmeny clena kapely do DB
	//USR005: Ziskej aktualni foto uzivatele
}
