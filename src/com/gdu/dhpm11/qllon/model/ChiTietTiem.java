package com.gdu.dhpm11.qllon.model;

import java.util.Date;

public class ChiTietTiem {
    private int MS_Chi_Tiet_Tiem;
    private Date Ngay_Tiem;
    private int Khoang_Ngay;
    private int MS_Vac_Xin;
    private int MS_Tai_Lon;

    public ChiTietTiem() {
    }

    public ChiTietTiem(int MS_Chi_Tiet_Tiem, Date ngay_Tiem, int khoang_Ngay, int MS_Vac_Xin, int MS_Tai_Lon) {
        this.MS_Chi_Tiet_Tiem = MS_Chi_Tiet_Tiem;
        Ngay_Tiem = ngay_Tiem;
        Khoang_Ngay = khoang_Ngay;
        this.MS_Vac_Xin = MS_Vac_Xin;
        this.MS_Tai_Lon = MS_Tai_Lon;
    }

    public int getMS_Chi_Tiet_Tiem() {
        return MS_Chi_Tiet_Tiem;
    }

    public void setMS_Chi_Tiet_Tiem(int MS_Chi_Tiet_Tiem) {
        this.MS_Chi_Tiet_Tiem = MS_Chi_Tiet_Tiem;
    }

    public Date getNgay_Tiem() {
        return Ngay_Tiem;
    }

    public void setNgay_Tiem(Date ngay_Tiem) {
        Ngay_Tiem = ngay_Tiem;
    }

    public int getKhoang_Ngay() {
        return Khoang_Ngay;
    }

    public void setKhoang_Ngay(int khoang_Ngay) {
        Khoang_Ngay = khoang_Ngay;
    }

    public int getMS_Vac_Xin() {
        return MS_Vac_Xin;
    }

    public void setMS_Vac_Xin(int MS_Vac_Xin) {
        this.MS_Vac_Xin = MS_Vac_Xin;
    }

    public int getMS_Tai_Lon() {
        return MS_Tai_Lon;
    }

    public void setMS_Tai_Lon(int MS_Tai_Lon) {
        this.MS_Tai_Lon = MS_Tai_Lon;
    }

    @Override
    public String toString() {
        return "ChiTietTiem{" +
                "MS_Chi_Tiet_Tiem=" + MS_Chi_Tiet_Tiem +
                ", Ngay_Tiem=" + Ngay_Tiem +
                ", Khoang_Ngay=" + Khoang_Ngay +
                ", MS_Vac_Xin=" + MS_Vac_Xin +
                ", MS_Tai_Lon=" + MS_Tai_Lon +
                '}';
    }
}
