package com.example.huflit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class viewstory extends AppCompatActivity {
    private ImageView mbtBack, mbtRp, mbtLove, mbtFl, mbtDown, mbtCmt,mimgStory;
   public int id;
RatingBar ratingBar;
    private Button mbtViewCmt, mbtRead, mbtViewChapter;
    TextView mtxtStrName,mtxtAlias,mtxtCate,mtxtType,txtDescipt,mtxtStt,mview,mtxtLoveNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstory);

        anhxa();
        setclick();

        //
        Intent intent=getIntent();
        if(intent!=null){
            String tentruyen=intent.getStringExtra("ten_truyen");
            String anhtruyen= intent.getStringExtra("anh_truyen");
            String danhmuc=intent.getStringExtra("danhmuc");
            if(danhmuc==null){danhmuc="Khác";}
            mtxtStrName.setText(tentruyen);
            mtxtAlias.setText(intent.getStringExtra("tac_gia").toString());
            mtxtCate.setText(danhmuc);
            mtxtType.setText(intent.getStringExtra("theloai").toString());
            txtDescipt.setText(intent.getStringExtra("tomtat").toString());
            mtxtStt.setText(intent.getStringExtra("trangthai").toString());
            mview.setText(String.valueOf(intent.getIntExtra("view",0))+" lượt");
            mtxtLoveNumber.setText(String.valueOf(intent.getIntExtra("love",0))+" lượt");
            float rating=(float) intent.getDoubleExtra("rating",0);
            ratingBar.setRating(rating);
            Glide.with(this).load(anhtruyen).into(mimgStory);
            id=intent.getIntExtra("id",0);
        }
    }
    private void anhxa() {
        // Initialize your UI components here
        mbtBack = findViewById(R.id.btBack);
        mbtRp = findViewById(R.id.btReport);
        mbtLove = findViewById(R.id.btLove);
        mbtFl = findViewById(R.id.btFl);
        mbtDown = findViewById(R.id.btDown);
        mbtViewCmt = findViewById(R.id.btViewCmt);
        mbtCmt = findViewById(R.id.btCmt);
        mbtRead = findViewById(R.id.btRead);
        mbtViewChapter = findViewById(R.id.btViewChapter);
        mtxtStrName=findViewById(R.id.txtStrName);
        mimgStory=findViewById(R.id.imgStory);
        mtxtAlias=findViewById(R.id.txtAlias);
        mtxtCate=findViewById(R.id.txtCate);
        mtxtType=findViewById(R.id.txtType);
        txtDescipt=findViewById(R.id.txtDescipt);
        mtxtStt=findViewById(R.id.txtStt);
        mview = findViewById(R.id.txtViewNumber);
        mtxtLoveNumber=findViewById(R.id.txtLoveNumber);
        ratingBar=findViewById(R.id.ratingView);
    }

    private void setclick() {
        mbtBack.setOnClickListener(v -> finish());

        mbtRp.setOnClickListener(v -> {
            // Handle Report button click
            // ShowDialogRp();
        });

//        mbtLove.setOnClickListener(v -> {
//            // Handle Love button click
//            // Toggle the love state and update UI
//            boolean isLoved = // Determine the state based on your data
//            if (isLoved) {
//                mbtLove.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
//            } else {
//                mbtLove.clearColorFilter();
//            }
//        });

        mbtRead.setOnClickListener(v -> {
            // Handle Read button click
            Intent i = new Intent(viewstory.this, Content.class);

            startActivity(i);
        });

        mbtViewChapter.setOnClickListener(v -> {
      Intent i=new Intent(viewstory.this, listChapter.class);
            i.putExtra("id",id);

      startActivity(i);
        });

        mbtViewCmt.setOnClickListener(v -> {
            // Handle View Comment button click
            // Implement your logic here
        });
    }

}
