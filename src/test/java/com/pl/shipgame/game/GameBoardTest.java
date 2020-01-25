package com.pl.shipgame.game;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.powermock.reflect.Whitebox;

import com.pl.shipgame.game.shiptypes.Ship;
import com.pl.shipgame.game.utils.Point;

class GameBoardTest {

	private GameBoard board;
	private Settings settings;
	private List<Ship> ships;
	private List<List<Point>> points;

	@BeforeEach
	void init() {
		board = new GameBoard();
		settings = Whitebox.getInternalState(board, "settings");
		ships = Whitebox.getInternalState(board, "ships");
		points = Whitebox.getInternalState(board, "points");
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
