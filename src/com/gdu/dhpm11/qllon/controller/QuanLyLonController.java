package com.gdu.dhpm11.qllon.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import com.gdu.dhpm11.qllon.model.ChiTietLonNai;
import com.gdu.dhpm11.qllon.service.*;
import com.gdu.dhpm11.qllon.utility.ClassTableModel;
import com.gdu.dhpm11.qllon.utility.Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai;
import com.gdu.dhpm11.qllon.utility.Class_TableView_ChiTietLonNai_VacXin;
import com.gdu.dhpm11.qllon.utility.Ham;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.stage.Window;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class QuanLyLonController implements Initializable {

    private int lay_MS_Tai_Lon_Tam_Thoi = 0;
    private int lay_Chu_Ky_Tam_Thoi = 0;
    private boolean kiemtraButtonThemHienAn = false;
    private String outputPath = null;

    ChiTietLonNai_Service service = new ChiTietLonNai_ServiceImpl();
    List<ChiTietLonNai> listDetails = service.getAll();

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
    private TextField txtChuyenSangChuongDe;

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
    private Button btnXuatFile;

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
        txtChuyenSangChuongDe.setEditable(false);
        setAnHien(false);
        HienThiTableView_KiemTraChuKyMangThai();
        HienThiTableView_VacXin();
        HienThiNgayNhap_NgayPhoi_Theo_MS_Tai_Lon_TableView_KiemTraChuKyMangThai();
        HienThiNgayNhap_NgayPhoi_Theo_MS_Tai_Lon_TableView_VacXin();

        txtMaTaiLon_QuanLyLonNai.setOnKeyReleased(e -> ChanngedThem());

        datePickerNgayNhap.setOnAction(e -> ChanngedThem());

        datePickerNgayPhoi.setOnAction(e -> ChanngedThem());

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
                        setAnHien(false);
                        kiemtraButtonThemHienAn = false;
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
                            setAnHien(false);
                            kiemtraButtonThemHienAn = false;
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
//                try {
//                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ChiTietLonNai_AnchorPane.fxml"));
////                    root = FXMLLoader.load(getClass().getResource("../view/ChiTietLonNai_AnchorPane.fxml"));
//                    Parent root = fxmlLoader.load();
//                    ChiTietLonNaiController chiTietLonNaiAnchorPane_controller = fxmlLoader.getController();
//                    chiTietLonNaiAnchorPane_controller.setMSTai_ChuKyDe(lay_MS_Tai_Lon_Tam_Thoi, lay_Chu_Ky_Tam_Thoi);
//                    Stage stage = new Stage();
//                    stage.setTitle("Sửa Chi Tiết Lợn Nái");
//                    stage.setScene(new Scene(root));
//                    stage.show();
////                    // Hide this current window (if this is what you want)
////                    ((Stage)(actionEvent.getSource())).getScene().getWindow().hide();
//                } catch (IOException e) {
//                    System.out.println("Loi btnSua.setOnAction(new EventHandler<ActionEvent>() {} : " + e.toString());
//                }

                try {
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("../view/ChiTietLonNai_AnchorPane.fxml"));
                    Parent chiTietLonNaiParent = loader.load();
                    Scene scene = new Scene(chiTietLonNaiParent);
                    ChiTietLonNaiController chiTietLonNaiAnchorPane_controller = loader.getController();
                    chiTietLonNaiAnchorPane_controller.setMSTai_ChuKyDe(lay_MS_Tai_Lon_Tam_Thoi, lay_Chu_Ky_Tam_Thoi);
                    stage.setScene(scene);
                    stage.centerOnScreen();
                } catch (IOException e) {
                    System.out.println("Loi btnSua.setOnAction(new EventHandler<ActionEvent>() {} trong package com.gdu.dhpm11.qllon.controller.QuanLyLonController : " + e.getMessage());
                }

            }
        });

        btnTaoMoi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                txtMaTaiLon_QuanLyLonNai.setEditable(true);
//                datePickerNgayNhap.setDisable(false);
//                datePickerNgayPhoi.setDisable(false);
                txtMaTaiLon_QuanLyLonNai.requestFocus();
                btnTaoMoi.setDisable(false);
//                btnThem.setDisable(false);
                btnSua.setDisable(true);
                btnXoa.setDisable(true);
