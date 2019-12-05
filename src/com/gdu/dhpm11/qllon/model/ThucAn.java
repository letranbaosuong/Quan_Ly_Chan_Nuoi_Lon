package com.gdu.dhpm11.qllon.model;

public class ThucAn {
    private int MS_Thuc_An;
    private String Ten_Thuc_An;
    private String Nha_San_Xuat_Thuc_An;
    private int MS_Loai_Thuc_An;

    public ThucAn() {
    }

    public ThucAn(int MS_Thuc_An, String ten_Thuc_An, String nha_San_Xuat_Thuc_An, int MS_Loai_Thuc_An) {
        this.MS_Thuc_An = MS_Thuc_An;
        Ten_Thuc_An = ten_Thuc_An;
        Nha_San_Xuat_Thuc_An = nha_San_Xuat_Thuc_An;
        this.MS_Loai_Thuc_An = MS_Loai_Thuc_An;
    }

    public int getMS_Thuc_An() {
        return MS_Thuc_An;
    }

    public void setMS_Thuc_An(int MS_Thuc_An) {
        this.MS_Thuc_An = MS_Thuc_An;
    }

    public String getTen_Thuc_An() {
        return Ten_Thuc_An;
    }

    public void setTen_Thuc_An(String ten_Thuc_An) {
        Ten_Thuc_An = ten_Thuc_An;
    }

    public String getNha_San_Xuat_Thuc_An() {
        return Nha_San_Xuat_Thuc_An;
    }

    public void setNha_San_Xuat_Thuc_An(String nha_San_Xuat_Thuc_An) {
        Nha_San_Xuat_Thuc_An = nha_San_Xuat_Thuc_An;
    }

    public int getMS_Loai_Thuc_An() {
        return MS_Loai_Thuc_An;
    }

    public void setMS_Loai_Thuc_An(int MS_Loai_Thuc_An) {
        this.MS_Loai_Thuc_An = MS_Loai_Thuc_An;
    }

    @Override
    public String toString() {
        return "ThucAn{" +
                "MS_Thuc_An=" + MS_Thuc_An +
                ", Ten_Thuc_An='" + Ten_Thuc_An + '\'' +
                ", Nha_San_Xuat_Thuc_An='" + Nha_San_Xuat_Thuc_An + '\'' +
                ", MS_Loai_Thuc_An=" + MS_Loai_Thuc_An +
                '}';
    }
}
