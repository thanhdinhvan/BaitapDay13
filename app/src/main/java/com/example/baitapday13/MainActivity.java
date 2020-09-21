package com.example.baitapday13;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baitapday13.adapter.MusicAdapter;
import com.example.baitapday13.model.Music;
import com.example.baitapday13.parser.MusicParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements Runnable{
private List<Music> musics;
private ListView listView;
private MusicAdapter musicAdapter;
private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        musics = new ArrayList<>();
        listView = findViewById(R.id.lv_music);
        musicAdapter = new MusicAdapter(musics,getApplicationContext());
        listView.setAdapter(musicAdapter);

        // media
        mediaPlayer = new MediaPlayer();


      //  mediaPlayer.prepareAsync();



//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//
//                try {
//
//                    mediaPlayer.stop();
//
//                    mediaPlayer.setDataSource(musics.get(i).getSource());
//                    //mediaPlayer.prepareAsync();
//                    //mediaPlayer.prepareAsync();
//                    mediaPlayer.prepare();
//                    mediaPlayer.start();
//                    musicAdapter.notifyDataSetChanged();
//
//
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//
//
//            }
//        });


//        Thread thread = new Thread(this);
//        thread.start();

//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                Getdata();
//              //  musicAdapter.notifyDataSetChanged();
//            }
//        });
        new LoadMusicTask().execute("https://storage.googleapis.com/automotive-media/music.json");


    }
    class LoadMusicTask extends AsyncTask<String, Void, List<Music>>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getApplicationContext(),"stars",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected List<Music> doInBackground(String... args) {
            String link = args[0];
            MusicParser musicParser = new MusicParser();


            return musicParser.parMusic(link);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(List<Music> music) {
            super.onPostExecute(music);
            musics.clear();
            musics.addAll(music);
            musicAdapter.notifyDataSetChanged();
        }
    }

    private void Getdata() {
        musics.clear();
        MusicParser musicParser = new MusicParser();
        MusicParser parser = new MusicParser();
        musics.addAll(parser.parMusic("https://storage.googleapis.com/automotive-media/music.json"));
        musicAdapter.notifyDataSetChanged();

    }


    @Override
    public void run() {
        Getdata();

        //musicAdapter.notifyDataSetChanged();
    }
}