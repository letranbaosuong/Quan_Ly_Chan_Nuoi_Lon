package com.gdu.dhpm11.qllon.dao;

import com.gdu.dhpm11.qllon.model.ChiTietLonNai_KiemTraChuKyMangThai;
import com.gdu.dhpm11.qllon.model.ChiTietLonNai_VacXin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChiTietLonNai_VacXin_DAOImpl implements ChiTietLonNai_VacXin_DAO {
    @Override
    public List<ChiTietLonNai_VacXin> LayDanhSach_ChiTietLonNai_VacXin() {
        Connection cons = DBConnect.getJDBCConnection();
        String sql = "SELECT * FROM `chi_tiet_lon_nai`";
        List<ChiTietLonNai_VacXin> ChiTietLonNai_VacXin_List = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietLonNai_VacXin chiTietLonNai_vacXin = new ChiTietLonNai_VacXin();
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
            System.out.println("Loi public List<ChiTietLonNai_VacXin> LayDanhSach_ChiTietLonNai_VacXin() {} trong package com.gdu.dhpm11.qllon.dao; : " + e.toString());
        }
        return null;
    }
}
