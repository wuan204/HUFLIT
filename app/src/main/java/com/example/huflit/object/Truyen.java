package com.example.huflit.object;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.JarException;

public class Truyen {
    private String tenChap,content;


    public Truyen(JSONObject o) throws JarException, JSONException {
        tenChap = o.getString("ChtName");
        content = o.getString("Content");

    }

    public Truyen(String tenChap,String content ) {
        this.content = content;
        this.tenChap = tenChap;
    }

    public Truyen() {
    }

    public String getTenChap() {
        return tenChap;
    }

    public void setTenChap(String tenChap) {
        this.tenChap = tenChap;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
