package com.pl.shipgame.game.utils;

import com.pl.shipgame.game.shiptypes.Ship;

public class PointWithShip extends Point {

	private Ship ship;
	private boolean isHit;

	public PointWithShip(int x, int y, Ship shipWithThisPoint) {
		super(x, y);
		ship = shipWithThisPoint;
		ship.addPointToDeck(this);
	}

	@Override
	public boolean wasHit() {
		return isHit;
	}
}
