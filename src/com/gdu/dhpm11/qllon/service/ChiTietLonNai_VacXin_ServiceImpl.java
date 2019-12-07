package com.gdu.dhpm11.qllon.service;

import com.gdu.dhpm11.qllon.dao.ChiTietLonNai_VacXin_DAO;
import com.gdu.dhpm11.qllon.dao.ChiTietLonNai_VacXin_DAOImpl;
import com.gdu.dhpm11.qllon.model.ChiTietLonNai_VacXin;

import java.util.List;

public class ChiTietLonNai_VacXin_ServiceImpl implements ChiTietLonNai_VacXin_Service {
    private ChiTietLonNai_VacXin_DAO chiTietLonNai_vacXin_dao = null;

    public ChiTietLonNai_VacXin_ServiceImpl() {
        chiTietLonNai_vacXin_dao = new ChiTietLonNai_VacXin_DAOImpl();
    }

    @Override
    public List<ChiTietLonNai_VacXin> LayDanhSach_ChiTietLonNai_VacXin() {
        return chiTietLonNai_vacXin_dao.LayDanhSach_ChiTietLonNai_VacXin();
    }
}
