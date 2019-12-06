package com.gdu.dhpm11.qllon.model;

import java.util.Date;

public class ChiTietLonNai_KiemTraChuKyMangThai extends Lon {
    private int MS_Tai_Lon;
    private Date Ngay_Nhap_Lon_Nai;
    private Date Ngay_Phoi;
    private Date Ngay_De;

    public ChiTietLonNai_KiemTraChuKyMangThai() {
    }

    public ChiTietLonNai_KiemTraChuKyMangThai(int MS_Tai_Lon, Date ngay_Nhap_Lon_Nai, Date ngay_Phoi, Date ngay_De) {
        this.MS_Tai_Lon = MS_Tai_Lon;
        this.Ngay_Nhap_Lon_Nai = ngay_Nhap_Lon_Nai;
        this.Ngay_Phoi = ngay_Phoi;
        this.Ngay_De = ngay_De;
    }

    @Override
    public int getMS_Tai_Lon() {
        return MS_Tai_Lon;
    }

    @Override
    public void setMS_Tai_Lon(int MS_Tai_Lon) {
        this.MS_Tai_Lon = MS_Tai_Lon;
    }

    public Date getNgay_Nhap_Lon_Nai() {
        return Ngay_Nhap_Lon_Nai;
    }

    public void setNgay_Nhap_Lon_Nai(Date ngay_Nhap_Lon_Nai) {
        Ngay_Nhap_Lon_Nai = ngay_Nhap_Lon_Nai;
    }

    public Date getNgay_Phoi() {
        return Ngay_Phoi;
    }

    public void setNgay_Phoi(Date ngay_Phoi) {
        Ngay_Phoi = ngay_Phoi;
    }

    public Date getNgay_De() {
        return Ngay_De;
    }

    public void setNgay_De(Date ngay_De) {
        Ngay_De = ngay_De;
    }

    @Override
    public String toString() {
        return "ChiTietLonNai_KiemTraChuKyMangThai{" +
                "MS_Tai_Lon=" + MS_Tai_Lon +
                ", Ngay_Nhap_Lon_Nai=" + Ngay_Nhap_Lon_Nai +
                ", Ngay_Phoi=" + Ngay_Phoi +
                ", Ngay_De=" + Ngay_De +
                '}';
    }
}
