package com.example.huflit.item;

public class StoryFull {
    private int id,view,love;
    private double rating;
    private String name,img,alias,categoies,status,show,descipt,type;

    public StoryFull(int id, int view, int love, double rating, String name, String img, String alias, String categoies, String status, String show, String descipt, String type) {
        this.id = id;
        this.view = view;
        this.love = love;
        this.rating = rating;
        this.name = name;
        this.img = img;
        this.alias = alias;
        this.categoies = categoies;
        this.status = status;
        this.show = show;
        this.descipt = descipt;
        this.type = type;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCategoies() {
        return categoies;
    }

    public void setCategoies(String categoies) {
        this.categoies = categoies;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getDescipt() {
        return descipt;
    }

    public void setDescipt(String descipt) {
        this.descipt = descipt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
