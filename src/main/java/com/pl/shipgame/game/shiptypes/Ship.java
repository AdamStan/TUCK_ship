package com.pl.shipgame.game.shiptypes;

import java.util.HashMap;
import java.util.Map;

import com.pl.shipgame.game.utils.Point;
import com.pl.shipgame.game.utils.Status;

public abstract class Ship {
    private Map<Point, Status> deck = new HashMap<>();

    public void addPointWithItsStatus(Point point, Status status) {
        if (!status.hasShip()) {
            deck.put(point, status);
            status.setHasShip(true);
        }
    }

    public boolean isReady() {
        return getMaximumSize() == deck.size();
    }

    public abstract int getMaximumSize();

    public void clearDeck() {
        deck.clear();
    }

}
