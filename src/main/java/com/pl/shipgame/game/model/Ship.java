package com.pl.shipgame.game.model;

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
    
    abstract void setRestPoints(List<Point> potentialDeck);
    
    public boolean checkPotentialDeck(List<Point> potentialDeck) {
        return false;
        
    }
    protected int deckSize() {
        return deck.size();
    }

    public abstract boolean isReady();

    protected abstract boolean canPointBeAdded(Point point);
}
