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
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
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
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

import static com.itextpdf.text.Annotation.FILE;

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
    private Button btnXuatFileBaoCaoChiTietLonNai;

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

        datePickerTuNgay.setEditable(false);
        datePickerDenNgay.setEditable(false);
        btnXuatFileBaoCaoChiTietLonNai.setDisable(true);

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

        int dem = 0;
        for (int i = 0; i < list.size(); i++) {
            soConCon = soConCon + list.get(i).getSo_Con_Con();
            soConChet = soConChet + list.get(i).getSo_Con_Chet();
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getMS_Tai_Lon() == list.get(j).getMS_Tai_Lon()) {
                    soConCon = soConCon + list.get(j).getSo_Con_Con();
                    soConChet = soConChet + list.get(j).getSo_Con_Chet();
                    dem++;
                }
            }
            listDetailsPieChart.add(new PieChartClassModel(list.get(i).getMS_Tai_Lon(), soConCon, soConChet));
            if (dem > 0) {
                i = i + dem;
            }
            soConCon = 0;
            soConChet = 0;
            dem = 0;
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
                    btnXuatFileBaoCaoChiTietLonNai.setDisable(false);
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
                    btnXuatFileBaoCaoChiTietLonNai.setDisable(true);
                }
            }
        });
        btnXuatFileBaoCaoChiTietLonNai.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet("Báo cáo chi tiết Lợn nái");
                XSSFRow header = sheet.createRow(0);
                header.createCell(0).setCellValue("STT");
                header.createCell(1).setCellValue("Mã Tai");
                header.createCell(2).setCellValue("Ngày Phối");
                header.createCell(3).setCellValue("Ngày Đẻ");
                header.createCell(4).setCellValue("Tuổi Lợn");
                header.createCell(5).setCellValue("Tổng Số Lợn");
                header.createCell(6).setCellValue("Số Lợn Chết");
                header.createCell(7).setCellValue("Tổng Số Lợn Sống");

                for (int i = 0; i < tableViewBaoCaoChiTiet.getItems().size(); i++) {
                    XSSFRow row = sheet.createRow(i + 1);
                    row.createCell(0).setCellValue(tableViewBaoCaoChiTiet.getItems().get(i).getSTT());
                    row.createCell(1).setCellValue(tableViewBaoCaoChiTiet.getItems().get(i).getMS_Tai());
                    row.createCell(2).setCellValue(tableViewBaoCaoChiTiet.getItems().get(i).getNgay_Phoi());
                    row.createCell(3).setCellValue(tableViewBaoCaoChiTiet.getItems().get(i).getNgay_De());
                    row.createCell(4).setCellValue(tableViewBaoCaoChiTiet.getItems().get(i).getTuoi_Lon());
                    row.createCell(5).setCellValue(tableViewBaoCaoChiTiet.getItems().get(i).getTong_So_Lon());
                    row.createCell(6).setCellValue(tableViewBaoCaoChiTiet.getItems().get(i).getSo_Lon_Chet());
                    row.createCell(7).setCellValue(tableViewBaoCaoChiTiet.getItems().get(i).getTong_So_Lon());
                }

                try {
                    FileOutputStream fileOut = new FileOutputStream("d:/Report/Bao_Cao_Chi_Tiet_Heo_Nai.xlsx");
                    wb.write(fileOut);
                    fileOut.close();

                    BaseFont base = BaseFont.createFont("C:\\Users\\Suong\\Desktop\\hoctap\\nam3\\Bao-Cao\\Quan_Ly_Chan_Nuoi_Lon\\src\\com\\gdu\\dhpm11\\qllon\\font\\times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                    Font fontTieuDe = new Font(base, 11f, Font.BOLD);
                    String[] headerChiTiet = {"STT", "Mã Tai", "Ngày phối", "Ngày đẻ", "Tuổi lợn", "Tổng số lợn", "Số lợn chết", "Còn lại"};
                    Document document = new Document();
                    Paragraph paragraph = new Paragraph();

                    PdfWriter.getInstance(document, new FileOutputStream("d:/Report/Bao_Cao_Chi_Tiet_Heo_Nai.pdf"));
                    document.open();
                    Ham ham = new Ham();
                    document.add(new Paragraph("Báo Cáo Từ Ngày " + ham.DateToString(ham.convertToDateViaSqlDate(datePickerTuNgay.getValue())) + " - 00:00 đến Ngày " + ham.DateToString(ham.convertToDateViaSqlDate(datePickerDenNgay.getValue())) + " - 23:59", fontTieuDe));
                    document.add(new Paragraph("Được tạo bởi: " + System.getProperty("user.name") + ", " + new Date(), fontTieuDe));
                    document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                    document.add(new Paragraph(" "));

                    PdfPTable pdfPTable = new PdfPTable(headerChiTiet.length);
                    PdfPCell pdfPCell;
                    pdfPTable.setWidthPercentage(100);
                    pdfPTable.setSpacingBefore(10);
                    float[] columnWidths = {0.9f, 1.5f, 2f, 2f, 2f, 2f, 2f, 2f};
                    pdfPTable.setWidths(columnWidths);

                    PdfPCell cellSoNaiChua;
                    Font fontCell = new Font(base, 14f, Font.BOLD);
                    cellSoNaiChua = new PdfPCell(new Phrase("Số nái chữa: ", fontCell));
                    cellSoNaiChua.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cellSoNaiChua.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cellSoNaiChua.setColspan(4);
                    cellSoNaiChua.setBackgroundColor(new BaseColor(255, 239, 246));
                    pdfPTable.addCell(cellSoNaiChua);
                    //
                    cellSoNaiChua = new PdfPCell(new Phrase(String.valueOf(tableViewBaoCao.getItems().get(0).getSo_Lieu())));
                    cellSoNaiChua.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellSoNaiChua.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cellSoNaiChua.setColspan(4);
                    cellSoNaiChua.setBackgroundColor(new BaseColor(255, 239, 246));
                    pdfPTable.addCell(cellSoNaiChua);

                    PdfPCell cellSoDe;
                    cellSoDe = new PdfPCell(new Phrase("Số nái đẻ: ", fontCell));
                    cellSoDe.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cellSoDe.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cellSoDe.setColspan(4);
                    cellSoDe.setBackgroundColor(new BaseColor(255, 239, 246));
                    pdfPTable.addCell(cellSoDe);
                    //
                    cellSoDe = new PdfPCell(new Phrase(String.valueOf(tableViewBaoCao.getItems().get(1).getSo_Lieu())));
                    cellSoDe.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellSoDe.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cellSoDe.setColspan(4);
                    cellSoDe.setBackgroundColor(new BaseColor(255, 239, 246));
                    pdfPTable.addCell(cellSoDe);

                    PdfPCell cellBaoCaoChiTiet;
                    Font fontCellBaoCaoChiTiet = new Font(base, 18f, Font.BOLD);
                    cellBaoCaoChiTiet = new PdfPCell(new Phrase("BÁO CÁO CHI TIẾT ", fontCellBaoCaoChiTiet));
                    cellBaoCaoChiTiet.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellBaoCaoChiTiet.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cellBaoCaoChiTiet.setColspan(8);
                    cellBaoCaoChiTiet.setBackgroundColor(BaseColor.CYAN);
                    pdfPTable.addCell(cellBaoCaoChiTiet);

                    int indexC = 0;
                    Font fontCellHead = new Font(base, 12f, Font.BOLD);
                    while (indexC < headerChiTiet.length) {
                        pdfPCell = new PdfPCell(new Phrase(headerChiTiet[indexC++], fontCellHead));
                        pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCell.setBackgroundColor(BaseColor.GREEN);
                        pdfPCell.setFixedHeight(20);
                        pdfPTable.addCell(pdfPCell);
                    }
                    for (int indexR = 0; indexR < tableViewBaoCaoChiTiet.getItems().size(); indexR++) {
//                        String[] row = tableViewBaoCaoChiTiet.getItems().get(indexR);
                        PdfPCell pdfPCell1 = new PdfPCell(new Phrase(String.valueOf(tableViewBaoCaoChiTiet.getItems().get(indexR).getSTT())));
                        PdfPCell pdfPCell2 = new PdfPCell(new Phrase(String.valueOf(tableViewBaoCaoChiTiet.getItems().get(indexR).getMS_Tai())));
                        PdfPCell pdfPCell3 = new PdfPCell(new Phrase(tableViewBaoCaoChiTiet.getItems().get(indexR).getNgay_Phoi()));
                        PdfPCell pdfPCell4 = new PdfPCell(new Phrase(tableViewBaoCaoChiTiet.getItems().get(indexR).getNgay_De()));
                        PdfPCell pdfPCell5 = new PdfPCell(new Phrase(String.valueOf(tableViewBaoCaoChiTiet.getItems().get(indexR).getTuoi_Lon())));
                        PdfPCell pdfPCell6 = new PdfPCell(new Phrase(String.valueOf(tableViewBaoCaoChiTiet.getItems().get(indexR).getTong_So_Lon())));
                        PdfPCell pdfPCell7 = new PdfPCell(new Phrase(String.valueOf(tableViewBaoCaoChiTiet.getItems().get(indexR).getSo_Lon_Chet())));
                        PdfPCell pdfPCell8 = new PdfPCell(new Phrase(String.valueOf(tableViewBaoCaoChiTiet.getItems().get(indexR).getTong_So_Lon_Song())));

                        pdfPCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        pdfPCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        pdfPCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        pdfPCell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        pdfPCell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        pdfPCell6.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        pdfPCell7.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCell7.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        pdfPCell8.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCell8.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        if (indexR % 2 != 0) {
                            pdfPCell1.setBackgroundColor(new BaseColor(237, 234, 252));
                            pdfPCell2.setBackgroundColor(new BaseColor(237, 234, 252));
                            pdfPCell3.setBackgroundColor(new BaseColor(237, 234, 252));
                            pdfPCell4.setBackgroundColor(new BaseColor(237, 234, 252));
                            pdfPCell5.setBackgroundColor(new BaseColor(237, 234, 252));
                            pdfPCell6.setBackgroundColor(new BaseColor(237, 234, 252));
                            pdfPCell7.setBackgroundColor(new BaseColor(237, 234, 252));
                            pdfPCell8.setBackgroundColor(new BaseColor(237, 234, 252));
                        }

                        pdfPTable.addCell(pdfPCell1);
                        pdfPTable.addCell(pdfPCell2);
                        pdfPTable.addCell(pdfPCell3);
                        pdfPTable.addCell(pdfPCell4);
                        pdfPTable.addCell(pdfPCell5);
                        pdfPTable.addCell(pdfPCell6);
                        pdfPTable.addCell(pdfPCell7);
                        pdfPTable.addCell(pdfPCell8);

                    }
                    PdfPCell cellTongCong;
                    cellTongCong = new PdfPCell(new Phrase("Tổng cộng: ", fontCell));
                    cellTongCong.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cellTongCong.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cellTongCong.setColspan(5);
                    cellTongCong.setBackgroundColor(new BaseColor(255, 239, 246));
                    pdfPTable.addCell(cellTongCong);

                    cellTongCong = new PdfPCell(new Phrase(String.valueOf(tableViewBaoCao.getItems().get(2).getSo_Lieu())));
                    cellTongCong.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellTongCong.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cellTongCong.setColspan(1);
                    cellTongCong.setBackgroundColor(new BaseColor(255, 239, 246));
                    pdfPTable.addCell(cellTongCong);

                    cellTongCong = new PdfPCell(new Phrase(String.valueOf(tableViewBaoCao.getItems().get(3).getSo_Lieu())));
                    cellTongCong.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellTongCong.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cellTongCong.setColspan(1);
                    cellTongCong.setBackgroundColor(new BaseColor(255, 239, 246));
                    pdfPTable.addCell(cellTongCong);

                    cellTongCong = new PdfPCell(new Phrase(String.valueOf(tableViewBaoCao.getItems().get(4).getSo_Lieu())));
                    cellTongCong.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellTongCong.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cellTongCong.setColspan(1);
                    cellTongCong.setBackgroundColor(new BaseColor(255, 239, 246));
                    pdfPTable.addCell(cellTongCong);
                    paragraph.add(pdfPTable);

                    document.add(paragraph);
                    document.close();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Tạo File Thành Công");
                    alert.setHeaderText(null);
                    alert.setContentText("Bao_Cao_Chi_Tiet_Heo_Nai.xlsx, Bao_Cao_Chi_Tiet_Heo_Nai.pdf đã được tạo.");
                    alert.showAndWait();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
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
