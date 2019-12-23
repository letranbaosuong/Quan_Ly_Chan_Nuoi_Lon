package com.gdu.dhpm11.qllon.model;

public class BaoCaoChiTietLonNai_LichTiem {
    private int stt;
    private int maTai;
    private int chuKy;
    private int chuKy_21ngay;
    private int chuKy_42ngay;
    private int chuKy_84ngay;
    private int ngayDe;
    private int ta;
    private int ecoli;
    private int tayGiun;
    private int parvo;
    private int fe_coc;
    private int suyen;
    private int prrs;

    public BaoCaoChiTietLonNai_LichTiem() {
    }

    public BaoCaoChiTietLonNai_LichTiem(int stt, int maTai, int chuKy, int chuKy_21ngay, int chuKy_42ngay, int chuKy_84ngay, int ngayDe, int ta, int ecoli, int tayGiun, int parvo, int fe_coc, int suyen, int prrs) {
        this.stt = stt;
        this.maTai = maTai;
        this.chuKy = chuKy;
        this.chuKy_21ngay = chuKy_21ngay;
        this.chuKy_42ngay = chuKy_42ngay;
        this.chuKy_84ngay = chuKy_84ngay;
        this.ngayDe = ngayDe;
        this.ta = ta;
        this.ecoli = ecoli;
        this.tayGiun = tayGiun;
        this.parvo = parvo;
        this.fe_coc = fe_coc;
        this.suyen = suyen;
        this.prrs = prrs;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getMaTai() {
        return maTai;
    }

    public void setMaTai(int maTai) {
        this.maTai = maTai;
    }

    public int getChuKy() {
        return chuKy;
    }

    public void setChuKy(int chuKy) {
        this.chuKy = chuKy;
    }

    public int getChuKy_21ngay() {
        return chuKy_21ngay;
    }

    public void setChuKy_21ngay(int chuKy_21ngay) {
        this.chuKy_21ngay = chuKy_21ngay;
    }

    public int getChuKy_42ngay() {
        return chuKy_42ngay;
    }

    public void setChuKy_42ngay(int chuKy_42ngay) {
        this.chuKy_42ngay = chuKy_42ngay;
    }

    public int getChuKy_84ngay() {
        return chuKy_84ngay;
    }

    public void setChuKy_84ngay(int chuKy_84ngay) {
        this.chuKy_84ngay = chuKy_84ngay;
    }

    public int getNgayDe() {
        return ngayDe;
    }

    public void setNgayDe(int ngayDe) {
        this.ngayDe = ngayDe;
    }

    public int getTa() {
        return ta;
    }

    public void setTa(int ta) {
        this.ta = ta;
    }

    public int getEcoli() {
        return ecoli;
    }

    public void setEcoli(int ecoli) {
        this.ecoli = ecoli;
    }

    public int getTayGiun() {
        return tayGiun;
    }

    public void setTayGiun(int tayGiun) {
        this.tayGiun = tayGiun;
    }

    public int getParvo() {
        return parvo;
    }

    public void setParvo(int parvo) {
        this.parvo = parvo;
    }

    public int getFe_coc() {
        return fe_coc;
    }

    public void setFe_coc(int fe_coc) {
        this.fe_coc = fe_coc;
    }

    public int getSuyen() {
        return suyen;
    }

    public void setSuyen(int suyen) {
        this.suyen = suyen;
    }

    public int getPrrs() {
        return prrs;
    }

    public void setPrrs(int prrs) {
        this.prrs = prrs;
    }

    @Override
    public String toString() {
        return "BaoCaoChiTietLonNai_LichTiem{" +
                "stt=" + stt +
                ", maTai=" + maTai +
                ", chuKy=" + chuKy +
                ", chuKy_21ngay=" + chuKy_21ngay +
                ", chuKy_42ngay=" + chuKy_42ngay +
                ", chuKy_84ngay=" + chuKy_84ngay +
                ", ngayDe=" + ngayDe +
                ", ta=" + ta +
                ", ecoli=" + ecoli +
                ", tayGiun=" + tayGiun +
                ", parvo=" + parvo +
                ", fe_coc=" + fe_coc +
                ", suyen=" + suyen +
                ", prrs=" + prrs +
                '}';
    }
}
