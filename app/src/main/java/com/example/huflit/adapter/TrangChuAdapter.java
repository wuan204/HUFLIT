package com.example.huflit.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.huflit.R;
import com.example.huflit.truyen_tranh.Truyen_tranh;
import com.example.huflit.viewstory;

import java.util.ArrayList;
import java.util.List;

public class TrangChuAdapter extends RecyclerView.Adapter<TrangChuAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Truyen_tranh> mDataSet;

    public TrangChuAdapter(Context context, ArrayList<Truyen_tranh> dataSet) {
        this.mContext = context;
        this.mDataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trang_chu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Truyen_tranh truyenTranh = mDataSet.get(position);
        holder.bind(truyenTranh);

        // Xử lý sự kiện khi click vào item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy tên truyện và tên chương từ đối tượng truyện
                String tenTruyen = truyenTranh.getTenTruyen();
                String tenChap = truyenTranh.getTenChap();

                // Chuyển sang activity viewstory và truyền tên truyện và tên chương
                Intent intent = new Intent(mContext, viewstory.class);
                intent.putExtra("ten_truyen", tenTruyen);
                intent.putExtra("ten_chap", tenChap);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tenTruyen, tenChap;
        ImageView bia;

        public ViewHolder(View itemView) {
            super(itemView);
            tenTruyen = itemView.findViewById(R.id.tentruyentrangchu);
            tenChap = itemView.findViewById(R.id.tenchaptrangchu);
            bia = itemView.findViewById(R.id.anhbiatrangchu);
        }

        public void bind(Truyen_tranh truyenTranh) {
            tenTruyen.setText(truyenTranh.getTenTruyen());
            tenChap.setText(truyenTranh.getTenChap());
            Glide.with(mContext).load(truyenTranh.getLinkAnh()).into(bia);
        }
    }
}