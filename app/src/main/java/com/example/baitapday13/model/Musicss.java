package com.example.baitapday13.model;

import java.util.ArrayList;
import java.util.List;

public class Musicss {

    private Music[] musicsc ;

    /**
     * No args constructor for use in serialization
     *
     */
    public Musicss() {
    }

    public Musicss(Music[] musicsc) {
        this.musicsc = musicsc;
    }

    /**
     *
     *
     */


    public Musicss(Object music) {
    }

    public Music[] getMusicsc() {
        return musicsc;
    }

    public void setMusicsc(Music[] musicsc) {
        this.musicsc = musicsc;
    }

    @Override
    public String toString() {
        return "Musicss{" +
                "musicsc=" + musicsc +
                '}';
    }
}
