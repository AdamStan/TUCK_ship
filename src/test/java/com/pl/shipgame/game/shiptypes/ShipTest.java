package com.pl.shipgame.game.shiptypes;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.pl.shipgame.game.shiptypes.Ship;
import com.pl.shipgame.game.utils.Point;

class ShipTest {

	@SuppressWarnings("unchecked")
	@Test
	void testShip() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		int deckSize = 10;
		Ship ship = new Ship(deckSize);
		Field fieldDeck = ship.getClass().getDeclaredField("deck");
		Field fieldDeckSize = ship.getClass().getDeclaredField("deckSize");
		fieldDeck.setAccessible(true);
		fieldDeckSize.setAccessible(true);
		assertEquals(deckSize, fieldDeckSize.getInt(ship));
		List<Point> deck = (List<Point>) fieldDeck.get(ship);
		assertEquals(0, deck.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testIsReadyTrue() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		int deckSize = 1;
		Ship ship = new Ship(deckSize);
		Field fieldDeck = ship.getClass().getDeclaredField("deck");
		fieldDeck.setAccessible(true);
		List<Point> deck = (List<Point>) fieldDeck.get(ship);
		deck.add(new Point(5, 5));
		assertEquals(true, ship.isReady());
	}

	@Test
	void testIsReadyFalse() {
		int deckSize = 1;
		Ship ship = new Ship(deckSize);
		assertEquals(false, ship.isReady());
	}

	@Test
	void testGetMaximumSize() {
		int deckSize = 10;
		Ship ship = new Ship(deckSize);
		assertEquals(deckSize, ship.getMaximumSize());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testClearDeck() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		int deckSize = 2;
		Ship ship = new Ship(deckSize);
		Field fieldDeck = ship.getClass().getDeclaredField("deck");
		fieldDeck.setAccessible(true);
		List<Point> deck = (List<Point>) fieldDeck.get(ship);
		deck.add(new Point(5, 10));
		deck.add(new Point(15, 20));
		assertEquals(deckSize, deck.size());
		ship.clearDeck();
		assertEquals(0, deck.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testAddPointToDeck() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		int deckSize = 1;
		Ship ship = new Ship(deckSize);
		Field fieldDeck = ship.getClass().getDeclaredField("deck");
		fieldDeck.setAccessible(true);
		List<Point> deck = (List<Point>) fieldDeck.get(ship);
		ship.addPointToDeck(new Point(5, 5));
		assertEquals(deckSize, deck.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testIsShipDestroyedTrue() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		int deckSize = 1;
		Point point = new Point(5, 5);
		Ship ship = new Ship(deckSize);
		Field fieldDeck = ship.getClass().getDeclaredField("deck");
		Field fieldHit = point.getClass().getDeclaredField("hit");
		fieldDeck.setAccessible(true);
		fieldHit.setAccessible(true);
		List<Point> deck = (List<Point>) fieldDeck.get(ship);
		deck.add(point);
		fieldHit.setBoolean(point, true);
		assertEquals(true, ship.isShipDestroyed());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testIsShipDestroyedFalse() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		int deckSize = 1;
		Point point = new Point(5, 5);
		Ship ship = new Ship(deckSize);
		Field fieldDeck = ship.getClass().getDeclaredField("deck");
		Field fieldHit = point.getClass().getDeclaredField("hit");
		fieldDeck.setAccessible(true);
		fieldHit.setAccessible(true);
		List<Point> deck = (List<Point>) fieldDeck.get(ship);
		deck.add(point);
		fieldHit.setBoolean(point, false);
		assertEquals(false, ship.isShipDestroyed());
	}

	@Test
	void testToString() {
		int deckSize = 1;
		String expectedString = "Ship";
		Ship ship = new Ship(deckSize);
		assertEquals(expectedString, ship.toString());
	}

}
