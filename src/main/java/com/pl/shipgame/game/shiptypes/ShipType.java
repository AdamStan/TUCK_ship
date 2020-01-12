package com.pl.shipgame.game.shiptypes;

public enum ShipType {
	GHOST(0), DESTROYER(2), SUBMARINE(3), CRUISER(3), BATTLESHIP(4), CARRIER(5);

	private int deckSize;

	private ShipType(int max) {
		deckSize = max;
	}

	public int getDeckSize() {
		return deckSize;
	}

}
