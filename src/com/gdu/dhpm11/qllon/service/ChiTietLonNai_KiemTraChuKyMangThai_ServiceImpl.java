package com.gdu.dhpm11.qllon.service;

import com.gdu.dhpm11.qllon.dao.ChiTietLonNai_KiemTraChuKyMangThai_DAO;
import com.gdu.dhpm11.qllon.dao.ChiTietLonNai_KiemTraChuKyMangThai_DAOImpl;
import com.gdu.dhpm11.qllon.model.ChiTietLonNai_KiemTraChuKyMangThai;

import java.util.List;

public class ChiTietLonNai_KiemTraChuKyMangThai_ServiceImpl implements ChiTietLonNai_KiemTraChuKyMangThai_Service {

    private ChiTietLonNai_KiemTraChuKyMangThai_DAO chiTietLonNai_kiemTraChuKyMangThai_dao = null;

    public ChiTietLonNai_KiemTraChuKyMangThai_ServiceImpl() {
        chiTietLonNai_kiemTraChuKyMangThai_dao = new ChiTietLonNai_KiemTraChuKyMangThai_DAOImpl();
    }

    @Override
    public List<ChiTietLonNai_KiemTraChuKyMangThai> LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai() {
        return chiTietLonNai_kiemTraChuKyMangThai_dao.LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai();
    }
}
