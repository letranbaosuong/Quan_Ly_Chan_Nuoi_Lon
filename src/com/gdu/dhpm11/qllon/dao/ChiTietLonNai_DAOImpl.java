package com.gdu.dhpm11.qllon.dao;

import com.gdu.dhpm11.qllon.model.ChiTietLonNai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChiTietLonNai_DAOImpl implements ChiTietLonNai_DAO {
    @Override
    public List<ChiTietLonNai> getListChiTietLonNaiDAO() {
        Connection cons = DBConnect.getJDBCConnection();
        String sql = "SELECT * FROM `chi_tiet_lon_nai`";
        List<ChiTietLonNai> chiTietLonNaiList = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietLonNai chiTietLonNai = new ChiTietLonNai();
                chiTietLonNai.setMS_Chi_Tiet_Lon_Nai(rs.getInt("MS_Chi_Tiet_Lon_Nai"));
                chiTietLonNai.setNgay_Nhap_Lon_Nai(rs.getDate("Ngay_Nhap_Lon_Nai"));
                chiTietLonNai.setNgay_Phoi(rs.getDate("Ngay_Phoi"));
                chiTietLonNai.setNgay_De(rs.getDate("Ngay_De"));
                chiTietLonNai.setChu_Ky(rs.getInt("Chu_Ky"));
                chiTietLonNai.setSo_Lan_Phoi(rs.getInt("So_Lan_Phoi"));
                chiTietLonNai.setSo_Lan_De(rs.getInt("So_Lan_De"));
                chiTietLonNai.setSo_Con_Con(rs.getInt("So_Con_Con"));
                chiTietLonNai.setSo_Con_Chet(rs.getInt("So_Con_Chet"));
                chiTietLonNai.setSo_Con_Chet_Kho(rs.getInt("So_Con_Chet_Kho"));
                chiTietLonNai.setSo_Con_Di_Tat(rs.getInt("So_Con_Di_Tat"));
                chiTietLonNai.setSo_Con_Chet_Theo_Me(rs.getInt("So_Con_Chet_Theo_Me"));
                chiTietLonNai.setNgay_Xuat_Lon_Nai(rs.getDate("Ngay_Xuat_Lon_Nai"));
                chiTietLonNai.setGia_Ban_Lon_Nai(rs.getInt("Gia_Ban_Lon_Nai"));
                chiTietLonNai.setMS_Tai_Lon(rs.getInt("MS_Tai_Lon"));

                chiTietLonNaiList.add(chiTietLonNai);
            }
            ps.close();
            rs.close();
            cons.close();
            return chiTietLonNaiList;
        } catch (SQLException e) {
            System.out.println("Loi public List<ChiTietLonNai> getListLonNaiDAO() {} trong package com.gdu.dhpm11.qllon.dao; : " + e.toString());
        }
        return null;
    }

    @Override
    public List<ChiTietLonNai> LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai() {
        Connection cons = DBConnect.getJDBCConnection();
        String sql = "SELECT * FROM `chi_tiet_lon_nai`";
        List<ChiTietLonNai> ChiTietLonNai_KiemTraChuKyMangThai_List = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietLonNai chiTietLonNai_kiemTraChuKyMangThai = new ChiTietLonNai();
                chiTietLonNai_kiemTraChuKyMangThai.setMS_Tai_Lon(rs.getInt("MS_Tai_Lon"));
                chiTietLonNai_kiemTraChuKyMangThai.setNgay_Nhap_Lon_Nai(rs.getDate("Ngay_Nhap_Lon_Nai"));
                chiTietLonNai_kiemTraChuKyMangThai.setNgay_Phoi(rs.getDate("Ngay_Phoi"));
                chiTietLonNai_kiemTraChuKyMangThai.setNgay_De(rs.getDate("Ngay_De"));

                ChiTietLonNai_KiemTraChuKyMangThai_List.add(chiTietLonNai_kiemTraChuKyMangThai);
            }
            ps.close();
            rs.close();
            cons.close();
            return ChiTietLonNai_KiemTraChuKyMangThai_List;
        } catch (SQLException e) {
            System.out.println("Loi public List<ChiTietLonNai> LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai() {} trong package com.gdu.dhpm11.qllon.dao; : " + e.toString());
        }
        return null;
    }

    @Override
    public List<ChiTietLonNai> LayDanhSach_ChiTietLonNai_VacXin() {
        Connection cons = DBConnect.getJDBCConnection();
        String sql = "SELECT * FROM `chi_tiet_lon_nai`";
        List<ChiTietLonNai> ChiTietLonNai_VacXin_List = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietLonNai chiTietLonNai_vacXin = new ChiTietLonNai();
                chiTietLonNai_vacXin.setMS_Tai_Lon(rs.getInt("MS_Tai_Lon"));
                chiTietLonNai_vacXin.setNgay_Phoi(rs.getDate("Ngay_Phoi"));
                chiTietLonNai_vacXin.setNgay_De(rs.getDate("Ngay_De"));

                ChiTietLonNai_VacXin_List.add(chiTietLonNai_vacXin);
            }
            ps.close();
            rs.close();
            cons.close();
            return ChiTietLonNai_VacXin_List;
        } catch (SQLException e) {
            System.out.println("Loi public List<ChiTietLonNai> LayDanhSach_ChiTietLonNai_VacXin() {} trong package com.gdu.dhpm11.qllon.dao; : " + e.toString());
        }
        return null;
    }

    @Override
    public List<ChiTietLonNai> LayChiTietLonNai_CaThe(int MS_Tai_Lon) {
        Connection cons = DBConnect.getJDBCConnection();
        String sql = "SELECT MS_Tai_Lon, Ngay_Nhap_Lon_Nai, Ngay_Phoi FROM `chi_tiet_lon_nai` WHERE MS_Tai_Lon = " + MS_Tai_Lon;
        List<ChiTietLonNai> ChiTietLonNai_CaThe_List = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietLonNai chiTietLonNai_caThe = new ChiTietLonNai();
                chiTietLonNai_caThe.setMS_Tai_Lon(rs.getInt("MS_Tai_Lon"));
                chiTietLonNai_caThe.setNgay_Nhap_Lon_Nai(rs.getDate("Ngay_Nhap_Lon_Nai"));
                chiTietLonNai_caThe.setNgay_Phoi(rs.getDate("Ngay_Phoi"));

                ChiTietLonNai_CaThe_List.add(chiTietLonNai_caThe);
            }
            ps.close();
            rs.close();
            cons.close();
            return ChiTietLonNai_CaThe_List;
        } catch (SQLException e) {
            System.out.println("Loi public List<ChiTietLonNai> LayChiTietLonNai_CaThe(int MS_Tai_Lon) {} trong package com.gdu.dhpm11.qllon.dao; : " + e.toString());
        }
        return null;
    }
}
