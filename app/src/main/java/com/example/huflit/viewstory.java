package com.example.huflit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class viewstory extends AppCompatActivity {
    ImageView mbtBack,mbtRp,mbtLove,mbtFl,mbtDown,mbtCmt;
    Button mbtViewCmt,mbtRead,mbtViewChapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstory);
        mbtBack= (ImageView) findViewById(R.id.btBack);
        mbtRp= (ImageView) findViewById(R.id.btReport);
        mbtLove= (ImageView) findViewById(R.id.btLove);
        mbtFl= (ImageView) findViewById(R.id.btFl);
        mbtDown= (ImageView) findViewById(R.id.btDown);
        mbtViewCmt=(Button) findViewById(R.id.btViewCmt);
        mbtCmt= (ImageView) findViewById(R.id.btCmt);
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
        View dialogview=layoutInflater.inflate(R.layout.dialog_report,null);
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
                AlertDialog.Builder dialog=new AlertDialog.Builder(viewstory.this);
                dialog.setMessage("Cảm ơn bạn đã báo cáo. ^.^");
                dialog.show();
                alertDialog.cancel();
            }
        });
    }
}
