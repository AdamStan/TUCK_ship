package com.pl.shipgame.game.shiptypes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.pl.shipgame.game.shiptypes.Ship;
import com.pl.shipgame.game.utils.Point;

class ShipTest {

	@Test
	void testShip() {
		int deckSize = 10;
		Ship ship = new Ship(deckSize);
		assertEquals(deckSize, ship.getMaximumSize());
		assertEquals(0, ship.getDeck().size());
	}

	@Test
	void testIsReadyTrue() {
		int deckSize = 1;
		Ship ship = new Ship(deckSize);
		ship.addPointToDeck(new Point(5, 5));
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

	@Test
	void testClearDeck() {
		int deckSize = 2;
		Ship ship = new Ship(deckSize);
		ship.addPointToDeck(new Point(5, 10));
		ship.addPointToDeck(new Point(15, 20));
		assertEquals(deckSize, ship.getDeck().size());
		ship.clearDeck();
		assertEquals(0, ship.getDeck().size());
	}

	@Test
	void testAddPointToDeck() {
		int deckSize = 1;
		Ship ship = new Ship(deckSize);
		ship.addPointToDeck(new Point(5, 5));
		assertEquals(true, ship.isReady());
	}

	@Test
	void testIsShipDestroyedTrue() {
		int deckSize = 1;
		Point point = new Point(5, 5);
		Ship ship = new Ship(deckSize);
		ship.addPointToDeck(point);
		point.setHit();
		assertEquals(true, ship.isShipDestroyed());
	}

	@Test
	void testIsShipDestroyedFalse() {
		int deckSize = 1;
		Point point = new Point(5, 5);
		Ship ship = new Ship(deckSize);
		ship.addPointToDeck(point);
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
