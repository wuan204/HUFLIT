package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;import android.provider.MediaStore;
import android.widget.Spinner;
import android.widget.TextView;

import static android.app.Activity.RESULT_OK;

public class mycomic extends AppCompatActivity {
    ImageView mbtnAddchapter;
    EditText medtname,medtdescripts;
    ImageView mimgdetail;
    ImageButton mbtnimg;
    Spinner stt,show;
    TextView mtxttype;
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri ImageUri;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycomic);
        medtname = (EditText) findViewById(R.id.edtTitledetail);
        medtdescripts = (EditText) findViewById(R.id.edtDescriptdetail);
        mimgdetail = findViewById(R.id.imgitemdetail);
        mbtnimg = (ImageButton) findViewById(R.id.btselectimgdetail);
        stt=findViewById(R.id.spnSttt);
        show=findViewById(R.id.spnShow);
        mtxttype=findViewById(R.id.txtType);
        //
        String[] items = new String[]{"Đang cập nhật", "Hoàn thành", "Ngưng bút"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stt.setAdapter(adapter);
        String[] itemshow = new String[]{"Mọi người", "Chỉ mình tôi"};
        ArrayAdapter<String> adt2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itemshow);
        adt2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        show.setAdapter(adt2);
        //
        Intent i=getIntent();
        if(i!=null)
        {
            String name=i.getStringExtra("name");
            String descripts = i.getStringExtra("descripts");
            String imageUriString = i.getStringExtra("imguri");
            String type=i.getStringExtra("type");
            medtname.setText(name);
            medtdescripts.setText(descripts);
            mtxttype.setText(type);
            if (imageUriString != null) {
                Uri imageUri = Uri.parse(imageUriString);
                mimgdetail.setImageURI(imageUri);
            }
        }
            mbtnimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
                }
            });


            mbtnAddchapter = (ImageView) findViewById(R.id.btnAddchapLayout);
            mbtnAddchapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mycomic.this, add_chaptercomic.class);
                    startActivity(intent);
                }
            });
        }

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            ImageUri = data.getData();

            mimgdetail.setImageURI(ImageUri);
        }
    }
}