package com.pl.shipgame.game.shiptypes;

public class Battleship extends ShipTemporary {
    private static final int MAX_DECK_SIZE = 4;

    Battleship() {   }

    @Override
    public int getMaximumSize() {
        return MAX_DECK_SIZE;
    }

}
