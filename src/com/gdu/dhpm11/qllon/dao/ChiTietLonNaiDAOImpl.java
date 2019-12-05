package com.gdu.dhpm11.qllon.dao;

import com.gdu.dhpm11.qllon.model.ChiTietLonNai;
import com.gdu.dhpm11.qllon.model.LoaiLon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChiTietLonNaiDAOImpl implements ChiTietLonNaiDAO {
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

    public static void main(String[] args) {
        ChiTietLonNaiDAO chiTietLonNaiDAO = new ChiTietLonNaiDAOImpl();
        System.out.println(chiTietLonNaiDAO.getListChiTietLonNaiDAO());
    }
}
