package com.example.jose_.ucampus;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class InfoDialogoAdapter extends RecyclerView.Adapter<InfoDialogoAdapter.InfoDialogoViewHolder>{





    private ArrayList<InfoDialogo> data2;

    public InfoDialogoAdapter(ArrayList<InfoDialogo> data2) {
        this.data2 = data2;
    }

    @NonNull
    @Override
    public InfoDialogoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new InfoDialogoViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.datos_escuela, viewGroup, false));


    }

    @Override
    public void onBindViewHolder(@NonNull InfoDialogoViewHolder holder, int i) {
        InfoDialogo infoDialogo = data2.get(i);


        holder.imgEdificio.setImageResource(infoDialogo.getImagen());
        holder.textoEdificio.setText(infoDialogo.getNombreEdifico());
        holder.nombreEncargado.setText(infoDialogo.getNombreEncargado());
        holder.nombreCordinador.setText(infoDialogo.getNombreCordinador());

    }

    @Override
    public int getItemCount() {
        return data2.size();
    }

    class InfoDialogoViewHolder extends RecyclerView.ViewHolder {


        ImageView imgEdificio;
        TextView textoEdificio,nombreCordinador,nombreEncargado;

        public InfoDialogoViewHolder(View itemView) {
            super(itemView);

            imgEdificio = itemView.findViewById(R.id.imagenCompletaEsc);
            textoEdificio = itemView.findViewById(R.id.textoEdificioS);
            nombreCordinador = itemView.findViewById(R.id.textoCordinadorS);
            nombreEncargado = itemView.findViewById(R.id.textoEncargadoS);


        }
    }
}
