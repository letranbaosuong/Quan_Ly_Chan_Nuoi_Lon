package com.gdu.dhpm11.qllon.model;

import java.util.Date;

public class ChiTietVacXin {
    private int MS_Chi_Tiet_Vac_Xin;
    private int Don_Gia_Vac_Xin;
    private int So_Luong_Vac_Xin;
    private Date Ngay_Nhap_Vac_Xin;
    private Date Han_Su_Dung_Vac_Xin;
    private int MS_Vac_Xin;

    public ChiTietVacXin() {
    }

    public ChiTietVacXin(int MS_Chi_Tiet_Vac_Xin, int don_Gia_Vac_Xin, int so_Luong_Vac_Xin, Date ngay_Nhap_Vac_Xin, Date han_Su_Dung_Vac_Xin, int MS_Vac_Xin) {
        this.MS_Chi_Tiet_Vac_Xin = MS_Chi_Tiet_Vac_Xin;
        Don_Gia_Vac_Xin = don_Gia_Vac_Xin;
        So_Luong_Vac_Xin = so_Luong_Vac_Xin;
        Ngay_Nhap_Vac_Xin = ngay_Nhap_Vac_Xin;
        Han_Su_Dung_Vac_Xin = han_Su_Dung_Vac_Xin;
        this.MS_Vac_Xin = MS_Vac_Xin;
    }

    public int getMS_Chi_Tiet_Vac_Xin() {
        return MS_Chi_Tiet_Vac_Xin;
    }

    public void setMS_Chi_Tiet_Vac_Xin(int MS_Chi_Tiet_Vac_Xin) {
        this.MS_Chi_Tiet_Vac_Xin = MS_Chi_Tiet_Vac_Xin;
    }

    public int getDon_Gia_Vac_Xin() {
        return Don_Gia_Vac_Xin;
    }

    public void setDon_Gia_Vac_Xin(int don_Gia_Vac_Xin) {
        Don_Gia_Vac_Xin = don_Gia_Vac_Xin;
    }

    public int getSo_Luong_Vac_Xin() {
        return So_Luong_Vac_Xin;
    }

    public void setSo_Luong_Vac_Xin(int so_Luong_Vac_Xin) {
        So_Luong_Vac_Xin = so_Luong_Vac_Xin;
    }

    public Date getNgay_Nhap_Vac_Xin() {
        return Ngay_Nhap_Vac_Xin;
    }

    public void setNgay_Nhap_Vac_Xin(Date ngay_Nhap_Vac_Xin) {
        Ngay_Nhap_Vac_Xin = ngay_Nhap_Vac_Xin;
    }

    public Date getHan_Su_Dung_Vac_Xin() {
        return Han_Su_Dung_Vac_Xin;
    }

    public void setHan_Su_Dung_Vac_Xin(Date han_Su_Dung_Vac_Xin) {
        Han_Su_Dung_Vac_Xin = han_Su_Dung_Vac_Xin;
    }

    public int getMS_Vac_Xin() {
        return MS_Vac_Xin;
    }

    public void setMS_Vac_Xin(int MS_Vac_Xin) {
        this.MS_Vac_Xin = MS_Vac_Xin;
    }

    @Override
    public String toString() {
        return "ChiTietVacXin{" +
                "MS_Chi_Tiet_Vac_Xin=" + MS_Chi_Tiet_Vac_Xin +
                ", Don_Gia_Vac_Xin=" + Don_Gia_Vac_Xin +
                ", So_Luong_Vac_Xin=" + So_Luong_Vac_Xin +
                ", Ngay_Nhap_Vac_Xin=" + Ngay_Nhap_Vac_Xin +
                ", Han_Su_Dung_Vac_Xin=" + Han_Su_Dung_Vac_Xin +
                ", MS_Vac_Xin=" + MS_Vac_Xin +
                '}';
    }
}
