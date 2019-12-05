package com.gdu.dhpm11.qllon.utility;

import com.gdu.dhpm11.qllon.model.ChiTietLonNai;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Date;

public class ClassTableModelChiTietLonNai {
    private SimpleIntegerProperty MS_Chi_Tiet_Lon_Nai;
    private SimpleObjectProperty Ngay_Nhap_Lon_Nai;
    private SimpleObjectProperty Ngay_Phoi;
    private SimpleObjectProperty Ngay_De;
    private SimpleIntegerProperty Chu_Ky;
    private SimpleIntegerProperty So_Lan_Phoi;
    private SimpleIntegerProperty So_Lan_De;
    private SimpleIntegerProperty So_Con_Con;
    private SimpleIntegerProperty So_Con_Chet;
    private SimpleIntegerProperty So_Con_Chet_Kho;
    private SimpleIntegerProperty So_Con_Di_Tat;
    private SimpleIntegerProperty So_Con_Chet_Theo_Me;
    private SimpleObjectProperty Ngay_Xuat_Lon_Nai;
    private SimpleIntegerProperty Gia_Ban_Lon_Nai;

    public ClassTableModelChiTietLonNai(ChiTietLonNai chiTietLonNai) {
        this.MS_Chi_Tiet_Lon_Nai = new SimpleIntegerProperty(chiTietLonNai.getMS_Chi_Tiet_Lon_Nai());
        this.Ngay_Nhap_Lon_Nai = new SimpleObjectProperty<>(chiTietLonNai.getNgay_Nhap_Lon_Nai());
        this.Ngay_Phoi = new SimpleObjectProperty<>(chiTietLonNai.getNgay_Phoi());
        this.Ngay_De = new SimpleObjectProperty<>(chiTietLonNai.getNgay_De());
        this.Chu_Ky = new SimpleIntegerProperty(1);
        this.So_Lan_Phoi = new SimpleIntegerProperty(0);
        this.So_Lan_De = new SimpleIntegerProperty(0);
        this.So_Con_Con = new SimpleIntegerProperty(0);
        this.So_Con_Chet = new SimpleIntegerProperty(0);
        this.So_Con_Chet_Kho = new SimpleIntegerProperty(0);
        this.So_Con_Di_Tat = new SimpleIntegerProperty(0);
        this.So_Con_Chet_Theo_Me = new SimpleIntegerProperty(0);
        this.Ngay_Xuat_Lon_Nai = new SimpleObjectProperty<>(chiTietLonNai.getNgay_Xuat_Lon_Nai());
        this.Gia_Ban_Lon_Nai = new SimpleIntegerProperty(0);
    }

    public ClassTableModelChiTietLonNai(int MS_Chi_Tiet_Lon_Nai, Date ngay_Nhap_Lon_Nai, Date ngay_Phoi, Date ngay_De, int chu_Ky, int so_Lan_Phoi, int so_Lan_De, int so_Con_Con, int so_Con_Chet, int so_Con_Chet_Kho, int so_Con_Di_Tat, int so_Con_Chet_Theo_Me, Date ngay_Xuat_Lon_Nai, int gia_Ban_Lon_Nai) {
        this.MS_Chi_Tiet_Lon_Nai = new SimpleIntegerProperty(MS_Chi_Tiet_Lon_Nai);
        this.Ngay_Nhap_Lon_Nai = new SimpleObjectProperty<>(ngay_Nhap_Lon_Nai);
        this.Ngay_Phoi = new SimpleObjectProperty<>(ngay_Phoi);
        this.Ngay_De = new SimpleObjectProperty<>(ngay_De);
        this.Chu_Ky = new SimpleIntegerProperty(chu_Ky);
        this.So_Lan_Phoi = new SimpleIntegerProperty(so_Lan_Phoi);
        this.So_Lan_De = new SimpleIntegerProperty(so_Lan_De);
        this.So_Con_Con = new SimpleIntegerProperty(so_Con_Con);
        this.So_Con_Chet = new SimpleIntegerProperty(so_Con_Chet);
        this.So_Con_Chet_Kho = new SimpleIntegerProperty(so_Con_Chet_Kho);
        this.So_Con_Di_Tat = new SimpleIntegerProperty(so_Con_Di_Tat);
        this.So_Con_Chet_Theo_Me = new SimpleIntegerProperty(so_Con_Chet_Theo_Me);
        this.Ngay_Xuat_Lon_Nai = new SimpleObjectProperty<>(ngay_Xuat_Lon_Nai);
        this.Gia_Ban_Lon_Nai = new SimpleIntegerProperty(gia_Ban_Lon_Nai);
    }

    public int getMS_Chi_Tiet_Lon_Nai() {
        return MS_Chi_Tiet_Lon_Nai.get();
    }

    public SimpleIntegerProperty MS_Chi_Tiet_Lon_NaiProperty() {
        return MS_Chi_Tiet_Lon_Nai;
    }

