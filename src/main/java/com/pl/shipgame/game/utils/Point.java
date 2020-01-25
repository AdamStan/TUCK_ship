package com.pl.shipgame.game.utils;

import java.util.Objects;
import java.util.Optional;

import com.pl.shipgame.game.shiptypes.Ship;

public class Point {
    private final int x;
    private final int y;
    private boolean hit;
    private Ship ship;

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
        return false;
    }

    public Optional<Ship> getShip() {
        return Optional.ofNullable(ship);
    }
    
    public void setShip(Ship shipInPoint) {
        ship = shipInPoint;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit() {
        hit = true;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

    public void clearShip() {
        ship = null;
    }
}
