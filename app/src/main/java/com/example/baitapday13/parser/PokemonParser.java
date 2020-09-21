package com.example.baitapday13.parser;

import android.util.Log;

import com.example.baitapday13.model.Music;
import com.example.baitapday13.model.Pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonParser {
    public List<Pokemon> parPokemon(String link){
        List<Pokemon> pokemons = new ArrayList<>();


        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            //doc tung dong
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();

            // ghi de len bo nho String
            StringBuilder stringBuilder = new StringBuilder();

            while (line != null){
                stringBuilder.append(line);
                line = reader.readLine();
            }
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            String count = jsonObject.getString("count");
            String next =  jsonObject.getString("next");
            String previous = jsonObject.getString("previous");
            String anhPoke = "https://pokeres.bastionbot.org/images/pokemon/";
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for (int i = 0 ; i < jsonArray.length();i++){
                JSONObject objectPokemon = (JSONObject) jsonArray.get(i);
                String name = objectPokemon.getString("name");
                String urlP = objectPokemon.getString("url");
                String [] anh = urlP.split("/");
                Log.d("thuylove", "parPokemon: "+ anh.toString());

                int leng1 = anh.length - 1 ;
                Log.d("tb", "parPokemon: " + anh[leng1]);
                String img = anhPoke+anh[leng1]+".png";
                Pokemon pokemon = new Pokemon(name,img);
                pokemons.add(pokemon);
                leng1 = 0;
                anh = null;
            }
            // Musicss musicss = new Musicss(jsonObject.getJSONObject("music"));
            //    Log.d("lovethuy", "parMusic: "+ musicss.toString());
            //JSONArray rootArray = musicss.getMusic();
            // Music[] jsonArray = musicss.getMusicsc();

//            for (int i = 0 ; i < jsonArray.length(); i++ ){
//
//                JSONObject objMusic = (JSONObject) jsonArray.get(i);
//                //   String a = musicss.getMusicsc().;
//                String title = objMusic.getString("title");
//                String artist = objMusic.getString("artist");
//                String genre = objMusic.getString("genre");
//                String image = "https://storage.googleapis.com/automotive-media/"+objMusic.getString("image");
////                String title = musicss.getMusic().get(i).getTitle();
////                String artist =musicss.getMusic().get(i).getArtist();
////                String genre = musicss.getMusic().get(i).getGenre();
////                String image = musicss.getMusic().get(i).getImage();
//                String nhac = "https://storage.googleapis.com/automotive-media/"+objMusic.getString("source");
//                Pokemon pokemon = new Pokemon();
//                pokemons.add(pokemon);
//
//
//            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return pokemons;
    }
}
