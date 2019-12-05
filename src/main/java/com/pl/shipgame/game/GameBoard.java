package com.pl.shipgame.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.pl.shipgame.utils.Point;
import com.pl.shipgame.utils.Shot;

/*
 * o - missed hit
 * * - normal field
 * x - hit
 */
public class GameBoard {
    private final Random rand;
    private final List<List<Point>> points = new ArrayList<>();
    private List<Ship> ships;
    private Settings settings;

    GameBoard(Settings settings) {
        this.settings = settings;
        rand = new Random(settings.getMaxSize());
        createPoints();
        setShipsOnBoard();
    }

    private void createPoints() {
        for (int i = 0; i < settings.getMaxSize(); i++) {
            points.add(new ArrayList<>());
            for (int j = 0; j < settings.getMaxSize(); j++) {
                points.get(i).add(new Point(i, j));
            }
        }
    }

    private void setShipsOnBoard() {
        ships = settings.getShips();
        int maxValue = settings.getMaxSize();
        for(Ship ship : ships) {
            while(!ship.isReady()) {
                Point startingPoint = points.get(rand.nextInt(maxValue)).get(rand.nextInt(maxValue));
                ship.addStartingPoint(startingPoint);
            }
        }
    }

    void draw() {
        StringBuilder builder = new StringBuilder();
        for (List<Point> row : points) {
            for (Point point : row) {
                builder.append(point.draw() + " ");
            }
            builder.append("\n");
        }
        System.out.print(builder.toString());
    }

    public void setShot(Shot shot) {
        points.get(shot.getX() - 1).get(shot.getY() - 1).setHit(true);
    }
}
