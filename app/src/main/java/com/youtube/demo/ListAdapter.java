package com.youtube.demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pravin on 26/05/17.
 */

public class ListAdapter extends ArrayAdapter {

    List<String> urlList;
    Context context;

    public ListAdapter(@NonNull Context context, int resource, List<String> list) {
        super(context, resource);
        urlList = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return urlList.size();
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = null;
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.adapter_view, parent, false);
            holder = new ViewHolder();
            holder.imgView = (ImageView) view.findViewById(R.id.imgview);
            holder.txtView = (AppCompatTextView) view.findViewById(R.id.txtview);
            view.setTag(holder);
        }else{
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        String content = urlList.get(position);
        holder.txtView.setText(content);
        return view;
    }

    class ViewHolder{
        public ImageView imgView;
        public AppCompatTextView txtView;
    }
}
