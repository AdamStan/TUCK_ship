package com.pl.shipgame.game;

import com.pl.shipgame.game.utils.Point;

public class Game {
    private GameBoard board;
    
    private Game() {
        
    }

    public static Game initializeGame() {
        Game game = new Game();
        game.board = new GameBoard();
        
        return game;
        
    }

    public Boolean setShot(Point shot) {
        Boolean wasShipHit = null;
        try {
            wasShipHit = Boolean.valueOf(board.setShot(shot));
        } catch(Exception ex) {
        	// for debug purpose
            ex.printStackTrace();
        }
        return wasShipHit;
    }
}
