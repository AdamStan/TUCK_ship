package com.pl.shipgame.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.pl.shipgame.game.shiptypes.Ship;
import com.pl.shipgame.game.utils.Point;

public class GameBoard {
	private final Random rand;
	private final List<List<Point>> points = new ArrayList<>();
	private Settings settings;
	private List<Ship> ships;

	GameBoard() {
		this.settings = Settings.getInstance();
		rand = new Random();
		createPoints();
		shipsOnBoard();
	}

	private void createPoints() {
		for (int i = 0; i < settings.getBoardHeight(); i++) {
			points.add(new ArrayList<>());
			for (int j = 0; j < settings.getBoardWidth(); j++) {
				points.get(i).add(new Point(i, j));
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
		int maxValueHeight = settings.getBoardHeight();
		int maxValueWidth = settings.getBoardWidth();
		while (!ship.isReady()) {
			ship.clearDeck();
			int xCoordinate = rand.nextInt(maxValueHeight - ship.getMaximumSize());
			int yCoordinate = rand.nextInt(maxValueWidth);
			for (int i = 0; i < ship.getMaximumSize(); i++) {
				addPointToShip(ship, points.get(xCoordinate + i).get(yCoordinate));
			}
		}
	}

	private void addPointToShip(Ship ship, Point point) {
		if (!point.getShip().isPresent()) {
			ship.addPointToDeck(point);
			point.setShip(ship);
		}
	}

	public boolean setShot(Point shot) {
		Point hitPoint = points.get(shot.getX() - 1).get(shot.getY() - 1);
		hitPoint.setHit();
		return hitPoint.getShip().isPresent();
	}

	public boolean checkIfShipIsDestroyed(Point shot) {
		Boolean isShipDestroyed;
		Point hitPoint = points.get(shot.getX() - 1).get(shot.getY() - 1);
		Ship ship = hitPoint.getShip().get();
		isShipDestroyed = ship.isShipDestroyed();
		if (isShipDestroyed) {
			System.out.println("Ship " + ship + " destroyed!");
		}
		ships.remove(ship);
		return isShipDestroyed;
	}

	public boolean allShipsDestroyed() {
		if (ships.isEmpty()) {
			System.out.println("All ships Destroyed");
			return true;
		}
		return false;
	}
}
