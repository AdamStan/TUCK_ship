package com.pl.shipgame.utils;

public class Point extends Coordinates {
    

    public Point(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "Point [x=" + getX() + ", y=" + getY() + "]";
    }

}
