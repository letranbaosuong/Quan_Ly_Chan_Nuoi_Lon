package com.gdu.dhpm11.qllon.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class QuanLyLonController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> tblC_MaTai;

    @FXML
    private TableColumn<?, ?> tblC_ChuKy_21Ngay;

    @FXML
    private TableColumn<?, ?> tblC_ChuKy_42Ngay;

    @FXML
    private TableColumn<?, ?> tblC_ChuKy_84Ngay;

    @FXML
    private TableColumn<?, ?> tblC_DeDuKien;

    @FXML
    private DatePicker datePickerNgayNhap;

    @FXML
    private DatePicker datePickerNgayPhoi;

    @FXML
    private TextField txtMaTaiLon;

    @FXML
    private TableColumn<?, ?> tblC_Ta;

    @FXML
    private TableColumn<?, ?> tblC_ECOLI;

    @FXML
    private TableColumn<?, ?> tblC_TayGiun;

    @FXML
    private TableColumn<?, ?> tblC_PARVO;

    @FXML
    private TableColumn<?, ?> tblC_FE_COC;

    @FXML
    private TableColumn<?, ?> tblC_Suyen;

    @FXML
    private TableColumn<?, ?> tblC_PRRS;

    @FXML
    void initialize() {
        assert tblC_MaTai != null : "fx:id=\"tblC_MaTai\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_ChuKy_21Ngay != null : "fx:id=\"tblC_ChuKy_21Ngay\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_ChuKy_42Ngay != null : "fx:id=\"tblC_ChuKy_42Ngay\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_ChuKy_84Ngay != null : "fx:id=\"tblC_ChuKy_84Ngay\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_DeDuKien != null : "fx:id=\"tblC_DeDuKien\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert datePickerNgayNhap != null : "fx:id=\"datePickerNgayNhap\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert datePickerNgayPhoi != null : "fx:id=\"datePickerNgayPhoi\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert txtMaTaiLon != null : "fx:id=\"txtMaTaiLon\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_Ta != null : "fx:id=\"tblC_Ta\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_ECOLI != null : "fx:id=\"tblC_ECOLI\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_TayGiun != null : "fx:id=\"tblC_TayGiun\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_PARVO != null : "fx:id=\"tblC_PARVO\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_FE_COC != null : "fx:id=\"tblC_FE_COC\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_Suyen != null : "fx:id=\"tblC_Suyen\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_PRRS != null : "fx:id=\"tblC_PRRS\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
