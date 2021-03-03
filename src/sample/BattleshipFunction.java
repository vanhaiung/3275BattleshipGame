package sample;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BattleshipFunction {

    public int boardSize = 7;
    public int numShips = 3;
    public int shipLength = 3;
    public int shipsSunk = 0;
    public int guesses = 0;

    ShipModel ShipModel = new ShipModel(boardSize, numShips, shipLength, shipsSunk);
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        BattleshipFunction game = new BattleshipFunction();
        Scanner input = new Scanner(System.in);
        System.out.print("Where would you like to fire? ");
        String location = input.nextLine();
        game.checkGuess(location);
        game.fire(location);

    }


    public BattleshipFunction(){
    }

    public boolean fire(String guess){
        for(int i = 0; i < ShipModel.getNumShips() ; i++){
            Ship ship = ShipModel.getShips().get(i);
            var index = ship.getLocation().indexOf(guess);

            if(ship.getHits().get(index) == "hit"){
                System.out.println("Oops, you already hit that location.");
                return true;
            }else if (index >= 0){
                ship.getHits().set(index, "hit");
                System.out.println("HIT!");

                if(this.isSunk(ship)){
                    JOptionPane.showMessageDialog(null, "You sank my battleship!");
                    this.shipsSunk++;
                }
                return true;
            }
        }
        System.out.println(guess);
        System.out.println("You missed.");
        return false;
    }

    public boolean isSunk(Ship ship){
        for(var i = 0; i < this.shipLength; i++){
            if(!ship.getHits().get(i).equals("hit")){
                return false;
            }
        }
        return true;
    }

    public void generateShipLocations(){
        int[] locations = new int[18];
        for(int i = 0; i < this.numShips; i++){
            do{
                generateShip(i);
            }while(collision(locations));
            ShipModel.getShips().get(i).getLocation().set(locations[i], locations[i]);
        }
        System.out.println("Ships array: ");
        System.out.println(this.numShips);
    }

    public void generateShip(int index){
        var direction = Math.floor(Math.random() * 2);
        int row = 0;
        int col = 0;
        if(direction == 1){
            row = (int)Math.floor(Math.random() * this.boardSize);
            col = (int)Math.floor(Math.random() * (this.boardSize - this.shipLength + 1));
        }else{
            col = (int)Math.floor(Math.random() * this.boardSize);
            row = (int)Math.floor(Math.random() * (this.boardSize - this.shipLength + 1));
        }

        for(int i = 0; i < this.shipLength; i++){
            if(direction == 1){
                ShipModel.getShips().get(index).getLocation().set(i, row * 10 + (col + i));
            }else{
                ShipModel.getShips().get(index).getLocation().set(i, (row + 1) + col * 10);
            }
        }
    }

    public boolean collision(int[] locations){
        for(int i = 0; i < numShips; i++){
            for(int j = 0; j < locations.length; j++){
                if(ShipModel.getShips().get(j).getLocation().indexOf(j) >= 0){
                    return true;
                }
            }
        }
        return false;
    }

    public void processGuess(String guess){
        String location = checkGuess(guess);
        for(int i = 0; i < ShipModel.getNumShips(); i++){
            this.guesses++;
            var hit = fire(location);
            if(hit && ShipModel.getShipsSunk() == ShipModel.getNumShips()){
                JOptionPane.showMessageDialog(null, "You sank all muy battleships! Only in " + this.guesses + " guesses!");
            }
        }
    }


    public String checkGuess(String guess){
        ArrayList<String> alphabet = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));

        if(guess == null || guess.length() != 2){
            JOptionPane.showMessageDialog(null, "Please enter a letter and a number on the board.");
        }else{
            char firstChar;
            char row = 0;
            char column = 0;
            for(int i = 0; i < alphabet.size(); i++){
                firstChar = guess.charAt(0);
                row = (char) alphabet.get(i).indexOf(firstChar);
                column = guess.charAt(1);
            }
            if((row == '\0') || (column == '\0')){
                JOptionPane.showMessageDialog(null, "That isn't on the board.");
            } else if(row < 0 || row >= ShipModel.getBoardSize() || column < 0 || column >= ShipModel.getBoardSize()){
                JOptionPane.showMessageDialog(null, "That isn't on the board.");
            } else{
            }
            guesses++;
        }
        return guess;
    }


    //event handlers
    public void handleFireButton(){

        //add button listener here
        String guessInput = input.next();
        String guess = guessInput.toUpperCase();
        processGuess(guess);

        guessInput = "";
    }

    public boolean handleKeyPress(KeyEvent e){

        //add button listener here
        String fireButton = input.next();

        if(e.getKeyCode() == KeyEvent.VK_ENTER){

            //button click
            return false;
        }
        return true;
    }



}

