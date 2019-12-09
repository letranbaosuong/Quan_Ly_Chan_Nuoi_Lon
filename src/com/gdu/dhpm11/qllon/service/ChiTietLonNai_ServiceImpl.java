package com.gdu.dhpm11.qllon.service;

import com.gdu.dhpm11.qllon.dao.ChiTietLonNai_DAO;
import com.gdu.dhpm11.qllon.dao.ChiTietLonNai_DAOImpl;
import com.gdu.dhpm11.qllon.model.ChiTietLonNai;

import java.util.List;

public class ChiTietLonNai_ServiceImpl implements ChiTietLonNai_Service {
    private ChiTietLonNai_DAO chiTietLonNai_kiemTraChuKyMangThai_dao = null;
    private ChiTietLonNai_DAO chiTietLonNai_vacXin_dao = null;
    private ChiTietLonNai_DAO chiTietLonNai_caThe_dao = null;

    public ChiTietLonNai_ServiceImpl() {
        chiTietLonNai_kiemTraChuKyMangThai_dao = new ChiTietLonNai_DAOImpl();
        chiTietLonNai_vacXin_dao = new ChiTietLonNai_DAOImpl();
        chiTietLonNai_caThe_dao = new ChiTietLonNai_DAOImpl();
    }

    @Override
    public List<ChiTietLonNai> LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai() {
        return chiTietLonNai_kiemTraChuKyMangThai_dao.LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai();
    }

    @Override
    public List<ChiTietLonNai> LayDanhSach_ChiTietLonNai_VacXin() {
        return chiTietLonNai_vacXin_dao.LayDanhSach_ChiTietLonNai_VacXin();
    }

    @Override
    public List<ChiTietLonNai> LayChiTietLonNai_CaThe(int MS_Tai_Lon) {
        return chiTietLonNai_caThe_dao.LayChiTietLonNai_CaThe(MS_Tai_Lon);
    }
}
