package com.pl.shipgame.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.pl.shipgame.game.shiptypes.Ship;
import com.pl.shipgame.game.shiptypes.ShipFactory;
import com.pl.shipgame.game.shiptypes.ShipFactory.ShipType;

public class Settings {

    private static Settings instance;
    private int boardSize = 10;

    private Integer amountOfDestriyers = 5;
    private Integer amountOfSubmarines = 3;
    private Integer amountOfCruisers = 3;
    private Integer amountOfBattleships = 2;
    private Integer amountOfCarriers = 1;

    private Map<ShipFactory.ShipType, Integer> shipsInSettings = new HashMap<>();

    private Settings() {
        shipsInSettings.put(ShipFactory.ShipType.DESTROYER, amountOfDestriyers);
        shipsInSettings.put(ShipFactory.ShipType.SUBMARINE, amountOfSubmarines);
        shipsInSettings.put(ShipFactory.ShipType.CRUISER, amountOfCruisers);
        shipsInSettings.put(ShipFactory.ShipType.BATTLESHIP, amountOfBattleships);
        shipsInSettings.put(ShipFactory.ShipType.CARRIER, amountOfCarriers);
    }
    
    public static synchronized Settings getInstance() {
        if(instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    public List<Ship> createShips() {
        List<Ship> ships = new ArrayList<>();
        for(Entry<ShipType, Integer> shipInSettings : shipsInSettings.entrySet()) {
            for(int i = 0; i < shipInSettings.getValue(); i++) {
                ShipFactory.createShip(shipInSettings.getKey()).ifPresent(ships::add);
            }
        }
        return ships;
    }

    public int getBoardSize() {
        return boardSize;
    }

}
