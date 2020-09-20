package com.example.baitapday13.parser;

import android.util.Log;
import android.util.StringBuilderPrinter;

import com.example.baitapday13.model.Music;
import com.example.baitapday13.model.Musicss;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MusicParser {
    public List<Music> parMusic(String link){
        List<Music> musics = new ArrayList<>();

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

            JSONArray jsonArray = jsonObject.getJSONArray("music");
           // Musicss musicss = new Musicss(jsonObject.getJSONObject("music"));
        //    Log.d("lovethuy", "parMusic: "+ musicss.toString());
            //JSONArray rootArray = musicss.getMusic();
           // Music[] jsonArray = musicss.getMusicsc();

            for (int i = 0 ; i < jsonArray.length(); i++ ){

                JSONObject objMusic = (JSONObject) jsonArray.get(i);
             //   String a = musicss.getMusicsc().;
                String title = objMusic.getString("title");
                String artist = objMusic.getString("artist");
                String genre = objMusic.getString("genre");
                String image = "https://storage.googleapis.com/automotive-media/"+objMusic.getString("image");
//                String title = musicss.getMusic().get(i).getTitle();
//                String artist =musicss.getMusic().get(i).getArtist();
//                String genre = musicss.getMusic().get(i).getGenre();
//                String image = musicss.getMusic().get(i).getImage();
                String nhac = "https://storage.googleapis.com/automotive-media/"+objMusic.getString("source");
            Music music = new Music(title,artist,genre,nhac,image);
            musics.add(music);


            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return musics;
    }
}
