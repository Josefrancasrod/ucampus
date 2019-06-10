package com.example.jose_.ucampus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    //ATRIBUTO PARA EL VIEWPAGER PROMOCIONES
    ViewPager viewPagerPromo;
    //ATRIBUTOS PARA DOTS VIEWPAGER
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    TextView descripcion, restaurant, telefono, ubicacion;

    private static final String TAG = "HOME FRAGMENT";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        getImages();
        initRecyclerView(view);
        getDotsPager(view);
        cargarTextView(view);
        return view;
    }
    private void cargarTextView(View view){
        descripcion = view.findViewById(R.id.tvDescripcion);
        restaurant = view.findViewById(R.id.tvRestaurant);
        telefono = view.findViewById(R.id.tvTelefono);
        ubicacion = view.findViewById(R.id.tvUbicacion);
        restaurant.setText("Burger King");
        descripcion.setText("Ahorros del Rey Family King. Por solo $109 MXN Tres Whopper + Nuggets");
        telefono.setText("618 254 8574");
        ubicacion.setText("Av. Heroico Colegio Militar 208, Col del Maestro, 34240 Durango, Dgo.");
    }
    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://scontent.fdgo1-1.fna.fbcdn.net/v/t1.0-9/22788947_2021811278036757_304344295943204598_n.jpg?_nc_cat=108&_nc_ht=scontent.fdgo1-1.fna&oh=acff820e6663ced1d56ed8a24aeed6df&oe=5CA7103F");
        mNames.add("El Tacon Milenario");

        mImageUrls.add("https://scontent.fdgo1-1.fna.fbcdn.net/v/t1.0-9/12376176_529583100531997_4289674973496158472_n.png?_nc_cat=106&_nc_ht=scontent.fdgo1-1.fna&oh=b4ddb2e1a5fb0cbfb2f66f4f9e907baf&oe=5CAF60E7");
        mNames.add("La Cabañita");

        mImageUrls.add("https://scontent.fdgo1-1.fna.fbcdn.net/v/t1.0-9/36176424_932008093665012_1589426796200198144_n.jpg?_nc_cat=107&_nc_ht=scontent.fdgo1-1.fna&oh=bfef89b83968004d9ef4a01f21534309&oe=5CA022CF");
        mNames.add("Waffles & Coffe");

        mImageUrls.add("https://scontent.fdgo1-1.fna.fbcdn.net/v/t1.0-9/19225082_1890246244564227_3475225587138728843_n.jpg?_nc_cat=107&_nc_ht=scontent.fdgo1-1.fna&oh=8122d9d28cd4a1e253714ea151cca200&oe=5C999815");
        mNames.add("Chilaquiles & Coffe");

        mImageUrls.add("https://scontent.fdgo1-1.fna.fbcdn.net/v/t1.0-9/13423742_483445871861929_6180229491501333077_n.jpg?_nc_cat=101&_nc_ht=scontent.fdgo1-1.fna&oh=4bb033daad46f5aa8113fdb1038c066a&oe=5CAA0B3E");
        mNames.add("Cafetería Plauchato");

        mImageUrls.add("https://scontent.fdgo1-1.fna.fbcdn.net/v/t1.0-9/26994220_411302082631051_2890034187712946829_n.jpg?_nc_cat=104&_nc_ht=scontent.fdgo1-1.fna&oh=90e1e5130ba40682e4592284c4772613&oe=5C9F53CB");
        mNames.add("Quince Doce");

        mImageUrls.add("https://scontent.fdgo1-1.fna.fbcdn.net/v/t1.0-9/16806963_1263215880438915_9097340566092784149_n.jpg?_nc_cat=104&_nc_ht=scontent.fdgo1-1.fna&oh=c2290b7cdcbf5c491080ad7834e08f0e&oe=5C644AD5");
        mNames.add("Taquería Hernández");

    }

    private void initRecyclerView(View view){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adaptador = new RecyclerViewAdapter(getActivity(),mNames,mImageUrls);
        recyclerView.setAdapter(adaptador);
    }
    private void getDotsPager(View view){
        viewPagerPromo = view.findViewById(R.id.viewPagerPromo);
        AdaptadorPromociones adaptadorPromociones= new AdaptadorPromociones(getActivity());
        viewPagerPromo.setAdapter(adaptadorPromociones);
        sliderDotspanel = view.findViewById(R.id.SliderDots);
        dotscount = adaptadorPromociones.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.active_dot));

        viewPagerPromo.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        restaurant.setText("Burger King");
                        descripcion.setText("Ahorros del Rey Family King. Por solo $109 MXN Tres Whopper + Nuggets");
                        telefono.setText("618 254 8574");
                        ubicacion.setText("Av. Heroico Colegio Militar 208, Col del Maestro, 34240 Durango, Dgo.");
                        break;
                    case 1:
                        restaurant.setText("Applebee's");
                        descripcion.setText("Plato Botanero. Por solo $69 MXN. Incluye Papas grandes + 6 Nuggets + 3 Jalapeño Poppers");
                        telefono.setText("618 129 2144");
                        ubicacion.setText("Felipe Pescador 1401 Local 1, Esperanza, 34080 Durango, Dgo.");
                        break;
                    case 2:
                        restaurant.setText("Burger King");
                        descripcion.setText("Promocion Exclusiva. Combo BBQ Tocino + Sundae Jr. por $99 MXN ó\nPromocion Exclusiva. Combo Regular Whopper + Cono por $69");
                        telefono.setText("618 254 8574");
                        ubicacion.setText("Av. Heroico Colegio Militar 208, Col del Maestro, 34240 Durango, Dgo.");
                        break;
                    case 3:
                        restaurant.setText("El Porton");
                        descripcion.setText("Comidas Corridas desde $85 MXN");
                        telefono.setText("618 813 6957");
                        ubicacion.setText("El Porton, Boulevard Felipe Pescador 1001-A, Zona Centro, 34000 Durango, Dgo.");
                        break;
                    case 4:
                        restaurant.setText("Burger King");
                        descripcion.setText("20 Nuggets + Papas y Refrescos por $105 MXN ó\n2 Papas Medianas por $30 MXN");
                        telefono.setText("618 254 8574");
                        ubicacion.setText("Av. Heroico Colegio Militar 208, Col del Maestro, 34240 Durango, Dgo.");
                        break;
                    case 5:
                        restaurant.setText("StarBucks");
                        descripcion.setText("Delicioso Frapuccino Banana Split por $30 MXN");
                        telefono.setText("618  8412");
                        ubicacion.setText("Paseo Durango\nBlvrd Felipe Pescador 1401, 34060 Durango, Dgo.");
                    default:
                        break;
                }
                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
