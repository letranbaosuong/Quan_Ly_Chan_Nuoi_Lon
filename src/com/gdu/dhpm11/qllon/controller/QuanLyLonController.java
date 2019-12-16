package com.gdu.dhpm11.qllon.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.gdu.dhpm11.qllon.dao.DBConnect;
import com.gdu.dhpm11.qllon.model.ChiTietLonNai;
import com.gdu.dhpm11.qllon.service.*;
import com.gdu.dhpm11.qllon.utility.ClassTableModel;
import com.gdu.dhpm11.qllon.utility.Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai;
import com.gdu.dhpm11.qllon.utility.Class_TableView_ChiTietLonNai_VacXin;
import com.gdu.dhpm11.qllon.utility.Ham;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private TableColumn<Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai, Integer> tblC_ChuKyDe_ChuKyMangThai;

    @FXML
    private TableColumn<Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai, Date> tblC_ChuKy_21Ngay;

    @FXML
    private TableColumn<Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai, Date> tblC_ChuKy_42Ngay;

    @FXML
    private TableColumn<Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai, Date> tblC_ChuKy_84Ngay;

    @FXML
    private TableColumn<Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai, Date> tblC_DeDuKien;

    @FXML
    private TextField txtTimKiemSoMaTai;

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
    private TableColumn<Class_TableView_ChiTietLonNai_VacXin, Integer> tblC_ChuKyDe_VacXin;

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
//        setAnHien(false);
        HienThiTableView_KiemTraChuKyMangThai();
        HienThiTableView_VacXin();
        HienThiNgayNhap_NgayPhoi_Theo_MS_Tai_Lon_TableView_KiemTraChuKyMangThai();
        HienThiNgayNhap_NgayPhoi_Theo_MS_Tai_Lon_TableView_VacXin();

        btnThem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChiTietLonNai_Service service = new ChiTietLonNai_ServiceImpl();
                Ham ham = new Ham();
                int MS_Tai_Lon = Integer.parseInt(txtMaTaiLon_QuanLyLonNai.getText().trim());
                List<ChiTietLonNai> ktraTonTai = service.KiemTraMS_Tai_Lon(MS_Tai_Lon);
                int chuKy = ktraTonTai.size();

                if (chuKy > 0) {

                    java.sql.Date Ngay_Nhap_Lon_Nai = java.sql.Date.valueOf(datePickerNgayNhap.getValue());
                    java.sql.Date Ngay_Phoi = java.sql.Date.valueOf(datePickerNgayPhoi.getValue());
                    java.sql.Date Ngay_De = java.sql.Date.valueOf(String.valueOf(ham.CongNgay(Ngay_Phoi, 115)));

                    int kqThemChiTietLonNai = service.Them_ChiTietLonNai(MS_Tai_Lon, Ngay_Nhap_Lon_Nai, Ngay_Phoi, Ngay_De, chuKy + 1);
                    if (kqThemChiTietLonNai > 0) {
                        HienThiTableView_KiemTraChuKyMangThai();
                        HienThiTableView_VacXin();
                    } else {
                        System.out.println(kqThemChiTietLonNai);
                    }

                } else {
                    int kqThemLonNai = service.Them_LonNai(MS_Tai_Lon, ham.TuoiLon(datePickerNgayNhap.getValue().toString(), LocalDate.now().toString()) + " ngày");
                    if (kqThemLonNai > 0) {
                        System.out.println("them thanh cong vao bang lon");

                        java.sql.Date Ngay_Nhap_Lon_Nai = java.sql.Date.valueOf(datePickerNgayNhap.getValue());
                        java.sql.Date Ngay_Phoi = java.sql.Date.valueOf(datePickerNgayPhoi.getValue());
                        java.sql.Date Ngay_De = java.sql.Date.valueOf(String.valueOf(ham.CongNgay(Ngay_Phoi, 115)));

                        int kqThemChiTietLonNai = service.Them_ChiTietLonNai(MS_Tai_Lon, Ngay_Nhap_Lon_Nai, Ngay_Phoi, Ngay_De, chuKy + 1);
                        if (kqThemChiTietLonNai > 0) {
                            HienThiTableView_KiemTraChuKyMangThai();
                            HienThiTableView_VacXin();
                        } else {
                            System.out.println(kqThemChiTietLonNai);
                        }
                    } else {
                        System.out.println("ko them dc vao bang lon");
                    }
                }

            }
        });

        btnSua.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

        btnTaoMoi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                txtMaTaiLon_QuanLyLonNai.setEditable(true);
                datePickerNgayNhap.setDisable(false);
                datePickerNgayPhoi.setDisable(false);
                txtMaTaiLon_QuanLyLonNai.requestFocus();
                btnTaoMoi.setDisable(true);
                btnThem.setDisable(false);
