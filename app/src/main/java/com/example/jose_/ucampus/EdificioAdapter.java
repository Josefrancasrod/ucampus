package com.example.jose_.ucampus;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EdificioAdapter extends RecyclerView.Adapter<EdificioAdapter.EdificioViewHolder> implements View.OnClickListener {

    private ArrayList<Edificio> data;
    private View.OnClickListener listener;

    public EdificioAdapter(ArrayList<Edificio> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public EdificioViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        int layout=0;



        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_edificio,viewGroup,false);

        view.setOnClickListener(this);

     //  return new EdificioViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_edificio, viewGroup, false));
        return new EdificioViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull EdificioViewHolder holder, int i) {


        Edificio edificio = data.get(i);

        holder.btnIma.setImageResource(edificio.getImagen());
        holder.nombreEdificio.setText(edificio.getNombreEdifico());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  void setOnClickListener(View.OnClickListener listener){

        this.listener=listener;


    }

    @Override
    public void onClick(View v) {

        if(listener!=null){


            listener.onClick(v);
        }
    }

    class EdificioViewHolder extends RecyclerView.ViewHolder {


        ImageView btnIma;
        TextView nombreEdificio;

        public EdificioViewHolder(View itemView) {
            super(itemView);

            btnIma = itemView.findViewById(R.id.btnImagen);
            nombreEdificio = itemView.findViewById(R.id.nombreEdificio);

        }
    }
}
