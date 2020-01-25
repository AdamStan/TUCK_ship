package com.pl.shipgame.game.shiptypes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import com.pl.shipgame.game.Game;
import com.pl.shipgame.game.shiptypes.Ship;
import com.pl.shipgame.game.utils.Point;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Game.class)
class ShipTest {

	List<Point> deck;
	Ship ship;
	int deckSize;
	
	@Test
	void testShip() {
		final int deckSizeToTest = 10;
		ship = new Ship(deckSizeToTest);
		deck = Whitebox.getInternalState(ship, "deck");
		deckSize = Whitebox.getInternalState(ship, "deckSize");
		assertEquals(deckSize, deckSize);
		assertEquals(0, deck.size());
	}

	@Test
	void testIsReadyTrue() {
		final int  deckSizeToTest = 1;
		Ship ship = new Ship(deckSizeToTest);
		deck = mock(List.class);
		Whitebox.setInternalState(ship, List.class, deck);
		when(deck.size()).thenReturn(deckSizeToTest);
		assertEquals(true, ship.isReady());
	}

	@Test
	void testIsReadyFalse() {
		final int deckSizeToTest = 1;
		Ship ship = new Ship(deckSizeToTest);
		deck = mock(List.class);
		Whitebox.setInternalState(ship, List.class, deck);
		when(deck.size()).thenReturn(0);
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
		final int deckSizeToTest = 2;
		Ship ship = new Ship(deckSizeToTest);
		deck = Whitebox.getInternalState(ship, "deck");
		deck.add(new Point(5, 10));
		deck.add(new Point(15, 20));
		assertEquals(deckSizeToTest, deck.size());
		ship.clearDeck();
		assertEquals(0, deck.size());
	}

	@Test
	void testAddPointToDeck() {
		final int deckSizeToTest = 1;
		Ship ship = new Ship(deckSizeToTest);
		deck = Whitebox.getInternalState(ship, "deck");
		ship.addPointToDeck(new Point(5, 5));
		assertEquals(deckSizeToTest, deck.size());
	}

	@Test
	void testIsShipDestroyedTrue() {
		int deckSizeToTest = 1;
		Ship ship = new Ship(deckSizeToTest);
		Point point = mock(Point.class);
		deck = Whitebox.getInternalState(ship, "deck");
		deck.add(point);
		when(point.isHit()).thenReturn(true);
		assertEquals(true, ship.isShipDestroyed());
	}

	@Test
	void testIsShipDestroyedFalse() {
		int deckSizeToTest = 1;
		Ship ship = new Ship(deckSizeToTest);
		Point point = mock(Point.class);
		deck = Whitebox.getInternalState(ship, "deck");
		deck.add(point);
		when(point.isHit()).thenReturn(false);
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
