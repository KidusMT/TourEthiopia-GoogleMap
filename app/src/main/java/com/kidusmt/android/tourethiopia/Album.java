package com.kidusmt.android.tourethiopia;

/**
 * Created by KidusMT on 4/10/2017.
 */

public class Album {
    private String title;
    private String description;
    private int thumbnail;

    public Album() {
    }

    public Album(String name, String numOfSongs, int thumbnail) {
        this.title = name;
        this.description = numOfSongs;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public String getNumOfSongs() {
        return description;
    }

    public void setNumOfSongs(String numOfSongs) {
        this.description = numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
