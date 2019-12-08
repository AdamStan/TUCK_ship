package com.pl.shipgame.game.model;

import java.util.List;

import com.pl.shipgame.utils.Point;

public class Carrier extends Ship {
    private static final int MAX_DECK_SIZE = 5;

    @Override
    public boolean isReady() {
        return deckSize() < MAX_DECK_SIZE;
    }

    @Override
    protected boolean canPointBeAdded(Point point) {
        return false;
    }

    @Override
    void setRestPoints(List<Point> potentialDeck) {
        // TODO Auto-generated method stub
        
    }

}
