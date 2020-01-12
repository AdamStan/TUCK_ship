package com.pl.shipgame.game.shiptypes;

import java.util.ArrayList;
import java.util.List;

import com.pl.shipgame.game.utils.Point;

public class Ship {
	private List<Point> deck;
	private int deckSize;

	public Ship(int deckSize) {
		deck = new ArrayList<>(deckSize);
		this.deckSize = deckSize;
	}
	
	public boolean isReady() {
		return getMaximumSize() == deck.size();
	}

	public int getMaximumSize() {
		return deckSize;
	}

	public void clearDeck() {
		deck.forEach(Point::clearShip);
		deck.clear();
	}

	public void addPointToDeck(Point point) {
		deck.add(point);
	}

	public boolean isShipDestroyed() {
		int hits = 0;
		for (Point point : deck) {
			if (point.isHit()) {
				hits++;
			}
		}
		return hits == deck.size();
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
