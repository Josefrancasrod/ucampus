package com.example.jose_.ucampus;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EscuelaFragment extends Fragment {

    private RecyclerView rvEdificios,rvInfoDialogo;
    private GridLayoutManager glm,glm2;
    private EdificioAdapter adapter;
    private InfoDialogoAdapter adapter2;
    private Button btnPrueba;
    Dialog dialogoInf;
    ArrayList<InfoDialogo> listaNombre;
    int cont;

    public ImageButton btnEdificio;

    public EscuelaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_edificios,container,false);

        dialogoInf = new Dialog(getActivity());


        rvEdificios =  view.findViewById(R.id.rv_edificios);

        glm = new GridLayoutManager(getActivity(), 2);
        rvEdificios.setLayoutManager(glm);
        adapter = new EdificioAdapter(dataSet());
        rvEdificios.setAdapter(adapter);

        //adapter2 = new InfoDialogoAdapter(dataSet2());
        // rvInfoDialogo.setAdapter(adapter2);

        listaNombre = new ArrayList<>();



        llenar();



        //String cont = listaNombre.get(rvEdificios.getChildAdapterPosition(view)).getNombreEdifico();
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont=rvEdificios.getChildAdapterPosition(v);

                dialogoInf.setContentView(R.layout.datos_escuela);
                Button okDialogBt = ( Button) dialogoInf.findViewById(R.id.btnOk);

                final ImageView imgEdifioc =(ImageView) dialogoInf.findViewById(R.id.imagenCompletaEsc);
                final TextView nombreEncargado = dialogoInf.findViewById(R.id.textoEncargadoS);
                final TextView textoCordinador = dialogoInf.findViewById(R.id.textoCordinadorS);
                final TextView titulo = dialogoInf.findViewById(R.id.textoEdificioS);


                okDialogBt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogoInf.dismiss();
                    }
                });



                //imgEdifioc.setImageResource(listaNombre.get(cont).getImagen());
                switch (cont){

                    case 0:
                        imgEdifioc.setImageResource(dataSet2().get(cont).getImagen());
                        nombreEncargado.setText(dataSet2().get(cont).getNombreEncargado());
                        textoCordinador.setText(dataSet2().get(cont).getNombreCordinador());
                        titulo.setText(dataSet2().get(cont).getNombreEdifico());
                    case 1:
                        imgEdifioc.setImageResource(dataSet2().get(cont).getImagen());
                        nombreEncargado.setText(dataSet2().get(cont).getNombreEncargado());
                        textoCordinador.setText(dataSet2().get(cont).getNombreCordinador());
                        titulo.setText(dataSet2().get(cont).getNombreEdifico());
                    case 2:
                        imgEdifioc.setImageResource(dataSet2().get(cont).getImagen());
                        nombreEncargado.setText(dataSet2().get(cont).getNombreEncargado());
                        textoCordinador.setText(dataSet2().get(cont).getNombreCordinador());
                        titulo.setText(dataSet2().get(cont).getNombreEdifico());
                    case 3:
                        imgEdifioc.setImageResource(dataSet2().get(cont).getImagen());
                        nombreEncargado.setText(dataSet2().get(cont).getNombreEncargado());
                        textoCordinador.setText(dataSet2().get(cont).getNombreCordinador());
                        titulo.setText(dataSet2().get(cont).getNombreEdifico());
                    case 4:
                        imgEdifioc.setImageResource(dataSet2().get(cont).getImagen());
                        nombreEncargado.setText(dataSet2().get(cont).getNombreEncargado());
                        textoCordinador.setText(dataSet2().get(cont).getNombreCordinador());
                        titulo.setText(dataSet2().get(cont).getNombreEdifico());
                    case 5:
                        imgEdifioc.setImageResource(dataSet2().get(cont).getImagen());
                        nombreEncargado.setText(dataSet2().get(cont).getNombreEncargado());
                        textoCordinador.setText(dataSet2().get(cont).getNombreCordinador());
                        titulo.setText(dataSet2().get(cont).getNombreEdifico());
                    case 6:
                        imgEdifioc.setImageResource(dataSet2().get(cont).getImagen());
                        nombreEncargado.setText(dataSet2().get(cont).getNombreEncargado());
                        textoCordinador.setText(dataSet2().get(cont).getNombreCordinador());
                        titulo.setText(dataSet2().get(cont).getNombreEdifico());
                    case 7:
                        imgEdifioc.setImageResource(dataSet2().get(cont).getImagen());
                        nombreEncargado.setText(dataSet2().get(cont).getNombreEncargado());
                        textoCordinador.setText(dataSet2().get(cont).getNombreCordinador());
                        titulo.setText(dataSet2().get(cont).getNombreEdifico());


                }

                dialogoInf.setCancelable(false);
                dialogoInf.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogoInf.show();


            }
        });






        return view;
    }

    private ArrayList<Edificio> dataSet() {

        ArrayList<Edificio> data = new ArrayList<>();

        data.add(new Edificio("Centro de idiomas  ",R.drawable.img_idiomas));
        data.add(new Edificio("Industrial  ",R.drawable.img_industrial));
        data.add(new Edificio("Química ",R.drawable.img_quimica));
        data.add(new Edificio("Electrica ", R.drawable.img_electrica));
        data.add(new Edificio("Mecanica ",R.drawable.img_mecanica));
        data.add(new Edificio("Laboratorio Sistemas ",R.drawable.img_laboratoriosis));
        data.add(new Edificio("Educación a distancia ",R.drawable.img_distancia));
        data.add(new Edificio("Centro de información ",R.drawable.img_biblioinf));


        return data;
    }

    private ArrayList<InfoDialogo> dataSet2(){
        ArrayList<InfoDialogo> data2 = new ArrayList<>();

        data2.add(new InfoDialogo("Centro de idiomas","Un camarada","Lic. Jessica Molina Escalier",
                R.drawable.img_idiomas));
        data2.add(new InfoDialogo("Industrial","M. C. Anapaula Rivas Barraza","M.C. María del Pilar Reyes Sierra",
                R.drawable.img_industrial));
        data2.add(new InfoDialogo("Química","Ing. Francisco Ruvalcaba González\t","M.C. Luisa Eugenia Gandarilla Castruita",
                R.drawable.img_quimica));
        data2.add(new InfoDialogo("Eléctrica","Dr. Rubén Guerrero Rivera","Ing. Alejandro Mendoza Ramírez",
                R.drawable.img_electrica));
        data2.add(new InfoDialogo("Mecánica","Ing. Miguel Cervantes Mata","Ing. Alfonso Alba de los Ríos",
                R.drawable.img_mecanica));
        data2.add(new InfoDialogo("Sistemas","L.I. Rocio Valadez Acosta","L..I. Jeorgina Calzada Terrones",
                R.drawable.img_laboratoriosis));
        data2.add(new InfoDialogo("Educación a distancia","Dra. Eustolia Nájera Jáquez","Alguien",
                R.drawable.img_distancia));
        data2.add(new InfoDialogo("Centro de información","Lic. Liz Margarita Quintero Robles","Termi",
                R.drawable.img_biblioinf));



        return data2;

    }

    public void llenar(){

        listaNombre.add(new InfoDialogo("Centro de idiomas","Un camarada","Lic. Jessica Molina Escalier",
                R.drawable.img_idiomas));
        listaNombre.add(new InfoDialogo("Industrial","M. C. Anapaula Rivas Barraza","M.C. María del Pilar Reyes Sierra",
                R.drawable.img_industrial));
        listaNombre.add(new InfoDialogo("Química","Ing. Francisco Ruvalcaba González\t","M.C. Luisa Eugenia Gandarilla Castruita",
                R.drawable.img_quimica));
        listaNombre.add(new InfoDialogo("Eléctrica","Dr. Rubén Guerrero Rivera","Ing. Alejandro Mendoza Ramírez",
                R.drawable.img_electrica));
        listaNombre.add(new InfoDialogo("Mecánica","Ing. Miguel Cervantes Mata","Ing. Alfonso Alba de los Ríos",
                R.drawable.img_mecanica));
        listaNombre.add(new InfoDialogo("Sistemas","L.I. Rocio Valadez Acosta","L..I. Jeorgina Calzada Terrones",
                R.drawable.img_laboratoriosis));
        listaNombre.add(new InfoDialogo("Educación a distancia","Dra. Eustolia Nájera Jáquez","Alguien",
                R.drawable.img_distancia));
        listaNombre.add(new InfoDialogo("Centro de información","Lic. Liz Margarita Quintero Robles","Termi",
                R.drawable.img_biblioinf));




    }

}
