package com.pl.shipgame;

import com.pl.shipgame.game.Game;

public class Application {
    public static void main(String[] args) {
        Game game =  Game.initializeGame();
        game.startGame();
    }
}
