package com.gdu.dhpm11.qllon.model;

public class PieChartClassModel {
    private int MS_Tai_Lon;
    private int So_Con_Con;
    private int So_Con_Chet;

    public int getMS_Tai_Lon() {
        return MS_Tai_Lon;
    }

    public void setMS_Tai_Lon(int MS_Tai_Lon) {
        this.MS_Tai_Lon = MS_Tai_Lon;
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
        return "PieChart{" +
                "MS_Tai_Lon=" + MS_Tai_Lon +
                ", So_Con_Con=" + So_Con_Con +
                ", So_Con_Chet=" + So_Con_Chet +
                '}';
    }
}
