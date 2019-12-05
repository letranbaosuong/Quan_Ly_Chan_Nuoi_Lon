package com.gdu.dhpm11.qllon.model;

import java.util.Date;

public class ChiTietTieuThuThucAn {
    private int MS_Chi_Tiet_Tieu_Thu_Thuc_An;
    private Date Ngay_Tieu_Thu;
    private int So_Luong_Tieu_Thu;
    private Date Ngay_Het;
    private int MS_Thuc_An;

    public ChiTietTieuThuThucAn() {
    }

    public ChiTietTieuThuThucAn(int MS_Chi_Tiet_Tieu_Thu_Thuc_An, Date ngay_Tieu_Thu, int so_Luong_Tieu_Thu, Date ngay_Het, int MS_Thuc_An) {
        this.MS_Chi_Tiet_Tieu_Thu_Thuc_An = MS_Chi_Tiet_Tieu_Thu_Thuc_An;
        Ngay_Tieu_Thu = ngay_Tieu_Thu;
        So_Luong_Tieu_Thu = so_Luong_Tieu_Thu;
        Ngay_Het = ngay_Het;
        this.MS_Thuc_An = MS_Thuc_An;
    }

    public int getMS_Chi_Tiet_Tieu_Thu_Thuc_An() {
        return MS_Chi_Tiet_Tieu_Thu_Thuc_An;
    }

    public void setMS_Chi_Tiet_Tieu_Thu_Thuc_An(int MS_Chi_Tiet_Tieu_Thu_Thuc_An) {
        this.MS_Chi_Tiet_Tieu_Thu_Thuc_An = MS_Chi_Tiet_Tieu_Thu_Thuc_An;
    }

    public Date getNgay_Tieu_Thu() {
        return Ngay_Tieu_Thu;
    }

    public void setNgay_Tieu_Thu(Date ngay_Tieu_Thu) {
        Ngay_Tieu_Thu = ngay_Tieu_Thu;
    }

    public int getSo_Luong_Tieu_Thu() {
        return So_Luong_Tieu_Thu;
    }

    public void setSo_Luong_Tieu_Thu(int so_Luong_Tieu_Thu) {
        So_Luong_Tieu_Thu = so_Luong_Tieu_Thu;
    }

    public Date getNgay_Het() {
        return Ngay_Het;
    }

    public void setNgay_Het(Date ngay_Het) {
        Ngay_Het = ngay_Het;
    }

    public int getMS_Thuc_An() {
        return MS_Thuc_An;
    }

    public void setMS_Thuc_An(int MS_Thuc_An) {
        this.MS_Thuc_An = MS_Thuc_An;
    }

    @Override
    public String toString() {
        return "ChiTietTieuThuThucAn{" +
                "MS_Chi_Tiet_Tieu_Thu_Thuc_An=" + MS_Chi_Tiet_Tieu_Thu_Thuc_An +
                ", Ngay_Tieu_Thu=" + Ngay_Tieu_Thu +
                ", So_Luong_Tieu_Thu=" + So_Luong_Tieu_Thu +
                ", Ngay_Het=" + Ngay_Het +
                ", MS_Thuc_An=" + MS_Thuc_An +
                '}';
    }
}
