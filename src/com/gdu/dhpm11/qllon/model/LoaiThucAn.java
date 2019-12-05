package com.gdu.dhpm11.qllon.model;

public class LoaiThucAn {
    private int MS_Loai_Thuc_An;
    private String Ten_Loai_Thuc_An;

    public LoaiThucAn() {
    }

    public LoaiThucAn(int MS_Loai_Thuc_An, String ten_Loai_Thuc_An) {
        this.MS_Loai_Thuc_An = MS_Loai_Thuc_An;
        Ten_Loai_Thuc_An = ten_Loai_Thuc_An;
    }

    public int getMS_Loai_Thuc_An() {
        return MS_Loai_Thuc_An;
    }

    public void setMS_Loai_Thuc_An(int MS_Loai_Thuc_An) {
        this.MS_Loai_Thuc_An = MS_Loai_Thuc_An;
    }

    public String getTen_Loai_Thuc_An() {
        return Ten_Loai_Thuc_An;
    }

    public void setTen_Loai_Thuc_An(String ten_Loai_Thuc_An) {
        Ten_Loai_Thuc_An = ten_Loai_Thuc_An;
    }

    @Override
    public String toString() {
        return "LoaiThucAn{" +
                "MS_Loai_Thuc_An=" + MS_Loai_Thuc_An +
                ", Ten_Loai_Thuc_An='" + Ten_Loai_Thuc_An + '\'' +
                '}';
    }
}
