package com.pl.shipgame.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.pl.shipgame.console.Drawable;
import com.pl.shipgame.game.shiptypes.Ship;
import com.pl.shipgame.game.utils.Point;
import com.pl.shipgame.game.utils.Shot;
import com.pl.shipgame.game.utils.Status;

public class GameBoard implements Drawable{
    /*
     * o - missed hit
     * * - normal field
     * x - hit
     */
    static class PointOnBoard implements Drawable{
        private static String HIDDEN = "?";
        private static String SHIP_HIT = "x";
        private static String MISS = "o";

        Point point;
        Status status;

        PointOnBoard(Point point, Status status) {
            this.point = point;
            this.status = status;
        }

        @Override
        public void draw() {
            if (!status.isHit()) {
                System.out.print(HIDDEN);
            } else if (status.hasShip()) {
                System.out.print(SHIP_HIT);
            } else {
                System.out.print(MISS);
            }
            System.out.print(" ");
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
                points.get(i)
                        .add(new PointOnBoard(new Point(i, j), new Status()));
            }
        }
    }

    private void shipsOnBoard() {
        ships = settings.createShips();
        for (Ship ship : ships) {
            createShipsDecks(ship);
        }
    }

    private void createShipsDecks(Ship ship) {
        int maxValue = settings.getBoardSize();
        while (!ship.isReady()) {
            ship.clearDeck();
            int xCoordinate = rand.nextInt(maxValue - ship.getMaximumSize());
            int yCoordinate = rand.nextInt(maxValue);
            for (int i = 0; i < ship.getMaximumSize(); i++) {
                addPointToShip(ship,
                        points.get(xCoordinate + i).get(yCoordinate));
            }
        }
    }

    private void addPointToShip(Ship ship, PointOnBoard point) {
        if (!point.status.hasShip()) {
            ship.addPointWithItsStatus(point.point, point.status);
        }
    }

    @Override
    public void draw() {
        for (List<PointOnBoard> row : points) {
            for (PointOnBoard point : row) {
                point.draw();
            }
            System.out.println();
        }
    }

    public boolean setShot(Shot shot) {
        PointOnBoard point = points.get(shot.getX() - 1).get(shot.getY() - 1);
        point.status.setHit(true);
        return point.status.hasShip();
    }

    public List<List<Status>> getStatuses() {
        List<List<Status>> statuses = new ArrayList<>();
        for(List<PointOnBoard> listOfPositions : points) {
            statuses.add(new ArrayList<>());
            for(PointOnBoard position : listOfPositions) {
                statuses.get(statuses.size() - 1).add(position.status);
            }
        }
        return statuses;
    }
}
