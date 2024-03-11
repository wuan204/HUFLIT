package com.example.huflit.object;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.JarException;

public class Truyen_tranh {
    private  String tenTruyen,linkAnh;

    public Truyen_tranh(){
    }
    public Truyen_tranh(JSONObject o) throws JarException, JSONException {

        tenTruyen = o.getString("tenTruyen");
        linkAnh = o.getString("linkAnh");
    }
    public Truyen_tranh(String tenTruyen, String linkAnh) {
        this.tenTruyen = tenTruyen;

        this.linkAnh = linkAnh;
    }



    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getLinkAnh() {
        return linkAnh;
    }

    public void setLinkAnh(String linkAnh) {
        this.linkAnh = linkAnh;
    }


}
