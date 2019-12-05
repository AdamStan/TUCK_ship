package com.pl.shipgame;

import com.pl.shipgame.game.Game;
import com.pl.shipgame.game.Settings;

public class Application {
    public static void main(String[] args) {
        Settings settings = Settings.getDefaultSettings();
        Game game =  Game.initializeGame(settings);       
        game.startGame();
    }
}
