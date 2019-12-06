package com.gdu.dhpm11.qllon.utility;

import com.gdu.dhpm11.qllon.model.ChiTietLonNai_KiemTraChuKyMangThai;
import com.gdu.dhpm11.qllon.service.ChiTietLonNai_KiemTraChuKyMangThai_Service;
import com.gdu.dhpm11.qllon.service.ChiTietLonNai_KiemTraChuKyMangThai_ServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Date;
import java.util.List;

public class ClassTableModel {

    public static ObservableList setTable_ChiTietLonNai_KiemTraChuKyMangThai(List<ChiTietLonNai_KiemTraChuKyMangThai> danhSach_ChiTietLonNai_KiemTraChuKyMangThai) {
        ObservableList<Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai> duLieuTableView_KiemTraChuKyMangThai = FXCollections.observableArrayList();

        int rows = danhSach_ChiTietLonNai_KiemTraChuKyMangThai.size();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                ChiTietLonNai_KiemTraChuKyMangThai chiTietLonNai_kiemTraChuKyMangThai = danhSach_ChiTietLonNai_KiemTraChuKyMangThai.get(i);
//                System.out.println(chiTietLonNai_kiemTraChuKyMangThai.toString());
                Date ngay_Phoi = chiTietLonNai_kiemTraChuKyMangThai.getNgay_Phoi();
                Ham ham = new Ham();
                Date chu_Ky_21_Ngay = ham.CongNgay(ngay_Phoi, 21);
                Date chu_Ky_42_Ngay = ham.CongNgay(ngay_Phoi, 42);
                Date chu_Ky_84_Ngay = ham.CongNgay(ngay_Phoi, 84);
                duLieuTableView_KiemTraChuKyMangThai.add(new Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai(chiTietLonNai_kiemTraChuKyMangThai.getMS_Tai_Lon(), chu_Ky_21_Ngay, chu_Ky_42_Ngay, chu_Ky_84_Ngay, chiTietLonNai_kiemTraChuKyMangThai.getNgay_De()));
            }
        }
        return duLieuTableView_KiemTraChuKyMangThai;
    }

    public static void main(String[] args) {
        ChiTietLonNai_KiemTraChuKyMangThai_Service chiTietLonNai_kiemTraChuKyMangThai_service = new ChiTietLonNai_KiemTraChuKyMangThai_ServiceImpl();
        setTable_ChiTietLonNai_KiemTraChuKyMangThai(chiTietLonNai_kiemTraChuKyMangThai_service.LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai());
    }
}
