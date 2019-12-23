package com.gdu.dhpm11.qllon.dao;

import com.gdu.dhpm11.qllon.model.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ChiTietLonNai_DAOImpl implements ChiTietLonNai_DAO {
    @Override
    public List<ChiTietLonNai> getAll() {
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
            System.out.println("Loi public List<ChiTietLonNai> getAll() {} trong package com.gdu.dhpm11.qllon.dao; : " + e.toString());
        }
        return null;
    }

    @Override
    public List<ChiTietLonNai> getListChiTietLonNai(int MS_Tai_Lon, int Chu_Ky) {
        Connection cons = DBConnect.getJDBCConnection();
        String sql = "SELECT * FROM `chi_tiet_lon_nai` WHERE MS_Tai_Lon = " + MS_Tai_Lon + " AND Chu_Ky = " + Chu_Ky;
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
                chiTietLonNai_kiemTraChuKyMangThai.setChu_Ky(rs.getInt("Chu_Ky"));

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
                chiTietLonNai_vacXin.setChu_Ky(rs.getInt("Chu_Ky"));

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
    public List<ChiTietLonNai> LayChiTietLonNai_CaThe(int MS_Tai_Lon, int Chu_Ky) {
        Connection cons = DBConnect.getJDBCConnection();
        String sql = "SELECT * FROM `chi_tiet_lon_nai` WHERE MS_Tai_Lon = " + MS_Tai_Lon + " AND Chu_Ky = " + Chu_Ky;
        List<ChiTietLonNai> ChiTietLonNai_CaThe_List = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietLonNai chiTietLonNai_caThe = new ChiTietLonNai();
                chiTietLonNai_caThe.setMS_Tai_Lon(rs.getInt("MS_Tai_Lon"));
                chiTietLonNai_caThe.setNgay_Nhap_Lon_Nai(rs.getDate("Ngay_Nhap_Lon_Nai"));
                chiTietLonNai_caThe.setNgay_Phoi(rs.getDate("Ngay_Phoi"));
                chiTietLonNai_caThe.setChu_Ky(rs.getInt("Chu_Ky"));
                chiTietLonNai_caThe.setNgay_De(rs.getDate("Ngay_De"));

                ChiTietLonNai_CaThe_List.add(chiTietLonNai_caThe);
            }
            ps.close();
            rs.close();
            cons.close();
            return ChiTietLonNai_CaThe_List;
        } catch (SQLException e) {
            System.out.println("Loi public List<ChiTietLonNai> LayChiTietLonNai_CaThe(int MS_Tai_Lon, int Chu_Ky) {} trong package com.gdu.dhpm11.qllon.dao; : " + e.toString());
        }
        return null;
    }

    @Override
    public List<ChiTietLonNai> LayChiTietLonNai_CaThe(int MS_Tai_Lon) {
        Connection cons = DBConnect.getJDBCConnection();
        String sql = "SELECT * FROM `chi_tiet_lon_nai` WHERE MS_Tai_Lon = " + MS_Tai_Lon;
        List<ChiTietLonNai> ChiTietLonNai_CaThe_List = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietLonNai chiTietLonNai_caThe = new ChiTietLonNai();
                chiTietLonNai_caThe.setMS_Tai_Lon(rs.getInt("MS_Tai_Lon"));
                chiTietLonNai_caThe.setChu_Ky(rs.getInt("Chu_Ky"));

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

    @Override
    public int Xoa_ChiTietLonNai(int MS_Tai_Lon) {
        Connection cons = DBConnect.getJDBCConnection();

        String sql = "DELETE FROM `chi_tiet_lon_nai` WHERE MS_Tai_Lon = ?";
        int rs = 0;
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, MS_Tai_Lon);
            rs = ps.executeUpdate();
            ps.close();
            cons.close();
            return rs;
        } catch (SQLException e) {
            System.out.println("Loi public int Xoa_ChiTietLonNai(int MS_Tai_Lon) {} : " + e.toString());
        }

        return rs;
    }

    @Override
    public int Xoa_ChiTietLonNai(int MS_Tai_Lon, int Chu_Ky) {
        Connection cons = DBConnect.getJDBCConnection();

        String sql = "DELETE FROM `chi_tiet_lon_nai` WHERE MS_Tai_Lon = ? AND Chu_Ky = ?";
        int rs = 0;
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, MS_Tai_Lon);
            ps.setInt(2, Chu_Ky);
            rs = ps.executeUpdate();
            ps.close();
            cons.close();
            return rs;
        } catch (SQLException e) {
            System.out.println("Loi public int Xoa_ChiTietLonNai(int MS_Tai_Lon, int Chu_Ky) {} : " + e.toString());
        }

        return rs;
    }

    @Override
    public int Xoa_LonNai(int MS_Tai_Lon) {
        Connection cons = DBConnect.getJDBCConnection();

        String sql = "DELETE FROM `lon` WHERE `lon`.`MS_Tai_Lon` = ?";
        int rs = 0;
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, MS_Tai_Lon);
            rs = ps.executeUpdate();
            ps.close();
            cons.close();
            return rs;
        } catch (SQLException e) {
            System.out.println("Loi public int Xoa_LonNai(int MS_Tai_Lon) {} : " + e.toString());
        }

        return rs;
    }

    @Override
    public int Them_ChiTietLonNai(int MS_Tai_Lon, Date Ngay_Nhap_Lon_Nai, Date Ngay_Phoi, Date Ngay_De, int Chu_Ky) {
        Connection cons = DBConnect.getJDBCConnection();

        String sql = "INSERT INTO `chi_tiet_lon_nai` (`Ngay_Nhap_Lon_Nai`, `Ngay_Phoi`,`Ngay_De`, `Chu_Ky`, `MS_Tai_Lon`) VALUES (?, ?, ?, ?, ?);";
        int rs = 0;
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setDate(1, Ngay_Nhap_Lon_Nai);
            ps.setDate(2, Ngay_Phoi);
            ps.setDate(3, Ngay_De);
            ps.setInt(4, Chu_Ky);
            ps.setInt(5, MS_Tai_Lon);
            rs = ps.executeUpdate();
            ps.close();
            cons.close();
            return rs;
        } catch (SQLException e) {
            System.out.println("Loi public int Them_ChiTietLonNai(int MS_Tai_Lon, Date Ngay_Nhap_Lon_Nai, Date Ngay_Phoi, Date Ngay_De) {} : " + e.toString());
        }
        return rs;
    }

    @Override
    public int Them_LonNai(int MS_Tai_Lon, String Tuoi_Lon) {
        Connection cons = DBConnect.getJDBCConnection();

        String sql = "INSERT INTO `lon` (`MS_Tai_Lon`, `Gioi_Tinh_Lon`, `Tuoi_Lon`, `MS_Loai_Lon`) VALUES (?, ?, ?, ?);";
        int rs = 0;
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, MS_Tai_Lon);
            ps.setString(2, "Cái");
            ps.setString(3, Tuoi_Lon);
            ps.setInt(4, 1);
            rs = ps.executeUpdate();
            ps.close();
            cons.close();
            return rs;
        } catch (SQLException e) {
            System.out.println("Loi public int Them_ChiTietLonNai(int MS_Tai_Lon, Date Ngay_Nhap_Lon_Nai, Date Ngay_Phoi, Date Ngay_De) {} : " + e.toString());
        }
        return rs;
    }

    @Override
    public List<ChiTietLonNai> KiemTraMS_Tai_Lon(int MS_Tai_Lon) {
        Connection cons = DBConnect.getJDBCConnection();
        String sql = "SELECT lon.MS_Tai_Lon, chi_tiet_lon_nai.Chu_Ky FROM lon INNER JOIN chi_tiet_lon_nai ON chi_tiet_lon_nai.MS_Tai_Lon = lon.MS_Tai_Lon WHERE lon.MS_Tai_Lon = " + MS_Tai_Lon;
        List<ChiTietLonNai> listKiemTra = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietLonNai listCaThe = new ChiTietLonNai();
                listCaThe.setMS_Tai_Lon(rs.getInt("MS_Tai_Lon"));
                listCaThe.setChu_Ky(rs.getInt("Chu_Ky"));

                listKiemTra.add(listCaThe);
            }
            ps.close();
            rs.close();
            cons.close();
            return listKiemTra;
        } catch (SQLException e) {
            System.out.println("Loi List<ChiTietLonNai> KiemTraMS_Tai_Lon(int MS_Tai_Lon) {} trong package com.gdu.dhpm11.qllon.dao; : " + e.toString());
        }
        return null;
    }

    @Override
    public int CapNhatChiTietLonNai(int MS_tai_Lon, int Chu_Ky, int So_Con_Con, int So_Con_Chet, Date Ngay_Nhap, Date Ngay_Phoi, Date Ngay_De) {
        Connection cons = DBConnect.getJDBCConnection();

        String sql = "UPDATE `chi_tiet_lon_nai` SET `Ngay_Nhap_Lon_Nai`= ?,`Ngay_Phoi`=?,`Ngay_De`=?,`So_Con_Con`=?,`So_Con_Chet`=? WHERE MS_Tai_Lon= ? AND Chu_Ky = ?";
        int rs = 0;
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setDate(1, Ngay_Nhap);
            ps.setDate(2, Ngay_Phoi);
            ps.setDate(3, Ngay_De);
            ps.setInt(4, So_Con_Con);
            ps.setInt(5, So_Con_Chet);
            ps.setInt(6, MS_tai_Lon);
            ps.setInt(7, Chu_Ky);
            rs = ps.executeUpdate();
            ps.close();
            cons.close();
            return rs;
        } catch (SQLException e) {
            System.out.println("Loi public void CapNhatChiTietLonNai(int MS_tai_Lon, int Chu_Ky, int So_Con_Con, int So_Con_Chet, Date Ngay_Nhap, Date Ngay_Phoi, Date Ngay_De) {} : " + e.toString());
        }
        return rs;
    }

    @Override
    public List<PieChartClassModel> getPieChart() {
        Connection cons = DBConnect.getJDBCConnection();
        String sql = "SELECT MS_Tai_Lon, So_Con_Con, So_Con_Chet FROM `chi_tiet_lon_nai` ORDER BY MS_Tai_Lon ASC";
        List<PieChartClassModel> chiTietLonNaiList = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PieChartClassModel chiTietLonNai = new PieChartClassModel();
                chiTietLonNai.setMS_Tai_Lon(rs.getInt("MS_Tai_Lon"));
                chiTietLonNai.setSo_Con_Con(rs.getInt("So_Con_Con"));
                chiTietLonNai.setSo_Con_Chet(rs.getInt("So_Con_Chet"));

                chiTietLonNaiList.add(chiTietLonNai);
            }
            ps.close();
            rs.close();
            cons.close();
            return chiTietLonNaiList;
        } catch (SQLException e) {
            System.out.println("Loi public List<ChiTietLonNai> getPieChart() {} trong package com.gdu.dhpm11.qllon.dao; : " + e.toString());
        }
        return null;
    }

    @Override
    public List<BarChartClassModel> getBarChart(int MS_Tai_Lon) {
        Connection cons = DBConnect.getJDBCConnection();
        String sql = "SELECT MS_Tai_Lon, Chu_Ky, So_Con_Con, So_Con_Chet FROM `chi_tiet_lon_nai` WHERE MS_Tai_Lon = " + MS_Tai_Lon;
        List<BarChartClassModel> chiTietLonNaiList = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BarChartClassModel chiTietLonNai = new BarChartClassModel();
                chiTietLonNai.setMS_Tai_Lon(rs.getInt("MS_Tai_Lon"));
                chiTietLonNai.setChu_Ky(rs.getInt("Chu_Ky"));
                chiTietLonNai.setSo_Con_Con(rs.getInt("So_Con_Con"));
                chiTietLonNai.setSo_Con_Chet(rs.getInt("So_Con_Chet"));

                chiTietLonNaiList.add(chiTietLonNai);
            }
            ps.close();
            rs.close();
            cons.close();
            return chiTietLonNaiList;
        } catch (SQLException e) {
            System.out.println("Loi public List<BarChartClassModel> getBarChart(int MS_Tai_Lon) {} trong package com.gdu.dhpm11.qllon.dao; : " + e.toString());
        }
        return null;
    }

    @Override
    public List<BaoCaoChiTietLonNai> LayBaoCaoChiTietLonNai(String tuNgay, String denNgay) {
        Connection cons = DBConnect.getJDBCConnection();
        String sql = "SELECT chi_tiet_lon_nai.MS_Tai_Lon, chi_tiet_lon_nai.Ngay_Phoi, chi_tiet_lon_nai.Ngay_De, chi_tiet_lon_nai.So_Con_Con, chi_tiet_lon_nai.So_Con_Chet, chi_tiet_lon_nai.Ngay_Nhap_Lon_Nai FROM chi_tiet_lon_nai INNER JOIN lon ON chi_tiet_lon_nai.MS_Tai_Lon=lon.MS_Tai_Lon WHERE Ngay_De BETWEEN '" + tuNgay + " 00:00:00' AND '" + denNgay + " 23:59:59' ORDER BY Ngay_De";
        List<BaoCaoChiTietLonNai> chiTietLonNaiList = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            int dem = 0;
            while (rs.next()) {
                BaoCaoChiTietLonNai chiTietLonNai = new BaoCaoChiTietLonNai();
                chiTietLonNai.setSTT(rs.getRow());
                chiTietLonNai.setMS_Tai(rs.getInt("MS_Tai_Lon"));
                chiTietLonNai.setNgay_Phoi(rs.getDate("Ngay_Phoi"));
                chiTietLonNai.setNgay_De(rs.getDate("Ngay_De"));
                int So_Con_Con = rs.getInt("So_Con_Con");
                int So_Con_Chet = rs.getInt("So_Con_Chet");
                chiTietLonNai.setTong_So_Lon(So_Con_Con);
                chiTietLonNai.setSo_Lon_Chet(So_Con_Chet);
                chiTietLonNai.setTong_So_Lon_Song(So_Con_Con - So_Con_Chet);
                chiTietLonNai.setNgay_Nhap(rs.getDate("Ngay_Nhap_Lon_Nai"));

                chiTietLonNaiList.add(chiTietLonNai);
            }
            ps.close();
            rs.close();
            cons.close();
            return chiTietLonNaiList;
        } catch (SQLException e) {
            System.out.println("public List<BaoCaoChiTietLonNai> LayBaoCaoChiTietLonNai(String tuNgay, String denNgay) {} trong package com.gdu.dhpm11.qllon.dao; : " + e.toString());
        }
        return null;
    }

    @Override
    public List<BaoCaoChiTietLonNai_LichTiem> LayBaoCaoChiTietLonNai_LichTiem() {
        Connection cons = DBConnect.getJDBCConnection();
        String sql = "SELECT chi_tiet_lon_nai.MS_Tai_Lon, chi_tiet_lon_nai.Ngay_Phoi, chi_tiet_lon_nai.Ngay_De, chi_tiet_lon_nai.So_Con_Con, chi_tiet_lon_nai.So_Con_Chet, chi_tiet_lon_nai.Ngay_Nhap_Lon_Nai FROM chi_tiet_lon_nai INNER JOIN lon ON chi_tiet_lon_nai.MS_Tai_Lon=lon.MS_Tai_Lon WHERE Ngay_De BETWEEN ' 00:00:00' AND ' 23:59:59' ORDER BY Ngay_De";
        List<BaoCaoChiTietLonNai> chiTietLonNaiList = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            int dem = 0;
            while (rs.next()) {
                BaoCaoChiTietLonNai chiTietLonNai = new BaoCaoChiTietLonNai();
                chiTietLonNai.setSTT(rs.getRow());
                chiTietLonNai.setMS_Tai(rs.getInt("MS_Tai_Lon"));
                chiTietLonNai.setNgay_Phoi(rs.getDate("Ngay_Phoi"));
                chiTietLonNai.setNgay_De(rs.getDate("Ngay_De"));
                int So_Con_Con = rs.getInt("So_Con_Con");
                int So_Con_Chet = rs.getInt("So_Con_Chet");
                chiTietLonNai.setTong_So_Lon(So_Con_Con);
                chiTietLonNai.setSo_Lon_Chet(So_Con_Chet);
                chiTietLonNai.setTong_So_Lon_Song(So_Con_Con - So_Con_Chet);
                chiTietLonNai.setNgay_Nhap(rs.getDate("Ngay_Nhap_Lon_Nai"));

                chiTietLonNaiList.add(chiTietLonNai);
            }
            ps.close();
            rs.close();
            cons.close();
            return null;
        } catch (SQLException e) {
            System.out.println("public List<BaoCaoChiTietLonNai> LayBaoCaoChiTietLonNai(String tuNgay, String denNgay) {} trong package com.gdu.dhpm11.qllon.dao; : " + e.toString());
        }
        return null;
    }

}
