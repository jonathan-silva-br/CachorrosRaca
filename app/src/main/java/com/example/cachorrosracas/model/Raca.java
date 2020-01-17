package com.example.cachorrosracas.model;

import java.util.ArrayList;

public class Raca {

    private String nomeRaca;
    private ArrayList<String> subRacas;

    public Raca(String nomeRaca, ArrayList<String> subRacas){
        this.setNomeRaca(nomeRaca);
        this.setSubRacas(subRacas);
    }

    public String getNomeRaca() {
        return nomeRaca;
    }

    public void setNomeRaca(String nomeRaca) {
        this.nomeRaca = nomeRaca;
    }

    public ArrayList<String> getSubRacas() {
        return subRacas;
    }

    public void setSubRacas(ArrayList<String> subRacas) {
        this.subRacas = subRacas;
    }



}