//                txtMaTaiLon_QuanLyLonNai.setText(String.valueOf(Integer.parseInt(txtMaTaiLon_QuanLyLonNai.getText().trim()) + 1));

                kiemtraButtonThemHienAn = true;
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
                                    setAnHien(false);
                                    txtMaTaiLon_QuanLyLonNai.setText("");
                                    datePickerNgayNhap.setValue(null);
                                    datePickerNgayPhoi.setValue(null);
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

        Stage LuuStage = new Stage();
        btnXuatFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Lưu");

                final File file = new FileChooser().showSaveDialog(LuuStage);
                Platform.runLater(new Runnable() {
                    public void run() {
                        if (file != null) {
                            outputPath = file.getPath();
                            System.out.println(outputPath);
                            // Export to the path
                        }
                    }
                });
                if (tableViewVacXin.getItems().size() > 0) {

                    XSSFWorkbook wb = new XSSFWorkbook();
                    XSSFSheet sheet = wb.createSheet("Chi tiết lịch tiêm heo nái");
                    XSSFRow header = sheet.createRow(0);
                    header.createCell(0).setCellValue("STT");
                    header.createCell(1).setCellValue("Mã Tai");
                    header.createCell(2).setCellValue("Lần Đẻ");
                    header.createCell(3).setCellValue("Chu Kỳ 21 Ngày");
                    header.createCell(4).setCellValue("Chu Kỳ 42 Ngày");
                    header.createCell(5).setCellValue("Chu Kỳ 84 Ngày");
                    header.createCell(6).setCellValue("Ngày Đẻ");
                    header.createCell(7).setCellValue("Tả");
                    header.createCell(8).setCellValue("ECOLI");
                    header.createCell(9).setCellValue("Tẩy giun");
                    header.createCell(10).setCellValue("PARVO");
                    header.createCell(11).setCellValue("FE+COC (3 ngày)");
                    header.createCell(12).setCellValue("Suyễn (14 ngày)");
                    header.createCell(13).setCellValue("PRRS (21 ngày)");

                    for (int i = 0; i < tableViewKiemTraChuKyMangThai.getItems().size(); i++) {
                        XSSFRow row = sheet.createRow(i + 1);
                        row.createCell(0).setCellValue(i + 1);
                        row.createCell(1).setCellValue(tableViewKiemTraChuKyMangThai.getItems().get(i).getMS_Tai_Lon());
                        row.createCell(2).setCellValue(tableViewKiemTraChuKyMangThai.getItems().get(i).getChu_Ky());
                        row.createCell(3).setCellValue(tableViewKiemTraChuKyMangThai.getItems().get(i).getChu_Ky_21_Ngay());
                        row.createCell(4).setCellValue(tableViewKiemTraChuKyMangThai.getItems().get(i).getChu_Ky_42_Ngay());
                        row.createCell(5).setCellValue(tableViewKiemTraChuKyMangThai.getItems().get(i).getChu_Ky_84_Ngay());
                        row.createCell(6).setCellValue(tableViewKiemTraChuKyMangThai.getItems().get(i).getNgay_De_Du_Kien());
                        row.createCell(7).setCellValue(tableViewVacXin.getItems().get(i).getTa());
                        row.createCell(8).setCellValue(tableViewVacXin.getItems().get(i).getECOLI());
                        row.createCell(9).setCellValue(tableViewVacXin.getItems().get(i).getTay_Giun());
                        row.createCell(10).setCellValue(tableViewVacXin.getItems().get(i).getPARVO());
                        row.createCell(11).setCellValue(tableViewVacXin.getItems().get(i).getFE_COC_3_Ngay());
                        row.createCell(12).setCellValue(tableViewVacXin.getItems().get(i).getSuyen_14_Ngay());
                        row.createCell(13).setCellValue(tableViewVacXin.getItems().get(i).getPRRS_21_Ngay());
                    }

                    try {
                        FileOutputStream fileOut = new FileOutputStream("d:/Report/Bao_Cao_Chi_Tiet_Lich_Tiem_Heo_Nai.xlsx");
//                        FileOutputStream fileOut = new FileOutputStream(outputPath + ".xlsx");
                        wb.write(fileOut);
                        fileOut.close();

                        BaseFont base = BaseFont.createFont("C:\\Users\\Suong\\Desktop\\hoctap\\nam3\\Bao-Cao\\Quan_Ly_Chan_Nuoi_Lon\\src\\com\\gdu\\dhpm11\\qllon\\font\\times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                        Font fontTieuDe = new Font(base, 11f, Font.BOLD);
//                        String[] headerLichTiemTruocSinh = {"STT", "Mã tai", "Lần Đẻ", "Tả", "ECOLI", "Tẩy giun", "PARVO"};
//                        String[] headerLichTiemSauSinh = {"STT", "Mã tai", "Lần Đẻ", "FE+COC (3 ngày)", "Suyễn (14 ngày)", "PRRS (21 ngày)"};
                        Document document = new Document();
                        Paragraph paragraph = new Paragraph();

                        PdfWriter.getInstance(document, new FileOutputStream("d:/Report/Bao_Cao_Chi_Tiet_Lich_Tiem_Heo_Nai.pdf"));
//                        PdfWriter.getInstance(document, new FileOutputStream(outputPath + ".pdf"));
                        document.open();
                        document.add(new Paragraph("Báo Cáo Chi Tiết Lịch Tiêm", fontTieuDe));
                        document.add(new Paragraph("Được tạo bởi: " + System.getProperty("user.name") + ", " + new Date(), fontTieuDe));
                        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        document.add(new Paragraph(" "));

                        PdfPTable pdfPTableKiemTraMangThai = new PdfPTable(7);
                        PdfPCell pdfPCellKiemTraMangThai;
                        pdfPTableKiemTraMangThai.setWidthPercentage(100);
                        pdfPTableKiemTraMangThai.setSpacingBefore(10);
                        float[] columnWidths = {1f, 1f, 1f, 2f, 2f, 2f, 2f};
                        pdfPTableKiemTraMangThai.setWidths(columnWidths);

                        PdfPCell cellBaoCaoChiTietLichTiem;
                        Font fontCellBaoCaoChiTietLichTiem = new Font(base, 18f, Font.BOLD);
                        cellBaoCaoChiTietLichTiem = new PdfPCell(new Phrase("BÁO CÁO KIỂM TRA CHU KỲ MANG THAI", fontCellBaoCaoChiTietLichTiem));
                        cellBaoCaoChiTietLichTiem.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellBaoCaoChiTietLichTiem.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cellBaoCaoChiTietLichTiem.setColspan(7);
                        cellBaoCaoChiTietLichTiem.setBackgroundColor(BaseColor.CYAN);
                        pdfPTableKiemTraMangThai.addCell(cellBaoCaoChiTietLichTiem);

                        // Kiem Tra Mang Thai
                        Font fontCellHead = new Font(base, 10f, Font.BOLD);
                        pdfPCellKiemTraMangThai = new PdfPCell(new Phrase("STT", fontCellHead));
                        pdfPCellKiemTraMangThai.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellKiemTraMangThai.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellKiemTraMangThai.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellKiemTraMangThai.setFixedHeight(20);
                        pdfPCellKiemTraMangThai.setRowspan(2);
                        pdfPTableKiemTraMangThai.addCell(pdfPCellKiemTraMangThai);

                        pdfPCellKiemTraMangThai = new PdfPCell(new Phrase("Mã tai", fontCellHead));
                        pdfPCellKiemTraMangThai.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellKiemTraMangThai.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellKiemTraMangThai.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellKiemTraMangThai.setFixedHeight(20);
                        pdfPCellKiemTraMangThai.setRowspan(2);
                        pdfPTableKiemTraMangThai.addCell(pdfPCellKiemTraMangThai);

                        pdfPCellKiemTraMangThai = new PdfPCell(new Phrase("Lần Đẻ", fontCellHead));
                        pdfPCellKiemTraMangThai.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellKiemTraMangThai.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellKiemTraMangThai.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellKiemTraMangThai.setFixedHeight(20);
                        pdfPCellKiemTraMangThai.setRowspan(2);
                        pdfPTableKiemTraMangThai.addCell(pdfPCellKiemTraMangThai);

                        pdfPCellKiemTraMangThai = new PdfPCell(new Phrase("Kiểm Tra Chu Ky Mang Thai (Ngày)", fontCellHead));
                        pdfPCellKiemTraMangThai.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellKiemTraMangThai.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellKiemTraMangThai.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellKiemTraMangThai.setFixedHeight(20);
                        pdfPCellKiemTraMangThai.setColspan(3);
                        pdfPTableKiemTraMangThai.addCell(pdfPCellKiemTraMangThai);

                        pdfPCellKiemTraMangThai = new PdfPCell(new Phrase("Ngày Đẻ", fontCellHead));
                        pdfPCellKiemTraMangThai.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellKiemTraMangThai.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellKiemTraMangThai.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellKiemTraMangThai.setFixedHeight(20);
                        pdfPCellKiemTraMangThai.setRowspan(2);
                        pdfPTableKiemTraMangThai.addCell(pdfPCellKiemTraMangThai);

                        pdfPCellKiemTraMangThai = new PdfPCell(new Phrase("21", fontCellHead));
                        pdfPCellKiemTraMangThai.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellKiemTraMangThai.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellKiemTraMangThai.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellKiemTraMangThai.setFixedHeight(20);
                        pdfPCellKiemTraMangThai.setRowspan(1);
                        pdfPTableKiemTraMangThai.addCell(pdfPCellKiemTraMangThai);

                        pdfPCellKiemTraMangThai = new PdfPCell(new Phrase("42", fontCellHead));
                        pdfPCellKiemTraMangThai.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellKiemTraMangThai.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellKiemTraMangThai.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellKiemTraMangThai.setFixedHeight(20);
                        pdfPCellKiemTraMangThai.setRowspan(1);
                        pdfPTableKiemTraMangThai.addCell(pdfPCellKiemTraMangThai);

                        pdfPCellKiemTraMangThai = new PdfPCell(new Phrase("84", fontCellHead));
                        pdfPCellKiemTraMangThai.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellKiemTraMangThai.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellKiemTraMangThai.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellKiemTraMangThai.setFixedHeight(20);
                        pdfPCellKiemTraMangThai.setRowspan(1);
                        pdfPTableKiemTraMangThai.addCell(pdfPCellKiemTraMangThai);
                        for (int indexR = 0; indexR < tableViewKiemTraChuKyMangThai.getItems().size(); indexR++) {
                            PdfPCell pdfPCell1 = new PdfPCell(new Phrase(String.valueOf(indexR + 1)));
                            PdfPCell pdfPCell2 = new PdfPCell(new Phrase(String.valueOf(tableViewKiemTraChuKyMangThai.getItems().get(indexR).getMS_Tai_Lon())));
                            PdfPCell pdfPCell3 = new PdfPCell(new Phrase(String.valueOf(tableViewKiemTraChuKyMangThai.getItems().get(indexR).getChu_Ky())));
                            PdfPCell pdfPCell4 = new PdfPCell(new Phrase(tableViewKiemTraChuKyMangThai.getItems().get(indexR).getChu_Ky_21_Ngay()));
                            PdfPCell pdfPCell5 = new PdfPCell(new Phrase(tableViewKiemTraChuKyMangThai.getItems().get(indexR).getChu_Ky_42_Ngay()));
                            PdfPCell pdfPCell6 = new PdfPCell(new Phrase(tableViewKiemTraChuKyMangThai.getItems().get(indexR).getChu_Ky_84_Ngay()));
                            PdfPCell pdfPCell7 = new PdfPCell(new Phrase(tableViewKiemTraChuKyMangThai.getItems().get(indexR).getNgay_De_Du_Kien()));

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

                            if (indexR % 2 != 0) {
                                pdfPCell1.setBackgroundColor(new BaseColor(237, 234, 252));
                                pdfPCell2.setBackgroundColor(new BaseColor(237, 234, 252));
                                pdfPCell3.setBackgroundColor(new BaseColor(237, 234, 252));
                                pdfPCell4.setBackgroundColor(new BaseColor(237, 234, 252));
                                pdfPCell5.setBackgroundColor(new BaseColor(237, 234, 252));
                                pdfPCell6.setBackgroundColor(new BaseColor(237, 234, 252));
                                pdfPCell7.setBackgroundColor(new BaseColor(237, 234, 252));
                            }

                            pdfPTableKiemTraMangThai.addCell(pdfPCell1);
                            pdfPTableKiemTraMangThai.addCell(pdfPCell2);
                            pdfPTableKiemTraMangThai.addCell(pdfPCell3);
                            pdfPTableKiemTraMangThai.addCell(pdfPCell4);
                            pdfPTableKiemTraMangThai.addCell(pdfPCell5);
                            pdfPTableKiemTraMangThai.addCell(pdfPCell6);
                            pdfPTableKiemTraMangThai.addCell(pdfPCell7);

                        }
                        paragraph.add(pdfPTableKiemTraMangThai);

                        // truoc khi sinh
                        PdfPTable pdfPTableLichTiemTruocKhiSinh = new PdfPTable(7);
                        PdfPCell pdfPCellLichTiemTruocKhiSinh;
                        pdfPTableLichTiemTruocKhiSinh.setWidthPercentage(100);
                        pdfPTableLichTiemTruocKhiSinh.setSpacingBefore(10);
                        float[] columnWidthsLichTiemTruocKhiSinh = {1f, 1f, 1f, 2f, 2f, 2f, 2f};
                        pdfPTableLichTiemTruocKhiSinh.setWidths(columnWidthsLichTiemTruocKhiSinh);

                        pdfPCellLichTiemTruocKhiSinh = new PdfPCell(new Phrase("BÁO CÁO LỊCH TIÊM TRƯỚC KHI SINH", fontCellBaoCaoChiTietLichTiem));
                        pdfPCellLichTiemTruocKhiSinh.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellLichTiemTruocKhiSinh.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellLichTiemTruocKhiSinh.setColspan(7);
                        pdfPCellLichTiemTruocKhiSinh.setBackgroundColor(BaseColor.CYAN);
                        pdfPTableLichTiemTruocKhiSinh.addCell(pdfPCellLichTiemTruocKhiSinh);

                        pdfPCellLichTiemTruocKhiSinh = new PdfPCell(new Phrase("STT", fontCellHead));
                        pdfPCellLichTiemTruocKhiSinh.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellLichTiemTruocKhiSinh.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellLichTiemTruocKhiSinh.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellLichTiemTruocKhiSinh.setFixedHeight(20);
                        pdfPCellLichTiemTruocKhiSinh.setRowspan(2);
                        pdfPTableLichTiemTruocKhiSinh.addCell(pdfPCellLichTiemTruocKhiSinh);

                        pdfPCellLichTiemTruocKhiSinh = new PdfPCell(new Phrase("Mã Tai", fontCellHead));
                        pdfPCellLichTiemTruocKhiSinh.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellLichTiemTruocKhiSinh.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellLichTiemTruocKhiSinh.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellLichTiemTruocKhiSinh.setFixedHeight(20);
                        pdfPCellLichTiemTruocKhiSinh.setRowspan(2);
                        pdfPTableLichTiemTruocKhiSinh.addCell(pdfPCellLichTiemTruocKhiSinh);

                        pdfPCellLichTiemTruocKhiSinh = new PdfPCell(new Phrase("Lần Đẻ", fontCellHead));
                        pdfPCellLichTiemTruocKhiSinh.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellLichTiemTruocKhiSinh.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellLichTiemTruocKhiSinh.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellLichTiemTruocKhiSinh.setFixedHeight(20);
                        pdfPCellLichTiemTruocKhiSinh.setRowspan(2);
                        pdfPTableLichTiemTruocKhiSinh.addCell(pdfPCellLichTiemTruocKhiSinh);

                        pdfPCellLichTiemTruocKhiSinh = new PdfPCell(new Phrase("Vác-Xin", fontCellHead));
                        pdfPCellLichTiemTruocKhiSinh.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellLichTiemTruocKhiSinh.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellLichTiemTruocKhiSinh.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellLichTiemTruocKhiSinh.setFixedHeight(20);
                        pdfPCellLichTiemTruocKhiSinh.setColspan(4);
                        pdfPTableLichTiemTruocKhiSinh.addCell(pdfPCellLichTiemTruocKhiSinh);

                        pdfPCellLichTiemTruocKhiSinh = new PdfPCell(new Phrase("Tả", fontCellHead));
                        pdfPCellLichTiemTruocKhiSinh.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellLichTiemTruocKhiSinh.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellLichTiemTruocKhiSinh.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellLichTiemTruocKhiSinh.setFixedHeight(20);
                        pdfPCellLichTiemTruocKhiSinh.setRowspan(1);
                        pdfPTableLichTiemTruocKhiSinh.addCell(pdfPCellLichTiemTruocKhiSinh);

                        pdfPCellLichTiemTruocKhiSinh = new PdfPCell(new Phrase("ECOLI", fontCellHead));
                        pdfPCellLichTiemTruocKhiSinh.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellLichTiemTruocKhiSinh.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellLichTiemTruocKhiSinh.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellLichTiemTruocKhiSinh.setFixedHeight(20);
                        pdfPCellLichTiemTruocKhiSinh.setRowspan(1);
                        pdfPTableLichTiemTruocKhiSinh.addCell(pdfPCellLichTiemTruocKhiSinh);

                        pdfPCellLichTiemTruocKhiSinh = new PdfPCell(new Phrase("Tẩy Giun", fontCellHead));
                        pdfPCellLichTiemTruocKhiSinh.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellLichTiemTruocKhiSinh.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellLichTiemTruocKhiSinh.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellLichTiemTruocKhiSinh.setFixedHeight(20);
                        pdfPCellLichTiemTruocKhiSinh.setRowspan(1);
                        pdfPTableLichTiemTruocKhiSinh.addCell(pdfPCellLichTiemTruocKhiSinh);

                        pdfPCellLichTiemTruocKhiSinh = new PdfPCell(new Phrase("PARVO", fontCellHead));
                        pdfPCellLichTiemTruocKhiSinh.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellLichTiemTruocKhiSinh.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellLichTiemTruocKhiSinh.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellLichTiemTruocKhiSinh.setFixedHeight(20);
                        pdfPCellLichTiemTruocKhiSinh.setRowspan(1);
                        pdfPTableLichTiemTruocKhiSinh.addCell(pdfPCellLichTiemTruocKhiSinh);

                        for (int indexR = 0; indexR < tableViewVacXin.getItems().size(); indexR++) {
                            PdfPCell pdfPCell1 = new PdfPCell(new Phrase(String.valueOf(indexR + 1)));
                            PdfPCell pdfPCell2 = new PdfPCell(new Phrase(String.valueOf(tableViewVacXin.getItems().get(indexR).getMS_Tai_Lon())));
                            PdfPCell pdfPCell3 = new PdfPCell(new Phrase(String.valueOf(tableViewVacXin.getItems().get(indexR).getChu_Ky())));
                            PdfPCell pdfPCell4 = new PdfPCell(new Phrase(tableViewVacXin.getItems().get(indexR).getTa()));
                            PdfPCell pdfPCell5 = new PdfPCell(new Phrase(tableViewVacXin.getItems().get(indexR).getECOLI()));
                            PdfPCell pdfPCell6 = new PdfPCell(new Phrase(tableViewVacXin.getItems().get(indexR).getTay_Giun()));
                            PdfPCell pdfPCell7 = new PdfPCell(new Phrase(tableViewVacXin.getItems().get(indexR).getPARVO()));

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

                            if (indexR % 2 != 0) {
                                pdfPCell1.setBackgroundColor(new BaseColor(237, 234, 252));
                                pdfPCell2.setBackgroundColor(new BaseColor(237, 234, 252));
                                pdfPCell3.setBackgroundColor(new BaseColor(237, 234, 252));
                                pdfPCell4.setBackgroundColor(new BaseColor(237, 234, 252));
                                pdfPCell5.setBackgroundColor(new BaseColor(237, 234, 252));
                                pdfPCell6.setBackgroundColor(new BaseColor(237, 234, 252));
                                pdfPCell7.setBackgroundColor(new BaseColor(237, 234, 252));
                            }

                            pdfPTableLichTiemTruocKhiSinh.addCell(pdfPCell1);
                            pdfPTableLichTiemTruocKhiSinh.addCell(pdfPCell2);
                            pdfPTableLichTiemTruocKhiSinh.addCell(pdfPCell3);
                            pdfPTableLichTiemTruocKhiSinh.addCell(pdfPCell4);
                            pdfPTableLichTiemTruocKhiSinh.addCell(pdfPCell5);
                            pdfPTableLichTiemTruocKhiSinh.addCell(pdfPCell6);
                            pdfPTableLichTiemTruocKhiSinh.addCell(pdfPCell7);

                        }

                        paragraph.add(pdfPTableLichTiemTruocKhiSinh);

                        // sau khi sinh
                        PdfPTable pdfPTableLichTiemSauKhiSinh = new PdfPTable(6);
                        PdfPCell pdfPCellLichTiemSauKhiSinh;
                        pdfPTableLichTiemSauKhiSinh.setWidthPercentage(100);
                        pdfPTableLichTiemSauKhiSinh.setSpacingBefore(10);
                        float[] columnWidthsLichTiemSauKhiSinh = {1f, 1f, 1f, 2f, 2f, 2f};
                        pdfPTableLichTiemSauKhiSinh.setWidths(columnWidthsLichTiemSauKhiSinh);

                        pdfPCellLichTiemSauKhiSinh = new PdfPCell(new Phrase("BÁO CÁO LỊCH TIÊM SAU KHI SINH", fontCellBaoCaoChiTietLichTiem));
                        pdfPCellLichTiemSauKhiSinh.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellLichTiemSauKhiSinh.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellLichTiemSauKhiSinh.setColspan(6);
                        pdfPCellLichTiemSauKhiSinh.setBackgroundColor(BaseColor.CYAN);
                        pdfPTableLichTiemSauKhiSinh.addCell(pdfPCellLichTiemSauKhiSinh);

                        pdfPCellLichTiemSauKhiSinh = new PdfPCell(new Phrase("STT", fontCellHead));
                        pdfPCellLichTiemSauKhiSinh.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellLichTiemSauKhiSinh.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellLichTiemSauKhiSinh.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellLichTiemSauKhiSinh.setFixedHeight(20);
                        pdfPCellLichTiemSauKhiSinh.setRowspan(2);
                        pdfPTableLichTiemSauKhiSinh.addCell(pdfPCellLichTiemSauKhiSinh);

                        pdfPCellLichTiemSauKhiSinh = new PdfPCell(new Phrase("Mã Tai", fontCellHead));
                        pdfPCellLichTiemSauKhiSinh.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellLichTiemSauKhiSinh.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellLichTiemSauKhiSinh.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellLichTiemSauKhiSinh.setFixedHeight(20);
                        pdfPCellLichTiemSauKhiSinh.setRowspan(2);
                        pdfPTableLichTiemSauKhiSinh.addCell(pdfPCellLichTiemSauKhiSinh);

                        pdfPCellLichTiemSauKhiSinh = new PdfPCell(new Phrase("Lần Đẻ", fontCellHead));
                        pdfPCellLichTiemSauKhiSinh.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellLichTiemSauKhiSinh.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellLichTiemSauKhiSinh.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellLichTiemSauKhiSinh.setFixedHeight(20);
                        pdfPCellLichTiemSauKhiSinh.setRowspan(2);
                        pdfPTableLichTiemSauKhiSinh.addCell(pdfPCellLichTiemSauKhiSinh);

                        pdfPCellLichTiemSauKhiSinh = new PdfPCell(new Phrase("Vác-Xin", fontCellHead));
                        pdfPCellLichTiemSauKhiSinh.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellLichTiemSauKhiSinh.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellLichTiemSauKhiSinh.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellLichTiemSauKhiSinh.setFixedHeight(20);
                        pdfPCellLichTiemSauKhiSinh.setColspan(3);
                        pdfPTableLichTiemSauKhiSinh.addCell(pdfPCellLichTiemSauKhiSinh);

                        pdfPCellLichTiemSauKhiSinh = new PdfPCell(new Phrase("FE+COC (3 ngày)", fontCellHead));
                        pdfPCellLichTiemSauKhiSinh.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellLichTiemSauKhiSinh.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellLichTiemSauKhiSinh.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellLichTiemSauKhiSinh.setFixedHeight(20);
                        pdfPCellLichTiemSauKhiSinh.setRowspan(1);
                        pdfPTableLichTiemSauKhiSinh.addCell(pdfPCellLichTiemSauKhiSinh);

                        pdfPCellLichTiemSauKhiSinh = new PdfPCell(new Phrase("Suyễn (14 ngày)", fontCellHead));
                        pdfPCellLichTiemSauKhiSinh.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellLichTiemSauKhiSinh.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellLichTiemSauKhiSinh.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellLichTiemSauKhiSinh.setFixedHeight(20);
                        pdfPCellLichTiemSauKhiSinh.setRowspan(1);
                        pdfPTableLichTiemSauKhiSinh.addCell(pdfPCellLichTiemSauKhiSinh);

                        pdfPCellLichTiemSauKhiSinh = new PdfPCell(new Phrase("PRRS (21 ngày)", fontCellHead));
                        pdfPCellLichTiemSauKhiSinh.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfPCellLichTiemSauKhiSinh.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        pdfPCellLichTiemSauKhiSinh.setBackgroundColor(BaseColor.GREEN);
                        pdfPCellLichTiemSauKhiSinh.setFixedHeight(20);
                        pdfPCellLichTiemSauKhiSinh.setRowspan(1);
                        pdfPTableLichTiemSauKhiSinh.addCell(pdfPCellLichTiemSauKhiSinh);

                        for (int indexR = 0; indexR < tableViewVacXin.getItems().size(); indexR++) {
                            PdfPCell pdfPCell1 = new PdfPCell(new Phrase(String.valueOf(indexR + 1)));
                            PdfPCell pdfPCell2 = new PdfPCell(new Phrase(String.valueOf(tableViewVacXin.getItems().get(indexR).getMS_Tai_Lon())));
                            PdfPCell pdfPCell3 = new PdfPCell(new Phrase(String.valueOf(tableViewVacXin.getItems().get(indexR).getChu_Ky())));
                            PdfPCell pdfPCell4 = new PdfPCell(new Phrase(tableViewVacXin.getItems().get(indexR).getFE_COC_3_Ngay()));
                            PdfPCell pdfPCell5 = new PdfPCell(new Phrase(tableViewVacXin.getItems().get(indexR).getSuyen_14_Ngay()));
                            PdfPCell pdfPCell6 = new PdfPCell(new Phrase(tableViewVacXin.getItems().get(indexR).getPARVO()));

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

                            if (indexR % 2 != 0) {
                                pdfPCell1.setBackgroundColor(new BaseColor(237, 234, 252));
                                pdfPCell2.setBackgroundColor(new BaseColor(237, 234, 252));
                                pdfPCell3.setBackgroundColor(new BaseColor(237, 234, 252));
                                pdfPCell4.setBackgroundColor(new BaseColor(237, 234, 252));
                                pdfPCell5.setBackgroundColor(new BaseColor(237, 234, 252));
                                pdfPCell6.setBackgroundColor(new BaseColor(237, 234, 252));
                            }

                            pdfPTableLichTiemSauKhiSinh.addCell(pdfPCell1);
                            pdfPTableLichTiemSauKhiSinh.addCell(pdfPCell2);
                            pdfPTableLichTiemSauKhiSinh.addCell(pdfPCell3);
                            pdfPTableLichTiemSauKhiSinh.addCell(pdfPCell4);
                            pdfPTableLichTiemSauKhiSinh.addCell(pdfPCell5);
                            pdfPTableLichTiemSauKhiSinh.addCell(pdfPCell6);

                        }

                        paragraph.add(pdfPTableLichTiemSauKhiSinh);

                        document.add(paragraph);
                        document.close();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Tạo File Thành Công");
                        alert.setHeaderText(null);
                        alert.setContentText("Bao_Cao_Chi_Tiet_Lich_Tiem_Heo_Nai.xlsx, Bao_Cao_Chi_Tiet_Lich_Tiem_Heo_Nai.pdf đã được tạo.");
                        alert.showAndWait();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Không Tìm Thấy Dữ Liệu");
                    alert.setHeaderText(null);
                    alert.setContentText("Không có dữ liệu nào trong bảng!");
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

                // set button
                btnThem.setDisable(true);
                btnSua.setDisable(false);
                btnTaoMoi.setDisable(false);
                btnXoa.setDisable(false);
                txtMaTaiLon_QuanLyLonNai.setEditable(false);
                datePickerNgayNhap.setDisable(true);
                datePickerNgayPhoi.setDisable(true);

                kiemtraButtonThemHienAn = false;

//                ChiTietLonNai chiTietLonNai = tableViewKiemTraChuKyMangThai.getSelectionModel().getSelectedItem();
                lay_MS_Tai_Lon_Tam_Thoi = tableViewVacXin.getSelectionModel().getSelectedItem().getMS_Tai_Lon();
                lay_Chu_Ky_Tam_Thoi = tableViewVacXin.getSelectionModel().getSelectedItem().getChu_Ky();
                ChiTietLonNai_Service chiTietLonNai_caThe_service = new ChiTietLonNai_ServiceImpl();
                List<ChiTietLonNai> list = chiTietLonNai_caThe_service.LayChiTietLonNai_CaThe(tableViewVacXin.getSelectionModel().getSelectedItem().getMS_Tai_Lon(), tableViewVacXin.getSelectionModel().getSelectedItem().getChu_Ky());
                for (int i = 0; i < list.size(); i++) {
                    ChiTietLonNai chiTietLonNai_caThe = list.get(i);
                    int MS_Tai_Lon = chiTietLonNai_caThe.getMS_Tai_Lon();
                    Date Ngay_Nhap_Lon_Nai = chiTietLonNai_caThe.getNgay_Nhap_Lon_Nai();
                    Date Ngay_Phoi = chiTietLonNai_caThe.getNgay_Phoi();
                    Date Ngay_De = chiTietLonNai_caThe.getNgay_De();

                    Ham ham = new Ham();
                    txtMaTaiLon_QuanLyLonNai.setText(Integer.toString(MS_Tai_Lon));
                    datePickerNgayNhap.setValue(ham.convertToLocalDateViaSqlDate(Ngay_Nhap_Lon_Nai));
                    datePickerNgayPhoi.setValue(ham.convertToLocalDateViaSqlDate(Ngay_Phoi));
                    txtChuyenSangChuongDe.setText(ham.DateToString(ham.TruNgay(Ngay_De, 10)));
                }
            }
        });
    }

    private void HienThiNgayNhap_NgayPhoi_Theo_MS_Tai_Lon_TableView_KiemTraChuKyMangThai() {
        tableViewKiemTraChuKyMangThai.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                // set button
                btnThem.setDisable(true);
                btnSua.setDisable(false);
                btnTaoMoi.setDisable(false);
                btnXoa.setDisable(false);
                txtMaTaiLon_QuanLyLonNai.setEditable(false);
                datePickerNgayNhap.setDisable(true);
                datePickerNgayPhoi.setDisable(true);

                kiemtraButtonThemHienAn = false;

                lay_MS_Tai_Lon_Tam_Thoi = tableViewKiemTraChuKyMangThai.getSelectionModel().getSelectedItem().getMS_Tai_Lon();
                lay_Chu_Ky_Tam_Thoi = tableViewKiemTraChuKyMangThai.getSelectionModel().getSelectedItem().getChu_Ky();
                ChiTietLonNai_Service chiTietLonNai_caThe_service = new ChiTietLonNai_ServiceImpl();
                List<ChiTietLonNai> list = chiTietLonNai_caThe_service.LayChiTietLonNai_CaThe(tableViewKiemTraChuKyMangThai.getSelectionModel().getSelectedItem().getMS_Tai_Lon(), tableViewKiemTraChuKyMangThai.getSelectionModel().getSelectedItem().getChu_Ky());
                for (int i = 0; i < list.size(); i++) {
                    ChiTietLonNai chiTietLonNai_caThe = list.get(i);
                    int MS_Tai_Lon = chiTietLonNai_caThe.getMS_Tai_Lon();
                    Date Ngay_Nhap_Lon_Nai = chiTietLonNai_caThe.getNgay_Nhap_Lon_Nai();
                    Date Ngay_Phoi = chiTietLonNai_caThe.getNgay_Phoi();
                    Date Ngay_De = chiTietLonNai_caThe.getNgay_De();

                    Ham ham = new Ham();
                    txtMaTaiLon_QuanLyLonNai.setText(Integer.toString(MS_Tai_Lon));
                    datePickerNgayNhap.setValue(ham.convertToLocalDateViaSqlDate(Ngay_Nhap_Lon_Nai));
                    datePickerNgayPhoi.setValue(ham.convertToLocalDateViaSqlDate(Ngay_Phoi));
                    txtChuyenSangChuongDe.setText(ham.DateToString(ham.TruNgay(Ngay_De, 10)));
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
        listDetails = service.getAll();

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

    public void HienThiTableView_VacXin() {
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
        listDetails = service.getAll();

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

    public void LoadData(int i) {
        if (i > 0) {
            HienThiTableView_KiemTraChuKyMangThai();
            HienThiTableView_VacXin();
        }
    }

    public void ChanngedThem() {
        System.out.println("kiemtraButtonThemHienAn : " + kiemtraButtonThemHienAn);
        if (kiemtraButtonThemHienAn) {
            Ham ham = new Ham();
            int tam = 0;
            try {
                int MS_Tai_Lon = Integer.parseInt(txtMaTaiLon_QuanLyLonNai.getText().trim());
                for (int i = 0; i < listDetails.size(); i++) {
                    if (listDetails.get(i).getMS_Tai_Lon() == MS_Tai_Lon) {
                        datePickerNgayNhap.setValue(ham.convertToLocalDateViaSqlDate(listDetails.get(i).getNgay_Nhap_Lon_Nai()));
                        tam++;
                    }
                }

                if (tam < 0) {
                    datePickerNgayNhap.setDisable(true);
                    datePickerNgayPhoi.setDisable(true);
                } else if (tam > 0) {
                    datePickerNgayNhap.setDisable(true);
                    datePickerNgayPhoi.setDisable(false);
//                datePickerNgayPhoi.setValue(null);
                } else {
                    datePickerNgayNhap.setDisable(false);
                    datePickerNgayPhoi.setDisable(false);
//                datePickerNgayNhap.setValue(null);
//                datePickerNgayPhoi.setValue(null);
                }
                System.out.println(tam);
            } catch (NumberFormatException e) {

            }
            btnThem.setDisable(!(KiemTra_MS_Tai_Lon() && KiemTraDatePicker()));
        }
    }

    private boolean KiemTraDatePicker() {
        if (datePickerNgayPhoi.getValue().compareTo(datePickerNgayNhap.getValue()) > 0) {
            return true;
        }
        return false;
    }

    private boolean KiemTra_MS_Tai_Lon() {
        boolean ktra = false;
        try {
            int MS_Tai_Lon = Integer.parseInt(txtMaTaiLon_QuanLyLonNai.getText().trim());
            if (MS_Tai_Lon > 0) {
                ktra = true;
            } else {
                ktra = false;
            }
        } catch (NumberFormatException e) {
            System.out.println("lỗi so");
            ktra = false;
        }
        return ktra;
    }

    private void generateReport() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Copy of Report");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.setInitialFileName("Log Entries.pdf");
        FileChooser.ExtensionFilter pdfExtensionFilter =
                new FileChooser.ExtensionFilter(
                        "PDF - Portable Document Format (.pdf)", "*.pdf");
        fileChooser.getExtensionFilters().add(pdfExtensionFilter);
        fileChooser.setSelectedExtensionFilter(pdfExtensionFilter);
//        File file = fileChooser.showSaveDialog(currentStage);

//        if (file != null) {
//            try {
//                exportTableAsPDF(file);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }
}
