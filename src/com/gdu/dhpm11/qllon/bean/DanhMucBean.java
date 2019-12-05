package com.gdu.dhpm11.qllon.bean;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class DanhMucBean {

    private String kind;
    private Pane pn;
    private Text txt;

    public DanhMucBean() {
    }

    public DanhMucBean(String kind, Pane pn, Text txt) {
        this.kind = kind;
        this.pn = pn;
        this.txt = txt;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Pane getPn() {
        return pn;
    }

    public void setPn(Pane pn) {
        this.pn = pn;
    }

    public Text getTxt() {
        return txt;
    }

    public void setTxt(Text txt) {
        this.txt = txt;
    }
}
