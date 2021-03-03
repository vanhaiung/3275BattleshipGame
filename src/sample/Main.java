package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        primaryStage.setTitle("Battleship Game");
        primaryStage.setScene(new Scene(root, 1025, 865));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

//        BattleshipFunction game = new BattleshipFunction();
//        Scanner input = new Scanner(System.in);
//        int index = input.nextInt();
//        game.generateShip(index);
    }
}
