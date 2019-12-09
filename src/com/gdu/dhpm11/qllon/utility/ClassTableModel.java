package com.gdu.dhpm11.qllon.utility;

import com.gdu.dhpm11.qllon.model.ChiTietLonNai;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Date;
import java.util.List;

public class ClassTableModel {

    public static ObservableList setTable_ChiTietLonNai_KiemTraChuKyMangThai(List<ChiTietLonNai> danhSach_ChiTietLonNai_KiemTraChuKyMangThai) {
        ObservableList<Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai> duLieuTableView_KiemTraChuKyMangThai = FXCollections.observableArrayList();

        int rows = danhSach_ChiTietLonNai_KiemTraChuKyMangThai.size();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                ChiTietLonNai chiTietLonNai_kiemTraChuKyMangThai = danhSach_ChiTietLonNai_KiemTraChuKyMangThai.get(i);
                Date ngay_Phoi = chiTietLonNai_kiemTraChuKyMangThai.getNgay_Phoi();
                Ham ham = new Ham();
                Date chu_Ky_21_Ngay = ham.CongNgay(ngay_Phoi, 21);
                Date chu_Ky_42_Ngay = ham.CongNgay(ngay_Phoi, 42);
                Date chu_Ky_84_Ngay = ham.CongNgay(ngay_Phoi, 84);
                duLieuTableView_KiemTraChuKyMangThai.add(new Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai(chiTietLonNai_kiemTraChuKyMangThai.getMS_Tai_Lon(), ham.DateToString(chu_Ky_21_Ngay), ham.DateToString(chu_Ky_42_Ngay), ham.DateToString(chu_Ky_84_Ngay), ham.DateToString(chiTietLonNai_kiemTraChuKyMangThai.getNgay_De())));
            }
        }
        return duLieuTableView_KiemTraChuKyMangThai;
    }

    public static ObservableList setTable_ChiTietLonNai_VacXin(List<ChiTietLonNai> danhSach_ChiTietLonNai_VacXin) {
        ObservableList<Class_TableView_ChiTietLonNai_VacXin> duLieuTableView_VacXin = FXCollections.observableArrayList();

        int rows = danhSach_ChiTietLonNai_VacXin.size();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                ChiTietLonNai chiTietLonNai_vacXin = danhSach_ChiTietLonNai_VacXin.get(i);
                Date ngay_Phoi = chiTietLonNai_vacXin.getNgay_Phoi();
                Date ngay_De = chiTietLonNai_vacXin.getNgay_De();
                Ham ham = new Ham();
                Date ta = ham.CongNgay(ngay_Phoi, 72);
                Date ecoli = ham.CongNgay(ngay_Phoi, 86);
                Date tayGiun = ham.CongNgay(ngay_Phoi, 107);
                Date parvo = ham.CongNgay(ngay_De, 14);
                Date fe_coc_3_ngay = ham.CongNgay(ngay_De, 3);
                Date suyen_14_ngay = ham.CongNgay(ngay_De, 14);
                Date prrs_21_ngay = ham.CongNgay(ngay_De, 21);
                duLieuTableView_VacXin.add(new Class_TableView_ChiTietLonNai_VacXin(chiTietLonNai_vacXin.getMS_Tai_Lon(),
                        ham.DateToString(ta),
                        ham.DateToString(ecoli),
                        ham.DateToString(tayGiun),
                        ham.DateToString(parvo),
                        ham.DateToString(fe_coc_3_ngay),
                        ham.DateToString(suyen_14_ngay),
                        ham.DateToString(prrs_21_ngay)));
            }
        }
        return duLieuTableView_VacXin;
    }

}
