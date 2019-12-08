package com.pl.shipgame.game.shiptypes;

public class Carrier extends ShipTemporary {
    private static final int MAX_DECK_SIZE = 5;

    @Override
    public int getMaximumSize() {
        return MAX_DECK_SIZE;
    }

}
