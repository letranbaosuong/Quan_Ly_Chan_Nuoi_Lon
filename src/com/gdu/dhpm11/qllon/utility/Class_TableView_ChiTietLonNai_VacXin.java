package com.gdu.dhpm11.qllon.utility;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Class_TableView_ChiTietLonNai_VacXin {
    private SimpleIntegerProperty MS_Tai_Lon;
    private SimpleIntegerProperty Chu_Ky;
    private SimpleStringProperty Ta;
    private SimpleStringProperty ECOLI;
    private SimpleStringProperty Tay_Giun;
    private SimpleStringProperty PARVO;
    private SimpleStringProperty FE_COC_3_Ngay;
    private SimpleStringProperty Suyen_14_Ngay;
    private SimpleStringProperty PRRS_21_Ngay;

    public Class_TableView_ChiTietLonNai_VacXin(int MS_Tai_Lon,int chu_Ky, String ta, String ECOLI, String tay_Giun, String PARVO, String FE_COC_3_Ngay, String suyen_14_Ngay, String PRRS_21_Ngay) {
        this.MS_Tai_Lon = new SimpleIntegerProperty(MS_Tai_Lon);
        this.Chu_Ky = new SimpleIntegerProperty(chu_Ky);
        Ta = new SimpleStringProperty(ta);
        this.ECOLI = new SimpleStringProperty(ECOLI);
        Tay_Giun = new SimpleStringProperty(tay_Giun);
        this.PARVO = new SimpleStringProperty(PARVO);
        this.FE_COC_3_Ngay = new SimpleStringProperty(FE_COC_3_Ngay);
        Suyen_14_Ngay = new SimpleStringProperty(suyen_14_Ngay);
        this.PRRS_21_Ngay = new SimpleStringProperty(PRRS_21_Ngay);
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

    public int getChu_Ky() {
        return Chu_Ky.get();
    }

    public SimpleIntegerProperty chu_KyProperty() {
        return Chu_Ky;
    }

    public void setChu_Ky(int chu_Ky) {
        this.Chu_Ky.set(chu_Ky);
    }

    public String getTa() {
        return Ta.get();
    }

    public SimpleStringProperty taProperty() {
        return Ta;
    }

    public void setTa(String ta) {
        this.Ta.set(ta);
    }

    public String getECOLI() {
        return ECOLI.get();
    }

    public SimpleStringProperty ECOLIProperty() {
        return ECOLI;
    }

    public void setECOLI(String ECOLI) {
        this.ECOLI.set(ECOLI);
    }

    public String getTay_Giun() {
        return Tay_Giun.get();
    }

    public SimpleStringProperty tay_GiunProperty() {
        return Tay_Giun;
    }

    public void setTay_Giun(String tay_Giun) {
        this.Tay_Giun.set(tay_Giun);
    }

    public String getPARVO() {
        return PARVO.get();
    }

    public SimpleStringProperty PARVOProperty() {
        return PARVO;
    }

    public void setPARVO(String PARVO) {
        this.PARVO.set(PARVO);
    }

    public String getFE_COC_3_Ngay() {
        return FE_COC_3_Ngay.get();
    }

    public SimpleStringProperty FE_COC_3_NgayProperty() {
        return FE_COC_3_Ngay;
    }

    public void setFE_COC_3_Ngay(String FE_COC_3_Ngay) {
        this.FE_COC_3_Ngay.set(FE_COC_3_Ngay);
    }

    public String getSuyen_14_Ngay() {
        return Suyen_14_Ngay.get();
    }

    public SimpleStringProperty suyen_14_NgayProperty() {
        return Suyen_14_Ngay;
    }

    public void setSuyen_14_Ngay(String suyen_14_Ngay) {
        this.Suyen_14_Ngay.set(suyen_14_Ngay);
    }

    public String getPRRS_21_Ngay() {
        return PRRS_21_Ngay.get();
    }

    public SimpleStringProperty PRRS_21_NgayProperty() {
        return PRRS_21_Ngay;
    }

    public void setPRRS_21_Ngay(String PRRS_21_Ngay) {
        this.PRRS_21_Ngay.set(PRRS_21_Ngay);
    }
}
