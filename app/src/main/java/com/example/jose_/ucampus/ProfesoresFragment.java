package com.example.jose_.ucampus;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfesoresFragment extends Fragment {


    public ProfesoresFragment() {
        // Required empty public constructor
    }
    List<Integer> lstImagen = new ArrayList<>();
    List<String> lstNombre = new ArrayList<>();
    List<Button> lstBtn = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profesores, container, false);


        initData();

        HorizontalInfiniteCycleViewPager pager = (HorizontalInfiniteCycleViewPager) v.findViewById(R.id.Horizontal);
        MyAdapter adapter = new MyAdapter(lstImagen, lstNombre, getContext());
        pager.setAdapter(adapter);


        return v;
    }

    private void initData() {
        lstImagen.add(R.drawable.usuario);
        lstImagen.add(R.drawable.usuario);
        lstImagen.add(R.drawable.usuario);
        lstImagen.add(R.drawable.usuario);
        lstImagen.add(R.drawable.usuario);




        lstNombre.add("Ari");
        lstNombre.add("George");
        lstNombre.add("Aaron");
        lstNombre.add("Paul");
        lstNombre.add("Sebabb");


    }

}
