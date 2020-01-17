package com.example.cachorrosracas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cachorrosracas.R;
import com.example.cachorrosracas.model.Raca;
import com.example.cachorrosracas.presenter.AdapterRecycler;
import com.example.cachorrosracas.presenter.JsonParser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Raca> listaRacas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerRacas);

        //Configura AdapterRecycler
        AdapterRecycler adapter = new AdapterRecycler(listaRacas);

        //Configura o RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        JsonParser jsonParser = new JsonParser();
        listaRacas = jsonParser.getInfos(this, adapter);
    }
}
