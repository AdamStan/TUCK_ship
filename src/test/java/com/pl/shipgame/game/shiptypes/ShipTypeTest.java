package com.pl.shipgame.game.shiptypes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShipTypeTest {

	@Test
	void testGetDeckSizeGhost() {
		int deckSize = 0;
		assertEquals(deckSize, ShipType.GHOST.getDeckSize());
	}
	
	@Test
	void testGetDeckSizeDestroyer() {
		int deckSize = 1;
		assertEquals(deckSize, ShipType.DESTROYER.getDeckSize());
	}

	@Test
	void testGetDeckSizeSubmarine() {
		int deckSize = 2;
		assertEquals(deckSize, ShipType.SUBMARINE.getDeckSize());
	}
	
	@Test
	void testGetDeckSizeCruiser() {
		int deckSize = 3;
		assertEquals(deckSize, ShipType.CRUISER.getDeckSize());
	}
	
	@Test
	void testGetDeckSizeBattleShip() {
		int deckSize = 4;
		assertEquals(deckSize, ShipType.BATTLESHIP.getDeckSize());
	}
	
	@Test
	void testGetDeckSizeCarrier() {
		int deckSize = 5;
		assertEquals(deckSize, ShipType.CARRIER.getDeckSize());
	}
}

