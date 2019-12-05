package com.gdu.dhpm11.qllon.model;

import javafx.beans.property.*;

import java.util.Date;

public class test {
    private final StringProperty MS_Chi_Tiet_Lon_Nai;
    private final StringProperty Ngay_Nhap_Lon_Nai;
    private final StringProperty Ngay_Phoi;
    private final StringProperty Ngay_De;
    private final StringProperty Chu_Ky;
    private final StringProperty So_Lan_Phoi;
    private final StringProperty So_Lan_De;
    private final StringProperty So_Con_Con;
    private final StringProperty So_Con_Chet;
    private final StringProperty So_Con_Chet_Kho;
    private final StringProperty So_Con_Di_Tat;
    private final StringProperty So_Con_Chet_Theo_Me;
    private final StringProperty Ngay_Xuat_Lon_Nai;
    private final StringProperty Gia_Ban_Lon_Nai;

    public test(StringProperty MS_Chi_Tiet_Lon_Nai, StringProperty ngay_Nhap_Lon_Nai, StringProperty ngay_Phoi, StringProperty ngay_De, StringProperty chu_Ky, StringProperty so_Lan_Phoi, StringProperty so_Lan_De, StringProperty so_Con_Con, StringProperty so_Con_Chet, StringProperty so_Con_Chet_Kho, StringProperty so_Con_Di_Tat, StringProperty so_Con_Chet_Theo_Me, StringProperty ngay_Xuat_Lon_Nai, StringProperty gia_Ban_Lon_Nai) {
        this.MS_Chi_Tiet_Lon_Nai = MS_Chi_Tiet_Lon_Nai;
        Ngay_Nhap_Lon_Nai = ngay_Nhap_Lon_Nai;
        Ngay_Phoi = ngay_Phoi;
        Ngay_De = ngay_De;
        Chu_Ky = chu_Ky;
        So_Lan_Phoi = so_Lan_Phoi;
        So_Lan_De = so_Lan_De;
        So_Con_Con = so_Con_Con;
        So_Con_Chet = so_Con_Chet;
        So_Con_Chet_Kho = so_Con_Chet_Kho;
        So_Con_Di_Tat = so_Con_Di_Tat;
        So_Con_Chet_Theo_Me = so_Con_Chet_Theo_Me;
        Ngay_Xuat_Lon_Nai = ngay_Xuat_Lon_Nai;
        Gia_Ban_Lon_Nai = gia_Ban_Lon_Nai;
    }
}
