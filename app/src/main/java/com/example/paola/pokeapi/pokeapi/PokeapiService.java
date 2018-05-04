package com.example.paola.pokeapi.pokeapi;


import com.example.paola.pokeapi.models.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeapiService
{

    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon();
}
