package com.gdu.dhpm11.qllon.main;

import com.gdu.dhpm11.qllon.controller.QuanLyLonController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ManHinhMain extends Application {

    private double x = 0, y = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("../view/ManHinh_Main.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setTitle("Quản Lý Chăn Nuôi Lợn");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();

        root.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });

        root.setOnMouseDragged(mouseEvent -> {
            primaryStage.setX(mouseEvent.getScreenX() - x);
            primaryStage.setY(mouseEvent.getScreenY() - y);
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
