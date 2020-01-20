package com.example.cachorrosracas.presenter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.cachorrosracas.model.Raca;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class JsonParser {

    private RequestQueue mQueue;
    private ArrayList<Raca> listaRacas;
    private JsonObjectRequest request;
    private String urlImage;
    private ImageView imageRaca;
    private String urlResponse;

    public void getInfos(Context context, final RacaAdapter adapterRecycler){

        mQueue = Volley.newRequestQueue(context);

        listaRacas = new ArrayList<>();
        String url = "https://dog.ceo/api/breeds/list/all";

        request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{

                    JSONObject listaResponse = response.getJSONObject("message");

                    Iterator<String> keys = listaResponse.keys();
                    while (keys.hasNext()){
                        String key = keys.next();
                        if (listaResponse.get(key) instanceof JSONArray){
                            JSONArray racaArray = (JSONArray) listaResponse.get(key);

                            ArrayList<String> subRacas = new ArrayList<>();

                            for(int x = 0; x < racaArray.length(); x++){
                                subRacas.add(racaArray.get(x).toString());
                            }

                            Raca raca = new Raca(key, subRacas);
                            listaRacas.add(raca);
                        }
                    }

                    adapterRecycler.setListaRacas(listaRacas);
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
        mQueue.add(request);
    }

    public void getImageRaca(final ImageView image, String nomeRaca, Context context){
        urlImage = "https://dog.ceo/api/breed/"+nomeRaca+"/images/random";
        urlResponse = "";
        request = new JsonObjectRequest(Request.Method.GET, urlImage, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    urlResponse = response.get("message").toString();
                    Picasso.get().load(urlResponse).into(image);

                }catch (Exception e) {
                    Log.e("Erro getImageRaca", e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Erro na clase Json", error.getMessage());
            }
        }
        );
        mQueue = Volley.newRequestQueue(context);
        mQueue.add(request);
    }

    public String getImageSubRaca(String urlImageSubRaca){
        return null;
    }


}
