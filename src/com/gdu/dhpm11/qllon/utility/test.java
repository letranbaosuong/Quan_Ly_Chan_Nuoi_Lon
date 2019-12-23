//package com.gdu.dhpm11.qllon.utility;
//
//import com.gdu.dhpm11.qllon.model.BaoCaoChiTietLonNai_LichTiem;
//import com.gdu.dhpm11.qllon.model.ChiTietLonNai;
//import com.gdu.dhpm11.qllon.service.ChiTietLonNai_Service;
//import com.gdu.dhpm11.qllon.service.ChiTietLonNai_ServiceImpl;
//
//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.beans.property.ReadOnlyObjectWrapper;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.stage.Stage;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//
//public class test extends Application {
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws IOException {
//        System.out.println("ok");
//        TableView<Class_TableView_BaoCaoLichTiem> tbData = new TableView<>();
//        System.out.println("ok1");
//        TableColumn<Class_TableView_BaoCaoLichTiem, Integer> stt = new TableColumn<>("");
//        TableColumn<Class_TableView_BaoCaoLichTiem, Integer> maTai = new TableColumn<>("");
//        TableColumn<Class_TableView_BaoCaoLichTiem, Integer> chuKy = new TableColumn<>("");
////        TableColumn<ChiTietLonNai, Date> chuKy_21Ngay = new TableColumn<ChiTietLonNai, Date>("");
////        TableColumn<ChiTietLonNai, Date> chuKy_42Ngay = new TableColumn<ChiTietLonNai, Date>("");
////        TableColumn<ChiTietLonNai, Date> chuKy_84Ngay = new TableColumn<ChiTietLonNai, Date>("");
////        TableColumn<ChiTietLonNai, Date> ngayDe = new TableColumn<ChiTietLonNai, Date>("");
////        TableColumn<ChiTietLonNai, Date> ta = new TableColumn<ChiTietLonNai, Date>("");
////        TableColumn<ChiTietLonNai, Date> ecoli = new TableColumn<ChiTietLonNai, Date>("");
////        TableColumn<ChiTietLonNai, Date> tayGiun = new TableColumn<ChiTietLonNai, Date>("");
////        TableColumn<ChiTietLonNai, Date> parvo = new TableColumn<ChiTietLonNai, Date>("");
////        TableColumn<ChiTietLonNai, Date> fe_coc = new TableColumn<ChiTietLonNai, Date>("");
////        TableColumn<ChiTietLonNai, Date> suyen = new TableColumn<ChiTietLonNai, Date>("");
////        TableColumn<ChiTietLonNai, Date> prrs = new TableColumn<ChiTietLonNai, Date>("");
//
//        stt.setCellValueFactory(column -> new ReadOnlyObjectWrapper(tbData.getItems().indexOf(column.getValue()) + 1));
//        maTai.setCellValueFactory(new PropertyValueFactory<>("MS_Tai_Lon"));
//        chuKy.setCellValueFactory(new PropertyValueFactory<>("Chu_Ky"));
////        chuKy_21Ngay.setCellValueFactory(new PropertyValueFactory<ChiTietLonNai, Date>("Chu_Ky_21_Ngay"));
////        chuKy_42Ngay.setCellValueFactory(
////                new PropertyValueFactory<ChiTietLonNai, Date>("Chu_Ky_42_Ngay"));
////        chuKy_84Ngay.setCellValueFactory(
////                new PropertyValueFactory<ChiTietLonNai, Date>("Chu_Ky_84_Ngay"));
////        ngayDe.setCellValueFactory(
////                new PropertyValueFactory<ChiTietLonNai, Date>("Ngay_De_Du_Kien"));
////        ta.setCellValueFactory(
////                new PropertyValueFactory<ChiTietLonNai, Date>("Ta"));
////        ecoli.setCellValueFactory(new PropertyValueFactory<ChiTietLonNai, Date>("ECOLI"));
////        tayGiun.setCellValueFactory(
////                new PropertyValueFactory<ChiTietLonNai, Date>("Tay_Giun"));
////        parvo.setCellValueFactory(
////                new PropertyValueFactory<ChiTietLonNai, Date>("PARVO"));
////        fe_coc.setCellValueFactory(
////                new PropertyValueFactory<ChiTietLonNai, Date>("FE_COC_3_Ngay"));
////        suyen.setCellValueFactory(new PropertyValueFactory<ChiTietLonNai, Date>("Suyen_14_Ngay"));
////        prrs.setCellValueFactory(new PropertyValueFactory<ChiTietLonNai, Date>("PRRS_21_Ngay"));
//        ChiTietLonNai_Service service = new ChiTietLonNai_ServiceImpl();
//        List<BaoCaoChiTietLonNai_LichTiem> listChiTietLonNai = service.LayBaoCaoChiTietLonNai();
//        ObservableList<Class_TableView_BaoCaoLichTiem> ChiTietLonNai123 = FXCollections
//                .observableArrayList(listChiTietLonNai);
//        tbData.setItems(ChiTietLonNai123);
//        ObservableList<TableColumn<Class_TableView_BaoCaoLichTiem, ?>> columns = tbData.getColumns();
//        columns.add(stt);
//        columns.add(maTai);
//        columns.add(chuKy);
////        columns.add(chuKy_21Ngay);
////        columns.add(chuKy_42Ngay);
////        columns.add(chuKy_84Ngay);
////        columns.add(ngayDe);
////        columns.add(ta);
////        columns.add(ecoli);
////        columns.add(tayGiun);
////        columns.add(parvo);
////        columns.add(fe_coc);
////        columns.add(prrs);
//        Workbook workbook = new HSSFWorkbook();
//        Sheet spreadsheet = workbook.createSheet("sample");
//
//        Row row = spreadsheet.createRow(0);
//
//        for (int j = 0; j < tbData.getColumns().size(); j++) {
//            row.createCell(j).setCellValue(tbData.getColumns().get(j).getText());
//        }
//
//        for (int i = 0; i < tbData.getItems().size(); i++) {
//            if (i == 0) {
//                row.createCell(0).setCellValue("STT");
//                row.createCell(1).setCellValue("Chu kỳ");
//                row.createCell(2).setCellValue("Mã tai");
////                row.createCell(2).setCellValue("Chu Kỳ 21 ngày");
////                row.createCell(3).setCellValue("Chu Kỳ 42 ngày");
////                row.createCell(4).setCellValue("Chu Kỳ 84 ngày");
////                row.createCell(5).setCellValue("Ngày đẻ");
////                row.createCell(6).setCellValue("Tả");
////                row.createCell(7).setCellValue("ECOLI");
////                row.createCell(8).setCellValue("Tẩy Giun");
////                row.createCell(9).setCellValue("PARVO");
////                row.createCell(10).setCellValue("FE_COC");
////                row.createCell(11).setCellValue("PRRS");
//            }
//            row = spreadsheet.createRow(i + 1);
//
//            for (int j = 0; j < tbData.getColumns().size(); j++) {
//                if (tbData.getColumns().get(j).getCellData(i) != null) {
//                    row.createCell(j).setCellValue(tbData.getColumns().get(j).getCellData(i).toString());
//                } else {
//                    row.createCell(j).setCellValue("");
//                }
//            }
//        }
//
//        FileOutputStream fileOut = new FileOutputStream("danh_sach_hoc_sinh.xls");
//        workbook.write(fileOut);
//        fileOut.close();
//        System.out.println("done");
//        Platform.exit();
//
//    }
//
//}

package com.gdu.dhpm11.qllon.utility;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        TableView<Person> table = new TableView<Person>();

        ObservableList<Person> teamMembers = getTeamMembers();
        table.setItems(teamMembers);

        TableColumn<Person,String> firstNameCol = new TableColumn<Person,String>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        TableColumn<Person,String> lastNameCol = new TableColumn<Person,String>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));

        ObservableList<TableColumn<Person, ?>> columns = table.getColumns();
        columns.add(firstNameCol);
        columns.add(lastNameCol);

        Workbook workbook = new HSSFWorkbook();
        Sheet spreadsheet = workbook.createSheet("sample");

        Row row = spreadsheet.createRow(0);

        for (int j = 0; j < table.getColumns().size(); j++) {
            row.createCell(j).setCellValue(table.getColumns().get(j).getText());
        }

        for (int i = 0; i < table.getItems().size(); i++) {
            row = spreadsheet.createRow(i + 1);
            for (int j = 0; j < table.getColumns().size(); j++) {
                if(table.getColumns().get(j).getCellData(i) != null) {
                    row.createCell(j).setCellValue(table.getColumns().get(j).getCellData(i).toString());
                }
                else {
                    row.createCell(j).setCellValue("");
                }
            }
        }

        FileOutputStream fileOut = new FileOutputStream("workbook.xls");
        workbook.write(fileOut);
        fileOut.close();

        Platform.exit();

    }

    private ObservableList<Person> getTeamMembers() {

        ObservableList<Person> people = FXCollections.observableArrayList();
        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Doe");
        people.add(person1);
        people.add(person1);
        people.add(person1);
        people.add(person1);
        people.add(person1);
        people.add(person1);

        Person person2 = new Person();
        person2.setFirstName("Jane");
        person2.setLastName("Doe");
        people.add(person2);
        people.add(person2);
        people.add(person2);
        people.add(person2);
        people.add(person2);

        return people;
    }

    public class Person {
        private StringProperty firstName;
        public void setFirstName(String value) { firstNameProperty().set(value); }
        public String getFirstName() { return firstNameProperty().get(); }
        public StringProperty firstNameProperty() {
            if (firstName == null) firstName = new SimpleStringProperty(this, "firstName");
            return firstName;
        }

        private StringProperty lastName;
        public void setLastName(String value) { lastNameProperty().set(value); }
        public String getLastName() { return lastNameProperty().get(); }
        public StringProperty lastNameProperty() {
            if (lastName == null) lastName = new SimpleStringProperty(this, "lastName");
            return lastName;
        }
    }
}