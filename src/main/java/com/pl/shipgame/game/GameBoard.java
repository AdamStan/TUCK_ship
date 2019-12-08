package com.pl.shipgame.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.pl.shipgame.game.shiptypes.Ship;
import com.pl.shipgame.utils.Point;
import com.pl.shipgame.utils.Shot;
import com.pl.shipgame.utils.Status;

/*
 * o - missed hit
 * * - normal field
 * x - hit
 */
public class GameBoard {

    static class PointOnBoard {
        private static String HIDDEN = "?";
        private static String SHIP_HIT = "x";
        private static String MISS = "o";

        Point point;
        Status status;

        PointOnBoard(Point point, Status status) {
            this.point = point;
            this.status = status;
        }

        public String draw() {
            if(!status.isHit()) {
                return HIDDEN;
            } else if (status.hasShip()) {
                return SHIP_HIT;
            }
            return MISS;
        }

    }

    private final Random rand;
    private final List<List<PointOnBoard>> points = new ArrayList<>();
    private Settings settings;
    private List<Ship> ships;

    GameBoard() {
        this.settings = Settings.getInstance();
        rand = new Random(settings.getBoardSize());
        createPoints();
        shipsOnBoard();
    }

    private void createPoints() {
        for (int i = 0; i < settings.getBoardSize(); i++) {
            points.add(new ArrayList<>());
            for (int j = 0; j < settings.getBoardSize(); j++) {
                points.get(i).add(new PointOnBoard(new Point(i, j), new Status()));
            }
        }
    }

    private void shipsOnBoard() {
        ships = settings.createShips();
        int maxValue = settings.getBoardSize();
        for(Ship ship : ships) {
            while(!ship.isReady()) {
                ship.clearDeck();
                int xCoordinate = rand.nextInt(maxValue - ship.getMaximumSize());
                int yCoordinate = rand.nextInt(maxValue);
                for (int i = 0; i < ship.getMaximumSize(); i++) {
                    PointOnBoard nextPoint = points.get(xCoordinate+i).get(yCoordinate);
                    if(!nextPoint.status.hasShip()) {
                        ship.addPointWithItsStatus(nextPoint.point, nextPoint.status);
                    }
                }
            }
        }
    }

    void draw() {
        StringBuilder builder = new StringBuilder();
        for (List<PointOnBoard> row : points) {
            for (PointOnBoard point : row) {
                builder.append(point.draw() + " ");
            }
            builder.append("\n");
        }
        System.out.print(builder.toString());
    }

    public void setShot(Shot shot) {
        points.get(shot.getX() - 1).get(shot.getY() - 1).status.setHit(true);
    }
}
