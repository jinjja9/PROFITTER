package com.example.profitter;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button regisButton;

    @FXML
    void logIn() {
        System.out.println("1");
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (username.equals("admin") && password.equals("admin")) {
            Main.isAdminLoggedIn = true;   //??????
            try {
                Stage stage = new Stage();
                stage.setTitle("PROFITTER");
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MainView.fxml"))));
                stage.show();

                Stage loginStage = (Stage) loginButton.getScene().getWindow();
                loginStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showAlert("Tài khoản hoặc Mật khẩu chưa đúng");
        }
    }

    @FXML
    private ImageView imageView; // ImageView để hiển thị ảnh
    @FXML   // Dang SAI:((
    public void addShirtAction(ActionEvent actionEvent) {
        System.out.println("2");
        if (Main.isAdminLoggedIn) {        //?????
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Chọn ảnh áo");
            System.out.println("Đã check");
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                Image image = new Image(file.toURI().toString());
                imageView.getImage(); // Thiết lập hình ảnh cho ImageView
            }
        } else {
            showAlert("Bạn cần đăng nhập bằng tài khoản admin để thực hiện thao tác này.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void openRegisterView() {
        try {
            Stage stage = new Stage();
            stage.setTitle("Register New Account");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Register.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
        // Tat các giao diện trước đi
    void Registration() {
        try {
            Stage mainStage = new Stage();
            mainStage.setTitle("PROFTTER");
            mainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MainView.fxml"))));
            mainStage.show();

            Stage registerStage = (Stage) regisButton.getScene().getWindow();
            registerStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void exit() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML   // quay tro lại giao dien đang nhap
    public void closeMainView(javafx.event.ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }
}