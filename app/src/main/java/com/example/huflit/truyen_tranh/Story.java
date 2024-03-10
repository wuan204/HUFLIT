package com.example.huflit.truyen_tranh;

public class Story {
    private int id;
    private String tentruyen, anhtruyen;

    public Story(int id, String tentruyen, String anhtruyen) {
        this.id = id;
        this.tentruyen = tentruyen;
        this.anhtruyen = anhtruyen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTentruyen() {
        return tentruyen;
    }

    public void setTentruyen(String tentruyen) {
        this.tentruyen = tentruyen;
    }

    public String getAnhtruyen() {
        return anhtruyen;
    }

    public void setAnhtruyen(String anhtruyen) {
        this.anhtruyen = anhtruyen;
    }
}
