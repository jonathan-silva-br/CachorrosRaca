package com.example.cachorrosracas.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/*
 * Teste do construtor da classe Raca
 *
 */

public class RacaTest {

    /*
     * Teste do parametro String NomeRaca do construtor.
     */

    @Test
    public void testNomeRacaConstrutor(){
        String nomeRaca = "akita";
        ArrayList<String> subRacas = new ArrayList<>();
        subRacas.add("aaa");
        subRacas.add("bbb");
        Raca raca = new Raca(nomeRaca, subRacas);
        Assert.assertEquals(nomeRaca, raca.getNomeRaca());
    }

    /*
     * Teste do parametro ArrayList<String> subRacas do construtor.
     */

    @Test
    public void testSubRacasConstrutor(){
        String nomeRaca = "akita";
        ArrayList<String> subRacas = new ArrayList<>();
        subRacas.add("aaa");
        subRacas.add("bbb");
        Raca raca = new Raca(nomeRaca, subRacas);
        Assert.assertEquals(subRacas, raca.getSubRacas());
    }


}