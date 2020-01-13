package com.pl.shipgame.game.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.Objects;

import org.junit.jupiter.api.Test;

import com.pl.shipgame.game.shiptypes.Ship;

class PointTest {

	@Test
	void testHashCode() {
		int x = 5;
		int y = 10;
		int hashCode = Objects.hash(x, y);
		Point point = new Point(x, y);
		assertEquals(hashCode, point.hashCode());
	}

	@Test
	void testPoint() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		int x = 5;
		int y = 10;
		Point point = new Point(x, y);
		Field fieldX = point.getClass().getDeclaredField("x");
		Field fieldY = point.getClass().getDeclaredField("y");
		fieldX.setAccessible(true);
		fieldY.setAccessible(true);
		assertEquals(x, fieldX.get(point));
		assertEquals(y, fieldY.get(point));
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
	void testEqualsObjectTrueTheSameClass() {
		int xOne = 1, yOne = 4;
		int xTwo = 2, yTwo = 5;
		int y = 4;
		Point pointOne = new Point(xOne, yOne);
		Point pointTwo = new Point(xTwo, yTwo);
		assertTrue(pointOne.equals(pointTwo));
	}

	@Test
	void testGetShip()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		int x = 2;
		int y = 8;
		int deckSize = 2;
		Point point = new Point(x, y);
		Field fieldShip = point.getClass().getDeclaredField("ship");
		fieldShip.setAccessible(true);
		Ship ship = new Ship(deckSize);
		fieldShip.set(point, ship);
		assertEquals(ship, point.getShip().get());
	}

	@Test
	void testSetShip()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		int x = 2;
		int y = 8;
		int deckSize = 2;
		Point point = new Point(x, y);
		Field fieldShip = point.getClass().getDeclaredField("ship");
		fieldShip.setAccessible(true);
		Ship ship = new Ship(deckSize);
		point.setShip(ship);
		assertEquals(ship, fieldShip.get(point));
	}

	@Test
	void testIsHit() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		int x = 2;
		int y = 8;
		Point point = new Point(x, y);
		Field fieldHit = point.getClass().getDeclaredField("hit");
		fieldHit.setAccessible(true);
		fieldHit.setBoolean(point, true);
		assertTrue(point.isHit());
	}

	@Test
	void testSetHit() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		int x = 2;
		int y = 8;
		Point point = new Point(x, y);
		Field fieldHit = point.getClass().getDeclaredField("hit");
		fieldHit.setAccessible(true);
		point.setHit();
		assertTrue(fieldHit.getBoolean(point));
	}

	@Test
	void testToString() {
		int x = 2;
		int y = 8;
		String expectedString = "Point [x=" + x + ", y=" + y + "]";
		Point point = new Point(x, y);
		assertEquals(expectedString, point.toString());
	}

	@Test
	void testClearShip()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		int x = 2;
		int y = 8;
		int deckSize = 2;
		Point point = new Point(x, y);
		Field fieldShip = point.getClass().getDeclaredField("ship");
		fieldShip.setAccessible(true);
		Ship ship = new Ship(deckSize);
		fieldShip.set(point, ship);
		assertEquals(ship, fieldShip.get(point));
		point.clearShip();
		assertEquals(null, fieldShip.get(point));
	}

}
