package com.example.huflit.object;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.JarException;

public class Truyen {
    private String TenTruyen,TrangThai,linkAnh,TomTat,NgayDang,Viewer,Love,Rating,AuthorID,StrID;

    public Truyen(){
    }
    public Truyen(JSONObject o) throws JarException, JSONException {
        TenTruyen = o.getString("tenTruyen");
        TrangThai = o.getString("TrangThai");
        linkAnh = o.getString("linkAnh");
        TomTat = o.getString("TomTat");
//        NgayDang = o.getString("NgayDang");
        Viewer = o.getString("Viewer");
        Love = o.getString("Love");
        Rating = o.getString("Rating");
        AuthorID = o.getString("AuthorID");
        StrID = o.getString("StrID");
    }

    public Truyen(String tenTruyen, String trangThai, String linkAnh, String tomTat, String ngayDang, String viewer, String love, String rating, String authorid) {
        TenTruyen = tenTruyen;
        TrangThai = trangThai;
        this.linkAnh = linkAnh;
        TomTat = tomTat;
//        NgayDang = ngayDang;
        Viewer = viewer;
        Love = love;
        Rating = rating;
        AuthorID = authorid;
    }

    public String getStrID() {
        return StrID;
    }

    public void setStrID(String strID) {
        StrID = strID;
    }

    public String getTenTruyen() {
        return TenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        TenTruyen = tenTruyen;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    public String getLinkAnh() {
        return linkAnh;
    }

    public void setLinkAnh(String linkAnh) {
        this.linkAnh = linkAnh;
    }

    public String getTomTat() {
        return TomTat;
    }

    public void setTomTat(String tomTat) {
        TomTat = tomTat;
    }

//    public String getNgayDang() {
//        return NgayDang;
//    }
//
//    public void setNgayDang(String ngayDang) {
//        NgayDang = ngayDang;
//    }

    public String getViewer() {
        return Viewer;
    }

    public void setViewer(String viewer) {
        Viewer = viewer;
    }

    public String getLove() {
        return Love;
    }

    public void setLove(String love) {
        Love = love;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getAuthor() {
        return AuthorID;
    }

    public void setAuthor(String authorid) {
        AuthorID = authorid;
    }
}
