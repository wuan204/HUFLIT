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
import com.example.huflit.item.StoryFull;
import com.example.huflit.object.Truyen_tranh;
import com.example.huflit.viewstory;

import java.util.ArrayList;

public class TrangChuAdapter extends RecyclerView.Adapter<TrangChuAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<StoryFull> mDataSet;

        public TrangChuAdapter(Context context, ArrayList<StoryFull> dataSet) {
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
        StoryFull truyenTranh = mDataSet.get(position);
        holder.bind(truyenTranh);

        // Xử lý sự kiện khi click vào item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy tên truyện và tên chương từ đối tượng truyện
                String tenTruyen = truyenTranh.getName();
                String anhTruyen= truyenTranh.getImg();
                String tacgia= truyenTranh.getAlias();
                String danhmuc=truyenTranh.getCategoies();
                String tomat=truyenTranh.getDescipt();;
                String capnhat =truyenTranh.getCapnhat();
                String theloai=truyenTranh.getType();
                String status=truyenTranh.getStatus();
                int view = truyenTranh.getView();
                int love=truyenTranh.getLove();
                double rating=truyenTranh.getRating();
                int id=truyenTranh.getId();

                // Chuyển sang activity viewstory
                Intent intent = new Intent(mContext, viewstory.class);
                // truyền tên truyện và tên chương
                intent.putExtra("ten_truyen", tenTruyen);
                intent.putExtra("anh_truyen", anhTruyen);
                intent.putExtra("tac_gia",tacgia);
                intent.putExtra("danhmuc",danhmuc);
                intent.putExtra("theloai",theloai);
                intent.putExtra("tomtat",tomat);
                intent.putExtra("capnhat",capnhat);
                intent.putExtra("trangthai",status);
                intent.putExtra(("view"),view);
                intent.putExtra("love",love);
                intent.putExtra("rating",rating);
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
        public void bind(StoryFull truyenTranh) {
            tenTruyen.setText(truyenTranh.getName());
            Glide.with(mContext).load(truyenTranh.getImg()).into(bia);
        }
    }
}