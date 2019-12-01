package com.pl.shipgame.game;

import java.util.ArrayList;
import java.util.List;

import com.pl.shipgame.utils.Point;

/*
 * o - missed hit
 * * - normal field
 * x - hit
 */
public class GameBoard {
	List<Point> points = new ArrayList<>();
	List<Ship> ships = new ArrayList<>();
	Settings settings = Settings.getDefaultSettings();
	
	public GameBoard(int width, int height) {
		// 5 x 5
		for(int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {				
				points.add(new Point(i, j));
			}
		}
	}
	
	void draw() {
		
	}
}
