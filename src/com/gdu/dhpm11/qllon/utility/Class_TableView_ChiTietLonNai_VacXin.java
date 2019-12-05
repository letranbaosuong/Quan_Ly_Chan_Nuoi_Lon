package com.gdu.dhpm11.qllon.utility;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Date;

public class Class_TableView_ChiTietLonNai_VacXin {
    private SimpleIntegerProperty MS_Tai_Lon;
    private SimpleObjectProperty Ta;
    private SimpleObjectProperty ECOLI;
    private SimpleObjectProperty Tay_Giun;
    private SimpleObjectProperty PARVO;
    private SimpleObjectProperty FE_COC_3_Ngay;
    private SimpleObjectProperty Suyen_14_Ngay;
    private SimpleObjectProperty PRRS_21_Ngay;

    public Class_TableView_ChiTietLonNai_VacXin(int MS_Tai_Lon, Date ta, Date ECOLI, Date tay_Giun, Date PARVO, Date FE_COC_3_Ngay, Date suyen_14_Ngay, Date PRRS_21_Ngay) {
        this.MS_Tai_Lon = new SimpleIntegerProperty(MS_Tai_Lon);
        this.Ta = new SimpleObjectProperty<>(ta);
        this.ECOLI = new SimpleObjectProperty<>(ECOLI);
        this.Tay_Giun = new SimpleObjectProperty<>(Tay_Giun);
        this.PARVO = new SimpleObjectProperty<>(PARVO);
        this.FE_COC_3_Ngay = new SimpleObjectProperty<>(FE_COC_3_Ngay);
        this.Suyen_14_Ngay = new SimpleObjectProperty<>(Suyen_14_Ngay);
        this.PRRS_21_Ngay = new SimpleObjectProperty<>(PRRS_21_Ngay);
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

    public Object getTa() {
        return Ta.get();
    }

    public SimpleObjectProperty taProperty() {
        return Ta;
    }

    public void setTa(Date ta) {
        this.Ta.set(ta);
    }

    public Object getECOLI() {
        return ECOLI.get();
    }

    public SimpleObjectProperty ECOLIProperty() {
        return ECOLI;
    }

    public void setECOLI(Date ECOLI) {
        this.ECOLI.set(ECOLI);
    }

    public Object getTay_Giun() {
        return Tay_Giun.get();
    }

    public SimpleObjectProperty tay_GiunProperty() {
        return Tay_Giun;
    }

    public void setTay_Giun(Date tay_Giun) {
        this.Tay_Giun.set(tay_Giun);
    }

    public Object getPARVO() {
        return PARVO.get();
    }

    public SimpleObjectProperty PARVOProperty() {
        return PARVO;
    }

    public void setPARVO(Date PARVO) {
        this.PARVO.set(PARVO);
    }

    public Object getFE_COC_3_Ngay() {
        return FE_COC_3_Ngay.get();
    }

    public SimpleObjectProperty FE_COC_3_NgayProperty() {
        return FE_COC_3_Ngay;
    }

    public void setFE_COC_3_Ngay(Date FE_COC_3_Ngay) {
        this.FE_COC_3_Ngay.set(FE_COC_3_Ngay);
    }

    public Object getSuyen_14_Ngay() {
        return Suyen_14_Ngay.get();
    }

    public SimpleObjectProperty suyen_14_NgayProperty() {
        return Suyen_14_Ngay;
    }

    public void setSuyen_14_Ngay(Date suyen_14_Ngay) {
        this.Suyen_14_Ngay.set(suyen_14_Ngay);
    }

    public Object getPRRS_21_Ngay() {
        return PRRS_21_Ngay.get();
    }

    public SimpleObjectProperty PRRS_21_NgayProperty() {
        return PRRS_21_Ngay;
    }

    public void setPRRS_21_Ngay(Date PRRS_21_Ngay) {
        this.PRRS_21_Ngay.set(PRRS_21_Ngay);
    }
}
