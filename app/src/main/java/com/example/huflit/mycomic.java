package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;import android.provider.MediaStore;
import static android.app.Activity.RESULT_OK;

public class mycomic extends AppCompatActivity {
    ImageView mbtnAddchapter;
    EditText medtname,medtdescripts;
    ImageView mimgdetail;
    ImageButton mbtnimg;
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri ImageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycomic);
        medtname = (EditText) findViewById(R.id.edtTitledetail);
        medtdescripts = (EditText) findViewById(R.id.edtDescriptdetail);
        mimgdetail = findViewById(R.id.imgitemdetail);
        mbtnimg = (ImageButton) findViewById(R.id.btselectimgdetail);
        //
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String nameStory = bundle.getString("namestory");
            String descripts = bundle.getString("descripts");
            String imageUriString = bundle.getString("imguri");

            medtname.setText(nameStory);
            medtdescripts.setText(descripts);
            if (imageUriString != null) {
                Uri imageUri = Uri.parse(imageUriString);
                mimgdetail.setImageURI(imageUri);
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