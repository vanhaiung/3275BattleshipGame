package sample;

import java.util.ArrayList;

public class ShipModel {
    private int boardSize;
    private int numShips;
    private int shipLength;
    private int shipsSunk;

    private ArrayList<Ship> ships;

    public ShipModel(int boardSize, int numShips, int shipLength, int shipsSunk) {
        this.boardSize = boardSize;
        this.numShips = numShips;
        this.shipLength = shipLength;
        this.shipsSunk = shipsSunk;
        for(int i = 0; i < numShips; i++){
            if (ships != null) {
                ships.add(new Ship());
            }
        }
    }


    public ArrayList<Ship> getShips() {
        return ships;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getNumShips() {
        return numShips;
    }

    public void setNumShips(int numShips) {
        this.numShips = numShips;
    }

    public int getShipLength() {
        return shipLength;
    }

    public void setShipLength(int shipLength) {
        this.shipLength = shipLength;
    }

    public int getShipsSunk() {
        return shipsSunk;
    }

    public void setShipsSunk(int shipsSunk) {
        this.shipsSunk = shipsSunk;
    }
}

