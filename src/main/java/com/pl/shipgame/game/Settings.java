package com.pl.shipgame.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Settings {
	
    private static final Random rand = new Random();
	private int size = 3;
	private int amountOfShips = 3;
	
	private List<Ship> ships = new ArrayList<>();

	public static Settings getDefaultSettings() {
		Settings settings = new Settings();
		for(int i = 0; i < 5; i++) {
		    settings.addShips();
		}
		return settings;
	}

	private void addShips() {
		if(rand.nextBoolean() ) {
			ships.add(new SingleMastedShip());
		} else {
			ships.add(new TwoMastedShip());
		}
	}

    public int getMaxSize() {
        return size;
    }

    public int getAmountOfShips() {
        return amountOfShips;
    }

    public List<Ship> getShips() {
        return ships;
    }

}
