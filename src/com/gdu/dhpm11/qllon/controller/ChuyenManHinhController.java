package com.gdu.dhpm11.qllon.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ChuyenManHinhController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane ManHinh_Main_BorderPane;

    @FXML
    private ImageView imgMinimize;

    @FXML
    private ImageView imgMaximize;

    @FXML
    void onMousePressed_UI_Quan_Ly_Lon(MouseEvent event) {
        loadUI("QuanLyLon_AnchorPane");
    }

    @FXML
    void onMousePressed_UI_Quan_Ly_Thuc_An(MouseEvent event) {
        loadUI("QuanLyThucAn_AnchorPane");
    }

    @FXML
    void onMousePressed_UI_Quan_Ly_Vac_Xin(MouseEvent event) {
        loadUI("QuanLyVacXin_AnchorPane");
    }

    @FXML
    void onMousePressed_UI_Thong_Ke_Bao_Cao(MouseEvent event) {
        loadUI("ThongKeBaoCao_AnchorPane");
    }

    @FXML
    void onMouseCliked_Close(MouseEvent event) {
        Stage stage = (Stage) ManHinh_Main_BorderPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onMouseCliked_Maximize(MouseEvent event) {
        Stage stage = (Stage) ManHinh_Main_BorderPane.getScene().getWindow();
        stage.setFullScreen(true);
    }

    @FXML
    void onMouseCliked_Minimize(MouseEvent event) {
        Stage stage = (Stage) ManHinh_Main_BorderPane.getScene().getWindow();
        stage.setIconified(true);
    }


    private void loadUI(String ui) {

        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("../view/" + ui + ".fxml"));
            ManHinh_Main_BorderPane.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Loi private void loadUI(String ui){} ChuyenManHinhController - " + e.toString());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadUI("QuanLyLon_AnchorPane");
    }

}
