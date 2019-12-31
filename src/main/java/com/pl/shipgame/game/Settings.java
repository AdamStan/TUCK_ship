package com.pl.shipgame.game;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
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
    private static final File FILE = new File("settings.txt");
    private static final int boardHeightDefault = 10;
    private static final int boardWidthDefault = 12;
    private static final Integer amountOfDestroyersDefault = 5;
    private static final Integer amountOfSubmarinesDefault = 3;
    private static final Integer amountOfCruisersDefault = 3;
    private static final Integer amountOfBattleshipsDefault = 2;
    private static final Integer amountOfCarriersDefault = 1;

    private int boardHeight = 10;
    private int boardWidth = 12;
    private Integer amountOfDestroyers = 5;
    private Integer amountOfSubmarines = 3;
    private Integer amountOfCruisers = 3;
    private Integer amountOfBattleships = 2;
    private Integer amountOfCarriers = 1;

    private Map<ShipFactory.ShipType, Integer> shipsInSettings = new HashMap<>();

    private Settings() {
        readValuesFromFile();
        saveSettings();
    }

    private void readValuesFromFile() {
        if (FILE.exists()) {
            try {
                List<String> content = Files.readAllLines(FILE.toPath());
                
                for(String line : content) {
                    String[] nameAndValue = line.split(":");
                    try {
                        Field field = this.getClass().getDeclaredField(nameAndValue[0]);
                        field.setAccessible(true);
                        field.set(this, Integer.valueOf(nameAndValue[1]));
                    } catch (NoSuchFieldException | SecurityException e) {
                        //ignore
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                // on debug purpose
                e.printStackTrace();
            }
        }
    }

    public void saveSettings() {
        StringBuilder content = new StringBuilder();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field f : fields) {
            try {
                f.setAccessible(true);
                Object value = f.get(this);
                if (!(value instanceof Integer) || Modifier.isFinal(f.getModifiers())) {
                    continue;
                }
                content.append(f.getName());
                content.append(":");
                content.append(value);
                content.append(System.lineSeparator());
            } catch (Exception ex) {
                // ignore
            }
        }
        try {
            Files.write(FILE.toPath(), content.toString().getBytes());
        } catch (IOException e) {
            // on debug purpose
            e.printStackTrace();
        }
    }

    public static synchronized Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        instance.reloadSettings();
        return instance;
    }

    public void reloadSettings() {
        shipsInSettings.put(ShipFactory.ShipType.DESTROYER, amountOfDestroyers);
        shipsInSettings.put(ShipFactory.ShipType.SUBMARINE, amountOfSubmarines);
        shipsInSettings.put(ShipFactory.ShipType.CRUISER, amountOfCruisers);
        shipsInSettings.put(ShipFactory.ShipType.BATTLESHIP,
                amountOfBattleships);
        shipsInSettings.put(ShipFactory.ShipType.CARRIER, amountOfCarriers);
    }
    
    public void restoreToDefault() {
        boardHeight = boardHeightDefault;
        boardWidth = boardWidthDefault;
        amountOfDestroyers = amountOfDestroyersDefault;
        amountOfSubmarines = amountOfSubmarinesDefault;
        amountOfCruisers = amountOfCruisersDefault;
        amountOfBattleships = amountOfBattleshipsDefault;
        amountOfCarriers = amountOfCarriersDefault;
        saveSettings();
    }

    public List<Ship> createShips() {
        List<Ship> ships = new ArrayList<>();
        for (Entry<ShipType, Integer> shipInSettings : shipsInSettings
                .entrySet()) {
            for (int i = 0; i < shipInSettings.getValue(); i++) {
                ShipFactory.createShip(shipInSettings.getKey())
                        .ifPresent(ships::add);
            }
        }
        return ships;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public Integer getAmountOfDestroyers() {
        return amountOfDestroyers;
    }

    public Integer getAmountOfSubmarines() {
        return amountOfSubmarines;
    }

    public Integer getAmountOfCruisers() {
        return amountOfCruisers;
    }

    public Integer getAmountOfBattleships() {
        return amountOfBattleships;
    }

    public Integer getAmountOfCarriers() {
        return amountOfCarriers;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    public void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth;
    }

    public void setAmountOfDestroyers(Integer amountOfDestroyers) {
        this.amountOfDestroyers = amountOfDestroyers;
    }

    public void setAmountOfSubmarines(Integer amountOfSubmarines) {
        this.amountOfSubmarines = amountOfSubmarines;
    }

    public void setAmountOfCruisers(Integer amountOfCruisers) {
        this.amountOfCruisers = amountOfCruisers;
    }

    public void setAmountOfBattleships(Integer amountOfBattleships) {
        this.amountOfBattleships = amountOfBattleships;
    }

    public void setAmountOfCarriers(Integer amountOfCarriers) {
        this.amountOfCarriers = amountOfCarriers;
    }

}
