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
import com.example.cachorrosracas.view.MainActivity;
import com.example.cachorrosracas.view.SubRacaActivity;

import java.util.ArrayList;

public class RacaAdapter extends RecyclerView.Adapter<RacaAdapter.MyViewHolder> {

    private ArrayList<Raca> listaSubRacas;
    private Context context;

    public void setListaRacas(ArrayList<Raca> listaRacas) {
        this.listaSubRacas = listaRacas;
    }

    public RacaAdapter(ArrayList<Raca> listaRacas, Context context){
        this.listaSubRacas = listaRacas;
        this.context = context;
    }

    @NonNull
    @Override
    public RacaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull RacaAdapter.MyViewHolder holder, int position) {
        Raca raca =listaSubRacas.get(position);
        holder.nomeRaca.setText(raca.getNomeRaca());

    }

    @Override
    public int getItemCount() {
        return listaSubRacas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{



        TextView nomeRaca;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeRaca = itemView.findViewById(R.id.textRaca);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Raca raca = listaSubRacas.get(getAdapterPosition());
                    ArrayList<String> subRacas=raca.getSubRacas();
                    String[] vetor = new String[subRacas.size()];

                    for(int i = 0; i < subRacas.size(); i++){
                        vetor[i] = subRacas.get(i);
                    }

                    Intent intent = new Intent(context, SubRacaActivity.class);
                    intent.putExtra("vetorSubRaca", vetor);
                    intent.putExtra("nomeRaca", raca.getNomeRaca());
                    context.startActivity(intent);

                    

                }
            });

        }


    }
}
