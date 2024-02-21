package com.example.huflit.truyen_tranh;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.JarException;

public class Truyen_tranh {
    private  String tenTruyen,tenChap,linkAnh;

    public Truyen_tranh(){
    }
    public Truyen_tranh(JSONObject o) throws JarException, JSONException {
        tenTruyen = o.getString("tenTruyen");
        tenChap = o.getString("tenChap");
        linkAnh = o.getString("linkAnh");
    }
    public Truyen_tranh(String tenTruyen, String tenChap, String linkAnh) {
        this.tenTruyen = tenTruyen;
        this.tenChap = tenChap;
        this.linkAnh = linkAnh;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getTenChap() {
        return tenChap;
    }

    public void setTenChap(String tenChap) {
        this.tenChap = tenChap;
    }

    public String getLinkAnh() {
        return linkAnh;
    }

    public void setLinkAnh(String linkAnh) {
        this.linkAnh = linkAnh;
    }


}
