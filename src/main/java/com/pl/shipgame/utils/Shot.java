package com.pl.shipgame.utils;

public class Shot extends Coordinates {

    public Shot(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "Shot [getX()=" + getX() + ", getY()=" + getY() + "]";
    }

}
