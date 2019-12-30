package com.pl.shipgame.window;

import java.util.HashMap;
import java.util.Map;

import com.pl.shipgame.game.Game;
import com.pl.shipgame.game.Settings;
import com.pl.shipgame.game.utils.Point;

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

	private Map<Object, Point> shots = new HashMap<>();

	@FXML
	public void startGame() {
		game = Game.initializeGame();
		battlefield = new VBox();
		settings = Settings.getInstance();
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
			Boolean shipWasHit = game.setShot(readShot);
			if (shipWasHit) {
				button.setText("x");
				Boolean isShipDestroyed = game.checkIfShipIsDestroyed(readShot);
				if (isShipDestroyed) {
					System.out.println("Ship destroyed");
				}
			} else {
				button.setText("o");
			}
			button.setDisable(true);
		}

	}
}
