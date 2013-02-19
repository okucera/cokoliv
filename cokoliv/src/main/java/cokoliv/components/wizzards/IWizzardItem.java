package cokoliv.components.wizzards;

import java.io.IOException;

import cokoliv.enumerate.EWizzardItems;

public interface IWizzardItem {
	public EWizzardItems getType();
	public void drawContent() throws IOException;
}
