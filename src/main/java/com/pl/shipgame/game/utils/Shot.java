package com.pl.shipgame.game.utils;

public class Shot extends Coordinates {

    public Shot(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "Shot [X=" + getX() + ", Y=" + getY() + "]";
    }

}
