package com.pl.shipgame.window;

import java.util.HashMap;
import java.util.Map;

import com.pl.shipgame.game.Game;
import com.pl.shipgame.game.Settings;
import com.pl.shipgame.game.utils.Shot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainWindowController {

    private Game game;

    @FXML
    private MenuItem start;

    @FXML
    private MenuItem restoreToDefaults;

    @FXML
    private MenuItem moreSettings;

    @FXML
    private BorderPane root;

    private VBox battlefield;

    private Settings settings;

    private Map<Object, Shot> shots = new HashMap<>();

    @FXML
    public void startGame() {
        game = Game.initializeGame();
        battlefield = new VBox();
        settings = Settings.getInstance();
        battlefield.setPrefWidth(50);
        for (int i = 1; i < settings.getBoardSize() + 1; i++) {
            HBox row = new HBox();
            row.setPrefHeight(25);
            for (int j = 1; j < settings.getBoardSize() + 1; j++) {
                Button button = new Button(i + "?" + j);
                button.setOnAction(this::onShot);
                button.setMinWidth(battlefield.getPrefWidth());
                button.setMinHeight(row.getPrefHeight());
                row.getChildren().add(button);
                shots.put(button, new Shot(i, j));
            }
            battlefield.getChildren().add(row);
        }
        root.setCenter(battlefield);
        System.out.println("DUPA");
    }

    public void onShot(ActionEvent event) {
        System.out.println(event);
        System.out.println("DUPA");
        Button button = (Button) event.getSource();
        Shot readShot = shots.get(event.getSource());
        if (readShot != null) {
            Boolean shipWasHit = game.setShot(readShot);
            System.out.println("wow, dziala");

            if (shipWasHit) {
                button.setText("x");
            } else if (!shipWasHit) {
                button.setText("o");
            }

            button.setDisable(true);
        }

    }
}
