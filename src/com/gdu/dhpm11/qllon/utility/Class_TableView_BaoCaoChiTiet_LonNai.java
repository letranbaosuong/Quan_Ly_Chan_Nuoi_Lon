package com.gdu.dhpm11.qllon.utility;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Class_TableView_BaoCaoChiTiet_LonNai {

    private SimpleIntegerProperty STT;
    private SimpleIntegerProperty MS_Tai;
    private SimpleStringProperty Ngay_Phoi;
    private SimpleStringProperty Ngay_De;
    private SimpleIntegerProperty Tong_So_Lon;
    private SimpleIntegerProperty So_Lon_Chet;
    private SimpleIntegerProperty Tong_So_Lon_Song;
    private SimpleStringProperty Tuoi_Lon;

    public Class_TableView_BaoCaoChiTiet_LonNai() {
    }

    public Class_TableView_BaoCaoChiTiet_LonNai(int STT, int MS_Tai, String ngay_Phoi, String ngay_De, int tong_So_Lon, int so_Lon_Chet, int tong_So_Lon_Song, String tuoi_Lon) {
        this.STT = new SimpleIntegerProperty(STT);
        this.MS_Tai = new SimpleIntegerProperty(MS_Tai);
        Ngay_Phoi = new SimpleStringProperty(ngay_Phoi);
        Ngay_De = new SimpleStringProperty(ngay_De);
        Tong_So_Lon = new SimpleIntegerProperty(tong_So_Lon);
        So_Lon_Chet = new SimpleIntegerProperty(so_Lon_Chet);
        Tong_So_Lon_Song = new SimpleIntegerProperty(tong_So_Lon_Song);
        Tuoi_Lon = new SimpleStringProperty(tuoi_Lon);
    }

    public int getSTT() {
        return STT.get();
    }

    public SimpleIntegerProperty STTProperty() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT.set(STT);
    }

    public int getMS_Tai() {
        return MS_Tai.get();
    }

    public SimpleIntegerProperty MS_TaiProperty() {
        return MS_Tai;
    }

    public void setMS_Tai(int MS_Tai) {
        this.MS_Tai.set(MS_Tai);
    }

    public String getNgay_Phoi() {
        return Ngay_Phoi.get();
    }

    public SimpleStringProperty ngay_PhoiProperty() {
        return Ngay_Phoi;
    }

    public void setNgay_Phoi(String ngay_Phoi) {
        this.Ngay_Phoi.set(ngay_Phoi);
    }

    public String getNgay_De() {
        return Ngay_De.get();
    }

    public SimpleStringProperty ngay_DeProperty() {
        return Ngay_De;
    }

    public void setNgay_De(String ngay_De) {
        this.Ngay_De.set(ngay_De);
    }

    public int getTong_So_Lon() {
        return Tong_So_Lon.get();
    }

    public SimpleIntegerProperty tong_So_LonProperty() {
        return Tong_So_Lon;
    }

    public void setTong_So_Lon(int tong_So_Lon) {
        this.Tong_So_Lon.set(tong_So_Lon);
    }

    public int getSo_Lon_Chet() {
        return So_Lon_Chet.get();
    }

    public SimpleIntegerProperty so_Lon_ChetProperty() {
        return So_Lon_Chet;
    }

    public void setSo_Lon_Chet(int so_Lon_Chet) {
        this.So_Lon_Chet.set(so_Lon_Chet);
    }

    public int getTong_So_Lon_Song() {
        return Tong_So_Lon_Song.get();
    }

    public SimpleIntegerProperty tong_So_Lon_SongProperty() {
        return Tong_So_Lon_Song;
    }

    public void setTong_So_Lon_Song(int tong_So_Lon_Song) {
        this.Tong_So_Lon_Song.set(tong_So_Lon_Song);
    }

    public String getTuoi_Lon() {
        return Tuoi_Lon.get();
    }

    public SimpleStringProperty tuoi_LonProperty() {
        return Tuoi_Lon;
    }

    public void setTuoi_Lon(String tuoi_Lon) {
        this.Tuoi_Lon.set(tuoi_Lon);
    }
}
