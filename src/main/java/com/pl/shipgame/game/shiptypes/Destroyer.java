package com.pl.shipgame.game.shiptypes;

import java.util.List;

import com.pl.shipgame.utils.Point;

public class Destroyer extends ShipTemporary {

    private static final int MAX_DECK_SIZE = 2;
    
    Destroyer() {   }

    @Override
    protected boolean canPointBeAdded(Point point) {
        return MAX_DECK_SIZE > deckSize();
    }

    @Override
    public boolean isReady() {
        return deckSize() == MAX_DECK_SIZE;
    }

    @Override
    void setRestPoints(List<Point> potentialDeck) {
        // TODO Auto-generated method stub
        
    }

}
