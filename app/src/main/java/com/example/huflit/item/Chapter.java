    package com.example.huflit.item;

    public class Chapter {
        int id, strid;
        String name;

        public Chapter(int id, int strid,String name) {
            this.id = id;
            this.strid = strid;
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
    }
