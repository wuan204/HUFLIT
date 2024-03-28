package com.example.huflit.adapter;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.huflit.R;
import com.example.huflit.Truyen_da_dang;
import com.example.huflit.item.StoryFull;
import com.example.huflit.item.itemTrangchu;
import com.example.huflit.mycomic;
import com.example.huflit.object.Truyen_tranh;
import com.example.huflit.viewstory;

import java.util.ArrayList;

public class mystoryAdapter extends RecyclerView.Adapter<mystoryAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<itemTrangchu> mDataSet;

    public mystoryAdapter(Context context, ArrayList<itemTrangchu> dataSet) {
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
        itemTrangchu truyenTranh = mDataSet.get(position);
        holder.bind(truyenTranh);

        // Xử lý sự kiện khi click vào item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy tên truyện và tên chương từ đối tượng truyện

                int id=truyenTranh.getId();

                // Chuyển sang activity viewstory
                Intent intent = new Intent(mContext, mycomic.class);
                // truyền tên truyện và tên chương
                intent.putExtra("id",id);
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tenTruyen;
        ImageView bia;
        public ViewHolder(View itemView) {
            super(itemView);
            tenTruyen = itemView.findViewById(R.id.tentruyentrangchu);
            bia = itemView.findViewById(R.id.anhbiatrangchu);
        }
        public void bind(itemTrangchu truyenTranh) {
            tenTruyen.setText(truyenTranh.getTen());
            Glide.with(mContext).load(truyenTranh.getAnh()).into(bia);
        }
    }
}
