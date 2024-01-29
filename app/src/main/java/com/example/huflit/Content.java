package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class Content extends AppCompatActivity {
    ImageView imgBack,imgMenu2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        imgBack = findViewById(R.id.imgBack);
        imgMenu2 = findViewById(R.id.imgMenu2);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imgMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }
    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.content_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.item1) {
                    // Xử lý khi Chapter 1 được chọn
                    showToast("Chapter1 đã được chọn");
                    return true;
                } else if (itemId == R.id.item2) {
                    // Xử lý khi Chapter 2 được chọn
                    showToast("Chapter2 đã được chọn");
                    return true;
                } else if (itemId == R.id.item3) {
                    // Xử lý khi Chapter 3 được chọn
                    showToast("Chapter2 đã được chọn");
                    return true;
                } else if (itemId == R.id.item4) {
                    // Xử lý khi Chapter 4 được chọn
                    showToast("Chapter2 đã được chọn");
                    return true;
                }

                return false;
            }
        });
        popupMenu.show();
    }
    private void showToast(String message) {
        // Inflate the custom layout
        View layout = getLayoutInflater().inflate(R.layout.toast, findViewById(R.id.custom_toast_container));

        // Set the text of the TextView in the custom layout
        TextView text = layout.findViewById(R.id.ThongBao);
        text.setText(message);

        // Apply the custom shape drawable as the background
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.toast_menu_item); // R.drawable.custom_toast_background should point to the XML shape drawable
        text.setBackground(gradientDrawable);

        // Create the Toast
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        // Show the Toast in the center of the screen
        toast.setGravity(Gravity.CENTER, 0, 0);

        // Show the Toast
        toast.show();
    }
}