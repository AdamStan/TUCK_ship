package com.pl.shipgame.window;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.pl.shipgame.game.Game;
import com.pl.shipgame.game.Settings;
import com.pl.shipgame.game.utils.Point;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

	private Settings settings;

	private Map<Object, Point> shots = new HashMap<>();
	
	public MainWindowController() {
	    settings = Settings.getInstance();
    }

	@FXML
	public void startGame() {
		game = Game.initializeGame();
		VBox battlefield = new VBox();
		battlefield.setPrefWidth(50);
		for (int i = 1; i < settings.getBoardHeight() + 1; i++) {
			HBox row = new HBox();
			row.setPrefHeight(25);
			for (int j = 1; j < settings.getBoardWidth() + 1; j++) {
				Button button = new Button(i + "?" + j);
				button.setOnAction(this::onShot);
				button.setMinWidth(battlefield.getPrefWidth());
				button.setMinHeight(row.getPrefHeight());
				row.getChildren().add(button);
				shots.put(button, new Point(i, j));
			}
			battlefield.getChildren().add(row);
		}
		root.setCenter(battlefield);
	}

	public void onShot(ActionEvent event) {
		Button button = (Button) event.getSource();
		Point readShot = shots.get(event.getSource());
		if (readShot != null) {
			boolean shipWasHit = game.setShot(readShot);
			if (shipWasHit) {
				button.setText("x");
				game.checkIfShipIsDestroyed(readShot);
			} else {
				button.setText("o");
			}
			button.setDisable(true);
			boolean allShipsDestroyed = game.checkIfAllShipsDestroyed();
			if (allShipsDestroyed)
			{
				startGame();
			}
		}
    }

    @FXML
    public void restoreToDefault() {
        settings.restoreToDefault();
    }
    
    @FXML
    public void showSettings() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("SettingsWindow.fxml"));
        GridPane window = fxmlLoader.load();
        Stage settingsStage = new Stage();
        settingsStage.setScene(new Scene(window));
        settingsStage.setTitle("Settings");
        SettingsController controller = fxmlLoader.getController();
        controller.initializeSliders();
        settingsStage.show();
    }

}
