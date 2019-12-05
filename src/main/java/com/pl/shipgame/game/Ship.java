package com.pl.shipgame.game;

import java.util.ArrayList;
import java.util.List;

import com.pl.shipgame.utils.Point;

public abstract class Ship {
    private List<Point> deck = new ArrayList<>();

    public void addPoint(Point point) {
        if (canPointBeAdded(point)) {
            deck.add(point);
        }
    }

    @Override
    public String toString() {
        return "Ship [deck=" + deck + "]";
    }

    public void addStartingPoint(Point startingPoint) {
        deck.add(startingPoint);
        startingPoint.setShipSet(true);
    }

    protected int deckSize() {
        return deck.size();
    }

    protected abstract boolean isReady();

    protected abstract boolean canPointBeAdded(Point point);
}
