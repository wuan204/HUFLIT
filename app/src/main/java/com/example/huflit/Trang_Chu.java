package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.huflit.adapter.TrangChuAdapter;
import com.example.huflit.truyen_tranh.Truyen_tranh;

import java.util.ArrayList;

public class Trang_Chu extends AppCompatActivity {
    ImageButton trangchu, timkiem, dangbai, menu;

    RecyclerView grvhoanthanh,grvdexuat,grvmoinhat,grvxemnhieu;

    TrangChuAdapter adapter; ArrayList<Truyen_tranh> TruyenTranhArraylist;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        trangchu=findViewById(R.id.buttomtrangchu);
        timkiem=findViewById(R.id.buttomtim);
        dangbai=findViewById(R.id.butomdangbai);
        menu=findViewById(R.id.buttommenu);


        //noi hien ham gridview

        initHoanthanh();
        anhxaHoanThanh();
        setupHoanThanh();
        setclickhoanthanh();

        initmoinhat();
        anhxamoinhat();
        setupmoinhat();
        setclickmoinhat();

        initdexuat();
        anhxadexuat();
        setupdexuat();
        setclickdexuat();

        initxemnhieu();
        anhxaxemnhieu();
        setupxemnhieu();
        setclickxemnhieu();

        // onclick
        trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trang_Chu.this, Trang_Chu.class);
                startActivity(intent);
            }
        });


        timkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trang_Chu.this, Search.class);
                startActivity(intent);
            }
        });



        dangbai.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(Trang_Chu.this, Diolog_dang_ki_truyen.class);
                 startActivity(intent);
            }
        });

        menu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(Trang_Chu.this, Menu.class);
                startActivity(intent);
            }


        });




    }




    /// hiển thị gridview

    //truyen hoan thanh
    public  void  initHoanthanh(){
        TruyenTranhArraylist=new ArrayList<>();


        // tạo truyện
        //mau tao truyen TruyenTranhArraylist.add(new Truyen_tranh("","",""));

        TruyenTranhArraylist.add(new Truyen_tranh("onepiece","30","https://tse1.mm.bing.net/th?id=OIP.yRu5sidk1N67HP1WVYvwxwHaEo&pid=Api&P=0&h=180"));
        TruyenTranhArraylist.add(new Truyen_tranh("doraemon","16","https://www.vooks.net/img/2019/08/doraemon.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("anh hùng trái đất","15","https://cdnnvd.com/nettruyen/thumb/sau-khi-cong-chua-boi-tinh-bac-nghia.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("xuyên không","99","https://cdnnvd.com/nettruyen/thumb/maou-no-ore-ga-dorei-elf-wo-yome-ni-shitanda-ga-dou-medereba-ii.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("tu tiên","32","https://cdnnvd.com/nettruyen/thumb/khoi-dau-co-kiem-vuc-ta-se-tro-thanh-kiem-than.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("no game no life","13","https://cdnnvd.com/nettruyen/thumb/con-quy-ngu-ngoc-dam-nhon-voi-cac-chi-thien-than.jpg"));

        adapter = new TrangChuAdapter(this, TruyenTranhArraylist);

    }
    public void  anhxaHoanThanh(){
        grvhoanthanh=findViewById(R.id.viewhoanthanh);

    }
    public  void setupHoanThanh(){

        grvhoanthanh.setAdapter(adapter);
    }
    public  void  setclickhoanthanh(){}


    //truyện mới nhất

    public  void  initmoinhat(){
        TruyenTranhArraylist=new ArrayList<>();


        // tạo truyện
        //mau tao truyen TruyenTranhArraylist.add(new Truyen_tranh("","",""));

        TruyenTranhArraylist.add(new Truyen_tranh("tu tiên","32","https://cdnnvd.com/nettruyen/thumb/khoi-dau-co-kiem-vuc-ta-se-tro-thanh-kiem-than.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("no game no life","13","https://cdnnvd.com/nettruyen/thumb/con-quy-ngu-ngoc-dam-nhon-voi-cac-chi-thien-than.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("khởi tạo phản diện","93","https://cdnnvd.com/nettruyen/thumb/khoi-tao-nhan-vat-phan-dien.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("đấu thần","44","https://cdnnvd.com/nettruyen/thumb/bach-luyen-thanh-than.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("kỷ nguyên","32","https://nettruyenco.vn/truyen-tranh/ky-nguyen-ky-la-12533"));
        TruyenTranhArraylist.add(new Truyen_tranh("tiến sĩ huyền thoại","11","https://cdnnvd.com/nettruyen/thumb/tien-si-slump.jpg"));

        adapter = new TrangChuAdapter(this, TruyenTranhArraylist);

    }
    public void  anhxamoinhat(){
        grvmoinhat=findViewById(R.id.viewmoinhat);

    }
    public  void setupmoinhat(){

        grvmoinhat.setAdapter(adapter);
    }
    public  void  setclickmoinhat(){}


    // truyện đề xuất

    public  void  initdexuat(){
        TruyenTranhArraylist=new ArrayList<>();


        // tạo truyện
        //mau tao truyen TruyenTranhArraylist.add(new Truyen_tranh("","",""));

        TruyenTranhArraylist.add(new Truyen_tranh("onepiece","30","https://tse1.mm.bing.net/th?id=OIP.yRu5sidk1N67HP1WVYvwxwHaEo&pid=Api&P=0&h=180"));
        TruyenTranhArraylist.add(new Truyen_tranh("tu tiên","32","https://cdnnvd.com/nettruyen/thumb/khoi-dau-co-kiem-vuc-ta-se-tro-thanh-kiem-than.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("no game no life","13","https://cdnnvd.com/nettruyen/thumb/con-quy-ngu-ngoc-dam-nhon-voi-cac-chi-thien-than.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("thiên kim toàn năng","43","https://cdnnvd.com/nettruyen/thumb/thien-kim-toan-nang-trong-sinh.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("hành trình mới","11","https://cdnnvd.com/nettruyen/thumb/kurotonbi-no-seija-tsuihou-sareta-kaifuku-jutsushi-wa-ariamaru-maryoku-de-yami-mahou-wo-kiwameru.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("quyền vô địch","87","https://cdnnvd.com/nettruyen/thumb/nhat-quyen-bao-tinh.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("isekai otomegame","33","https://cdnnvd.com/nettruyen/thumb/nhan-vat-phan-dien-dai-su-huynh-tat-ca-cac-su-muoi-deu-la-benh-kieu.jpg"));

        adapter = new TrangChuAdapter(this, TruyenTranhArraylist);

    }
    public void  anhxadexuat(){
        grvdexuat=findViewById(R.id.viewdexuat);

    }
    public  void setupdexuat(){

        grvdexuat.setAdapter(adapter);
    }
    public  void  setclickdexuat(){}



    //truyện xem nhiều
    public  void  initxemnhieu(){
        TruyenTranhArraylist=new ArrayList<>();


        // tạo truyện
        //mau tao truyen TruyenTranhArraylist.add(new Truyen_tranh("","",""));

        TruyenTranhArraylist.add(new Truyen_tranh("onepiece","30","https://tse1.mm.bing.net/th?id=OIP.yRu5sidk1N67HP1WVYvwxwHaEo&pid=Api&P=0&h=180"));
        TruyenTranhArraylist.add(new Truyen_tranh("no game no life","13","https://cdnnvd.com/nettruyen/thumb/con-quy-ngu-ngoc-dam-nhon-voi-cac-chi-thien-than.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("người trên vạn người","24","https://cdnnvd.com/nettruyen/thumb/ta-nguoi-chi-can-nhin-thay-thanh-mau-co-the-trung-phat-than-linh.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("toàn chức pháp sư","67","https://cdnnvd.com/nettruyen/thumb/toan-chuc-phap-su.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("dược sư kì lạ","12","https://cdnnvd.com/nettruyen/thumb/duoc-su-ki-la-benh-nhan-cua-toi-deu-rat-khung-bo.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("khai thiên phú hộ","32","https://cdnnvd.com/nettruyen/thumb/thien-khai-bai-gia.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("hoa sơn luận kiếm","55","https://cdnnvd.com/nettruyen/thumb/phu-quan-lam-on-de-ta-yen.jpg"));
        TruyenTranhArraylist.add(new Truyen_tranh("chiến binh cách mạng","88","https://cdnnvd.com/nettruyen/thumb/chien-binh-cach-mang-nguoi-cho-con-trinh.jpg"));

        adapter = new TrangChuAdapter(this, TruyenTranhArraylist);

    }
    public void  anhxaxemnhieu(){
        grvxemnhieu=findViewById(R.id.viewxemnhieu);

    }
    public  void setupxemnhieu(){

        grvxemnhieu.setAdapter(adapter);
    }
    public  void  setclickxemnhieu(){}



}
