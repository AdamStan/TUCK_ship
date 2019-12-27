package com.pl.shipgame.game.shiptypes;

import java.util.Optional;

public class ShipFactory {

    public enum ShipType {
        DESTROYER,
        SUBMARINE,
        CRUISER,
        BATTLESHIP,
        CARRIER
    }
    
    private ShipFactory() {
        
    }
    
    public static Optional<Ship> createShip(ShipType type) {
        Ship ship = null;
        switch (type) {
        case DESTROYER:
            ship = new Destroyer();
            break;
        case SUBMARINE:
            ship = new Submarine();
            break;
        case CRUISER:
            ship = new Cruiser();
            break;
        case BATTLESHIP:
            ship = new Battleship();
            break;
        case CARRIER:
            ship = new Carrier();
            break;
        default:
            break;
        }
        return Optional.ofNullable(ship);
    }
}
