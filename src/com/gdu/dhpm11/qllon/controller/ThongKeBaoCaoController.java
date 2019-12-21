package com.gdu.dhpm11.qllon.controller;

import com.gdu.dhpm11.qllon.model.BaoCaoChiTietLonNai;
import com.gdu.dhpm11.qllon.model.BarChartClassModel;
import com.gdu.dhpm11.qllon.model.ChiTietLonNai;
import com.gdu.dhpm11.qllon.model.PieChartClassModel;
import com.gdu.dhpm11.qllon.service.ChiTietLonNai_Service;
import com.gdu.dhpm11.qllon.service.ChiTietLonNai_ServiceImpl;
import com.gdu.dhpm11.qllon.utility.ClassTableModel;
import com.gdu.dhpm11.qllon.utility.Class_TableView_BaoCaoChiTiet_LonNai;
import com.gdu.dhpm11.qllon.utility.Class_TableView_BaoCao_LonNai;
import com.gdu.dhpm11.qllon.utility.Ham;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ThongKeBaoCaoController implements Initializable {

    ChiTietLonNai_Service service = new ChiTietLonNai_ServiceImpl();
    List<PieChartClassModel> list = service.getPieChart();

    @FXML
    private TextField txtNhapMaSoTai;

    @FXML
    private Button btnKetQua;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PieChart pieChart;

    @FXML
    private BarChart<String, Number> chartLonNai;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private DatePicker datePickerTuNgay;

    @FXML
    private DatePicker datePickerDenNgay;

    @FXML
    private Button btnHienThiKetQuaBaoCao;

    @FXML
    private TableView<Class_TableView_BaoCao_LonNai> tableViewBaoCao;

    @FXML
    private TableColumn<Class_TableView_BaoCao_LonNai, Integer> tblC_STT_BaoCao;

    @FXML
    private TableColumn<Class_TableView_BaoCao_LonNai, String> tblC_TieuChiBaoCao;

    @FXML
    private TableColumn<Class_TableView_BaoCao_LonNai, Integer> tblC_SoLieu;

    @FXML
    private TableView<Class_TableView_BaoCaoChiTiet_LonNai> tableViewBaoCaoChiTiet;

    @FXML
    private TableColumn<Class_TableView_BaoCaoChiTiet_LonNai, Integer> tblC_STT_BaoCaoChiTiet;

    @FXML
    private TableColumn<Class_TableView_BaoCaoChiTiet_LonNai, Integer> tblC_MaTai;

    @FXML
    private TableColumn<Class_TableView_BaoCaoChiTiet_LonNai, Date> tblC_NgayPhoi;

    @FXML
    private TableColumn<Class_TableView_BaoCaoChiTiet_LonNai, Date> tblC_NgayDe;

    @FXML
    private TableColumn<Class_TableView_BaoCaoChiTiet_LonNai, Integer> tblC_TongSoLon;

    @FXML
    private TableColumn<Class_TableView_BaoCaoChiTiet_LonNai, Integer> tblC_SoLonChet;

    @FXML
    private TableColumn<Class_TableView_BaoCaoChiTiet_LonNai, Integer> tblC_TongSoLonSong;

    @FXML
    private TableColumn<Class_TableView_BaoCaoChiTiet_LonNai, Integer> tblC_TuoiLon;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnKetQua.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    ChiTietLonNai_Service service = new ChiTietLonNai_ServiceImpl();
                    List<BarChartClassModel> listBarchart = service.getBarChart(Integer.parseInt(txtNhapMaSoTai.getText().trim()));
                    chartLonNai.getData().clear();
                    if (listBarchart.size() > 0) {
                        XYChart.Series series1 = new XYChart.Series();
                        XYChart.Series series2 = new XYChart.Series();
                        XYChart.Series series3 = new XYChart.Series();

                        for (int i = 0; i < listBarchart.size(); i++) {
                            x.setLabel("Lần đẻ");
                            y.setLabel("Số lượng");

                            series1.setName("Số con chết");
                            series1.getData().add(new XYChart.Data(String.valueOf(listBarchart.get(i).getChu_Ky()), listBarchart.get(i).getSo_Con_Chet()));

                            series2.setName("Số con sinh ra");
                            series2.getData().add(new XYChart.Data(String.valueOf(listBarchart.get(i).getChu_Ky()), listBarchart.get(i).getSo_Con_Con()));

                            series3.setName("Tổng số con");
                            series3.getData().add(new XYChart.Data(String.valueOf(listBarchart.get(i).getChu_Ky()), listBarchart.get(i).getSo_Con_Con()
                                    - listBarchart.get(i).getSo_Con_Chet()));

                            x.setAnimated(false);
                            y.setAnimated(false);
                            chartLonNai.setTitle("Biểu đồ chi tiết lợn nái Mã số " + listBarchart.get(i).getMS_Tai_Lon());
                        }

                        chartLonNai.getData().addAll(series1, series2, series3);
                    } else {
                        chartLonNai.getData().clear();
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Không Tìm Thấy");
                        alert.setHeaderText("Không tìm thấy Heo có Mã " + txtNhapMaSoTai.getText().trim());
                        alert.setContentText("@_@");
                        alert.showAndWait();
                        chartLonNai.setTitle("Biểu đồ chi tiết lợn nái");
                    }

//                chartLonNai.getData().clear();
//
//                x.setLabel("Lần đẻ");
//                y.setLabel("Số lượng");
//                XYChart.Series series1 = new XYChart.Series();
//                series1.setName("Số con chết");
//                series1.getData().add(new XYChart.Data(austria, 2));
//                series1.getData().add(new XYChart.Data(brazil, 1));
//                series1.getData().add(new XYChart.Data(france, 0));
//                series1.getData().add(new XYChart.Data(italy, 4));
//                series1.getData().add(new XYChart.Data(usa, 3));
//
//                XYChart.Series series2 = new XYChart.Series();
//                series2.setName("Số con sinh ra");
//                series2.getData().add(new XYChart.Data(austria, 10));
//                series2.getData().add(new XYChart.Data(brazil, 13));
//                series2.getData().add(new XYChart.Data(france, 8));
//                series2.getData().add(new XYChart.Data(italy, 12));
//                series2.getData().add(new XYChart.Data(usa, 14));
//
//                XYChart.Series series3 = new XYChart.Series();
//                series3.setName("Tổng số con");
//                series3.getData().add(new XYChart.Data(austria, 8));
//                series3.getData().add(new XYChart.Data(brazil, 12));
//                series3.getData().add(new XYChart.Data(france, 8));
//                series3.getData().add(new XYChart.Data(italy, 8));
//                series3.getData().add(new XYChart.Data(usa, 11));
//
//                x.setAnimated(false);
//                y.setAnimated(false);
//                chartLonNai.getData().addAll(series1, series2, series3);

                } catch (NumberFormatException e) {
                    chartLonNai.getData().clear();
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Không Tìm Thấy");
                    alert.setHeaderText("Không tìm thấy Heo có Mã " + txtNhapMaSoTai.getText().trim());
                    alert.setContentText("@_@");
                    alert.showAndWait();
                    chartLonNai.setTitle("Biểu đồ chi tiết lợn nái");
                }
            }
        });
        int soConCon = 0, soConChet = 0;
        List<PieChartClassModel> listDetailsPieChart = new ArrayList<>();

        int temp = list.get(0).getMS_Tai_Lon();
        int dem = 1;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                soConCon = soConCon + list.get(i).getSo_Con_Con();
                if (list.get(i).getMS_Tai_Lon() == list.get(j).getMS_Tai_Lon()) {
//                    soConCon = soConCon + list.get(j).getSo_Con_Con();
//                    soConChet = soConChet + list.get(i).getSo_Con_Chet() + list.get(j).getSo_Con_Chet();
                    dem++;
                } else {
                    soConCon = list.get(i).getSo_Con_Con();
                    soConChet = list.get(i).getSo_Con_Chet();
                }
            }
            System.out.println("dem = " + dem);
            dem = 1;
            if (dem > 1) {
                i = i + dem - 2;
                dem = 0;
            }

