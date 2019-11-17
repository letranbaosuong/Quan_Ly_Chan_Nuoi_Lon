package com.gdu.dhpm11.qllon.bean;

import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;

public class DanhMucBean {

    private String kind;
    private AnchorPane an;
    private Label lb;

    public DanhMucBean() {
    }

    public DanhMucBean(String kind, AnchorPane an, Label lb) {
        this.kind = kind;
        this.an = an;
        this.lb = lb;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public AnchorPane getPn() {
        return an;
    }

    public void setPn(AnchorPane pn) {
        this.an = pn;
    }

    public Label getLb() {
        return lb;
    }

    public void setLb(Label lb) {
        this.lb = lb;
    }
}
