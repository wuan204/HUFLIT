package com.example.huflit;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.huflit.object.Truyen;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.jar.JarException;

public class viewstory extends AppCompatActivity {
    private ImageView mbtBack, mbtRp, mbtLove, mbtFl, mbtDown, mbtCmt,mimgStory;

    private Button mbtViewCmt, mbtRead, mbtViewChapter;
    TextView mtxtStrName,mtxtAlias,mtxtCate,mtxtType,txtDescipt,mtxtStt,mview,mtxtLoveNumber;
    private String StrID;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstory);

        requestQueue = Volley.newRequestQueue(this);
     //   init();
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
            mview.setText(String.valueOf(intent.getIntExtra("view",0)));
            mtxtLoveNumber.setText(String.valueOf(intent.getIntExtra("love",0)));

            Glide.with(this).load(anhtruyen).into(mimgStory);

        }
    }

    private void init() {
        Bundle b = getIntent().getBundleExtra("data");
        if (b != null && b.containsKey("StrID")) {
            StrID = b.getString("StrID");
            // Tiếp tục xử lý dữ liệu...
        } else {
            // Xử lý trường hợp key "StrID" không tồn tại (nếu cần)
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
            // Handle View Chapter button click
            // Implement your logic here
        });

        mbtViewCmt.setOnClickListener(v -> {
            // Handle View Comment button click
            // Implement your logic here
        });
    }

}
