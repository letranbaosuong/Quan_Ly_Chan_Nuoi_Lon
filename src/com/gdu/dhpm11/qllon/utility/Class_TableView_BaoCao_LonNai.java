package com.gdu.dhpm11.qllon.utility;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Class_TableView_BaoCao_LonNai {

    private SimpleIntegerProperty STT;
    private SimpleStringProperty Tieu_Chi_Bao_Cao;
    private SimpleIntegerProperty So_Lieu;

    public Class_TableView_BaoCao_LonNai(int STT, String tieu_Chi_Bao_Cao, int so_Lieu) {
        this.STT = new SimpleIntegerProperty(STT);
        Tieu_Chi_Bao_Cao = new SimpleStringProperty(tieu_Chi_Bao_Cao);
        So_Lieu = new SimpleIntegerProperty(so_Lieu);
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

    public String getTieu_Chi_Bao_Cao() {
        return Tieu_Chi_Bao_Cao.get();
    }

    public SimpleStringProperty tieu_Chi_Bao_CaoProperty() {
        return Tieu_Chi_Bao_Cao;
    }

    public void setTieu_Chi_Bao_Cao(String tieu_Chi_Bao_Cao) {
        this.Tieu_Chi_Bao_Cao.set(tieu_Chi_Bao_Cao);
    }

    public int getSo_Lieu() {
        return So_Lieu.get();
    }

    public SimpleIntegerProperty so_LieuProperty() {
        return So_Lieu;
    }

    public void setSo_Lieu(int so_Lieu) {
        this.So_Lieu.set(so_Lieu);
    }
}
