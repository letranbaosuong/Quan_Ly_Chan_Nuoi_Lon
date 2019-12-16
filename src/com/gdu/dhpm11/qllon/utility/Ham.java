package com.gdu.dhpm11.qllon.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Ham {
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

    public Date CongNgay(Date ngayCanCong, int soNgayCanCong) {

        LocalDate ngayTam = convertToLocalDateViaSqlDate(ngayCanCong);
        ngayTam = ngayTam.plusDays(soNgayCanCong);

        return convertToDateViaSqlDate(ngayTam);
    }

    public Date TruNgay(Date ngayCanTru, int soNgayCanTru) {
        LocalDate ngayTam = convertToLocalDateViaSqlDate(ngayCanTru);
        ngayTam = ngayTam.minusDays(soNgayCanTru);

        return convertToDateViaSqlDate(ngayTam);
    }

    public String DateToString(Date date) {
        return dateFormat.format(date);
    }

    public Date StringToDate(String date) {
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("Loi Class Ham public Date StringToDate(String date){}");
        }
        return null;
    }

    public LocalDate StringToLocalDate(String date) {
        return LocalDate.parse(date, dateTimeFormatter);
    }

    public long TuoiLon(String ngayNhapChuong, String ngayHienTai) {
        LocalDate d1 = LocalDate.parse(ngayNhapChuong, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate d2 = LocalDate.parse(ngayHienTai, DateTimeFormatter.ISO_LOCAL_DATE);
        Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
        long diffDays = diff.toDays();
        return diffDays;
    }

    public static void main(String[] args) {
        Ham ham = new Ham();
        System.out.println(ham.TuoiLon("2019-12-01", LocalDate.now().toString()));
    }
}
