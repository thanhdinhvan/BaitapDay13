package com.example.baitapday13.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.baitapday13.R;
import com.example.baitapday13.model.Music;

import java.util.List;

public class MusicAdapter extends BaseAdapter {
    private List<Music> musics;
    private Context context;

    public MusicAdapter(List<Music> musics, Context context) {
        this.musics = musics;
        this.context = context;
    }

    @Override
    public int getCount() {
        Log.d("vanthanh", "getCount: d km may"+musics.size());

        return musics.size();
    }

    @Override
    public Object getItem(int i) {
        return musics.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = view;
        ViewHorder viewHolder;
        if (view == null){
            view1 = LayoutInflater.from(context).inflate( R.layout.item_music,viewGroup,false);
            viewHolder =  new ViewHorder();
            viewHolder.imageView = view1.findViewById(R.id.img_music);
            viewHolder.tv_artist = view1.findViewById(R.id.tv_artist);
            viewHolder.tv_genre = view1.findViewById(R.id.tv_genre);
            viewHolder.tv_title = view1.findViewById(R.id.tv_title);
            Music music = musics.get(i);
            viewHolder.tv_genre.setText(music.getGenre());
            viewHolder.tv_title.setText(music.getTitle());
            viewHolder.tv_artist.setText(music.getArtist());
            Glide.with(context).load(music.getImage()).into(viewHolder.imageView);

            view1.setTag(viewHolder);


        } else {
            viewHolder = (ViewHorder) view1.getTag();
        }
        Music music = musics.get(i);
        viewHolder.tv_genre.setText(music.getGenre());
        viewHolder.tv_title.setText(music.getTitle());
        viewHolder.tv_artist.setText(music.getArtist());
        Glide.with(context).load(music.getImage()).into(viewHolder.imageView);


        return view1;
    }
    class ViewHorder{
        private TextView tv_title, tv_artist, tv_genre;
        private ImageView imageView;
    }
}
