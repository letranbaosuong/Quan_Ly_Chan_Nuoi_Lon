package com.gdu.dhpm11.qllon.service;

import com.gdu.dhpm11.qllon.dao.ChiTietLonNai_DAO;
import com.gdu.dhpm11.qllon.dao.ChiTietLonNai_DAOImpl;
import com.gdu.dhpm11.qllon.model.ChiTietLonNai;

import java.sql.Date;
import java.util.List;

public class ChiTietLonNai_ServiceImpl implements ChiTietLonNai_Service {
    private ChiTietLonNai_DAO chiTietLonNai_dao = null;

    public ChiTietLonNai_ServiceImpl() {
        chiTietLonNai_dao = new ChiTietLonNai_DAOImpl();
    }

    @Override
    public List<ChiTietLonNai> getAll() {
        return chiTietLonNai_dao.getAll();
    }

    @Override
    public List<ChiTietLonNai> getListChiTietLonNai(int MS_Tai_Lon, int Chu_Ky) {
        return chiTietLonNai_dao.getListChiTietLonNai(MS_Tai_Lon, Chu_Ky);
    }

    @Override
    public List<ChiTietLonNai> LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai() {
        return chiTietLonNai_dao.LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai();
    }

    @Override
    public List<ChiTietLonNai> LayDanhSach_ChiTietLonNai_VacXin() {
        return chiTietLonNai_dao.LayDanhSach_ChiTietLonNai_VacXin();
    }

    @Override
    public List<ChiTietLonNai> LayChiTietLonNai_CaThe(int MS_Tai_Lon, int Chu_Ky) {
        return chiTietLonNai_dao.LayChiTietLonNai_CaThe(MS_Tai_Lon, Chu_Ky);
    }

    @Override
    public List<ChiTietLonNai> LayChiTietLonNai_CaThe(int MS_Tai_Lon) {
        return chiTietLonNai_dao.LayChiTietLonNai_CaThe(MS_Tai_Lon);
    }

    @Override
    public int Xoa_ChiTietLonNai(int MS_Tai_Lon) {
        return chiTietLonNai_dao.Xoa_ChiTietLonNai(MS_Tai_Lon);
    }

    @Override
    public int Xoa_LonNai(int MS_Tai_Lon) {
        return chiTietLonNai_dao.Xoa_LonNai(MS_Tai_Lon);
    }

    @Override
    public int Them_ChiTietLonNai(int MS_Tai_Lon, Date Ngay_Nhap_Lon_Nai, Date Ngay_Phoi, Date Ngay_De, int Chu_Ky) {
        return chiTietLonNai_dao.Them_ChiTietLonNai(MS_Tai_Lon, Ngay_Nhap_Lon_Nai, Ngay_Phoi, Ngay_De, Chu_Ky);
    }

    @Override
    public int Them_LonNai(int MS_Tai_Lon, String Tuoi_Lon) {
        return chiTietLonNai_dao.Them_LonNai(MS_Tai_Lon, Tuoi_Lon);
    }

    @Override
    public List<ChiTietLonNai> KiemTraMS_Tai_Lon(int MS_Tai_Lon) {
        return chiTietLonNai_dao.KiemTraMS_Tai_Lon(MS_Tai_Lon);
    }

    @Override
    public int CapNhatChiTietLonNai(int MS_tai_Lon, int Chu_Ky, int So_Con_Con, int So_Con_Chet, Date Ngay_Nhap, Date Ngay_Phoi, Date Ngay_De) {
        return chiTietLonNai_dao.CapNhatChiTietLonNai(MS_tai_Lon, Chu_Ky, So_Con_Con, So_Con_Chet, Ngay_Nhap, Ngay_Phoi, Ngay_De);
    }

}
