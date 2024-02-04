package com.example.huflit;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ViewStory extends AppCompatActivity {
    Button mbtBack,mbtRp,mbtLove,mbtFl,mbtDown;
    Button mbtViewCmt,mbtCmt,mbtRead,mbtViewChapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstory);
        mbtBack=(Button) findViewById(R.id.btBack);
        mbtRp=(Button) findViewById(R.id.btRp);
        mbtLove=(Button) findViewById(R.id.btLove);
        mbtFl=(Button) findViewById(R.id.btFl);
        mbtDown=(Button) findViewById(R.id.btDown);
        mbtViewCmt=(Button) findViewById(R.id.btViewCmt);
        mbtCmt=(Button) findViewById(R.id.btCmt);
        mbtRead=(Button) findViewById(R.id.btRead);
        mbtViewChapter=(Button) findViewById(R.id.btViewChapter);
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
