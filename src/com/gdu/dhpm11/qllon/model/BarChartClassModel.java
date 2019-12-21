package com.gdu.dhpm11.qllon.model;

public class BarChartClassModel {
    private int MS_Tai_Lon;
    private int Chu_Ky;
    private int So_Con_Con;
    private int So_Con_Chet;

    public BarChartClassModel() {
    }

    public BarChartClassModel(int MS_Tai_Lon, int chu_Ky, int so_Con_Con, int so_Con_Chet) {
        this.MS_Tai_Lon = MS_Tai_Lon;
        Chu_Ky = chu_Ky;
        So_Con_Con = so_Con_Con;
        So_Con_Chet = so_Con_Chet;
    }

    public int getMS_Tai_Lon() {
        return MS_Tai_Lon;
    }

    public void setMS_Tai_Lon(int MS_Tai_Lon) {
        this.MS_Tai_Lon = MS_Tai_Lon;
    }

    public int getChu_Ky() {
        return Chu_Ky;
    }

    public void setChu_Ky(int chu_Ky) {
        Chu_Ky = chu_Ky;
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

    @Override
    public String toString() {
        return "BarChartClassModel{" +
                "MS_Tai_Lon=" + MS_Tai_Lon +
                ", Chu_Ky=" + Chu_Ky +
                ", So_Con_Con=" + So_Con_Con +
                ", So_Con_Chet=" + So_Con_Chet +
                '}';
    }
}
