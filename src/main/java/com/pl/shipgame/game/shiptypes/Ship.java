package com.pl.shipgame.game.shiptypes;

import java.util.ArrayList;
import java.util.List;

import com.pl.shipgame.game.utils.Point;

public abstract class Ship {
	private List<Point> deck = new ArrayList<>();

	public boolean isReady() {
		return getMaximumSize() == deck.size();
	}

	public abstract int getMaximumSize();

	public void clearDeck() {
		deck.forEach(point -> point.clearShip());
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
		if (hits == deck.size()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[deck=" + deck + "]";
	}
}
