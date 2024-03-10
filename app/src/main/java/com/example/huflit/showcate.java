package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.huflit.itemfilter.ADTFilterGrV;
import com.example.huflit.itemfilter.Itemft;

import java.util.ArrayList;
import java.util.List;

public class showcate extends AppCompatActivity {
    private GridView gridView;
    Button mbtnDone;
    ImageView mbtnbackcate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showcate);
        gridView=findViewById(R.id.grvCate);
        mbtnDone=findViewById(R.id.btnDone);
        //   mbtBack=findViewById(R.id.btBack)
        List<Itemft> mylist=new ArrayList<Itemft>();
        mylist.add(new Itemft(false,"Xuyên không"));
        mylist.add(new Itemft(false,"Kiếm hiệp"));
        mylist.add(new Itemft(false,"Ngôn tình"));
        mylist.add(new Itemft(false,"Dị giới"));
        mylist.add(new Itemft(false,"Dị năng"));
        mylist.add(new Itemft(false,"Hài hước"));
        mylist.add(new Itemft(false,"Ngược"));
        mylist.add(new Itemft(false,"Truyện teen"));
        ////
        ADTFilterGrV adtckbgrview=new ADTFilterGrV(this,mylist,getLayoutInflater());
        gridView.setAdapter(adtckbgrview);
        mbtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> checkedItems= adtckbgrview.getCheckedItems();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("checkedItems", (ArrayList<String>) checkedItems);
                Intent intent = new Intent(showcate.this, create_story.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

    }

}
