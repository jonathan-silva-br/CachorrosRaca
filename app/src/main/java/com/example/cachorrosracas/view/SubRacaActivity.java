package com.example.cachorrosracas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cachorrosracas.R;
import com.example.cachorrosracas.model.Raca;
import com.example.cachorrosracas.presenter.RacaAdapter;
import com.example.cachorrosracas.presenter.JsonParser;
import com.example.cachorrosracas.presenter.SubRacaAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SubRacaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Raca> listaSubRacas;
    private ArrayList<String> subRacas;
    private String nomeRaca;
    private TextView nomeDaRaca;
    private ImageView imageRaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_raca);



        recyclerView = findViewById(R.id.recyclerSubRaca);

        subRacas = new ArrayList<>();


        Intent intent = getIntent();
        String[] racas = intent.getStringArrayExtra("vetorSubRaca");
        nomeRaca = intent.getStringExtra("nomeRaca");

        for (String as: racas) {
            this.subRacas.add(as);
        }

        nomeDaRaca = findViewById(R.id.textRaca);
        nomeDaRaca.setText(nomeRaca);

        //Configura RacaAdapter
        SubRacaAdapter adapter = new SubRacaAdapter(subRacas, this);

        //Configura o RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);



        //ImageView
        imageRaca = findViewById(R.id.imageRaca);

        JsonParser jsonParser = new JsonParser();

       jsonParser.getImageRaca(imageRaca, nomeRaca, this);







    }
}
