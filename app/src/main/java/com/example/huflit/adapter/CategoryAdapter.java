package com.example.huflit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.huflit.R;
import com.example.huflit.item.category;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    private static class ViewHolder{
        EditText namecate,idcate;
        ImageView btnwrite,btndelete;
    }
    private Context context;
    private   List<category> mylistcate;
     private int layoutID;

    public CategoryAdapter(Context context, List<category> mylistcate, int layoutID) {
        this.context = context;
        this.mylistcate = mylistcate;
        this.layoutID = layoutID;
    }

    @Override
    public int getCount() {
        return mylistcate.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){

            viewHolder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layoutID,null);
            viewHolder.namecate=convertView.findViewById(R.id.edtNamecate);
            viewHolder.idcate=convertView.findViewById(R.id.edtnumber);
            viewHolder.btnwrite=convertView.findViewById(R.id.btnwritecate);
            viewHolder.btndelete=convertView.findViewById(R.id.btndeletecate);
            convertView.setTag(viewHolder);

        }
        else {viewHolder=(ViewHolder) convertView.getTag(); }
       category item=mylistcate.get(position);
        viewHolder.namecate.setText(item.getNamecate());
        viewHolder.idcate.setText(String.valueOf(item.getId()));
viewHolder.btndelete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        mylistcate.remove(position);
        notifyDataSetChanged();
    }
});
return convertView;
    }
}
