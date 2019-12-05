package com.pl.shipgame.console;

import java.util.Scanner;

import com.pl.shipgame.game.Game;
import com.pl.shipgame.utils.Shot;

public class ConsoleApi {
    private static final Scanner SCAN = new Scanner(System.in);
    private Shot shot = null;

    public void gameLoop(Game game) {
        for(;;) {
            readFromConsole();
            try {
                game.setShot(getReadShot());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(getReadShot());
            game.drawBoard();
        }
    }

    private void readFromConsole() {
        String answer = SCAN.nextLine();
        if(answer.equalsIgnoreCase("e")) {
            System.exit(0);
        }
        readShot(answer);
    }
    
    private void readShot(String answer) {
        String[] answers = answer.split(" ");
        try {
            int x = Integer.parseInt(answers[0]);
            int y = Integer.parseInt(answers[1]);
            shot = new Shot(x, y);
        } catch(Exception e) {
            shot = null;
            System.out.println(e.getClass() + " " + e.getMessage());
            System.out.println("Wrong answer: " + answer);
        }
    }
    
    public Shot getReadShot() {
        return shot;
    }
}
