package com.pl.shipgame.game;

import com.pl.shipgame.utils.Point;

public class TwoMastedShip extends Ship {

    private static final int MAX_DECK_SIZE = 2;

    @Override
    protected boolean canPointBeAdded(Point point) {
        return MAX_DECK_SIZE > deckSize();
    }

    @Override
    protected boolean isReady() {
        return deckSize() == MAX_DECK_SIZE;
    }

}
