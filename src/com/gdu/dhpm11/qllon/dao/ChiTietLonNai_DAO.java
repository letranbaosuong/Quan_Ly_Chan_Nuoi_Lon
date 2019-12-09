package com.gdu.dhpm11.qllon.dao;

import com.gdu.dhpm11.qllon.model.ChiTietLonNai;

import java.util.List;

public interface ChiTietLonNai_DAO {

    public List<ChiTietLonNai> getListChiTietLonNaiDAO();

    public List<ChiTietLonNai> LayDanhSach_ChiTietLonNai_KiemTraChuKyMangThai();

    public List<ChiTietLonNai> LayDanhSach_ChiTietLonNai_VacXin();

    public List<ChiTietLonNai> LayChiTietLonNai_CaThe(int MS_Tai_Lon);
}
