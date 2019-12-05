package com.gdu.dhpm11.qllon.utility;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Date;

public class Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai {
    private SimpleIntegerProperty MS_Tai_Lon;
    private SimpleObjectProperty Chu_Ky_21_Ngay;
    private SimpleObjectProperty Chu_Ky_42_Ngay;
    private SimpleObjectProperty Chu_Ky_84_Ngay;
    private SimpleObjectProperty Ngay_De_Du_Kien;

    public Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai(int MS_Tai_Lon, Date chu_Ky_21_Ngay, Date chu_Ky_42_Ngay, Date chu_Ky_84_Ngay, Date ngay_De_Du_Kien) {
        this.MS_Tai_Lon = new SimpleIntegerProperty(MS_Tai_Lon);
        this.Chu_Ky_21_Ngay = new SimpleObjectProperty<>(chu_Ky_21_Ngay);
        this.Chu_Ky_42_Ngay = new SimpleObjectProperty<>(chu_Ky_42_Ngay);
        this.Chu_Ky_84_Ngay = new SimpleObjectProperty<>(chu_Ky_84_Ngay);
        this.Ngay_De_Du_Kien = new SimpleObjectProperty<>(ngay_De_Du_Kien);
    }

    public int getMS_Tai_Lon() {
        return MS_Tai_Lon.get();
    }

    public SimpleIntegerProperty MS_Tai_LonProperty() {
        return MS_Tai_Lon;
    }

    public void setMS_Tai_Lon(int MS_Tai_Lon) {
        this.MS_Tai_Lon.set(MS_Tai_Lon);
    }

    public Object getChu_Ky_21_Ngay() {
        return Chu_Ky_21_Ngay.get();
    }

    public SimpleObjectProperty chu_Ky_21_NgayProperty() {
        return Chu_Ky_21_Ngay;
    }

    public void setChu_Ky_21_Ngay(Date chu_Ky_21_Ngay) {
        this.Chu_Ky_21_Ngay.set(chu_Ky_21_Ngay);
    }

    public Object getChu_Ky_42_Ngay() {
        return Chu_Ky_42_Ngay.get();
    }

    public SimpleObjectProperty chu_Ky_42_NgayProperty() {
        return Chu_Ky_42_Ngay;
    }

    public void setChu_Ky_42_Ngay(Date chu_Ky_42_Ngay) {
        this.Chu_Ky_42_Ngay.set(chu_Ky_42_Ngay);
    }

    public Object getChu_Ky_84_Ngay() {
        return Chu_Ky_84_Ngay.get();
    }

    public SimpleObjectProperty chu_Ky_84_NgayProperty() {
        return Chu_Ky_84_Ngay;
    }

    public void setChu_Ky_84_Ngay(Date chu_Ky_84_Ngay) {
        this.Chu_Ky_84_Ngay.set(chu_Ky_84_Ngay);
    }

    public Object getNgay_De_Du_Kien() {
        return Ngay_De_Du_Kien.get();
    }

    public SimpleObjectProperty ngay_De_Du_KienProperty() {
        return Ngay_De_Du_Kien;
    }

    public void setNgay_De_Du_Kien(Date ngay_De_Du_Kien) {
        this.Ngay_De_Du_Kien.set(ngay_De_Du_Kien);
    }
}
