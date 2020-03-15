package com.example.android.fastshipv1;

import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.*;
import java.lang.Object;
import java.util.ArrayList;
import java.util.Locale;

public class CustomAdapter extends BaseAdapter {
    Context mcontext ;
    ArrayList<Data> data ;
    private ArrayList<Data> arraylist;
    public CustomAdapter(Context context , ArrayList<Data> data){
        mcontext = context;
        this.data = data;
        this.arraylist = new ArrayList<Data>();
        this.arraylist.addAll(data);
    }
    @Override
    public int getCount() {
        return data.size();
    }
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.lvshape,parent,false);
        }

        TextView from = (TextView) convertView.findViewById(R.id.tvfrom);
        TextView To = (TextView) convertView.findViewById(R.id.tvto);
        TextView name = (TextView) convertView.findViewById(R.id.tvname);
        TextView rate = (TextView) convertView.findViewById(R.id.tvrate);
        TextView w = (TextView) convertView.findViewById(R.id.tvw);
        from.setText(data.get(position).getFcountry());
        To.setText(data.get(position).getTocountry());
        name.setText(data.get(position).getName());
        rate.setText(""+data.get(position).getRate());
        w.setText(""+data.get(position).getWeight());
        return convertView;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        data.clear();
        if (charText.length() == 0) {
            data.addAll(arraylist);
        }
        else
        {
            for (Data wp : arraylist)
            {
                if (wp.getFcountry().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    data.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
