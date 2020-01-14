package com.pl.shipgame.game;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pl.shipgame.game.shiptypes.Ship;
import com.pl.shipgame.game.utils.Point;

class GameBoardTest {

	GameBoard board;
	Settings settings;
	List<Ship> ships;
	List<List<Point>> points;

	@SuppressWarnings("unchecked")
	@BeforeEach
	void init() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		board = new GameBoard();
		Field fieldSettings = board.getClass().getDeclaredField("settings");
		Field fieldShips = board.getClass().getDeclaredField("ships");
		Field fieldPoints = board.getClass().getDeclaredField("points");
		fieldSettings.setAccessible(true);
		fieldShips.setAccessible(true);
		fieldPoints.setAccessible(true);
		settings = (Settings) fieldSettings.get(board);
		ships = (List<Ship>) fieldShips.get(board);
		points = (List<List<Point>>) fieldPoints.get(board);
	}

	@Test
	void testGameBoard() {
		assertNotEquals(null, settings);
		assertNotEquals(null, ships);
	}

	@Test
	void testSetShot() {
		Point shotPoint = new Point(5, 5);
		Point hitPoint = points.get(shotPoint.getX() - 1).get(shotPoint.getY() - 1);
		hitPoint.setShip(new Ship(1));
		assertTrue(board.setShot(shotPoint));
	}

	@Test
	void testCheckIfShipIsDestroyedTrue() {
		Point shotPoint = new Point(5, 5);
		Point hitPoint = points.get(shotPoint.getX() - 1).get(shotPoint.getY() - 1);
		Ship newShip = new Ship(1);
		newShip.addPointToDeck(hitPoint);
		hitPoint.setShip(newShip);
		assertFalse(board.checkIfShipIsDestroyed(shotPoint));
	}
	
	@Test
	void testCheckIfShipIsDestroyedFalse() {
		Point shotPoint = new Point(5, 5);
		Point hitPoint = points.get(shotPoint.getX() - 1).get(shotPoint.getY() - 1);
		Ship newShip = new Ship(1);
		newShip.addPointToDeck(hitPoint);
		hitPoint.setShip(newShip);
		hitPoint.setHit();
		assertTrue(board.checkIfShipIsDestroyed(shotPoint));
	}

	@Test
	void testAllShipsDestroyedTrue() {
		ships.clear();
		assertTrue(board.allShipsDestroyed());
	}

	@Test
	void testAllShipsDestroyedFalse() {
		assertFalse(board.allShipsDestroyed());
	}

}
