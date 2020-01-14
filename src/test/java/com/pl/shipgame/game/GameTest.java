package com.pl.shipgame.game;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pl.shipgame.game.shiptypes.Ship;
import com.pl.shipgame.game.utils.Point;

class GameTest {

	Game game;
	Field fieldBoard;

	@BeforeEach
	void init() throws NoSuchFieldException, SecurityException {
		game = Game.initializeGame();
		fieldBoard = game.getClass().getDeclaredField("board");
		fieldBoard.setAccessible(true);
	}

	@Test
	void testInitializeGame()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		GameBoard board = (GameBoard) fieldBoard.get(game);
		assertNotEquals(null, board);
	}

	@Test
	void testCheckIfAllShipsDestroyedFalse()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		assertFalse(game.checkIfAllShipsDestroyed());
	}

	@Test
	void testCheckIfAllShipsDestroyedTrue()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		GameBoard board = (GameBoard) fieldBoard.get(game);
		Field fieldShips = board.getClass().getDeclaredField("ships");
		fieldShips.setAccessible(true);
		List<Ship> ships = (List<Ship>) fieldShips.get(board);
		ships.clear();
		assertTrue(game.checkIfAllShipsDestroyed());
	}

}
