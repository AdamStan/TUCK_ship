package com.pl.shipgame.game;

import com.pl.shipgame.console.ConsoleApi;
import com.pl.shipgame.utils.Shot;

public class Game {
    GameBoard board;
    Settings settings;
    
    private Game() {
        
    }

    public static Game initializeGame(Settings settings) {
        if(settings == null) {
            settings = Settings.getDefaultSettings();
        }
        
        Game game = new Game();
        
        game.board = new GameBoard(settings);
        game.settings = settings;
        
        return game;
        
    }
    
    public void startGame() {
        ConsoleApi console = new ConsoleApi();
        console.gameLoop(this);
    }
    
    public void drawBoard() {
        board.draw();
    }

    public void startGameWithConsoleApi() {
        
    }

    public void setShot(Shot readShot) {
        try {
            board.setShot(readShot);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
