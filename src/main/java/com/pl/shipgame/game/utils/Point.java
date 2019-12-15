package com.pl.shipgame.game.utils;

import java.util.Objects;

public class Point{
    private final int x;
    private final int y;
	private boolean hit;

    public Point(int x, int y) {
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
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        return x == other.x && y == other.y;
    }
    
    public boolean wasHit() {
    	return hit;
    }
    
    public void setHit() {
    	hit = true;
    }

    @Override
    public String toString() {
        return "Shot [x=" + x + ", y=" + y + "]";
    }
}
