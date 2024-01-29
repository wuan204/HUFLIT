package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class Truyen_da_dang extends AppCompatActivity {
    ImageView imgBack, imgMenu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen_da_dang);

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
                // Khi người dùng click vào imgMenu2, hiển thị menu
                showPopupMenu(imgMenu2);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dangbai, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.item1) {
            // Xử lý khi người dùng click vào mục chính
            return true;
        } else if (itemId == R.id.imgMenu2) {
            // Xử lý khi người dùng click vào imgMenu2
            // Bạn có thể mở một PopupMenu ở đây để hiển thị các mục con
            showPopupMenu(imgMenu2);
            return true;
        } else if (itemId == R.id.item1) {
            // Xử lý khi người dùng click vào mục con t1
            showToast("Truyen1 đã được click");
            return true;
        } else if (itemId == R.id.item2) {
            // Xử lý khi người dùng click vào mục con t2
            showToast("Truyen2 đã được click");
            return true;
        } else if (itemId == R.id.item3) {
            // Xử lý khi người dùng click vào mục con t3
            showToast("Truyen3 đã được click");
            return true;
        } else if (itemId == R.id.item4) {
            // Xử lý khi người dùng click vào mục con t4
            showToast("Truyen4 đã được click");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_dangbai, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                onOptionsItemSelected(menuItem);
                return true;
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

    public void PrintToast(String message) {
        // Inflate the custom layout
        View layout = getLayoutInflater().inflate(R.layout.toast, findViewById(R.id.custom_toast_container));

        // Set the text of the TextView in the custom layout
        TextView text = layout.findViewById(R.id.ThongBao);
        text.setText(message);

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
