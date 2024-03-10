package com.example.huflit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.huflit.R;
import com.example.huflit.truyen_tranh.Story;

import java.util.List;
import java.util.Objects;

public class ShowStoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Story> array;
    private Context context;

    public ShowStoryAdapter(List<Story> array, Context context) {
        this.array = array;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trang_chu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    ViewHolder viewHolder= (ViewHolder) holder;
    Story newitem=(Story) array.get(position);
    viewHolder.storyname.setText(newitem.getTentruyen());
    Glide.with(this.context).load(newitem.getAnhtruyen()).into(viewHolder.storyimg);
    viewHolder.storyimg.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });
    }
    @Override
    public int getItemCount() {
        return array.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView storyname;
        ImageView storyimg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            storyname = itemView.findViewById(R.id.tentruyentrangchu);
            storyimg = itemView.findViewById(R.id.anhbiatrangchu);
        }
    }
}
