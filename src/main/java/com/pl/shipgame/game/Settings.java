package com.pl.shipgame.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Settings {
	
	private int width = 10;
	private int height = 10;
	private int amountOfShips = 5;
	
	List<Ship> ships = new ArrayList<>();

	public static Settings getDefaultSettings() {
		Settings settings = new Settings();
		settings.addShips();
		return settings;
	}

	private void addShips() {
		Random rand = new Random();
		if(rand.nextBoolean() ) {
			ships.add(new SingleMastedShip());
		} else {
			ships.add(new TwoMastedShip());
		}
	}

}
