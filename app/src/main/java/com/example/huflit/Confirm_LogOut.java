package com.example.huflit;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Confirm_LogOut extends DialogFragment {

    public interface ConfirmLogoutListener {
        void onConfirmLogout();
        void onCancelLogout();
    }

    private ConfirmLogoutListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Tạo dialog từ layout
        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(R.layout.activity_confirm_log_out);

        // Ánh xạ các thành phần trong layout
        TextView txtConfirm = dialog.findViewById(R.id.txtConfirm);
        Button btnKhong = dialog.findViewById(R.id.btnKhong);
        Button btnCo = dialog.findViewById(R.id.btnCo);

        // Đặt nội dung và xử lý sự kiện cho TextView và Buttons
        txtConfirm.setText("Bạn có chắc chắn muốn đăng xuất không?");

        btnKhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gọi hàm callback khi người dùng click vào nút "Hủy"
                if (listener != null) {
                    listener.onCancelLogout();
                }
                // Đóng dialog
                dialog.dismiss();
            }
        });

        btnCo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gọi hàm callback khi người dùng click vào nút "Có"
                if (listener != null) {
                    listener.onConfirmLogout();
                }
                // Đóng dialog
                dialog.dismiss();
            }
        });

        return dialog;
    }

    public void setConfirmLogoutListener(ConfirmLogoutListener listener) {
        this.listener = listener;
    }
}
