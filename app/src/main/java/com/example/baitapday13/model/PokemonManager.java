package com.example.baitapday13.model;

import java.util.List;

public class PokemonManager {

    private Integer count;
    private String next;
    private String previous;
    private List<Pokemon> pokemons = null;

    public PokemonManager() {
    }

    public PokemonManager(Integer count, String next, String previous, List<Pokemon> pokemons) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.pokemons = pokemons;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
