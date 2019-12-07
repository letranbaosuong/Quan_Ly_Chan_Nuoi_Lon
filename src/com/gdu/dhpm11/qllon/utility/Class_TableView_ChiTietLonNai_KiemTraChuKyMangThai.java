package com.gdu.dhpm11.qllon.utility;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai {
    private SimpleIntegerProperty MS_Tai_Lon;
    private SimpleStringProperty Chu_Ky_21_Ngay;
    private SimpleStringProperty Chu_Ky_42_Ngay;
    private SimpleStringProperty Chu_Ky_84_Ngay;
    private SimpleStringProperty Ngay_De_Du_Kien;

    public Class_TableView_ChiTietLonNai_KiemTraChuKyMangThai(int MS_Tai_Lon, String chu_Ky_21_Ngay, String chu_Ky_42_Ngay, String chu_Ky_84_Ngay, String ngay_De_Du_Kien) {
        this.MS_Tai_Lon = new SimpleIntegerProperty(MS_Tai_Lon);
        Chu_Ky_21_Ngay = new SimpleStringProperty(chu_Ky_21_Ngay);
        Chu_Ky_42_Ngay = new SimpleStringProperty(chu_Ky_42_Ngay);
        Chu_Ky_84_Ngay = new SimpleStringProperty(chu_Ky_84_Ngay);
        Ngay_De_Du_Kien = new SimpleStringProperty(ngay_De_Du_Kien);
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

    public String getChu_Ky_21_Ngay() {
        return Chu_Ky_21_Ngay.get();
    }

    public SimpleStringProperty chu_Ky_21_NgayProperty() {
        return Chu_Ky_21_Ngay;
    }

    public void setChu_Ky_21_Ngay(String chu_Ky_21_Ngay) {
        this.Chu_Ky_21_Ngay.set(chu_Ky_21_Ngay);
    }

    public String getChu_Ky_42_Ngay() {
        return Chu_Ky_42_Ngay.get();
    }

    public SimpleStringProperty chu_Ky_42_NgayProperty() {
        return Chu_Ky_42_Ngay;
    }

    public void setChu_Ky_42_Ngay(String chu_Ky_42_Ngay) {
        this.Chu_Ky_42_Ngay.set(chu_Ky_42_Ngay);
    }

    public String getChu_Ky_84_Ngay() {
        return Chu_Ky_84_Ngay.get();
    }

    public SimpleStringProperty chu_Ky_84_NgayProperty() {
        return Chu_Ky_84_Ngay;
    }

    public void setChu_Ky_84_Ngay(String chu_Ky_84_Ngay) {
        this.Chu_Ky_84_Ngay.set(chu_Ky_84_Ngay);
    }

    public String getNgay_De_Du_Kien() {
        return Ngay_De_Du_Kien.get();
    }

    public SimpleStringProperty ngay_De_Du_KienProperty() {
        return Ngay_De_Du_Kien;
    }

    public void setNgay_De_Du_Kien(String ngay_De_Du_Kien) {
        this.Ngay_De_Du_Kien.set(ngay_De_Du_Kien);
    }
}
