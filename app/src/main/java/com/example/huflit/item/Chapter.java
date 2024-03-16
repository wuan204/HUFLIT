    package com.example.huflit.item;

    public class Chapter {
        int id, strid;
        String name, content;

        public Chapter(int id, int strid,String name, String content) {
            this.id = id;
            this.strid = strid;
            this.content = content;
            this.name=name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getStrid() {
            return strid;
        }

        public void setStrid(int strid) {
            this.strid = strid;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
