package com.pl.shipgame.game;

import com.pl.shipgame.console.ConsoleApi;
import com.pl.shipgame.utils.Shot;

public class Game {
    GameBoard board;
    
    private Game() {
        
    }

    public static Game initializeGame() {
        Game game = new Game();
        game.board = new GameBoard();
        
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
