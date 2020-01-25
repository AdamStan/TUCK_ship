package com.pl.shipgame.game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import com.pl.shipgame.game.utils.Point;
import org.powermock.core.classloader.annotations.PrepareForTest;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Game.class)
class GameTest {

	private Game game;
	private GameBoard boardMock;

	@BeforeEach
	void init() throws Exception {
		boardMock = mock(GameBoard.class);
		game = Game.initializeGame();
		Whitebox.setInternalState(game, GameBoard.class, boardMock);
	}

	@Test
	void testCheckIfAllShipsDestroyedFalse() {
		when(boardMock.allShipsDestroyed()).thenReturn(false);
		assertFalse(game.checkIfAllShipsDestroyed());
	}

	@Test
	void testCheckIfAllShipsDestroyedTrue() {
		when(boardMock.allShipsDestroyed()).thenReturn(true);
		assertTrue(game.checkIfAllShipsDestroyed());
	}

	@Test
	void testSetShotTrue() {
		Point point = new Point(5, 5);
		when(boardMock.setShot(point)).thenReturn(true);
		assertTrue(game.setShot(point));
	}

	@Test
	void testSetShotFalse() {
		Point point = new Point(5, 5);
		when(boardMock.setShot(point)).thenReturn(false);
		assertFalse(game.setShot(point));
	}

	@Test
	void testCheckIfShipIsDestroyedTrue() {
		Point point = new Point(5, 5);
		when(boardMock.checkIfShipIsDestroyed(point)).thenReturn(true);
		assertTrue(game.checkIfShipIsDestroyed(point));
	}

	@Test
	void testCheckIfShipIsDestroyedFalse() {
		Point point = new Point(5, 5);
		when(boardMock.checkIfShipIsDestroyed(point)).thenReturn(false);
		assertFalse(game.checkIfShipIsDestroyed(point));
	}

}
