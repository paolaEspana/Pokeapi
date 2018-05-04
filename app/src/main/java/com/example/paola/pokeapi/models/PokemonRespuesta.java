package com.example.paola.pokeapi.models;

import java.util.ArrayList;

public class PokemonRespuesta
{
    private int count;
    //url
    private String previous;
    private String next;

    //lista de pokemon
    private ArrayList<Pokemon> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
