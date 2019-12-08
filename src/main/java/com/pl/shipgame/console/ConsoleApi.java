package com.pl.shipgame.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pl.shipgame.game.Game;
import com.pl.shipgame.game.utils.Shot;

public class ConsoleApi {
    private static final Scanner SCAN = new Scanner(System.in);
    private Shot shot = null;
    private List<Shot> history = new ArrayList<>();

    public void gameLoop(Game game) {
        for(;;) {
            readFromConsole();
            try {
                game.setShot(getReadShot());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(getReadShot());
            System.out.println("This was your: " + history.size() + " shot.");
            game.draw();
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
            history.add(shot);
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
