package com.gdu.dhpm11.qllon.model;

import java.util.Date;

public class ChiTietLonThit {
    private int MS_Chi_Tiet_Lon_Thit;
    private Date Ngay_Nhap_Lon_Thit;
    private Date Ngay_Xuat_Lon_Thit;
    private int Gia_Ban_Lon_Thit;
    private int MS_Tai_Lon;

    public ChiTietLonThit() {
    }

    public ChiTietLonThit(int MS_Chi_Tiet_Lon_Thit, Date ngay_Nhap_Lon_Thit, Date ngay_Xuat_Lon_Thit, int gia_Ban_Lon_Thit, int MS_Tai_Lon) {
        this.MS_Chi_Tiet_Lon_Thit = MS_Chi_Tiet_Lon_Thit;
        Ngay_Nhap_Lon_Thit = ngay_Nhap_Lon_Thit;
        Ngay_Xuat_Lon_Thit = ngay_Xuat_Lon_Thit;
        Gia_Ban_Lon_Thit = gia_Ban_Lon_Thit;
        this.MS_Tai_Lon = MS_Tai_Lon;
    }

    public int getMS_Chi_Tiet_Lon_Thit() {
        return MS_Chi_Tiet_Lon_Thit;
    }

    public void setMS_Chi_Tiet_Lon_Thit(int MS_Chi_Tiet_Lon_Thit) {
        this.MS_Chi_Tiet_Lon_Thit = MS_Chi_Tiet_Lon_Thit;
    }

    public Date getNgay_Nhap_Lon_Thit() {
        return Ngay_Nhap_Lon_Thit;
    }

    public void setNgay_Nhap_Lon_Thit(Date ngay_Nhap_Lon_Thit) {
        Ngay_Nhap_Lon_Thit = ngay_Nhap_Lon_Thit;
    }

    public Date getNgay_Xuat_Lon_Thit() {
        return Ngay_Xuat_Lon_Thit;
    }

    public void setNgay_Xuat_Lon_Thit(Date ngay_Xuat_Lon_Thit) {
        Ngay_Xuat_Lon_Thit = ngay_Xuat_Lon_Thit;
    }

    public int getGia_Ban_Lon_Thit() {
        return Gia_Ban_Lon_Thit;
    }

    public void setGia_Ban_Lon_Thit(int gia_Ban_Lon_Thit) {
        Gia_Ban_Lon_Thit = gia_Ban_Lon_Thit;
    }

    public int getMS_Tai_Lon() {
        return MS_Tai_Lon;
    }

    public void setMS_Tai_Lon(int MS_Tai_Lon) {
        this.MS_Tai_Lon = MS_Tai_Lon;
    }

    @Override
    public String toString() {
        return "ChiTietLonThit{" +
                "MS_Chi_Tiet_Lon_Thit=" + MS_Chi_Tiet_Lon_Thit +
                ", Ngay_Nhap_Lon_Thit=" + Ngay_Nhap_Lon_Thit +
                ", Ngay_Xuat_Lon_Thit=" + Ngay_Xuat_Lon_Thit +
                ", Gia_Ban_Lon_Thit=" + Gia_Ban_Lon_Thit +
                ", MS_Tai_Lon=" + MS_Tai_Lon +
                '}';
    }
}
