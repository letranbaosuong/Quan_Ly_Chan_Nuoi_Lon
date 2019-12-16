package com.gdu.dhpm11.qllon.dao;

import com.gdu.dhpm11.qllon.model.ChiTietLonNai;

import java.sql.Date;
import java.util.List;

public interface ChiTietLonNai_DAO {

    public List<ChiTietLonNai> getListChiTietLonNaiDAO();

    public List<ChiTietLonNai> LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai();

    public List<ChiTietLonNai> LayDanhSach_ChiTietLonNai_VacXin();

    public List<ChiTietLonNai> LayChiTietLonNai_CaThe(int MS_Tai_Lon, int Chu_Ky);

    public List<ChiTietLonNai> LayChiTietLonNai_CaThe(int MS_Tai_Lon);

    public int Xoa_ChiTietLonNai(int MS_Tai_Lon);

    public int Xoa_LonNai(int MS_Tai_Lon);

    public int Them_ChiTietLonNai(int MS_Tai_Lon, Date Ngay_Nhap_Lon_Nai, Date Ngay_Phoi, Date Ngay_De, int Chu_Ky);

    public int Them_LonNai(int MS_Tai_Lon, String Tuoi_Lon);

    public List<ChiTietLonNai> KiemTraMS_Tai_Lon(int MS_Tai_Lon);

}
