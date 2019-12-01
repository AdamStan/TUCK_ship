package com.pl.shipgame.utils;

import java.util.Objects;

public class Point {
	private int x;
	private int y;
	private boolean isHit;
	private boolean isShipSet;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}

	public boolean isShipSet() {
		return isShipSet;
	}

	public void setShipSet(boolean isShipSet) {
		this.isShipSet = isShipSet;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", isHit=" + isHit + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(isHit, x, y);
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
		return isHit == other.isHit && x == other.x && y == other.y;
	}
	
}
