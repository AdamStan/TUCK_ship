package com.pl.shipgame.window;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;

import com.pl.shipgame.game.Settings;

class MainWindowControllerTest {
	MainWindowController mainWindowController;
	Settings settings;
	@BeforeEach
	void init() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
	    mainWindowController = new MainWindowController();
		Field fieldSettings = mainWindowController.getClass().getDeclaredField("settings");
		fieldSettings.setAccessible(true);
		settings = (Settings) fieldSettings.get(mainWindowController);
	}

}
