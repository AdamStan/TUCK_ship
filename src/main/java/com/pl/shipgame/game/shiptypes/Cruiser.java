package com.pl.shipgame.game.shiptypes;

public class Cruiser extends ShipTemporary {

    private static final int MAX_DECK_SIZE = 3;

    @Override
    public int getMaximumSize() {
        return MAX_DECK_SIZE;
    }

}
