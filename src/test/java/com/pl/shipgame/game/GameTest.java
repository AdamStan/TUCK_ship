package com.pl.shipgame.game;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void testInitializeGame() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
	Game game = Game.initializeGame();
	GameBoard board = new GameBoard();
	Field fieldBoard = game.getClass().getDeclaredField("board");
	fieldBoard.setAccessible(true);
	assertNotEquals(null, fieldBoard.get(game));
	}

	@Test
	void testSetShot() {
		fail("Not yet implemented");
	}

	@Test
	void testCheckIfShipIsDestroyed() {
		fail("Not yet implemented");
	}

	@Test
	void testCheckIfAllShipsDestroyed() {
		fail("Not yet implemented");
	}

}
