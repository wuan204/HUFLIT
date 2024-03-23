package com.example.huflit.api;

public class APIDanhMuc {

    private int CateID;
    private String Catename;

    public APIDanhMuc(int CateID, String Catename) {
        this.CateID = CateID;
        this.Catename = Catename;
    }

    public int getId() {
        return CateID;
    }

    public String getName() {
        return Catename ;
    }


}
