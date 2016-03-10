package data;

import java.io.Serializable;
import java.util.ArrayList;

public class Song implements Serializable {
    private String title;
    private String artist;
    private String album;
    private int songLength;
    private int year;
    private ArrayList<String> tags;
    
    public Song(String title, String artist, String album, int songLenght, int year, ArrayList<String> tags) {
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.songLength = songLenght;
        this.year = year;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }
    
    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<String> getTags() {
        return tags;
    }    
    
    public int getSongLength() {
        return songLength;
    }
    
      @Override
    public String toString() {
        
        String str = "title = " + getTitle() + " artist = " + getArtist() + " album = " + getAlbum() + " songLength = " + getSongLength() + "year = " + getYear() + " tags:";
        
        for (String tag: getTags()) { 
            str += tag + ", ";
        }
        
        return str;
    }
}
