package com.example.baitapday13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.baitapday13.adapter.MusicAdapter;
import com.example.baitapday13.adapter.PokemonAdapter;
import com.example.baitapday13.model.Music;
import com.example.baitapday13.model.Pokemon;
import com.example.baitapday13.parser.MusicParser;
import com.example.baitapday13.parser.PokemonParser;

import java.util.ArrayList;
import java.util.List;

public class PokemonActivity extends AppCompatActivity {
    private List<Pokemon> pokemons;
    private ListView listView;
    private PokemonAdapter pokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        pokemons = new ArrayList<>();
        listView = findViewById(R.id.lv_pokemon);
        pokemonAdapter = new PokemonAdapter(pokemons,getApplicationContext());
        listView.setAdapter(pokemonAdapter);
        new LoadPokemonTask().execute("https://pokeapi.co/api/v2/pokemon?limit=100&offset=200");


    }
    class LoadPokemonTask extends AsyncTask<String, Void, List<Pokemon>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getApplicationContext(),"stars pokemon",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected List<Pokemon> doInBackground(String... args) {
            String link = args[0];
            PokemonParser pokemonParser = new PokemonParser();


            return pokemonParser.parPokemon(link);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(List<Pokemon> pokemon) {
            super.onPostExecute(pokemon);
            pokemons.clear();
            pokemons.addAll(pokemon);
            pokemonAdapter.notifyDataSetChanged();
        }
    }
}