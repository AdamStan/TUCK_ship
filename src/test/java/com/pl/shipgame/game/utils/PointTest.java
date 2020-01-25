package com.pl.shipgame.game.utils;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import com.pl.shipgame.game.shiptypes.Ship;


@RunWith(PowerMockRunner.class)
@PrepareForTest(Point.class)
class PointTest {

	private int x;
	private int y;
	private boolean hit;
	private Ship ship;

	@BeforeEach
	void init() {
		x = 0;
		y = 0;
		hit = false;
		ship = null;
	}

	@Test
	void testPoint() {
		int xToTest = 5;
		int yToTest = 10;
		Point point = new Point(xToTest, yToTest);
		x = Whitebox.getInternalState(point, "x");
		y = Whitebox.getInternalState(point, "y");
		assertEquals(xToTest, x);
		assertEquals(yToTest, y);
	}

	@Test
	void testGetX() {
		int x = 2;
		int y = 8;
		Point point = new Point(x, y);
		assertEquals(x, point.getX());
	}

	@Test
	void testGetY() {
		int x = 1;
		int y = 4;
		Point point = new Point(x, y);
		assertEquals(y, point.getY());
	}

	@Test
	void testEqualsObjectTrueTheSameObject() {
		int x = 1;
		int y = 4;
		Point pointOne = new Point(x, y);
		Point pointTwo = pointOne;
		assertTrue(pointOne.equals(pointTwo));
	}

	@Test
	void testEqualsObjectFalseNull() {
		int x = 1;
		int y = 4;
		Point pointOne = new Point(x, y);
		Point pointTwo = null;
		assertFalse(pointOne.equals(pointTwo));
	}

	@Test
	void testEqualsObjectFalseDifferentClass() {
		int x = 1;
		int y = 4;
		Point pointOne = new Point(x, y);
		Object object = new Object();
		assertFalse(pointOne.equals(object));
	}

	@Test
	void testEqualsObjectFalseSameClass() {
		int xOne = 1, yOne = 1;
		int xTwo = 4, yTwo = 4;
		Point pointOne = new Point(xOne, yOne);
		Point pointTwo = new Point(xTwo, yTwo);
		assertFalse(pointOne.equals(pointTwo));
	}

	@Test
	void testGetShip() {
		int xToTest = 2;
		int yToTest = 8;
		int deckSizeToTest = 2;
		Point point = new Point(xToTest, yToTest);
		Ship ship = new Ship(deckSizeToTest);
		point.setShip(ship);
		assertEquals(ship, point.getShip().get());
	}

	@Test
	void testSetShip() {
		int xToTest = 2;
		int yToTest = 8;
		int deckSizeToTest = 2;
		Point point = new Point(xToTest, yToTest);
		Ship ship = new Ship(deckSizeToTest);
		point.setShip(ship);
		assertEquals(ship, point.getShip().get());
	}

	@Test
	void testIsHit() {
		int xToTest = 2;
		int yToTest = 8;
		Point point = new Point(xToTest, yToTest);
		Whitebox.setInternalState(point, Boolean.class, true);
		assertTrue(point.isHit());
	}

	@Test
	void testSetHit() {
		int xToTest = 2;
		int yToTest = 8;
		Point point = new Point(xToTest, yToTest);
		point.setHit();
		assertTrue(point.isHit());
	}

	@Test
	void testToString() {
		int xToTest = 2;
		int yToTest = 8;
		Point point = new Point(xToTest, yToTest);
		String expectedString = "Point [x=" + xToTest + ", y=" + yToTest + "]";
		assertEquals(expectedString, point.toString());
	}

	@Test
	void testClearShip() {
		int xToTest = 2;
		int yToTest = 8;
		Point point = new Point(xToTest, yToTest);
		int deckSizeToTest = 2;
		Ship shipToTest = new Ship(deckSizeToTest);
		Whitebox.setInternalState(point, Ship.class, shipToTest);
		ship = Whitebox.getInternalState(point, Ship.class);
		assertEquals(shipToTest, ship);
		point.clearShip();
		ship = Whitebox.getInternalState(point, Ship.class);
		assertEquals(null, ship);
	}

	@Test
	void testHashCode() {
		int x = 5;
		int y = 10;
		int hashCode = Objects.hash(x, y);
		Point point = new Point(x, y);
		assertEquals(hashCode, point.hashCode());
	}

}
