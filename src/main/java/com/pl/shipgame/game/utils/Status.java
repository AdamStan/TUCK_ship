package com.pl.shipgame.game.utils;

public class Status {
    private boolean isHit;
    private boolean hasShip;

    public boolean isHit() {
        return isHit;
    }
    public void setHit(boolean isHit) {
        this.isHit = isHit;
    }
    public boolean hasShip() {
        return hasShip;
    }
    public void setHasShip(boolean hasShip) {
        this.hasShip = hasShip;
    }

    @Override
    public String toString() {
        return "Status [isHit=" + isHit + ", hasShip=" + hasShip + "]";
    }
}
