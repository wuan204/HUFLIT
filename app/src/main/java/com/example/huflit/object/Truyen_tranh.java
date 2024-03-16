    package com.example.huflit.object;

    import org.json.JSONException;
    import org.json.JSONObject;

    import java.util.jar.JarException;

    public class Truyen_tranh   {

        private  String tenTruyen,linkAnh,alias,danhmuc,tomtat,capnhat,theloai,status,content,tenchap;
        private int view,love,id;
        private  double rating;

        public Truyen_tranh(){
        }
        public Truyen_tranh(JSONObject o) throws JarException, JSONException {
            tenTruyen = o.getString("tenTruyen");
            linkAnh = o.getString("linkAnh");
            alias=o.getString("alias");
            danhmuc=o.getString("danhMuc");
            tomtat=o.getString("tomTat");
            capnhat=o.getString("lastUpdate");
            view=o.getInt("view");
            love=o.getInt("love");
            theloai= o.getString("type");
            rating=o.getDouble("rating");
            status=o.getString("status");
        }

        public Truyen_tranh(int id,String tenTruyen, String linkAnh, String alias, String danhmuc, String tomtat, String capnhat, String theloai,  int view, int love, double rating, String status) {
            this.tenTruyen = tenTruyen;
            this.linkAnh = linkAnh;
            this.alias = alias;
            this.danhmuc = danhmuc;
            this.tomtat = tomtat;
            this.capnhat = capnhat;
            this.theloai = theloai;
            this.view = view;
            this.love = love;
            this.rating = rating;
            this.status=status;
this.id=id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTheloai() {
            return theloai;
        }

        public void setTheloai(String theloai) {
            this.theloai = theloai;
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

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getDanhmuc() {
            return danhmuc;
        }

        public void setDanhmuc(String danhmuc) {
            this.danhmuc = danhmuc;
        }

        public String getTomtat() {
            return tomtat;
        }

        public void setTomtat(String tomtat) {
            this.tomtat = tomtat;
        }

        public String getCapnhat() {
            return capnhat;
        }

        public void setCapnhat(String capnhat) {
            this.capnhat = capnhat;
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

        public String getTenchap() {
            return tenchap;
        }

        public String getContent() {
            return content;
        }
    }
