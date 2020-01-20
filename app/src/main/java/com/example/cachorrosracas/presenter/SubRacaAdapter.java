package com.example.cachorrosracas.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cachorrosracas.R;
import com.example.cachorrosracas.model.Raca;

import java.util.ArrayList;

public class SubRacaAdapter extends RecyclerView.Adapter<SubRacaAdapter.MyViewHolder> {

    private ArrayList<String> listaSubRacas;
    private Context mContext;

    public SubRacaAdapter(ArrayList<String> listaRacas, Context mContext){
        this.listaSubRacas = listaRacas;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SubRacaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_subraca, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String subRaca = listaSubRacas.get(position);
        holder.nomeSubRaca.setText(subRaca);
    }

    @Override
    public int getItemCount() {
        return listaSubRacas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView nomeSubRaca;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeSubRaca = itemView.findViewById(R.id.textSubRaca);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
