package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.net.Uri;
import android.provider.MediaStore;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class create_story extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    ImageButton mbtnselect;
    ImageView mbtnCreateComic,mbtbackComic;
    Button mbtnSelectCate;

    TextView mtxtCategory;
    EditText medtnamestory,medtdescripts;
    private Uri selectedImageUri;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_story);
        // anh xa 11
        mbtnselect=(ImageButton) findViewById(R.id.btselectimg);
        mbtnSelectCate=(Button)findViewById(R.id.btselectCate);
        mbtnCreateComic=(ImageView) findViewById(R.id.btnCreateComic);
        mbtbackComic=(ImageView) findViewById(R.id.btbackComic);
        mtxtCategory=(TextView) findViewById(R.id.txtCategory);
        medtdescripts=(EditText) findViewById(R.id.edtDescript) ;
        medtnamestory=(EditText) findViewById(R.id.txtnamestory);
        //
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("checkedItems")) {
            ArrayList<String> checkedItems = bundle.getStringArrayList("checkedItems");
            StringBuilder stringBuilder = new StringBuilder();
            for (String item : checkedItems) {
                stringBuilder.append(item).append("-");
            }
            mtxtCategory.setText(stringBuilder.toString());
        }


        //on click
        mbtnselect.setOnClickListener(v -> {
            // Tạo một Intent để mở thư viện ảnh
            Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
        });
        mbtnSelectCate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(create_story.this, showcate.class);
                startActivity(i);
            }
        });
        mbtnCreateComic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1= new Bundle();
                bundle1.putString("namestory",medtnamestory.getText().toString());
                bundle1.putString("descripts",medtdescripts.getText().toString());
                if(selectedImageUri!=null){ bundle1.putString("imguri",selectedImageUri.toString()); }
                Intent i = new Intent(create_story.this, mycomic.class);
                i.putExtras(bundle1);
                startActivity(i);


            }
        });

    }
    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            selectedImageUri = data.getData();
            ImageView imageView   = findViewById(R.id.imgitem);
            imageView.setImageURI(selectedImageUri);
        }
    }

}