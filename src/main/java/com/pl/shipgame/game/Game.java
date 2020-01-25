package com.pl.shipgame.game;

import com.pl.shipgame.game.utils.Point;

public class Game {
	private GameBoard board = null;

	private Game() {

	}

	public static Game initializeGame() {
		Game game = new Game();
		game.board = new GameBoard();
		return game;
	}

	public boolean setShot(Point shot) {
		boolean wasShipHit = false;
		wasShipHit = board.setShot(shot);
		return wasShipHit;
	}

	public boolean checkIfShipIsDestroyed(Point shot) {
		boolean isShipDestroyed = false;
		isShipDestroyed = board.checkIfShipIsDestroyed(shot);
		return isShipDestroyed;

	}

	public boolean checkIfAllShipsDestroyed() {
		boolean isShipDestroyed = false;
		isShipDestroyed = board.allShipsDestroyed();
		return isShipDestroyed;
	}
}
