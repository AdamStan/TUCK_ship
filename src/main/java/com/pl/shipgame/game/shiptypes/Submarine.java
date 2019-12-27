package com.pl.shipgame.game.shiptypes;

public class Submarine extends Ship {
    private static final int MAX_DECK_SIZE = 3;

    Submarine() {   }

    @Override
    public int getMaximumSize() {
        return MAX_DECK_SIZE;
    }

}
