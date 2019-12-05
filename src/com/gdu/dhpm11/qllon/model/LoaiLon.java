package com.gdu.dhpm11.qllon.model;

public class LoaiLon {
    private int MS_Loai_Lon;
    private String Ten_Loai_Lon;

    public LoaiLon() {
        this.MS_Loai_Lon = 1;
        Ten_Loai_Lon = "Lợn nái";
    }

    public LoaiLon(int MS_Loai_Lon) {
        this.MS_Loai_Lon = MS_Loai_Lon;
        Ten_Loai_Lon = "Lợn nái";
    }

    public LoaiLon(int MS_Loai_Lon, String ten_Loai_Lon) {
        this.MS_Loai_Lon = MS_Loai_Lon;
        Ten_Loai_Lon = ten_Loai_Lon;
    }

    public int getMS_Loai_Lon() {
        return MS_Loai_Lon;
    }

    public void setMS_Loai_Lon(int MS_Loai_Lon) {
        this.MS_Loai_Lon = MS_Loai_Lon;
    }

    public String getTen_Loai_Lon() {
        return Ten_Loai_Lon;
    }

    public void setTen_Loai_Lon(String ten_Loai_Lon) {
        Ten_Loai_Lon = ten_Loai_Lon;
    }

    @Override
    public String toString() {
        return "LoaiLon{" +
                "MS_Loai_Lon=" + MS_Loai_Lon +
                ", Ten_Loai_Lon='" + Ten_Loai_Lon + '\'' +
                '}';
    }
}
