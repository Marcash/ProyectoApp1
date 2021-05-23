package com.example.proyectoapp1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> nombres;
    private int Element;

    public MyAdapter(Context context, int layout, List<String> item) {
        this.context = context;
        this.layout = layout;
        this.nombres = item;
        Element = R.layout.grid_item;
    }

    @Override
    public int getCount() {
        return this.nombres.size();
    }

    @Override
    public Object getItem(int position) {
        return this.nombres.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(Element, null);
        }else{

        }

        return convertView;
    }
    public void addImagen(){
        Element = R.layout.grid_item_img;
        this.notifyDataSetChanged();
    }

    public void addNotes(){
        Element = R.layout.grid_item;
        this.notifyDataSetChanged();
    }
}