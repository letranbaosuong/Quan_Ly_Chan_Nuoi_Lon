package com.gdu.dhpm11.qllon.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import com.gdu.dhpm11.qllon.dao.DBConnect;
import com.gdu.dhpm11.qllon.model.ChiTietLonNai;
import com.gdu.dhpm11.qllon.model.ChiTietLonNai_KiemTraChuKyMangThai;
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
    private TableColumn<ChiTietLonNai_KiemTraChuKyMangThai, Integer> tblC_MaTai_ChuKyMangThai;

    @FXML
    private TableColumn<?, ?> tblC_ChuKy_21Ngay;

    @FXML
    private TableColumn<?, ?> tblC_ChuKy_42Ngay;

    @FXML
    private TableColumn<?, ?> tblC_ChuKy_84Ngay;

    @FXML
    private TableColumn<?, ?> tblC_DeDuKien;

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

    @FXML
    void initialize() {
        assert txtMaTaiLon_QuanLyLonNai != null : "fx:id=\"txtMaTaiLon_QuanLyLonNai\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert datePickerNgayNhap != null : "fx:id=\"datePickerNgayNhap\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert datePickerNgayPhoi != null : "fx:id=\"datePickerNgayPhoi\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tableViewKiemTraChuKyMangThai != null : "fx:id=\"tableViewKiemTraChuKyMangThai\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_MaTai_ChuKyMangThai != null : "fx:id=\"tblC_MaTai_ChuKyMangThai\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_ChuKy_21Ngay != null : "fx:id=\"tblC_ChuKy_21Ngay\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_ChuKy_42Ngay != null : "fx:id=\"tblC_ChuKy_42Ngay\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_ChuKy_84Ngay != null : "fx:id=\"tblC_ChuKy_84Ngay\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_DeDuKien != null : "fx:id=\"tblC_DeDuKien\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert txtTimKiem != null : "fx:id=\"txtTimKiem\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert btnThem != null : "fx:id=\"btnThem\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert btnSua != null : "fx:id=\"btnSua\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert btnTaoMoi != null : "fx:id=\"btnTaoMoi\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert btnXoa != null : "fx:id=\"btnXoa\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tableViewVacXin != null : "fx:id=\"tableViewVacXin\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_MaTai_VacXin != null : "fx:id=\"tblC_MaTai_VacXin\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_Ta != null : "fx:id=\"tblC_Ta\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_ECOLI != null : "fx:id=\"tblC_ECOLI\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_TayGiun != null : "fx:id=\"tblC_TayGiun\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_PARVO != null : "fx:id=\"tblC_PARVO\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_FE_COC != null : "fx:id=\"tblC_FE_COC\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_Suyen != null : "fx:id=\"tblC_Suyen\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
        assert tblC_PRRS != null : "fx:id=\"tblC_PRRS\" was not injected: check your FXML file 'QuanLyLon_AnchorPane.fxml'.";
    }

    private ObservableList<Class_TableView_ChiTietLonNai_VacXin> dataTableModelChiTietLonNai = FXCollections.observableArrayList();

    private static final String DATE_PATTERN = "dd/MM/yyyy";

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(DATE_PATTERN);

//    private void addTableRow() {
//        String type, products;
//        Integer amount, price = 0;
//        type = cbxCategories.getValue().toString();
//        products = cbxProducts.getValue().toString();
//        amount = Integer.parseInt(txtAmount.getText());
//        String sql = "select * from products where name = '" + products + "';";
//        try {
//            ResultSet rs = Objects.requireNonNull(ConnectDatabase.Connect()).createStatement().executeQuery(sql);
//            if(rs.next())
//                price = Integer.parseInt(rs.getString("price"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        //add Row to Table
//        int row = mainTable.getItems().size();
//        ClassSales cs;
//        for(int i = 0 ; i < row ; i ++) {
//            cs = dataTable.get(i);
//            if(cs.getType().equals(cbxCategories.getValue().toString()) && cs.getProducts().equals(cbxProducts.getValue().toString())) {
//                dataTable.remove(cs);
//                break;
//            }
//        }
//        dataTable.add(new ClassSales(type, products, amount, getFormattedAmount(amount * price)));
//        clmType.setCellValueFactory(new PropertyValueFactory<ClassSales, String>("Type"));
//        clmProducts.setCellValueFactory(new PropertyValueFactory<ClassSales, String>("Products"));
//        clmAmount.setCellValueFactory(new PropertyValueFactory<ClassSales, Integer>("Amount"));
//        clmPrice.setCellValueFactory(new PropertyValueFactory<ClassSales, Integer>("Price"));
//        mainTable.setItems(dataTable);
//        mainTable.getSelectionModel().selectFirst();
//        check();
//        totalPrice();
//    }

    ObservableList<ChiTietLonNai_KiemTraChuKyMangThai> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection con= DBConnect.getJDBCConnection();
        try {
            ResultSet rs=con.createStatement().executeQuery("SELECT * FROM `chi_tiet_lon_nai`");
            while(rs.next()){
                observableList.add(new ChiTietLonNai_KiemTraChuKyMangThai(rs.getInt("MS_Tai_Lon"),rs.getDate("Ngay_Nhap_Lon_Nai"),rs.getDate("Ngay_Phoi")));
            }
        } catch (SQLException e) {
            System.out.println("Loi ketnoi csdl kiemtrachukymangthai");
        }
        tblC_MaTai_ChuKyMangThai.setCellValueFactory(new PropertyValueFactory<>("MS_Tai_Lon"));
        tableViewKiemTraChuKyMangThai.setItems(observableList);
    }
}