    public void setMS_Chi_Tiet_Lon_Nai(int MS_Chi_Tiet_Lon_Nai) {
        this.MS_Chi_Tiet_Lon_Nai.set(MS_Chi_Tiet_Lon_Nai);
    }

    public Object getNgay_Nhap_Lon_Nai() {
        return Ngay_Nhap_Lon_Nai.get();
    }

    public SimpleObjectProperty ngay_Nhap_Lon_NaiProperty() {
        return Ngay_Nhap_Lon_Nai;
    }

    public void setNgay_Nhap_Lon_Nai(Object ngay_Nhap_Lon_Nai) {
        this.Ngay_Nhap_Lon_Nai.set(ngay_Nhap_Lon_Nai);
    }

    public Object getNgay_Phoi() {
        return Ngay_Phoi.get();
    }

    public SimpleObjectProperty ngay_PhoiProperty() {
        return Ngay_Phoi;
    }

    public void setNgay_Phoi(Object ngay_Phoi) {
        this.Ngay_Phoi.set(ngay_Phoi);
    }

    public Object getNgay_De() {
        return Ngay_De.get();
    }

    public SimpleObjectProperty ngay_DeProperty() {
        return Ngay_De;
    }

    public void setNgay_De(Object ngay_De) {
        this.Ngay_De.set(ngay_De);
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

    public int getSo_Lan_Phoi() {
        return So_Lan_Phoi.get();
    }

    public SimpleIntegerProperty so_Lan_PhoiProperty() {
        return So_Lan_Phoi;
    }

    public void setSo_Lan_Phoi(int so_Lan_Phoi) {
        this.So_Lan_Phoi.set(so_Lan_Phoi);
    }

    public int getSo_Lan_De() {
        return So_Lan_De.get();
    }

    public SimpleIntegerProperty so_Lan_DeProperty() {
        return So_Lan_De;
    }

    public void setSo_Lan_De(int so_Lan_De) {
        this.So_Lan_De.set(so_Lan_De);
    }

    public int getSo_Con_Con() {
        return So_Con_Con.get();
    }

    public SimpleIntegerProperty so_Con_ConProperty() {
        return So_Con_Con;
    }

    public void setSo_Con_Con(int so_Con_Con) {
        this.So_Con_Con.set(so_Con_Con);
    }

    public int getSo_Con_Chet() {
        return So_Con_Chet.get();
    }

    public SimpleIntegerProperty so_Con_ChetProperty() {
        return So_Con_Chet;
    }

    public void setSo_Con_Chet(int so_Con_Chet) {
        this.So_Con_Chet.set(so_Con_Chet);
    }

    public int getSo_Con_Chet_Kho() {
        return So_Con_Chet_Kho.get();
    }

    public SimpleIntegerProperty so_Con_Chet_KhoProperty() {
        return So_Con_Chet_Kho;
    }

    public void setSo_Con_Chet_Kho(int so_Con_Chet_Kho) {
        this.So_Con_Chet_Kho.set(so_Con_Chet_Kho);
    }

    public int getSo_Con_Di_Tat() {
        return So_Con_Di_Tat.get();
    }

    public SimpleIntegerProperty so_Con_Di_TatProperty() {
        return So_Con_Di_Tat;
    }

    public void setSo_Con_Di_Tat(int so_Con_Di_Tat) {
        this.So_Con_Di_Tat.set(so_Con_Di_Tat);
    }

    public int getSo_Con_Chet_Theo_Me() {
        return So_Con_Chet_Theo_Me.get();
    }

    public SimpleIntegerProperty so_Con_Chet_Theo_MeProperty() {
        return So_Con_Chet_Theo_Me;
    }

    public void setSo_Con_Chet_Theo_Me(int so_Con_Chet_Theo_Me) {
        this.So_Con_Chet_Theo_Me.set(so_Con_Chet_Theo_Me);
    }

    public Object getNgay_Xuat_Lon_Nai() {
        return Ngay_Xuat_Lon_Nai.get();
    }

    public SimpleObjectProperty ngay_Xuat_Lon_NaiProperty() {
        return Ngay_Xuat_Lon_Nai;
    }

    public void setNgay_Xuat_Lon_Nai(Object ngay_Xuat_Lon_Nai) {
        this.Ngay_Xuat_Lon_Nai.set(ngay_Xuat_Lon_Nai);
    }

    public int getGia_Ban_Lon_Nai() {
        return Gia_Ban_Lon_Nai.get();
    }

    public SimpleIntegerProperty gia_Ban_Lon_NaiProperty() {
        return Gia_Ban_Lon_Nai;
    }

    public void setGia_Ban_Lon_Nai(int gia_Ban_Lon_Nai) {
        this.Gia_Ban_Lon_Nai.set(gia_Ban_Lon_Nai);
    }
}
