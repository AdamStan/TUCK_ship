package com.pl.shipgame.game;

import java.util.ArrayList;
import java.util.List;

import com.pl.shipgame.utils.Point;

public abstract class Ship {
	private List<Point> board = new ArrayList<>();
	
	public void addPoint(Point point) {
		if(canPointBeAdded(point)) {
			board.add(point);
		}
	}
	
	protected abstract boolean canPointBeAdded(Point point);

	@Override
	public String toString() {
		return "Ship [board=" + board + "]";
	}
	
}
