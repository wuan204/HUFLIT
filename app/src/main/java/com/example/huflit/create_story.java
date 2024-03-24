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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class create_story extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    ImageButton mbtnselect;
    ImageView mbtnCreateComic,mbtbackComic;
    Button mbtnSelectCate;

    TextView mtxtCategory;
    EditText medtnamestory,medtdescripts;
    RadioButton comic, word;
    private Uri selectedImageUri;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_story);
        // anh xa 11
        mbtnselect=(ImageButton) findViewById(R.id.btselectimg);
        mbtnCreateComic=(ImageView) findViewById(R.id.btnCreateComic);
        mbtbackComic=(ImageView) findViewById(R.id.btbackComic);
        medtdescripts=(EditText) findViewById(R.id.edtDescript) ;
        medtnamestory=(EditText) findViewById(R.id.txtnamestory);
        comic=findViewById(R.id.rdocomic);
        word=findViewById(R.id.rdoword);
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
        mbtnselect.setOnClickListener(v -> {
            Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
        });

        mbtnCreateComic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedImageUri!=null){   Intent i = new Intent(create_story.this, mycomic.class);
                    //

                    //
                    i.putExtra("namestory",medtnamestory.getText().toString());
                    i.putExtra("descripts",medtdescripts.getText().toString());
                    i.putExtra("imguri",selectedImageUri.toString());
                    String type="";
                    if (comic.isChecked()) {
                        type = "Truyện tranh";
                    } else {
                        type = "Truyện chữ";}
                    i.putExtra("type",type);
                    startActivity(i); }
              else {
                    Toast.makeText(create_story.this, "Hãy chọn ảnh cho truyện của bạn", Toast.LENGTH_SHORT).show();
                }
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