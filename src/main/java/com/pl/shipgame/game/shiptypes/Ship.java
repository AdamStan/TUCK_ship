package com.pl.shipgame.game.shiptypes;

import java.util.ArrayList;
import java.util.List;

import com.pl.shipgame.game.utils.Point;
import com.pl.shipgame.game.utils.PointWithShip;

public abstract class Ship {
    private List<Point> deck = new ArrayList<>();

    public boolean isReady() {
        return getMaximumSize() == deck.size();
    }

    public abstract int getMaximumSize();

    public void clearDeck() {
        deck.clear();
    }

	public void addPointToDeck(PointWithShip pointWithShip) {
		deck.add(pointWithShip);
	}
	
	public boolean isShipDestroyed() {
		return deck.stream().allMatch(point -> point.wasHit());
	}

}
