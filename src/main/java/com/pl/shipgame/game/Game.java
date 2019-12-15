package com.pl.shipgame.game;

import java.util.List;

import com.pl.shipgame.console.ConsoleApi;
import com.pl.shipgame.game.utils.Shot;
import com.pl.shipgame.game.utils.Status;

public class Game {
    private GameBoard board;
    private ConsoleApi console;
    
    private Game() {
        
    }

    public static Game initializeGame() {
        Game game = new Game();
        game.board = new GameBoard();
        
        return game;
        
    }
    
    public void startConsoleGame() {
        console = new ConsoleApi();
        console.gameLoop(this);
    }
    
    public void restartConsoleGame() {
        board = new GameBoard();
        console.clearHistory();
    }

    public Boolean setShot(Shot readShot) {
        Boolean wasShipHit = null;
        try {
            wasShipHit = Boolean.valueOf(board.setShot(readShot));
        } catch(Exception ex) {
        	// on debug purpose
            ex.printStackTrace();
        }
        return wasShipHit;
    }
    
    public List<List<Status>> getPointsStatus() {
        return board.getStatuses();
    }

    public void draw() {
        board.draw();
    }
}