//                txtMaTaiLon_QuanLyLonNai.setText(String.valueOf(Integer.parseInt(txtMaTaiLon_QuanLyLonNai.getText().trim()) + 1));
            }
        });

        btnXoa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChiTietLonNai_Service chiTietLonNai_service = new ChiTietLonNai_ServiceImpl();
                int MS_Tai_Lon = Integer.parseInt(txtMaTaiLon_QuanLyLonNai.getText().trim());
                List<ChiTietLonNai> list = chiTietLonNai_service.LayChiTietLonNai_CaThe(MS_Tai_Lon);
                int demSoCaTheTimDuoc = list.size();
                if (demSoCaTheTimDuoc > 0) {
                    Alert alertXacNhan = new Alert(Alert.AlertType.CONFIRMATION);
                    alertXacNhan.setTitle("Xác Nhận Xóa");
                    alertXacNhan.setHeaderText("Sẽ xóa thông tin của lợn nái mang Mã Số " + MS_Tai_Lon);
                    alertXacNhan.setContentText("Bạn có chắc chắn muốn xóa không?");

                    ButtonType buttonTypeYes = new ButtonType("Đồng ý");
                    ButtonType buttonTypeNo = new ButtonType("Không", ButtonBar.ButtonData.CANCEL_CLOSE);
//                    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

                    alertXacNhan.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
//                    alertXacNhan.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo, buttonTypeCancel);
                    Optional<ButtonType> result = alertXacNhan.showAndWait();

                    switch (result.get().getText()) {
                        case "Đồng ý":
                            int kqChiTietLonNai = chiTietLonNai_service.Xoa_ChiTietLonNai(MS_Tai_Lon);
                            if (kqChiTietLonNai > 0) {
                                int kqLonNai = chiTietLonNai_service.Xoa_LonNai(MS_Tai_Lon);
                                if (kqLonNai > 0) {
                                    HienThiTableView_KiemTraChuKyMangThai();
                                    HienThiTableView_VacXin();
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("Hoàn Thành");
                                    alert.setHeaderText("Đã xóa thành công lợn mang mã số " + MS_Tai_Lon);
                                    alert.setContentText("Đã xóa thành công!");
                                    alert.showAndWait();
                                } else
                                    System.out.println("Khong co Du Lieu trong bang lon_nai");
                            } else
                                System.out.println("Khong co Du Lieu trong bang chi_tiet_lon_nai");
                            break;
                        default:
                            break;
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Không Tìm Thấy");
                    alert.setHeaderText("Không tìm thấy Mã Số " + MS_Tai_Lon);
                    alert.setContentText("Không tìm thấy dữ liệu nào!");
                    alert.showAndWait();
                }
            }
        });
    }

    private void setAnHien(boolean b) {
        txtMaTaiLon_QuanLyLonNai.setEditable(b);
        datePickerNgayNhap.setDisable(!b);
        datePickerNgayPhoi.setDisable(!b);
        btnThem.setDisable(!b);
        btnSua.setDisable(!b);
        btnTaoMoi.setDisable(b);
        btnXoa.setDisable(!b);
    }

    private void HienThiNgayNhap_NgayPhoi_Theo_MS_Tai_Lon_TableView_VacXin() {
        tableViewVacXin.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ChiTietLonNai_Service chiTietLonNai_caThe_service = new ChiTietLonNai_ServiceImpl();
                List<ChiTietLonNai> list = chiTietLonNai_caThe_service.LayChiTietLonNai_CaThe(tableViewVacXin.getSelectionModel().getSelectedItem().getMS_Tai_Lon(), tableViewVacXin.getSelectionModel().getSelectedItem().getChu_Ky());
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
                List<ChiTietLonNai> list = chiTietLonNai_caThe_service.LayChiTietLonNai_CaThe(tableViewKiemTraChuKyMangThai.getSelectionModel().getSelectedItem().getMS_Tai_Lon(), tableViewKiemTraChuKyMangThai.getSelectionModel().getSelectedItem().getChu_Ky());
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
        tblC_ChuKyDe_ChuKyMangThai.setCellValueFactory(new PropertyValueFactory<>("Chu_Ky"));
        tblC_ChuKy_21Ngay.setCellValueFactory(new PropertyValueFactory<>("Chu_Ky_21_Ngay"));
        tblC_ChuKy_42Ngay.setCellValueFactory(new PropertyValueFactory<>("Chu_Ky_42_Ngay"));
        tblC_ChuKy_84Ngay.setCellValueFactory(new PropertyValueFactory<>("Chu_Ky_84_Ngay"));
        tblC_DeDuKien.setCellValueFactory(new PropertyValueFactory<>("Ngay_De_Du_Kien"));
        ChiTietLonNai_Service chiTietLonNai_kiemTraChuKyMangThai_service = new ChiTietLonNai_ServiceImpl();
        List<ChiTietLonNai> list = chiTietLonNai_kiemTraChuKyMangThai_service.LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai();
        tableViewKiemTraChuKyMangThai.setItems(ClassTableModel.setTable_ChiTietLonNai_KiemTraChuKyMangThai(list));

        // Tim kiem ma so tai lon theo ma
        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai> filteredData = new FilteredList<>(ClassTableModel.setTable_ChiTietLonNai_KiemTraChuKyMangThai(list), b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        txtTimKiemSoMaTai.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(chiTietLonNai_kiemTraChuKyMangThai -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (Integer.toString(chiTietLonNai_kiemTraChuKyMangThai.getMS_Tai_Lon()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches MS_Tai_Lon.
                }
//                else if (chiTietLonNai_kiemTraChuKyMangThai.getChu_Ky_21_Ngay().toLowerCase().indexOf(lowerCaseFilter) != -1) {
//                    return true; // Filter matches last name.
//                } else if (chiTietLonNai_kiemTraChuKyMangThai.getChu_Ky_42_Ngay().indexOf(lowerCaseFilter) != -1)
//                    return true;
//                else
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableViewKiemTraChuKyMangThai.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableViewKiemTraChuKyMangThai.setItems(sortedData);
    }

    private void HienThiTableView_VacXin() {
        tblC_MaTai_VacXin.setCellValueFactory(new PropertyValueFactory<>("MS_Tai_Lon"));
        tblC_ChuKyDe_VacXin.setCellValueFactory(new PropertyValueFactory<>("Chu_Ky"));
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

        // Tim kiem ma so tai lon theo ma
        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Class_TableView_ChiTietLonNai_VacXin> filteredData = new FilteredList<>(ClassTableModel.setTable_ChiTietLonNai_VacXin(list), b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        txtTimKiemSoMaTai.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(chiTietLonNai_vacXin -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (Integer.toString(chiTietLonNai_vacXin.getMS_Tai_Lon()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches MS_Tai_Lon.
                }
//                else if (chiTietLonNai_vacXin.getTa().toLowerCase().indexOf(lowerCaseFilter) != -1) {
//                    return true; // Filter matches last name.
//                } else if (chiTietLonNai_vacXin.getTay_Giun().indexOf(lowerCaseFilter) != -1)
//                    return true;
//                else
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Class_TableView_ChiTietLonNai_VacXin> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableViewVacXin.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableViewVacXin.setItems(sortedData);
    }
}
