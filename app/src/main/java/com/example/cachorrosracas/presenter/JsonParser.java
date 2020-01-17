package com.example.cachorrosracas.presenter;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.cachorrosracas.model.Raca;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class JsonParser {

    private RequestQueue mQueue;
    private ArrayList<Raca> listaRacas;
    private ArrayList<String> subRacas;

    public ArrayList<Raca> getInfos(Context context, final AdapterRecycler adapterRecycler){

        mQueue = Volley.newRequestQueue(context);
        subRacas = new ArrayList<>();
        listaRacas = new ArrayList<>();
        String url = "https://dog.ceo/api/breeds/list/all";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{

                    JSONObject listaResponse = response.getJSONObject("messege");

                    Iterator<String> keys = listaResponse.keys();
                    while (keys.hasNext()){
                        String key = keys.next();
                        if (listaResponse.get(key) instanceof JSONArray){
                            JSONArray racaArray = (JSONArray) listaResponse.get(key);
                            for(int x = 0; x < racaArray.length(); x++){
                                subRacas.add(racaArray.get(x).toString());
                            }

                            Raca raca = new Raca(key, subRacas);
                            listaRacas.add(raca);
                        }
                    }

                    adapterRecycler.notifyDataSetChanged();

                }catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Erro na clase Json", error.getMessage());
            }
        }
        );

        return listaRacas;
    }


}
