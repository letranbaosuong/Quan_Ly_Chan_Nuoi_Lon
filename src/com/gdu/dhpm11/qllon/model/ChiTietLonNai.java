package com.gdu.dhpm11.qllon.model;

import javafx.beans.property.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class ChiTietLonNai extends Lon {
    private int MS_Chi_Tiet_Lon_Nai;
    private Date Ngay_Nhap_Lon_Nai;
    private Date Ngay_Phoi;
    private Date Ngay_De;
    private int Chu_Ky;
    private int So_Lan_Phoi;
    private int So_Lan_De;
    private int So_Con_Con;
    private int So_Con_Chet;
    private int So_Con_Chet_Kho;
    private int So_Con_Di_Tat;
    private int So_Con_Chet_Theo_Me;
    private Date Ngay_Xuat_Lon_Nai;
    private int Gia_Ban_Lon_Nai;

    //    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    private void Test() {
        /*
        // Test
        System.out.println(dateFormat.format(ngayCanCong));

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(ngayCanCong);

        // manipulate date
        c.add(Calendar.YEAR, 0);
        c.add(Calendar.MONTH, 0);
        c.add(Calendar.DATE, soNgayCanCong); //same with c.add(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.HOUR, 0);
        c.add(Calendar.MINUTE, 0);
        c.add(Calendar.SECOND, 0);

        // convert calendar to date
        Date ngayDaCong = c.getTime();

        System.out.println(dateFormat.format(ngayDaCong));

        return ngayDaCong;

        System.out.println("Today: " + LocalDate.now());
        System.out.println("Tomorrow: " + LocalDate.now().plusDays(1));
        System.out.println("yesterday: " + LocalDate.now().minusDays(1));
        System.out.println("Next week: " + LocalDate.now().plusWeeks(1));
        System.out.println("Next month: " + LocalDate.now().plusMonths(1));
        System.out.println("Next year: " + LocalDate.now().plusYears(1));
        System.out.println("Before year: " + LocalDate.now().minusYears(1));

        String date = "2019-11-27";

        //default, ISO_LOCAL_DATE
        LocalDate localDate = LocalDate.parse(date);
        System.out.println(localDate);
//        LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
        localDate = localDate.plusDays(4);
        System.out.println(dateTimeFormatter.format(localDate));

        */

        try {
            String sDate1 = "2019-11-08";
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
            System.out.println(sDate1);
            System.out.println(CongNgay(date1, 115));
        } catch (ParseException e) {
            System.out.println("Loi Test() : " + e.toString());
        }
    }

    private Date CongNgay(Date ngayCanCong, int soNgayCanCong) {

        LocalDate ngayTam = convertToLocalDateViaSqlDate(ngayCanCong);
        ngayTam = ngayTam.plusDays(soNgayCanCong);

        return convertToDateViaSqlDate(ngayTam);
    }

    private Date TruNgay(Date ngayCanTru, int soNgayCanTru) {
        LocalDate ngayTam = convertToLocalDateViaSqlDate(ngayCanTru);
        ngayTam = ngayTam.minusDays(soNgayCanTru);

        return convertToDateViaSqlDate(ngayTam);
    }

    public ChiTietLonNai() {
        super();
        this.MS_Chi_Tiet_Lon_Nai = 1;
        this.Ngay_Nhap_Lon_Nai = new Date();
        this.Ngay_Phoi = CongNgay(this.Ngay_Nhap_Lon_Nai,180);
        this.Ngay_De = CongNgay(this.Ngay_Phoi,115);
        this.Chu_Ky = 1;
        this.So_Lan_Phoi = 0;
        this.So_Lan_De = 0;
        this.So_Con_Con = 0;
        this.So_Con_Chet = 0;
        this.So_Con_Chet_Kho = 0;
        this.So_Con_Di_Tat = 0;
        this.So_Con_Chet_Theo_Me = 0;
        this.Ngay_Xuat_Lon_Nai = CongNgay(Ngay_Nhap_Lon_Nai,365);
        this.Gia_Ban_Lon_Nai = 30000;
    }

    public ChiTietLonNai(int MS_Chi_Tiet_Lon_Nai, Date ngay_Nhap_Lon_Nai, Date ngay_Phoi, Date ngay_De, int chu_Ky, int so_Lan_Phoi, int so_Lan_De, int so_Con_Con, int so_Con_Chet, int so_Con_Chet_Kho, int so_Con_Di_Tat, int so_Con_Chet_Theo_Me, Date ngay_Xuat_Lon_Nai, int gia_Ban_Lon_Nai) {
        this.MS_Chi_Tiet_Lon_Nai = MS_Chi_Tiet_Lon_Nai;
        this.Ngay_Nhap_Lon_Nai = ngay_Nhap_Lon_Nai;
        this.Ngay_Phoi = ngay_Phoi;
        this.Ngay_De = ngay_De;
        this.Chu_Ky = chu_Ky;
        this.So_Lan_Phoi = so_Lan_Phoi;
        this.So_Lan_De = so_Lan_De;
        this.So_Con_Con = so_Con_Con;
        this.So_Con_Chet = so_Con_Chet;
        this.So_Con_Chet_Kho = so_Con_Chet_Kho;
        this.So_Con_Di_Tat = so_Con_Di_Tat;
        this.So_Con_Chet_Theo_Me = so_Con_Chet_Theo_Me;
        this.Ngay_Xuat_Lon_Nai = ngay_Xuat_Lon_Nai;
        this.Gia_Ban_Lon_Nai = gia_Ban_Lon_Nai;
    }

    public int getMS_Chi_Tiet_Lon_Nai() {
        return MS_Chi_Tiet_Lon_Nai;
    }

    public void setMS_Chi_Tiet_Lon_Nai(int MS_Chi_Tiet_Lon_Nai) {
        this.MS_Chi_Tiet_Lon_Nai = MS_Chi_Tiet_Lon_Nai;
    }

    public Date getNgay_Nhap_Lon_Nai() {
        return Ngay_Nhap_Lon_Nai;
    }

    public void setNgay_Nhap_Lon_Nai(Date ngay_Nhap_Lon_Nai) {
        Ngay_Nhap_Lon_Nai = ngay_Nhap_Lon_Nai;
    }

    public Date getNgay_Phoi() {
        return Ngay_Phoi;
    }

    public void setNgay_Phoi(Date ngay_Phoi) {
        Ngay_Phoi = ngay_Phoi;
    }

    public Date getNgay_De() {
        return Ngay_De;
    }

    public void setNgay_De(Date ngay_De) {
        Ngay_De = ngay_De;
    }

    public int getChu_Ky() {
        return Chu_Ky;
    }

    public void setChu_Ky(int chu_Ky) {
        Chu_Ky = chu_Ky;
    }

    public int getSo_Lan_Phoi() {
        return So_Lan_Phoi;
    }

    public void setSo_Lan_Phoi(int so_Lan_Phoi) {
        So_Lan_Phoi = so_Lan_Phoi;
    }

    public int getSo_Lan_De() {
        return So_Lan_De;
    }

    public void setSo_Lan_De(int so_Lan_De) {
        So_Lan_De = so_Lan_De;
    }

    public int getSo_Con_Con() {
        return So_Con_Con;
    }

    public void setSo_Con_Con(int so_Con_Con) {
        So_Con_Con = so_Con_Con;
    }

    public int getSo_Con_Chet() {
        return So_Con_Chet;
    }

    public void setSo_Con_Chet(int so_Con_Chet) {
        So_Con_Chet = so_Con_Chet;
    }

    public int getSo_Con_Chet_Kho() {
        return So_Con_Chet_Kho;
    }

    public void setSo_Con_Chet_Kho(int so_Con_Chet_Kho) {
        So_Con_Chet_Kho = so_Con_Chet_Kho;
    }

    public int getSo_Con_Di_Tat() {
        return So_Con_Di_Tat;
    }

    public void setSo_Con_Di_Tat(int so_Con_Di_Tat) {
        So_Con_Di_Tat = so_Con_Di_Tat;
    }

    public int getSo_Con_Chet_Theo_Me() {
        return So_Con_Chet_Theo_Me;
    }

    public void setSo_Con_Chet_Theo_Me(int so_Con_Chet_Theo_Me) {
        So_Con_Chet_Theo_Me = so_Con_Chet_Theo_Me;
    }

    public Date getNgay_Xuat_Lon_Nai() {
        return Ngay_Xuat_Lon_Nai;
    }

    public void setNgay_Xuat_Lon_Nai(Date ngay_Xuat_Lon_Nai) {
        Ngay_Xuat_Lon_Nai = ngay_Xuat_Lon_Nai;
    }

    public int getGia_Ban_Lon_Nai() {
        return Gia_Ban_Lon_Nai;
    }

    public void setGia_Ban_Lon_Nai(int gia_Ban_Lon_Nai) {
        Gia_Ban_Lon_Nai = gia_Ban_Lon_Nai;
    }

    @Override
    public String toString() {
        return "ChiTietLonNai{" +
                "MS_Chi_Tiet_Lon_Nai=" + MS_Chi_Tiet_Lon_Nai +
                ", Ngay_Nhap_Lon_Nai=" + Ngay_Nhap_Lon_Nai +
                ", Ngay_Phoi=" + Ngay_Phoi +
                ", Ngay_De=" + Ngay_De +
                ", Chu_Ky=" + Chu_Ky +
                ", So_Lan_Phoi=" + So_Lan_Phoi +
                ", So_Lan_De=" + So_Lan_De +
                ", So_Con_Con=" + So_Con_Con +
                ", So_Con_Chet=" + So_Con_Chet +
                ", So_Con_Chet_Kho=" + So_Con_Chet_Kho +
                ", So_Con_Di_Tat=" + So_Con_Di_Tat +
                ", So_Con_Chet_Theo_Me=" + So_Con_Chet_Theo_Me +
                ", Ngay_Xuat_Lon_Nai=" + Ngay_Xuat_Lon_Nai +
                ", Gia_Ban_Lon_Nai=" + Gia_Ban_Lon_Nai +
                '}';
    }

    public static void main(String[] args) {
        new ChiTietLonNai();
    }
}
