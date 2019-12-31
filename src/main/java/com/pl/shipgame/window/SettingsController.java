package com.pl.shipgame.window;

import com.pl.shipgame.game.Settings;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class SettingsController {
    private Settings settings;

    @FXML
    private Slider boardHeight;
    @FXML
    private Slider boardWidth;
    @FXML
    private Slider amountOfDestroyers;
    @FXML
    private Slider amountOfSubmarines;
    @FXML
    private Slider amountOfCruisers;
    @FXML
    private Slider amountOfBattleships;
    @FXML
    private Slider amountOfCarriers;

    @FXML
    private Button apply;
    @FXML
    private Button cancel;

    @FXML
    private Label error;

    public SettingsController() {
        settings = Settings.getInstance();
    }

    public void initializeSliders() {
        boardHeight.setValue(settings.getBoardHeight());
        boardHeight.valueProperty()
                .addListener((obs, oldval, newVal) -> boardHeight
                        .setValue(Math.round(newVal.doubleValue())));

        boardWidth.setValue(settings.getBoardWidth());
        boardWidth.valueProperty()
                .addListener((obs, oldval, newVal) -> boardWidth
                        .setValue(Math.round(newVal.doubleValue())));

        amountOfDestroyers.setValue(settings.getAmountOfDestroyers());
        amountOfDestroyers.valueProperty()
                .addListener((obs, oldval, newVal) -> amountOfDestroyers
                        .setValue(Math.round(newVal.doubleValue())));

        amountOfSubmarines.setValue(settings.getAmountOfSubmarines());
        amountOfSubmarines.valueProperty()
                .addListener((obs, oldval, newVal) -> amountOfSubmarines
                        .setValue(Math.round(newVal.doubleValue())));

        amountOfCruisers.setValue(settings.getAmountOfCruisers());
        amountOfCruisers.valueProperty()
                .addListener((obs, oldval, newVal) -> amountOfCruisers
                        .setValue(Math.round(newVal.doubleValue())));

        amountOfBattleships.setValue(settings.getAmountOfBattleships());
        amountOfBattleships.valueProperty()
                .addListener((obs, oldval, newVal) -> amountOfBattleships
                        .setValue(Math.round(newVal.doubleValue())));

        amountOfCarriers.setValue(settings.getAmountOfCarriers());
        amountOfCarriers.valueProperty()
                .addListener((obs, oldval, newVal) -> amountOfCarriers
                        .setValue(Math.round(newVal.doubleValue())));

    }

    @FXML
    public void apply() {
        try {
            settings.setBoardHeight((int) boardHeight.getValue());
            settings.setBoardWidth((int) boardWidth.getValue());
            settings.setAmountOfDestroyers((int) amountOfDestroyers.getValue());
            settings.setAmountOfSubmarines((int) amountOfSubmarines.getValue());
            settings.setAmountOfCruisers((int) amountOfCruisers.getValue());
            settings.setAmountOfBattleships((int) amountOfBattleships.getValue());
            settings.setAmountOfCarriers((int) amountOfCarriers.getValue());
            settings.saveSettings();
            this.closeWindow();
        } catch (Exception ex) {
            error.setText(ex.getMessage());
        }
    }

    @FXML
    public void cancel() {
        this.closeWindow();
    }
    
    private void closeWindow() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
}
