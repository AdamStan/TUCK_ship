package com.pl.shipgame.game.shiptypes;

import java.util.ArrayList;
import java.util.List;

import com.pl.shipgame.game.utils.Point;

public class Ship {
	private List<Point> deck;
	private int deckSize;

	public Ship(int deckSize) {
		deck = new ArrayList<>();
		this.deckSize = deckSize;
	}
	
	public boolean isReady() {
		return getMaximumSize() == getDeck().size();
	}

	public int getMaximumSize() {
		return deckSize;
	}

	public void clearDeck() {
		getDeck().forEach(Point::clearShip);
		getDeck().clear();
	}

	public void addPointToDeck(Point point) {
		getDeck().add(point);
	}

	public boolean isShipDestroyed() {
		int hits = 0;
		for (Point point : getDeck()) {
			if (point.isHit()) {
				hits++;
			}
		}
		return hits == getDeck().size();
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

	public List<Point> getDeck() {
		return deck;
	}
}
