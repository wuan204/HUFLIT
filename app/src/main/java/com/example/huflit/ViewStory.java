package com.example.huflit;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ViewStory extends AppCompatActivity {
    Button mbtLove,mbtFl,mbtDown;
    Button mbtViewCmt,mbtCmt,mbtRead,mbtViewChapter;
    ImageButton mbtBack,mbtRp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstory);
        mbtBack= findViewById(R.id.btBack);
        mbtRp= findViewById(R.id.btRp);
        mbtLove=findViewById(R.id.btLove);
        mbtFl= findViewById(R.id.btFl);
        mbtDown=findViewById(R.id.btDown);
        mbtViewCmt= findViewById(R.id.btViewCmt);
        mbtCmt= findViewById(R.id.btCmt);
        mbtRead= findViewById(R.id.btRead);
        mbtViewChapter= findViewById(R.id.btViewChapter);
        //action
        mbtRp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {ShowDialogRp();

            }
        });

    }
    private void ShowDialogRp(){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        LayoutInflater layoutInflater=this.getLayoutInflater();
        View dialogview=layoutInflater.inflate(R.layout.reportdialog,null);
        builder.setView(dialogview);
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
        Button mbtCancel= dialogview.findViewById(R.id.btCancel);
        Button mbtSendRp= dialogview.findViewById(R.id.btSendRp);
        mbtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });
        mbtSendRp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(ViewStory.this);
                dialog.setMessage("Cảm ơn bạn đã báo cáo. ^.^");
                dialog.show();
                alertDialog.cancel();
            }
        });
    }
}
