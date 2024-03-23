package com.example.huflit.item;
import java.io.Serializable;

public class User implements Serializable{
    private  int userid,role;
    private  String name,email,pass;

    public User(int userid, int role, String name, String email, String pass) {
        this.userid = userid;
        this.role = role;
        this.name = name;
        this.email = email;
        this.pass = pass;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}
