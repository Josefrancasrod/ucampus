package com.example.jose_.ucampus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.List;

public class MyAdapter extends PagerAdapter {

    List<Integer> lstImagen;
    List<String> lstNombre;
    Context context;
    LayoutInflater layoutInflater;

    public MyAdapter(List<Integer> lstImagen, List<String> lstNombre,  Context context) {
        this.lstImagen = lstImagen;
        this.lstNombre = lstNombre;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return lstImagen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.card_item,container,false);
        EditText txNombre = (EditText) view.findViewById(R.id.edNombre);
        txNombre.setText(lstNombre.get(position));
        ImageView imageView = (ImageView) view.findViewById(R.id.imagenView);
        imageView.setImageResource(lstImagen.get(position));

        container.addView(view);

        return view;
    }
}