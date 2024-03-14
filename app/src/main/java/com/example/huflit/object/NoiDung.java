package com.example.huflit.object;

public class NoiDung {
    private String txtNoiDung,txtTenchap;

    public NoiDung(String txtNoiDung, String txtTenchap) {
        this.txtNoiDung = txtNoiDung;
        this.txtTenchap = txtTenchap;
    }

    public String getTxtNoiDung() {
        return txtNoiDung;
    }

    public void setTxtNoiDung(String txtNoiDung) {
        this.txtNoiDung = txtNoiDung;
    }

    public String getTxtTenchap() {
        return txtTenchap;
    }

    public void setTxtTenchap(String txtTenchap) {
        this.txtTenchap = txtTenchap;
    }
}
