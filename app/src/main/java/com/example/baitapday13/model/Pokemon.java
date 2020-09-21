package com.example.baitapday13.model;

public class Pokemon {

    private String name;
    private String url;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pokemon() {
    }

    /**
     *
     * @param name
     * @param url
     */
    public Pokemon(String name, String url) {
        super();
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
