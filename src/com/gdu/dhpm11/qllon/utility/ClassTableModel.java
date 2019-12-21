package com.gdu.dhpm11.qllon.utility;

import com.gdu.dhpm11.qllon.model.BaoCaoChiTietLonNai;
import com.gdu.dhpm11.qllon.model.ChiTietLonNai;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
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
                duLieuTableView_KiemTraChuKyMangThai.add(new Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai(chiTietLonNai_kiemTraChuKyMangThai.getMS_Tai_Lon(), chiTietLonNai_kiemTraChuKyMangThai.getChu_Ky(), ham.DateToString(chu_Ky_21_Ngay), ham.DateToString(chu_Ky_42_Ngay), ham.DateToString(chu_Ky_84_Ngay), ham.DateToString(chiTietLonNai_kiemTraChuKyMangThai.getNgay_De())));
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
                duLieuTableView_VacXin.add(new Class_TableView_ChiTietLonNai_VacXin(chiTietLonNai_vacXin.getMS_Tai_Lon(), chiTietLonNai_vacXin.getChu_Ky(),
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

    public static ObservableList setTable_BaoCaoChiTietLonNai(List<BaoCaoChiTietLonNai> list) {
        ObservableList<Class_TableView_BaoCaoChiTiet_LonNai> duLieuTableView_BaoCaoChiTiet = FXCollections.observableArrayList();

        int rows = list.size();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                Ham ham = new Ham();
                BaoCaoChiTietLonNai baoCaoChiTietLonNai = list.get(i);
                int stt = baoCaoChiTietLonNai.getSTT();
                int maTai = baoCaoChiTietLonNai.getMS_Tai();
                Date ngayPhoi = baoCaoChiTietLonNai.getNgay_Phoi();
                Date ngayDe = baoCaoChiTietLonNai.getNgay_De();
                int tongSoLon = baoCaoChiTietLonNai.getTong_So_Lon();
                int soLonChet = baoCaoChiTietLonNai.getSo_Lon_Chet();
                int tongSoLonSong = baoCaoChiTietLonNai.getTong_So_Lon_Song();
                Date ngayNhap = baoCaoChiTietLonNai.getNgay_Nhap();
                String tuoiLon = ham.TuoiLon(ngayNhap.toString(), LocalDate.now().toString()) + " ngày";
                duLieuTableView_BaoCaoChiTiet.add(new Class_TableView_BaoCaoChiTiet_LonNai(stt, maTai, ham.DateToString(ngayPhoi), ham.DateToString(ngayDe), tongSoLon, soLonChet, tongSoLonSong, tuoiLon));
            }
        }
        return duLieuTableView_BaoCaoChiTiet;
    }

    public static ObservableList<Class_TableView_BaoCao_LonNai> setTable_BaoCaoLonNai(List<BaoCaoChiTietLonNai> list) {

        int soConSinhRa = 0, soConChet = 0, soConConLai = 0, soNaiChuaDe = 0, soNaiDe = 0;

        int rows = list.size();
        Date ngayHienTai = new Date();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                BaoCaoChiTietLonNai baoCaoChiTietLonNai = list.get(i);

                soConSinhRa += baoCaoChiTietLonNai.getTong_So_Lon();
                soConChet += baoCaoChiTietLonNai.getSo_Lon_Chet();
                soConConLai += baoCaoChiTietLonNai.getTong_So_Lon_Song();
                if (baoCaoChiTietLonNai.getNgay_De().compareTo(ngayHienTai) > 0) {
                    soNaiChuaDe++;
                } else {
                    soNaiDe++;
                }
            }
            System.out.println("-------------------");
            System.out.println(soNaiChuaDe);
            System.out.println(soNaiDe);
            System.out.println(soConSinhRa);
            System.out.println(soConChet);
            System.out.println(soConConLai);
        }
        Class_TableView_BaoCao_LonNai data1 = new Class_TableView_BaoCao_LonNai(1, "Số Nái Chữa", soNaiChuaDe);
        Class_TableView_BaoCao_LonNai data2 = new Class_TableView_BaoCao_LonNai(2, "Số Nái Đẻ", soNaiDe);
        Class_TableView_BaoCao_LonNai data3 = new Class_TableView_BaoCao_LonNai(3, "Số Con Sinh Ra", soConSinhRa);
        Class_TableView_BaoCao_LonNai data4 = new Class_TableView_BaoCao_LonNai(4, "Số Con Chết", soConChet);
        Class_TableView_BaoCao_LonNai data5 = new Class_TableView_BaoCao_LonNai(5, "Số Con Còn Lại", soConConLai);

        ObservableList<Class_TableView_BaoCao_LonNai> duLieuTableView_BaoCao = FXCollections.observableArrayList(data1, data2, data3, data4, data5);
        return duLieuTableView_BaoCao;
    }

}
