package com.example.huflit.item;

import org.json.JSONObject;
import org.json.JSONException;


public class category {
    private int id;
    private String namecate;
    public category(int id, String namecate) {
        this.id = id;
        this.namecate = namecate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamecate() {
        return namecate;
    }

    public void setNamecate(String namecate) {
        this.namecate = namecate;
    }
}
