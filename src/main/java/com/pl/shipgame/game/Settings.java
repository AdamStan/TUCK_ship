package com.pl.shipgame.game;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.pl.shipgame.game.shiptypes.Ship;
import com.pl.shipgame.game.shiptypes.ShipType;
/**
 * Replace modified values with java properties
 * 
 * @author Adam
 *
 */
public class Settings {
    private final File file;
    private static Settings instance;
    private static String fileName = "settings.txt";
    public static final int BOARD_HEIGHT_DEFAULT = 10;
    public static final int BOARD_WIDTH_DEFAULT = 12;
    public static final Integer AMOUNT_OF_DESTROYERS_DEFAULT = 5;
    public static final Integer AMOUNT_OF_SUBMARINES_DEFAULT = 3;
    public static final Integer AMOUNT_OF_CRUISERS_DEFAULT = 3;
    public static final Integer AMOUNT_OF_BATTLESHIPS_DEFAULT = 2;
    public static final Integer AMOUNT_OF_CARRIERS_DEFAULT = 1;

    private int boardHeight = BOARD_HEIGHT_DEFAULT;
    private int boardWidth = BOARD_WIDTH_DEFAULT;
    private Integer amountOfDestroyers = AMOUNT_OF_DESTROYERS_DEFAULT;
    private Integer amountOfSubmarines = AMOUNT_OF_SUBMARINES_DEFAULT;
    private Integer amountOfCruisers = AMOUNT_OF_CRUISERS_DEFAULT;
    private Integer amountOfBattleships = AMOUNT_OF_BATTLESHIPS_DEFAULT;
    private Integer amountOfCarriers = AMOUNT_OF_CARRIERS_DEFAULT;

    private Map<ShipType, Integer> shipsInSettings = new EnumMap<>(ShipType.class);

    private Settings() {
        file = new File(fileName);
        readValuesFromFile();
    }

    public static synchronized Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        instance.reloadShipSettings();
        return instance;
    }

    private void readValuesFromFile() {
        if (file.exists()) {
            try {
                List<String> content = Files.readAllLines(file.toPath());
                
                for(String line : content) {
                    String[] nameAndValue = line.split(":");
                    setFieldValue(nameAndValue[0], nameAndValue[1]);
                }
            } catch (IOException e) {
                // on debug purpose
                e.printStackTrace();
            }
        }
    }
    
    private void setFieldValue(String fieldName, String value) {
        try {
            Field field = this.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(this, Integer.valueOf(value));
        } catch (NoSuchFieldException | SecurityException e) {
            // ignore
        } catch (Exception e) {
            // ignore
        }
    }

    public void saveSettings() {
        StringBuilder content = prepareSettingsToSave();
        try {
            Files.write(file.toPath(), content.toString().getBytes());
        } catch (IOException e) {
            // on debug purpose
            e.printStackTrace();
        } finally {
            this.reloadShipSettings();
        }
    }
    
    private StringBuilder prepareSettingsToSave() {
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
        return content;
    }

    private void reloadShipSettings() {
        shipsInSettings.put(ShipType.DESTROYER, amountOfDestroyers);
        shipsInSettings.put(ShipType.SUBMARINE, amountOfSubmarines);
        shipsInSettings.put(ShipType.CRUISER, amountOfCruisers);
        shipsInSettings.put(ShipType.BATTLESHIP,
                amountOfBattleships);
        shipsInSettings.put(ShipType.CARRIER, amountOfCarriers);
    }
    
    public void restoreToDefault() {
        boardHeight = BOARD_HEIGHT_DEFAULT;
        boardWidth = BOARD_WIDTH_DEFAULT;
        amountOfDestroyers = AMOUNT_OF_DESTROYERS_DEFAULT;
        amountOfSubmarines = AMOUNT_OF_SUBMARINES_DEFAULT;
        amountOfCruisers = AMOUNT_OF_CRUISERS_DEFAULT;
        amountOfBattleships = AMOUNT_OF_BATTLESHIPS_DEFAULT;
        amountOfCarriers = AMOUNT_OF_CARRIERS_DEFAULT;
        saveSettings();
    }

    public List<Ship> createShips() {
        List<Ship> ships = new ArrayList<>();
        for (Entry<ShipType, Integer> shipInSettings : shipsInSettings
                .entrySet()) {
            for (int i = 0; i < shipInSettings.getValue(); i++) {
                ships.add(new Ship(shipInSettings.getKey().getDeckSize()));
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
