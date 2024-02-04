package com.example.huflit;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class View_Story extends AppCompatActivity {
    Button mbtLove, mbtFl, mbtDown, mbtViewCmt, mbtCmt, mbtRead, mbtViewChapter, btnGui, btnHuy;
    ImageButton imgBack, imgRp;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_story);

        imgBack = findViewById(R.id.imgBack);
        imgRp = findViewById(R.id.imgRp);
        mbtLove = findViewById(R.id.btLove);
        mbtFl = findViewById(R.id.btFl);
        mbtDown = findViewById(R.id.btDown);
        mbtViewCmt = findViewById(R.id.btViewCmt);
        mbtCmt = findViewById(R.id.btCmt);
        mbtRead = findViewById(R.id.btRead);
        mbtViewChapter = findViewById(R.id.btViewChapter);
        btnGui = findViewById(R.id.btnGui);
        btnHuy = findViewById(R.id.btnHuy);

        imgRp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogRp();
            }
        });
    }

    private void showDialogRp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View dialogView = layoutInflater.inflate(R.layout.reportdialog, null);

        // Set up the views in the custom dialog
       TextView txtTitle = dialogView.findViewById(R.id.txtTitle);
        EditText edtTextRp = dialogView.findViewById(R.id.edtTextRp);
        Button btnHuyDialog = dialogView.findViewById(R.id.btnHuy);
        Button btnGuiDialog = dialogView.findViewById(R.id.btnGui);

        // Set up the dialog content
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        // Set up actions for buttons in the custom dialog
        btnHuyDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        btnGuiDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the "Gửi" button click in the dialog
                // You can add your logic here
                alertDialog.dismiss();
            }
        });
    }
}


