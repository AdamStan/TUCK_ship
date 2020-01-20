package com.pl.shipgame.game;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pl.shipgame.game.shiptypes.Ship;
import com.pl.shipgame.game.shiptypes.ShipType;

class SettingsTest {

    private String nameForSettingFile = "test.txt";

    private int modifiedHeight = 5;
    private int modifiedWidth = 5;
    private Integer modifiedAmountOfDestroyers = 6;
    private Integer modifiedAmountOfSubmarines = 7;
    private Integer modifiedAmountOfCruisers = 8;
    private Integer modifiedAmountOfBattleships = 3;
    private Integer modifiedAmountOfCarriers = 4;

    private String settingsContent = "boardHeight:5\r\n" + "boardWidth:5\r\n"
            + "amountOfDestroyers:6\r\n" + "amountOfSubmarines:7\r\n"
            + "amountOfCruisers:8\r\n" + "amountOfBattleships:3\r\n"
            + "amountOfCarriers:4\r\n";

    @BeforeEach
    void resetSingleton() {
        try {
            Field instance = Settings.class.getDeclaredField("instance");
            instance.setAccessible(true);
            instance.set(instance, null);
            Field filename = Settings.class.getDeclaredField("fileName");
            filename.setAccessible(true);
            filename.set(filename, nameForSettingFile);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @AfterEach
    void removeTestFile() {
        File file = new File(nameForSettingFile);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testGetInstance() {
        Settings ref1 = Settings.getInstance();
        Settings ref2 = Settings.getInstance();
        assertEquals(ref1, ref2);
    }

    @Test
    void testReadValuesFromFile() throws Exception {
        Settings set = Settings.getInstance();
        initializeFileWithTestSettings();
        Method readValuesFromFile = set.getClass()
                .getDeclaredMethod("readValuesFromFile");
        readValuesFromFile.setAccessible(true);
        readValuesFromFile.invoke(set);
        validateAllParameters(set);
    }

    @Test
    void testSaveSettings() throws Exception {
        Settings set = Settings.getInstance();
        setModifiedSettings(set);
        set.saveSettings();
        File testSettingFile = new File(nameForSettingFile);
        StringBuilder contentFile = new StringBuilder();
        Files.readAllLines(testSettingFile.toPath()).forEach(line -> {
            contentFile.append(line);
            contentFile.append("\r\n");
        });
        assertEquals(settingsContent, contentFile.toString());
    }

    @Test
    void testRestoreToDefault() {
        Settings setting = Settings.getInstance();
        setModifiedSettings(setting);
        validateAllParameters(setting);
        setting.restoreToDefault();
        assertEquals(Settings.BOARD_WIDTH_DEFAULT, setting.getBoardWidth());
        assertEquals(Settings.BOARD_HEIGHT_DEFAULT, setting.getBoardHeight());
        assertEquals(Settings.AMOUNT_OF_BATTLESHIPS_DEFAULT,
                setting.getAmountOfBattleships());
        assertEquals(Settings.AMOUNT_OF_CARRIERS_DEFAULT,
                setting.getAmountOfCarriers());
        assertEquals(Settings.AMOUNT_OF_CRUISERS_DEFAULT,
                setting.getAmountOfCruisers());
        assertEquals(Settings.AMOUNT_OF_SUBMARINES_DEFAULT,
                setting.getAmountOfSubmarines());
        assertEquals(Settings.AMOUNT_OF_DESTROYERS_DEFAULT,
                setting.getAmountOfDestroyers());
    }

    @Test
    void testCreateShips() {
        Settings settings = Settings.getInstance();
        List<Ship> ships = settings.createShips();
        long amountOfDestroyers = ships
                .stream().filter(ship -> ship
                        .getMaximumSize() == ShipType.DESTROYER.getDeckSize())
                .count();
        assertEquals(Settings.AMOUNT_OF_DESTROYERS_DEFAULT,
                (int) amountOfDestroyers);
        long amountOfSubmarines = ships
                .stream().filter(ship -> ship
                        .getMaximumSize() == ShipType.SUBMARINE.getDeckSize())
                .count();
        assertEquals(Settings.AMOUNT_OF_SUBMARINES_DEFAULT,
                (int) amountOfSubmarines);
    }

    private void validateAllParameters(Settings set) {
        assertEquals(this.modifiedWidth, set.getBoardWidth());
        assertEquals(this.modifiedHeight, set.getBoardHeight());
        assertEquals(this.modifiedAmountOfBattleships,
                set.getAmountOfBattleships());
        assertEquals(this.modifiedAmountOfCarriers, set.getAmountOfCarriers());
        assertEquals(this.modifiedAmountOfCruisers, set.getAmountOfCruisers());
        assertEquals(this.modifiedAmountOfSubmarines,
                set.getAmountOfSubmarines());
        assertEquals(this.modifiedAmountOfDestroyers,
                set.getAmountOfDestroyers());
    }

    private void setModifiedSettings(Settings settings) {
        settings.setBoardWidth(this.modifiedWidth);
        settings.setBoardHeight(this.modifiedHeight);
        settings.setAmountOfBattleships(this.modifiedAmountOfBattleships);
        settings.setAmountOfCarriers(this.modifiedAmountOfCarriers);
        settings.setAmountOfCruisers(this.modifiedAmountOfCruisers);
        settings.setAmountOfDestroyers(this.modifiedAmountOfDestroyers);
        settings.setAmountOfSubmarines(this.modifiedAmountOfSubmarines);
    }

    private void initializeFileWithTestSettings() throws IOException {
        File fileSetting = new File(nameForSettingFile);
        if (!fileSetting.exists()) {
            fileSetting.createNewFile();
        }
        Files.write(fileSetting.toPath(), settingsContent.getBytes());
    }
}
