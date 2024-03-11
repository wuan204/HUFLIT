package com.example.huflit.object;

public class Noi_Dung {

   private String tenChap;
   private String noiDung;
  // private String congKhai;

   public Noi_Dung(String tenChap, String noiDung) {
      this.tenChap = tenChap;
      this.noiDung = noiDung;
      //this.congKhai = congKhai;
   }

//   public String getCongKhai() {
//      return congKhai;
//   }
//
//   public void setCongKhai(String congKhai) {
//      this.congKhai = congKhai;
//   }

   public String getTenChap() {
      return tenChap;
   }

   public void setTenChap(String tenChap) {
      this.tenChap = tenChap;
   }

   public String getNoiDung() {
      return noiDung;
   }

   public void setNoiDung(String noiDung) {
      this.noiDung = noiDung;
   }
}
