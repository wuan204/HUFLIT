package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.huflit.itemfilter.ADTFilterGrV;
import com.example.huflit.itemfilter.Itemft;

import java.util.ArrayList;
import java.util.List;

public class filter extends AppCompatActivity {

    private GridView gridView;
    ImageView mbtFilter,mbtBack;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        gridView=findViewById(R.id.gvCate);
        mbtBack=findViewById(R.id.btBack);
        mbtFilter=findViewById(R.id.btFilter);

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
}