package com.example.baitapday13.model;

public class Music {

    private String title;
    private String album;
    private String artist;
    private String genre;
    private String source;
    private String image;
    private Integer trackNumber;
    private Integer totalTrackCount;
    private Integer duration;
    private String site;

    /**
     * No args constructor for use in serialization
     *
     */
    public Music() {
    }

    /**
     *
     * @param totalTrackCount
     * @param duration
     * @param image
     * @param site
     * @param trackNumber
     * @param artist
     * @param album
     * @param genre
     * @param source
     * @param title
     */
    public Music(String title, String album, String artist, String genre, String source, String image, Integer trackNumber, Integer totalTrackCount, Integer duration, String site) {
        super();
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.genre = genre;
        this.source = source;
        this.image = image;
        this.trackNumber = trackNumber;
        this.totalTrackCount = totalTrackCount;
        this.duration = duration;
        this.site = site;
    }

    public Music(String title, String artist, String genre, String image) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.image = image;
    }

    public Music(String title, String artist, String genre, String source, String image) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.source = source;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Integer getTotalTrackCount() {
        return totalTrackCount;
    }

    public void setTotalTrackCount(Integer totalTrackCount) {
        this.totalTrackCount = totalTrackCount;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

}
