package com.pl.shipgame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.pl.shipgame.game.shiptypes.Ship;
import com.pl.shipgame.game.utils.Point;

import junit.framework.Assert;

class ShipTest {

	@Test
	void testShip() {
		int deckSize = 10;
		Ship ship = new Ship(deckSize);
		assertEquals(deckSize, ship.getMaximumSize());
	}

	@Test
	void testIsReady() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMaximumSize() {
		fail("Not yet implemented");
	}

	@Test
	void testClearDeck() {
		fail("Not yet implemented");
	}

	@Test
	void testAddPointToDeck() {
		fail("Not yet implemented");
	}

	@Test
	void testIsShipDestroyed() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
