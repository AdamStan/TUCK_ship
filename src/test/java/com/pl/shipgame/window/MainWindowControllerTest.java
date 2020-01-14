package com.pl.shipgame.window;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

	@Test
	void testMainWindowController()
	{
		assertNotEquals(null, settings);
	}

	@Test
	void testStartGame() {
		fail("Not yet implemented");
	}

	@Test
	void testOnShot() {
		fail("Not yet implemented");
	}

	@Test
	void testRestoreToDefault() {
		fail("Not yet implemented");
	}

	@Test
	void testShowSettings() {
		fail("Not yet implemented");
	}

}
