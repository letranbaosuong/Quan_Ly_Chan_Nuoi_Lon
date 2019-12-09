package com.gdu.dhpm11.qllon.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.gdu.dhpm11.qllon.model.ChiTietLonNai;
import com.gdu.dhpm11.qllon.service.*;
import com.gdu.dhpm11.qllon.utility.ClassTableModel;
import com.gdu.dhpm11.qllon.utility.Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai;
import com.gdu.dhpm11.qllon.utility.Class_TableView_ChiTietLonNai_VacXin;
import com.gdu.dhpm11.qllon.utility.Ham;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
    private TableView<Class_TableView_ChiTietLonNai_VacXin> tableViewVacXin;

    @FXML
    private TableColumn<Class_TableView_ChiTietLonNai_VacXin, Integer> tblC_MaTai_VacXin;

    @FXML
    private TableColumn<Class_TableView_ChiTietLonNai_VacXin, Date> tblC_Ta;

    @FXML
    private TableColumn<Class_TableView_ChiTietLonNai_VacXin, Date> tblC_ECOLI;

    @FXML
    private TableColumn<Class_TableView_ChiTietLonNai_VacXin, Date> tblC_TayGiun;

    @FXML
    private TableColumn<Class_TableView_ChiTietLonNai_VacXin, Date> tblC_PARVO;

    @FXML
    private TableColumn<Class_TableView_ChiTietLonNai_VacXin, Date> tblC_FE_COC;

    @FXML
    private TableColumn<Class_TableView_ChiTietLonNai_VacXin, Date> tblC_Suyen;

    @FXML
    private TableColumn<Class_TableView_ChiTietLonNai_VacXin, Date> tblC_PRRS;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HienThiTableView_KiemTraChuKyMangThai();
        HienThiTableView_VacXin();
        HienThiNgayNhap_NgayPhoi_Theo_MS_Tai_Lon_TableView_KiemTraChuKyMangThai();
        HienThiNgayNhap_NgayPhoi_Theo_MS_Tai_Lon_TableView_VacXin();
    }

    private void HienThiNgayNhap_NgayPhoi_Theo_MS_Tai_Lon_TableView_VacXin() {
        tableViewVacXin.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ChiTietLonNai_Service chiTietLonNai_caThe_service = new ChiTietLonNai_ServiceImpl();
                List<ChiTietLonNai> list = chiTietLonNai_caThe_service.LayChiTietLonNai_CaThe(tableViewVacXin.getSelectionModel().getSelectedItem().getMS_Tai_Lon());
                for (int i = 0; i < list.size(); i++) {
                    ChiTietLonNai chiTietLonNai_caThe = list.get(i);
                    int MS_Tai_Lon = chiTietLonNai_caThe.getMS_Tai_Lon();
                    Date Ngay_Nhap_Lon_Nai = chiTietLonNai_caThe.getNgay_Nhap_Lon_Nai();
                    Date Ngay_Phoi = chiTietLonNai_caThe.getNgay_Phoi();

                    Ham ham = new Ham();
                    txtMaTaiLon_QuanLyLonNai.setText(Integer.toString(MS_Tai_Lon));
                    datePickerNgayNhap.setValue(ham.convertToLocalDateViaSqlDate(Ngay_Nhap_Lon_Nai));
                    datePickerNgayPhoi.setValue(ham.convertToLocalDateViaSqlDate(Ngay_Phoi));
                }
            }
        });
    }

    private void HienThiNgayNhap_NgayPhoi_Theo_MS_Tai_Lon_TableView_KiemTraChuKyMangThai() {
        tableViewKiemTraChuKyMangThai.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ChiTietLonNai_Service chiTietLonNai_caThe_service = new ChiTietLonNai_ServiceImpl();
                List<ChiTietLonNai> list = chiTietLonNai_caThe_service.LayChiTietLonNai_CaThe(tableViewKiemTraChuKyMangThai.getSelectionModel().getSelectedItem().getMS_Tai_Lon());
                for (int i = 0; i < list.size(); i++) {
                    ChiTietLonNai chiTietLonNai_caThe = list.get(i);
                    int MS_Tai_Lon = chiTietLonNai_caThe.getMS_Tai_Lon();
                    Date Ngay_Nhap_Lon_Nai = chiTietLonNai_caThe.getNgay_Nhap_Lon_Nai();
                    Date Ngay_Phoi = chiTietLonNai_caThe.getNgay_Phoi();

                    Ham ham = new Ham();
                    txtMaTaiLon_QuanLyLonNai.setText(Integer.toString(MS_Tai_Lon));
                    datePickerNgayNhap.setValue(ham.convertToLocalDateViaSqlDate(Ngay_Nhap_Lon_Nai));
                    datePickerNgayPhoi.setValue(ham.convertToLocalDateViaSqlDate(Ngay_Phoi));
                }
            }
        });
    }

    public void HienThiTableView_KiemTraChuKyMangThai() {
        tblC_MaTai_ChuKyMangThai.setCellValueFactory(new PropertyValueFactory<>("MS_Tai_Lon"));
        tblC_ChuKy_21Ngay.setCellValueFactory(new PropertyValueFactory<>("Chu_Ky_21_Ngay"));
        tblC_ChuKy_42Ngay.setCellValueFactory(new PropertyValueFactory<>("Chu_Ky_42_Ngay"));
        tblC_ChuKy_84Ngay.setCellValueFactory(new PropertyValueFactory<>("Chu_Ky_84_Ngay"));
        tblC_DeDuKien.setCellValueFactory(new PropertyValueFactory<>("Ngay_De_Du_Kien"));
        ChiTietLonNai_Service chiTietLonNai_kiemTraChuKyMangThai_service = new ChiTietLonNai_ServiceImpl();
        List<ChiTietLonNai> list = chiTietLonNai_kiemTraChuKyMangThai_service.LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai();
        tableViewKiemTraChuKyMangThai.setItems(ClassTableModel.setTable_ChiTietLonNai_KiemTraChuKyMangThai(list));
    }

    private void HienThiTableView_VacXin() {
        tblC_MaTai_VacXin.setCellValueFactory(new PropertyValueFactory<>("MS_Tai_Lon"));
        tblC_Ta.setCellValueFactory(new PropertyValueFactory<>("Ta"));
        tblC_ECOLI.setCellValueFactory(new PropertyValueFactory<>("ECOLI"));
        tblC_TayGiun.setCellValueFactory(new PropertyValueFactory<>("Tay_Giun"));
        tblC_PARVO.setCellValueFactory(new PropertyValueFactory<>("PARVO"));
        tblC_FE_COC.setCellValueFactory(new PropertyValueFactory<>("FE_COC_3_Ngay"));
        tblC_Suyen.setCellValueFactory(new PropertyValueFactory<>("Suyen_14_Ngay"));
        tblC_PRRS.setCellValueFactory(new PropertyValueFactory<>("PRRS_21_Ngay"));
        ChiTietLonNai_Service chiTietLonNai_vacXin_service = new ChiTietLonNai_ServiceImpl();
        List<ChiTietLonNai> list = chiTietLonNai_vacXin_service.LayDanhSach_ChiTietLonNai_VacXin();
        tableViewVacXin.setItems(ClassTableModel.setTable_ChiTietLonNai_VacXin(list));
    }
}
