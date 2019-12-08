package com.pl.shipgame.game.shiptypes;

import java.util.HashMap;
import java.util.Map;

import com.pl.shipgame.utils.Point;
import com.pl.shipgame.utils.Status;

public abstract class ShipTemporary {
    private Map<Point, Status> deck = new HashMap<>();

    public void addPointWithItsStatus(Point point, Status status) {
        if (!status.hasShip()) {
            deck.put(point, status);
            status.setHasShip(true);
        } else {
            
        }
    }

    @Override
    public String toString() {
        return "Ship [deck=" + deck + "]";
    }

    public boolean isReady() {
        return getMaximumSize() == deck.size();
    }

    public abstract int getMaximumSize();

    public void clearDeck() {
        deck.clear();
    }

}
