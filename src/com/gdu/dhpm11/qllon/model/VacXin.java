package com.gdu.dhpm11.qllon.model;

public class VacXin {
    private int MS_Vac_Xin;
    private String Ten_Vac_Xin;
    private int MS_Loai_Vac_Xin;

    public VacXin() {
    }

    public VacXin(int MS_Vac_Xin, String ten_Vac_Xin, int MS_Loai_Vac_Xin) {
        this.MS_Vac_Xin = MS_Vac_Xin;
        Ten_Vac_Xin = ten_Vac_Xin;
        this.MS_Loai_Vac_Xin = MS_Loai_Vac_Xin;
    }

    public int getMS_Vac_Xin() {
        return MS_Vac_Xin;
    }

    public void setMS_Vac_Xin(int MS_Vac_Xin) {
        this.MS_Vac_Xin = MS_Vac_Xin;
    }

    public String getTen_Vac_Xin() {
        return Ten_Vac_Xin;
    }

    public void setTen_Vac_Xin(String ten_Vac_Xin) {
        Ten_Vac_Xin = ten_Vac_Xin;
    }

    public int getMS_Loai_Vac_Xin() {
        return MS_Loai_Vac_Xin;
    }

    public void setMS_Loai_Vac_Xin(int MS_Loai_Vac_Xin) {
        this.MS_Loai_Vac_Xin = MS_Loai_Vac_Xin;
    }

    @Override
    public String toString() {
        return "VacXin{" +
                "MS_Vac_Xin=" + MS_Vac_Xin +
                ", Ten_Vac_Xin='" + Ten_Vac_Xin + '\'' +
                ", MS_Loai_Vac_Xin=" + MS_Loai_Vac_Xin +
                '}';
    }
}
