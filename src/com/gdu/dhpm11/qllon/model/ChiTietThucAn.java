package com.gdu.dhpm11.qllon.model;

import java.util.Date;

public class ChiTietThucAn {
    private int MS_Chi_Tiet_Thuc_An;
    private int Don_Gia_Thuc_An;
    private int So_Luong_Thuc_An;
    private Date Ngay_Nhap_Thuc_An;
    private Date Han_Su_Dung_Thuc_An;
    private int MS_Thuc_An;

    public ChiTietThucAn() {
    }

    public ChiTietThucAn(int MS_Chi_Tiet_Thuc_An, int don_Gia_Thuc_An, int so_Luong_Thuc_An, Date ngay_Nhap_Thuc_An, Date han_Su_Dung_Thuc_An, int MS_Thuc_An) {
        this.MS_Chi_Tiet_Thuc_An = MS_Chi_Tiet_Thuc_An;
        Don_Gia_Thuc_An = don_Gia_Thuc_An;
        So_Luong_Thuc_An = so_Luong_Thuc_An;
        Ngay_Nhap_Thuc_An = ngay_Nhap_Thuc_An;
        Han_Su_Dung_Thuc_An = han_Su_Dung_Thuc_An;
        this.MS_Thuc_An = MS_Thuc_An;
    }

    public int getMS_Chi_Tiet_Thuc_An() {
        return MS_Chi_Tiet_Thuc_An;
    }

    public void setMS_Chi_Tiet_Thuc_An(int MS_Chi_Tiet_Thuc_An) {
        this.MS_Chi_Tiet_Thuc_An = MS_Chi_Tiet_Thuc_An;
    }

    public int getDon_Gia_Thuc_An() {
        return Don_Gia_Thuc_An;
    }

    public void setDon_Gia_Thuc_An(int don_Gia_Thuc_An) {
        Don_Gia_Thuc_An = don_Gia_Thuc_An;
    }

    public int getSo_Luong_Thuc_An() {
        return So_Luong_Thuc_An;
    }

    public void setSo_Luong_Thuc_An(int so_Luong_Thuc_An) {
        So_Luong_Thuc_An = so_Luong_Thuc_An;
    }

    public Date getNgay_Nhap_Thuc_An() {
        return Ngay_Nhap_Thuc_An;
    }

    public void setNgay_Nhap_Thuc_An(Date ngay_Nhap_Thuc_An) {
        Ngay_Nhap_Thuc_An = ngay_Nhap_Thuc_An;
    }

    public Date getHan_Su_Dung_Thuc_An() {
        return Han_Su_Dung_Thuc_An;
    }

    public void setHan_Su_Dung_Thuc_An(Date han_Su_Dung_Thuc_An) {
        Han_Su_Dung_Thuc_An = han_Su_Dung_Thuc_An;
    }

    public int getMS_Thuc_An() {
        return MS_Thuc_An;
    }

    public void setMS_Thuc_An(int MS_Thuc_An) {
        this.MS_Thuc_An = MS_Thuc_An;
    }

    @Override
    public String toString() {
        return "ChiTietThucAn{" +
                "MS_Chi_Tiet_Thuc_An=" + MS_Chi_Tiet_Thuc_An +
                ", Don_Gia_Thuc_An=" + Don_Gia_Thuc_An +
                ", So_Luong_Thuc_An=" + So_Luong_Thuc_An +
                ", Ngay_Nhap_Thuc_An=" + Ngay_Nhap_Thuc_An +
                ", Han_Su_Dung_Thuc_An=" + Han_Su_Dung_Thuc_An +
                ", MS_Thuc_An=" + MS_Thuc_An +
                '}';
    }
}