//            System.out.println("i = " + i + " - dem = " + dem + " - soConCon = " + soConCon + " - soConChet = " + soConChet);

//            PieChartClassModel chiTietPieChart = new PieChartClassModel();
//            chiTietPieChart.setMS_Tai_Lon(list.get(i).getMS_Tai_Lon());
//            chiTietPieChart.setSo_Con_Con(soConCon);
//            chiTietPieChart.setSo_Con_Chet(soConChet);
//            listDetailsPieChart.add(chiTietPieChart);
//            soConCon = 0;
//            soConChet = 0;
//            if (dem > 0) {
//                i = i + dem + 1;
//                dem = 0;
//            } else {
//
//            }
        }

        System.out.println(listDetailsPieChart.toString());

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (int m = 0; m < listDetailsPieChart.size(); m++) {
            pieChartData.add(new PieChart.Data("MS " + listDetailsPieChart.get(m).getMS_Tai_Lon(),
                    listDetailsPieChart.get(m).getSo_Con_Con() - listDetailsPieChart.get(m).getSo_Con_Chet()));
        }

        pieChart.setData(pieChartData);

        // Bao Cao
        btnHienThiKetQuaBaoCao.setDisable(true);
        datePickerTuNgay.setOnAction(e -> ChangedDate());
        datePickerDenNgay.setOnAction(e -> ChangedDate());
        btnHienThiKetQuaBaoCao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChiTietLonNai_Service service = new ChiTietLonNai_ServiceImpl();
                List<BaoCaoChiTietLonNai> list = service.LayBaoCaoChiTietLonNai(datePickerTuNgay.getValue().toString(), datePickerDenNgay.getValue().toString());

                if (list.size() > 0) {
                    tblC_STT_BaoCaoChiTiet.setCellValueFactory(new PropertyValueFactory<>("STT"));
                    tblC_MaTai.setCellValueFactory(new PropertyValueFactory<>("MS_Tai"));
                    tblC_NgayPhoi.setCellValueFactory(new PropertyValueFactory<>("Ngay_Phoi"));
                    tblC_NgayDe.setCellValueFactory(new PropertyValueFactory<>("Ngay_De"));
                    tblC_TongSoLon.setCellValueFactory(new PropertyValueFactory<>("Tong_So_Lon"));
                    tblC_SoLonChet.setCellValueFactory(new PropertyValueFactory<>("So_Lon_Chet"));
                    tblC_TongSoLonSong.setCellValueFactory(new PropertyValueFactory<>("Tong_So_Lon_Song"));
                    tblC_TuoiLon.setCellValueFactory(new PropertyValueFactory<>("Tuoi_Lon"));
                    tableViewBaoCaoChiTiet.setItems(ClassTableModel.setTable_BaoCaoChiTietLonNai(list));

                    tblC_STT_BaoCao.setCellValueFactory(new PropertyValueFactory<>("STT"));
                    tblC_TieuChiBaoCao.setCellValueFactory(new PropertyValueFactory<>("Tieu_Chi_Bao_Cao"));
                    tblC_SoLieu.setCellValueFactory(new PropertyValueFactory<>("So_Lieu"));
                    tableViewBaoCao.setItems(ClassTableModel.setTable_BaoCaoLonNai(list));
                } else {
                    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String tuNgay = datePickerTuNgay.getValue().format(formatters);
                    String denNgay = datePickerDenNgay.getValue().format(formatters);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Không Tìm Thấy");
                    alert.setHeaderText("Không tìm thấy dữ liệu nào!");
                    alert.setContentText("Trong khoảng từ ngày " + tuNgay + " 00:00 đến ngày " + denNgay + " 23:59");
                    alert.showAndWait();
                    tableViewBaoCaoChiTiet.setItems(null);
                    tableViewBaoCao.setItems(null);
                }
            }
        });
    }

    private void ChangedDate() {
        if (datePickerDenNgay.getValue().compareTo(datePickerTuNgay.getValue()) >= 0) {
            btnHienThiKetQuaBaoCao.setDisable(false);
        } else {
            btnHienThiKetQuaBaoCao.setDisable(true);
        }
    }
}
