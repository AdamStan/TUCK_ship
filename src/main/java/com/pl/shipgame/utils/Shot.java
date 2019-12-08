package com.pl.shipgame.utils;

public class Shot {
    private final int x;
    private final int y;

    public Shot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Shot [x=" + x + ", y=" + y + "]";
    }

}
