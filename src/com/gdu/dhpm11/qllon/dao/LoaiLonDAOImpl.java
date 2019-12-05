package com.gdu.dhpm11.qllon.dao;

import com.gdu.dhpm11.qllon.model.LoaiLon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiLonDAOImpl implements LoaiLonDAO {
    @Override
    public List<LoaiLon> getListLonNaiDAO() {
        Connection cons = DBConnect.getJDBCConnection();
        String sql = "SELECT * FROM `loai_lon`";
        List<LoaiLon> loaiLonList = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiLon loaiLon = new LoaiLon();
                loaiLon.setMS_Loai_Lon(rs.getInt("MS_Loai_Lon"));
                loaiLon.setTen_Loai_Lon(rs.getString("Ten_Loai_Lon"));

                loaiLonList.add(loaiLon);
            }
            ps.close();
            rs.close();
            cons.close();
            return loaiLonList;
        } catch (SQLException e) {
            System.out.println("Loi  public List<LoaiLon> getList() {} trong package package com.gdu.dhpm11.qllon.dao; : " + e.toString());
        }
        return null;
    }

    public static void main(String[] args) {
        LoaiLonDAO loaiLonDAO = new LoaiLonDAOImpl();
        System.out.println(loaiLonDAO.getListLonNaiDAO());
    }
}
