package com.gdu.dhpm11.qllon.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.gdu.dhpm11.qllon.dao.DBConnect;
import com.gdu.dhpm11.qllon.model.ChiTietLonNai;
import com.gdu.dhpm11.qllon.model.ChiTietLonNai_KiemTraChuKyMangThai;
import com.gdu.dhpm11.qllon.service.ChiTietLonNai_KiemTraChuKyMangThai_Service;
import com.gdu.dhpm11.qllon.service.ChiTietLonNai_KiemTraChuKyMangThai_ServiceImpl;
import com.gdu.dhpm11.qllon.utility.ClassTableModel;
import com.gdu.dhpm11.qllon.utility.Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai;
import com.gdu.dhpm11.qllon.utility.Class_TableView_ChiTietLonNai_VacXin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class QuanLyLonController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtMaTaiLon_QuanLyLonNai;

    @FXML
    private DatePicker datePickerNgayNhap;

    @FXML
    private DatePicker datePickerNgayPhoi;

    @FXML
    private TableView<Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai> tableViewKiemTraChuKyMangThai;

    @FXML
    private TableColumn<Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai, Integer> tblC_MaTai_ChuKyMangThai;

    @FXML
    private TableColumn<Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai, Date> tblC_ChuKy_21Ngay;

    @FXML
    private TableColumn<Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai, Date> tblC_ChuKy_42Ngay;

    @FXML
    private TableColumn<Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai, Date> tblC_ChuKy_84Ngay;

    @FXML
    private TableColumn<Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai, Date> tblC_DeDuKien;

    @FXML
    private TextField txtTimKiem;

    @FXML
    private Button btnThem;

    @FXML
    private Button btnSua;

    @FXML
    private Button btnTaoMoi;

    @FXML
    private Button btnXoa;

    @FXML
    private TableView<?> tableViewVacXin;

    @FXML
    private TableColumn<?, ?> tblC_MaTai_VacXin;

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

    private ObservableList<Class_TableView_ChiTietLonNai_VacXin> dataTableModelChiTietLonNai = FXCollections.observableArrayList();

    private static final String DATE_PATTERN = "dd/MM/yyyy";

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(DATE_PATTERN);

    private ChiTietLonNai_KiemTraChuKyMangThai_Service chiTietLonNai_kiemTraChuKyMangThai_service = null;
    ObservableList<Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai> dataTableView_KiemTrachukymangThai = FXCollections.observableArrayList();

    public void HienThiTableViewKiemTraChuKyMangThai() {
        ObservableList<Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai> dataTableView_KiemTrachukymangThai = FXCollections.observableArrayList();

        List<ChiTietLonNai_KiemTraChuKyMangThai> danhSach_ChiTietLonNai_KiemTraChuKyMangThai = chiTietLonNai_kiemTraChuKyMangThai_service.LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblC_MaTai_ChuKyMangThai.setCellValueFactory(new PropertyValueFactory<>("MS_Tai_Lon"));
        tblC_ChuKy_21Ngay.setCellValueFactory(new PropertyValueFactory<>("Chu_Ky_21_Ngay"));
        tblC_ChuKy_42Ngay.setCellValueFactory(new PropertyValueFactory<>("Chu_Ky_42_Ngay"));
        tblC_ChuKy_84Ngay.setCellValueFactory(new PropertyValueFactory<>("Chu_Ky_84_Ngay"));
        tblC_DeDuKien.setCellValueFactory(new PropertyValueFactory<>("Ngay_De_Du_Kien"));
        ChiTietLonNai_KiemTraChuKyMangThai_Service chiTietLonNai_kiemTraChuKyMangThai_service = new ChiTietLonNai_KiemTraChuKyMangThai_ServiceImpl();
        List<ChiTietLonNai_KiemTraChuKyMangThai> list = chiTietLonNai_kiemTraChuKyMangThai_service.LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai();
        tableViewKiemTraChuKyMangThai.setItems(ClassTableModel.setTable_ChiTietLonNai_KiemTraChuKyMangThai(list));
    }
}
