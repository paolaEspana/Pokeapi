package com.example.paola.pokeapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.paola.pokeapi.models.Pokemon;
import com.example.paola.pokeapi.models.PokemonRespuesta;
import com.example.paola.pokeapi.pokeapi.PokeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        retrofit = new Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/").addConverterFactory(GsonConverterFactory.create()).build();

        procesarDatos();
    }

    private void procesarDatos() {

        PokeapiService service = retrofit.create(PokeapiService.class);

        Call<PokemonRespuesta> pokemonRespuestaCall = service.obtenerListaPokemon();

        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
            public static final String TAG = "POKEAPI";

            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                if (response.isSuccessful()) {

                    PokemonRespuesta pokemonRespuesta = response.body();
                    Log.i(TAG, "count: " + pokemonRespuesta.getCount());
                    Log.i(TAG, "count: " + pokemonRespuesta.getNext());

                    ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();

                    for (int i = 0; i < listaPokemon.size(); i++)
                    {
                        Pokemon pokemon = (Pokemon) listaPokemon.get(i);

                        Log.i(TAG, "name: " + pokemon.getName());
                    }
                } else {
                    Log.e(TAG, " OnResponse " + response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                //falla
                Log.e(TAG, " OnFailure: " + t.getMessage());
            }
        });
    }
}
