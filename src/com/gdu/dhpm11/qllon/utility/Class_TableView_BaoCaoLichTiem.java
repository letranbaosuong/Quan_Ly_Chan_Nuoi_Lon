package com.gdu.dhpm11.qllon.utility;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Class_TableView_BaoCaoLichTiem {
    private SimpleIntegerProperty stt;
    private SimpleIntegerProperty maTai;
    private SimpleIntegerProperty chuKy;
    private SimpleStringProperty chuKy_21ngay;
    private SimpleStringProperty chuKy_42ngay;
    private SimpleStringProperty chuKy_84ngay;
    private SimpleStringProperty ngayDe;
    private SimpleStringProperty ta;
    private SimpleStringProperty ecoli;
    private SimpleStringProperty tayGiun;
    private SimpleStringProperty parvo;
    private SimpleStringProperty fe_coc;
    private SimpleStringProperty suyen;
    private SimpleStringProperty prrs;

    public Class_TableView_BaoCaoLichTiem() {
    }

    public Class_TableView_BaoCaoLichTiem(int stt, int maTai, int chuKy, String chuKy_21ngay, String chuKy_42ngay,
                                          String chuKy_84ngay, String ngayDe, String ta, String ecoli, String tayGiun,
                                          String parvo, String fe_coc, String suyen, String prrs) {
        this.stt = new SimpleIntegerProperty(stt);
        this.maTai = new SimpleIntegerProperty(maTai);
        this.chuKy = new SimpleIntegerProperty(chuKy);
        this.chuKy_21ngay = new SimpleStringProperty(chuKy_21ngay);
        this.chuKy_42ngay = new SimpleStringProperty(chuKy_42ngay);
        this.chuKy_84ngay = new SimpleStringProperty(chuKy_84ngay);
        this.ngayDe = new SimpleStringProperty(ngayDe);
        this.ta = new SimpleStringProperty(ta);
        this.ecoli = new SimpleStringProperty(ecoli);
        this.tayGiun = new SimpleStringProperty(tayGiun);
        this.parvo = new SimpleStringProperty(parvo);
        this.fe_coc = new SimpleStringProperty(fe_coc);
        this.suyen = new SimpleStringProperty(suyen);
        this.prrs = new SimpleStringProperty(prrs);
    }

    public int getStt() {
        return stt.get();
    }

    public SimpleIntegerProperty sttProperty() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt.set(stt);
    }

    public int getMaTai() {
        return maTai.get();
    }

    public SimpleIntegerProperty maTaiProperty() {
        return maTai;
    }

    public void setMaTai(int maTai) {
        this.maTai.set(maTai);
    }

    public int getChuKy() {
        return chuKy.get();
    }

    public SimpleIntegerProperty chuKyProperty() {
        return chuKy;
    }

    public void setChuKy(int chuKy) {
        this.chuKy.set(chuKy);
    }

    public String getChuKy_21ngay() {
        return chuKy_21ngay.get();
    }

    public SimpleStringProperty chuKy_21ngayProperty() {
        return chuKy_21ngay;
    }

    public void setChuKy_21ngay(String chuKy_21ngay) {
        this.chuKy_21ngay.set(chuKy_21ngay);
    }

    public String getChuKy_42ngay() {
        return chuKy_42ngay.get();
    }

    public SimpleStringProperty chuKy_42ngayProperty() {
        return chuKy_42ngay;
    }

    public void setChuKy_42ngay(String chuKy_42ngay) {
        this.chuKy_42ngay.set(chuKy_42ngay);
    }

    public String getChuKy_84ngay() {
        return chuKy_84ngay.get();
    }

    public SimpleStringProperty chuKy_84ngayProperty() {
        return chuKy_84ngay;
    }

    public void setChuKy_84ngay(String chuKy_84ngay) {
        this.chuKy_84ngay.set(chuKy_84ngay);
    }

    public String getNgayDe() {
        return ngayDe.get();
    }

    public SimpleStringProperty ngayDeProperty() {
        return ngayDe;
    }

    public void setNgayDe(String ngayDe) {
        this.ngayDe.set(ngayDe);
    }

    public String getTa() {
        return ta.get();
    }

    public SimpleStringProperty taProperty() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta.set(ta);
    }

    public String getEcoli() {
        return ecoli.get();
    }

    public SimpleStringProperty ecoliProperty() {
        return ecoli;
    }

    public void setEcoli(String ecoli) {
        this.ecoli.set(ecoli);
    }

    public String getTayGiun() {
        return tayGiun.get();
    }

    public SimpleStringProperty tayGiunProperty() {
        return tayGiun;
    }

    public void setTayGiun(String tayGiun) {
        this.tayGiun.set(tayGiun);
    }

    public String getParvo() {
        return parvo.get();
    }

    public SimpleStringProperty parvoProperty() {
        return parvo;
    }

    public void setParvo(String parvo) {
        this.parvo.set(parvo);
    }

    public String getFe_coc() {
        return fe_coc.get();
    }

    public SimpleStringProperty fe_cocProperty() {
        return fe_coc;
    }

    public void setFe_coc(String fe_coc) {
        this.fe_coc.set(fe_coc);
    }

    public String getSuyen() {
        return suyen.get();
    }

    public SimpleStringProperty suyenProperty() {
        return suyen;
    }

    public void setSuyen(String suyen) {
        this.suyen.set(suyen);
    }

    public String getPrrs() {
        return prrs.get();
    }

    public SimpleStringProperty prrsProperty() {
        return prrs;
    }

    public void setPrrs(String prrs) {
        this.prrs.set(prrs);
    }
}
