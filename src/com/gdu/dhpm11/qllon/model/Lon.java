package com.gdu.dhpm11.qllon.model;

public class Lon extends LoaiLon {
    private int MS_Tai_Lon;
    private String Gioi_Tinh_Lon;
    private String Tuoi_Lon;

    public Lon() {
        super();
        this.MS_Tai_Lon = 1;
        Gioi_Tinh_Lon = "Cái";
        Tuoi_Lon = "0 tháng 1 ngày";
    }

    public Lon(int MS_Loai_Lon) {
        super(MS_Loai_Lon);
        this.MS_Tai_Lon = 1;
        Gioi_Tinh_Lon = "Cái";
        Tuoi_Lon = "0 tháng 1 ngày";
    }

    public Lon(int MS_Tai_Lon, String gioi_Tinh_Lon, String tuoi_Lon) {
        this.MS_Tai_Lon = MS_Tai_Lon;
        Gioi_Tinh_Lon = gioi_Tinh_Lon;
        Tuoi_Lon = tuoi_Lon;
    }

    public Lon(int MS_Loai_Lon, int MS_Tai_Lon, String gioi_Tinh_Lon, String tuoi_Lon) {
        super(MS_Loai_Lon);
        this.MS_Tai_Lon = MS_Tai_Lon;
        Gioi_Tinh_Lon = gioi_Tinh_Lon;
        Tuoi_Lon = tuoi_Lon;
    }

    public Lon(int MS_Loai_Lon, String ten_Loai_Lon, int MS_Tai_Lon, String gioi_Tinh_Lon, String tuoi_Lon) {
        super(MS_Loai_Lon, ten_Loai_Lon);
        this.MS_Tai_Lon = MS_Tai_Lon;
        Gioi_Tinh_Lon = gioi_Tinh_Lon;
        Tuoi_Lon = tuoi_Lon;
    }

    public int getMS_Tai_Lon() {
        return MS_Tai_Lon;
    }

    public void setMS_Tai_Lon(int MS_Tai_Lon) {
        this.MS_Tai_Lon = MS_Tai_Lon;
    }

    public String getGioi_Tinh_Lon() {
        return Gioi_Tinh_Lon;
    }

    public void setGioi_Tinh_Lon(String gioi_Tinh_Lon) {
        Gioi_Tinh_Lon = gioi_Tinh_Lon;
    }

    public String getTuoi_Lon() {
        return Tuoi_Lon;
    }

    public void setTuoi_Lon(String tuoi_Lon) {
        Tuoi_Lon = tuoi_Lon;
    }

    @Override
    public String toString() {
        return "Lon{" +
                "MS_Tai_Lon=" + MS_Tai_Lon +
                ", Gioi_Tinh_Lon='" + Gioi_Tinh_Lon + '\'' +
                ", Tuoi_Lon='" + Tuoi_Lon + '\'' +
                '}' + "LoaiLon{" + super.toString() + "}";
    }
}
