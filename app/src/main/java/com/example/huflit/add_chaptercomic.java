package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.huflit.itemchapcomic.adtImg;
import com.example.huflit.itemchapcomic.itemimg;
import com.example.huflit.itemfilter.Itemft;

import java.util.ArrayList;

public class add_chaptercomic extends AppCompatActivity {
    private static final int REQUEST_CODE_PICK_IMAGE = 1;
    private ArrayList<itemimg> mImageUris = new ArrayList<>();
    private adtImg mAdapter;
    private GridView mGridView;
    Button mbtnAddChapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chaptercomic);
        mbtnAddChapter = (Button) findViewById(R.id.btnAddChapter);
        mGridView = findViewById(R.id.GrVImgContent);
        mAdapter = new adtImg(this,mImageUris);
        mGridView.setAdapter(mAdapter);
        mbtnAddChapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageGallery();
            }
        });
    }

    private void openImageGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            if (selectedImageUri != null) {
                itemimg newitem=new itemimg(selectedImageUri);
                mImageUris.add(newitem);
                mAdapter.notifyDataSetChanged();
            }
        }
    }}


