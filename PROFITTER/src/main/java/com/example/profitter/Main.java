package com.example.profitter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("Clothing Shop Management");
        primaryStage.setScene(new Scene(root, 299.0, 265.0));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    public static boolean isAdminLoggedIn = false;
}