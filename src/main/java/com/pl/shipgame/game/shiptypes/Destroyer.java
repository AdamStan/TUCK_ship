package com.pl.shipgame.game.shiptypes;

public class Destroyer extends Ship {

    private static final int MAX_DECK_SIZE = 2;
    
    Destroyer() {   }

    @Override
    public int getMaximumSize() {
        return MAX_DECK_SIZE;
    }

}
