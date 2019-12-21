package com.gdu.dhpm11.qllon.model;

import java.util.Date;

public class BaoCaoChiTietLonNai extends Lon {

    private int STT;
    private int MS_Tai;
    private Date Ngay_Phoi;
    private Date Ngay_De;
    private int Tong_So_Lon;
    private int So_Lon_Chet;
    private int Tong_So_Lon_Song;
    private Date Ngay_Nhap;

    public BaoCaoChiTietLonNai() {
    }

    public BaoCaoChiTietLonNai(int STT, int MS_Tai, Date ngay_Phoi, Date ngay_De, int tong_So_Lon, int so_Lon_Chet, int tong_So_Lon_Song, Date ngay_Nhap) {
        this.STT = STT;
        this.MS_Tai = MS_Tai;
        Ngay_Phoi = ngay_Phoi;
        Ngay_De = ngay_De;
        Tong_So_Lon = tong_So_Lon;
        So_Lon_Chet = so_Lon_Chet;
        Tong_So_Lon_Song = tong_So_Lon_Song;
        Ngay_Nhap = ngay_Nhap;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public int getMS_Tai() {
        return MS_Tai;
    }

    public void setMS_Tai(int MS_Tai) {
        this.MS_Tai = MS_Tai;
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

    public int getTong_So_Lon() {
        return Tong_So_Lon;
    }

    public void setTong_So_Lon(int tong_So_Lon) {
        Tong_So_Lon = tong_So_Lon;
    }

    public int getSo_Lon_Chet() {
        return So_Lon_Chet;
    }

    public void setSo_Lon_Chet(int so_Lon_Chet) {
        So_Lon_Chet = so_Lon_Chet;
    }

    public int getTong_So_Lon_Song() {
        return Tong_So_Lon_Song;
    }

    public void setTong_So_Lon_Song(int tong_So_Lon_Song) {
        Tong_So_Lon_Song = tong_So_Lon_Song;
    }

    public Date getNgay_Nhap() {
        return Ngay_Nhap;
    }

    public void setNgay_Nhap(Date ngay_Nhap) {
        Ngay_Nhap = ngay_Nhap;
    }

    @Override
    public String toString() {
        return "BaoCaoChiTietLonNai{" +
                "STT=" + STT +
                ", MS_Tai=" + MS_Tai +
                ", Ngay_Phoi=" + Ngay_Phoi +
                ", Ngay_De=" + Ngay_De +
                ", Tong_So_Lon=" + Tong_So_Lon +
                ", So_Lon_Chet=" + So_Lon_Chet +
                ", Tong_So_Lon_Song=" + Tong_So_Lon_Song +
                ", Ngay_Nhap=" + Ngay_Nhap +
                '}';
    }
}
