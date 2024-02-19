package com.example.huflit.itemfilter;

public class Itemft {
    private boolean checked;
    private String nameitem;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getNameitem() {
        return nameitem;
    }

    public void setNameitem(String nameitem) {
        this.nameitem = nameitem;
    }

    public Itemft(boolean checked, String nameitem) {
        this.checked = checked;
        this.nameitem = nameitem;
    }

}
