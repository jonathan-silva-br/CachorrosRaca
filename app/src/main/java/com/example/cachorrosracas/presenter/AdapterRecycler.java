package com.example.cachorrosracas.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cachorrosracas.R;
import com.example.cachorrosracas.model.Raca;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyViewHolder> {

    private ArrayList<Raca> listaRacas;

    public void setListaRacas(ArrayList<Raca> listaRacas) {
        this.listaRacas = listaRacas;
    }

    public AdapterRecycler(ArrayList<Raca> listaRacas){
        this.listaRacas = listaRacas;
    }

    @NonNull
    @Override
    public AdapterRecycler.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecycler.MyViewHolder holder, int position) {
        Raca raca =listaRacas.get(position);
        holder.Nomeraca.setText(raca.getNomeRaca());
    }

    @Override
    public int getItemCount() {
        return listaRacas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Nomeraca;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Nomeraca = itemView.findViewById(R.id.textRaca);
        }
    }
}
