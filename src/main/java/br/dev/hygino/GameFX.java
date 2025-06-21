package br.dev.hygino;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameFX extends Application{

    public static void main(String[] args) {
       launch(args);
    }

   /* @Override
    public void start(Stage primaryStage) throws Exception {
     primaryStage.setTitle("App JavaFX");
        primaryStage.setScene(new Scene(new Label("Olá JavaFX"), 300, 200));
        primaryStage.show();
    }*/

    @Override
    public void start(Stage stage) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/ConsoleForm.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
