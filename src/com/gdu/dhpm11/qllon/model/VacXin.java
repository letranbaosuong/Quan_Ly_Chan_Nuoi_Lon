package com.gdu.dhpm11.qllon.model;

import javafx.beans.property.SimpleStringProperty;

public class VacXin {
    private SimpleStringProperty Ta;
    private SimpleStringProperty ECOLI;
    private SimpleStringProperty Tay_Giun;
    private SimpleStringProperty PARVO;
    private SimpleStringProperty FE_COC;
    private SimpleStringProperty Suyen;
    private SimpleStringProperty PRRS;

    public VacXin(String ta, String ECOLI, String tay_Giun, String PARVO, String FE_COC, String suyen, String PRRS) {
        this.Ta = new SimpleStringProperty(ta);
        this.ECOLI =new SimpleStringProperty(ECOLI) ;
        this.Tay_Giun = new SimpleStringProperty(tay_Giun);
        this.PARVO = new SimpleStringProperty(PARVO);
        this.FE_COC = new SimpleStringProperty(FE_COC);
        this.Suyen = new SimpleStringProperty(suyen);
        this.PRRS = new SimpleStringProperty(PRRS);
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

    public String getFE_COC() {
        return FE_COC.get();
    }

    public SimpleStringProperty FE_COCProperty() {
        return FE_COC;
    }

    public void setFE_COC(String FE_COC) {
        this.FE_COC.set(FE_COC);
    }

    public String getSuyen() {
        return Suyen.get();
    }

    public SimpleStringProperty suyenProperty() {
        return Suyen;
    }

    public void setSuyen(String suyen) {
        this.Suyen.set(suyen);
    }

    public String getPRRS() {
        return PRRS.get();
    }

    public SimpleStringProperty PRRSProperty() {
        return PRRS;
    }

    public void setPRRS(String PRRS) {
        this.PRRS.set(PRRS);
    }
}
