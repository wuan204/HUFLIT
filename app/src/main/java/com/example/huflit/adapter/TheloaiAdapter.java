package com.example.huflit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huflit.api.APIDanhMuc;
import com.example.huflit.R;

import java.util.List;


public class TheloaiAdapter extends RecyclerView.Adapter<TheloaiAdapter.ViewHolder>{

    private Context context;
    private List<APIDanhMuc> danhMucList;

    public TheloaiAdapter(Context context, List<APIDanhMuc> danhMucList) {
        this.context = context;
        this.danhMucList = danhMucList;
    }



    @NonNull
    @Override
    public TheloaiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_theloai,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TheloaiAdapter.ViewHolder holder, int position) {

        APIDanhMuc item = danhMucList.get(position);
        holder.bind(item);


    }

    @Override
    public int getItemCount() {
        return danhMucList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView categoryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.CategoryName);
        }

        public void bind(APIDanhMuc item) {
            categoryName.setText(item.getName());
        }
    }

}
