package com.gdu.dhpm11.qllon.service;

import com.gdu.dhpm11.qllon.dao.LoaiLonDAO;
import com.gdu.dhpm11.qllon.dao.LoaiLonDAOImpl;
import com.gdu.dhpm11.qllon.model.LoaiLon;

import java.util.List;

public class LoaiLonServiceImpl implements LoaiLonService {

    private LoaiLonDAO loaiLonDAO = null;

    public LoaiLonServiceImpl() {
        loaiLonDAO = new LoaiLonDAOImpl();
    }

    @Override
    public List<LoaiLon> getListLonNaiService() {
        return loaiLonDAO.getListLonNaiDAO();
    }
}
