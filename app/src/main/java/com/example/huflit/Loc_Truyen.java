package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.huflit.itemfilter.ADTFilterGrV;
import com.example.huflit.itemfilter.Itemft;

import java.util.ArrayList;
import java.util.List;

public class Loc_Truyen extends AppCompatActivity {

    private GridView gridView;
    ImageView mbtBack,imgBack;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loc_truyen);
        gridView=findViewById(R.id.gvCate);
        mbtBack=findViewById(R.id.btBack);
        imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        List<Itemft> mylist=new ArrayList<Itemft>();
        mylist.add(new Itemft(false,"Xuyên không"));
        mylist.add(new Itemft(false,"Kiếm hiệp"));
        mylist.add(new Itemft(false,"Ngôn tình"));
        mylist.add(new Itemft(false,"Dị giới"));
        mylist.add(new Itemft(false,"Dị năng"));
        mylist.add(new Itemft(false,"Hài hước"));
        mylist.add(new Itemft(false,"Ngược"));
        mylist.add(new Itemft(false,"Truyện teen"));
        gridView.setAdapter(new ADTFilterGrV(this,mylist,getLayoutInflater()));

    }

    public void show(FragmentManager supportFragmentManager, String filterDialogFragment) {
    }
}