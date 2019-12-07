package com.gdu.dhpm11.qllon.dao;

import com.gdu.dhpm11.qllon.model.ChiTietLonNai_KiemTraChuKyMangThai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChiTietLonNai_KiemTraChuKyMangThai_DAOImpl implements ChiTietLonNai_KiemTraChuKyMangThai_DAO {
    @Override
    public List<ChiTietLonNai_KiemTraChuKyMangThai> LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai() {
        Connection cons = DBConnect.getJDBCConnection();
        String sql = "SELECT * FROM `chi_tiet_lon_nai`";
        List<ChiTietLonNai_KiemTraChuKyMangThai> ChiTietLonNai_KiemTraChuKyMangThai_List = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietLonNai_KiemTraChuKyMangThai chiTietLonNai_kiemTraChuKyMangThai = new ChiTietLonNai_KiemTraChuKyMangThai();
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
            System.out.println("Loi public List<ChiTietLonNai_KiemTraChuKyMangThai> LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai() {} trong package com.gdu.dhpm11.qllon.dao; : " + e.toString());
        }
        return null;
    }

    public static void main(String[] args) {
        ChiTietLonNai_KiemTraChuKyMangThai_DAO chiTietLonNai_kiemTraChuKyMangThaiDAO = new ChiTietLonNai_KiemTraChuKyMangThai_DAOImpl();
        System.out.println(chiTietLonNai_kiemTraChuKyMangThaiDAO.LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai());
    }
}
