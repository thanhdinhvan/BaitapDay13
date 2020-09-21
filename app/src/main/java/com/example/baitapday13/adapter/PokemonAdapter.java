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
import com.example.baitapday13.model.Pokemon;

import java.util.List;

public class PokemonAdapter extends BaseAdapter {
    private List<Pokemon> pokemons;
    private Context context;

    public PokemonAdapter(List<Pokemon> pokemons, Context context) {
        this.pokemons = pokemons;
        this.context = context;
    }

    @Override
    public int getCount() {
        Log.d("vanthanh", "getCount: d km may"+pokemons.size());

        return pokemons.size();
    }

    @Override
    public Object getItem(int i) {
        return pokemons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = view;
        PokemonAdapter.ViewHorder viewHolder;
        if (view == null){
            view1 = LayoutInflater.from(context).inflate( R.layout.item_music,viewGroup,false);
            viewHolder =  new PokemonAdapter.ViewHorder();
            viewHolder.imageView = view1.findViewById(R.id.img_music);
            viewHolder.tv_artist = view1.findViewById(R.id.tv_artist);
            viewHolder.tv_genre = view1.findViewById(R.id.tv_genre);
            viewHolder.tv_title = view1.findViewById(R.id.tv_title);
            Pokemon pokemon = pokemons.get(i);

           // viewHolder.tv_genre.setText(pokemon.getGenre());
            viewHolder.tv_title.setText(pokemon.getName());
            viewHolder.tv_artist.setText(pokemon.getUrl());
            Glide.with(context).load(pokemon.getUrl()).into(viewHolder.imageView);

            view1.setTag(viewHolder);


        } else {
            viewHolder = (PokemonAdapter.ViewHorder) view1.getTag();
        }
        Pokemon pokemon = pokemons.get(i);
        //viewHolder.tv_genre.setText(pokemon.getGenre());
        viewHolder.tv_title.setText(pokemon.getName());
        viewHolder.tv_artist.setText(pokemon.getUrl());
        Glide.with(context).load(pokemon.getUrl()).into(viewHolder.imageView);


        return view1;
    }
    class ViewHorder{
        private TextView tv_title, tv_artist, tv_genre;
        private ImageView imageView;
    }
}
