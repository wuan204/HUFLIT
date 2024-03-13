//package com.example.huflit.adapter;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//
//import com.example.huflit.Content;
//import com.example.huflit.R;
//import com.example.huflit.object.Truyen;
//import com.example.huflit.object.Truyen_tranh;
//import com.example.huflit.viewstory;
//
//import java.util.ArrayList;
//
//public class TruyenAdapter extends RecyclerView.Adapter<TruyenAdapter.ViewHolder> {
//    private Context ct;
//    private ArrayList<Truyen_tranh> arr;
//    public TruyenAdapter( Context context, ArrayList<Truyen_tranh> arrayList) {
//        super();
//        this.ct = context;
//        this.arr = arrayList;
//
//    }
//
//    @NonNull
//    @Override
//    public TruyenAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trang_chu, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull TruyenAdapter.ViewHolder holder, int position) {
//        Truyen truyen = ct.get(position);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        public ViewHolder(View view) {
//            super();
//
//        }
//    }
//}
