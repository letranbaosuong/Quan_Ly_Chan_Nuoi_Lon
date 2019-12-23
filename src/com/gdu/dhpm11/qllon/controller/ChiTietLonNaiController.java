package com.gdu.dhpm11.qllon.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

import com.gdu.dhpm11.qllon.model.ChiTietLonNai;
import com.gdu.dhpm11.qllon.service.ChiTietLonNai_Service;
import com.gdu.dhpm11.qllon.service.ChiTietLonNai_ServiceImpl;
import com.gdu.dhpm11.qllon.utility.Ham;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;
import javafx.scene.Node;

public class ChiTietLonNaiController {

    private int msTaiLon = 0;
    private int chuKy = 0;

    private double x = 0, y = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtSoCon;

    @FXML
    private TextField txtSoConChet;

    @FXML
    private TextField txtTongSoLon;

    @FXML
    private DatePicker datePickerNgayNhap;

    @FXML
    private DatePicker datePickerNgayPhoi;

    @FXML
    private DatePicker datePickerNgayDe;

    @FXML
    private Button btnCapNhat;

    @FXML
    private Button btnThoat;

    @FXML
    private TextField txtMaTai;

    @FXML
    private TextField txtChuKyDe;

    @FXML
    void initialize() {

        txtSoCon.setOnKeyReleased(e -> Changed());

        txtSoConChet.setOnKeyReleased(e -> Changed());

        datePickerNgayNhap.setOnAction(e -> Changed());

        datePickerNgayPhoi.setOnAction(e -> Changed());

        datePickerNgayDe.setOnAction(e -> Changed());

        btnCapNhat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChiTietLonNai_Service service = new ChiTietLonNai_ServiceImpl();
                int MS_Tai_Lon = Integer.parseInt(txtMaTai.getText().trim());
                int Chu_Ky = Integer.parseInt(txtChuKyDe.getText().trim());
                int So_Con_Con = Integer.parseInt(txtSoCon.getText().trim());
                int So_Con_Chet = Integer.parseInt(txtSoConChet.getText().trim());
                Date Ngay_Nhap = Date.valueOf(datePickerNgayNhap.getValue());
                Date Ngay_Phoi = Date.valueOf(datePickerNgayPhoi.getValue());
                Date Ngay_De = Date.valueOf(datePickerNgayDe.getValue());

                int kqCapNhat = service.CapNhatChiTietLonNai(MS_Tai_Lon, Chu_Ky, So_Con_Con, So_Con_Chet, Ngay_Nhap, Ngay_Phoi, Ngay_De);
                if (kqCapNhat > 0) {
                    System.out.println("Cập nhật thành công");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Cập Nhật Thành Công");
                    alert.setHeaderText("Mã Số " + MS_Tai_Lon);
                    alert.showAndWait();

                } else {
                    System.out.println("Cập nhật ko thành công");
                }
            }
        });

        btnThoat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("../view/ManHinh_Main.fxml"));
                    Parent manHinh_Man = loader.load();
                    Scene scene = new Scene(manHinh_Man);
                    stage.setScene(scene);
                    stage.centerOnScreen();
                } catch (IOException e) {
                    System.out.println("Loi btnThoat.setOnAction(new EventHandler<ActionEvent>() {} trong package com.gdu.dhpm11.qllon.controller.ChiTietLonNaiController : " + e.getMessage());
                }

            }
        });

        txtMaTai.setDisable(true);
        txtChuKyDe.setDisable(true);
        txtTongSoLon.setDisable(true);
        datePickerNgayNhap.setEditable(false);
        datePickerNgayPhoi.setEditable(false);
        datePickerNgayDe.setEditable(false);
        btnCapNhat.setDisable(true);
    }

    public void setMSTai_ChuKyDe(int MS_Tai_Lon, int Chu_Ky) {
        Ham ham = new Ham();

        txtMaTai.setText(String.valueOf(MS_Tai_Lon));
        txtChuKyDe.setText(String.valueOf(Chu_Ky));

        ChiTietLonNai_Service service = new ChiTietLonNai_ServiceImpl();
        List<ChiTietLonNai> list = service.getListChiTietLonNai(MS_Tai_Lon, Chu_Ky);
        txtSoCon.setText(String.valueOf(list.get(0).getSo_Con_Con()));
        txtSoConChet.setText(String.valueOf(list.get(0).getSo_Con_Chet()));
        txtTongSoLon.setText(String.valueOf(Integer.parseInt(txtSoCon.getText().trim()) - Integer.parseInt(txtSoConChet.getText().trim())));
        datePickerNgayNhap.setValue(ham.convertToLocalDateViaSqlDate(list.get(0).getNgay_Nhap_Lon_Nai()));
        datePickerNgayPhoi.setValue(ham.convertToLocalDateViaSqlDate(list.get(0).getNgay_Phoi()));
        datePickerNgayDe.setValue(ham.convertToLocalDateViaSqlDate(list.get(0).getNgay_De()));

        btnCapNhat.setDisable(!(KiemTraTxt() && KiemTraDatePicker()));
    }

    public void TongSoHeoCon() {
        try {
            int soConCon = Integer.parseInt(txtSoCon.getText().trim());
            int soConChet = Integer.parseInt(txtSoConChet.getText().trim());
            int tongSocon = soConCon - soConChet;
            txtTongSoLon.setText(tongSocon + "");
        } catch (NumberFormatException e) {
            System.out.println("Loi : cho nay phai nhap so trong txtSoConChet.setOnKeyReleased(new EventHandler<KeyEvent>() {} trong package com.gdu.dhpm11.qllon.controller.ChiTietLonNaiController");
        }
    }

    public boolean KiemTraTxt() {
        int soCon = 0;
        int soConChet = 0;
        int tong = 0;
        boolean kq = false;
        try {
            soCon = Integer.parseInt(txtSoCon.getText().trim());
            soConChet = Integer.parseInt(txtSoConChet.getText().trim());
            tong = Integer.parseInt(txtTongSoLon.getText().trim());
        } catch (NumberFormatException e) {
            return false;
        }
        if (soCon > 0 && soConChet >= 0 && tong >= 0)
            kq = true;
        else
            kq = false;

        return kq;
    }

    public boolean KiemTraDatePicker() {
        if (datePickerNgayPhoi.getValue().compareTo(datePickerNgayNhap.getValue()) > 0
                && datePickerNgayDe.getValue().compareTo(datePickerNgayPhoi.getValue()) > 0) {
            return true;
        }
        return false;
    }

    public void Changed() {
        TongSoHeoCon();
        btnCapNhat.setDisable(!(KiemTraTxt() && KiemTraDatePicker()));
    }

}
