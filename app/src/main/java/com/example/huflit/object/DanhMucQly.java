package com.example.huflit.object;

import org.json.JSONException;
import org.json.JSONObject;

public class DanhMucQly {
    private String tenDanhMuc, id;
    public DanhMucQly(){

    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public DanhMucQly(String tenDanhMuc,String id){
        this.tenDanhMuc=tenDanhMuc;
        this.id=id;
    }
    public DanhMucQly(JSONObject o) throws JSONException{
        tenDanhMuc=o.getString("Catename");
        id=o.getString("CateID");

    }
}

