package com.pl.shipgame.window;

import com.pl.shipgame.game.Settings;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SettingsController {
    private Settings settings;

    @FXML
    private TextField boardHeight;
    @FXML
    private TextField boardWidth;
    @FXML
    private TextField amountOfDestroyers;
    @FXML
    private TextField amountOfSubmarines;
    @FXML
    private TextField amountOfCruisers;
    @FXML
    private TextField amountOfBattleships;
    @FXML
    private TextField amountOfCarriers;
    
    @FXML
    private Button apply;
    @FXML
    private Button cancel;
    
}
