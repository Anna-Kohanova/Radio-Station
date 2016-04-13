package musicCollection.data;

import java.util.ArrayList;

public class Song {

    private String title;
    private String artist;
    private String album;
    private String year;
    private int playbacks;
    private double rating;
    private ArrayList<String> tags;

    public Song(String title, String artist, String album, String year, int playbacks,
            double rating, ArrayList<String> tags) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.playbacks = playbacks;
        this.rating = rating;
        this.tags = tags;
    }

    public Song() {

    }

    @Override
    public String toString() {

        String str = "title = " + getTitle() + ", artist = " + getArtist() + ", album = " + getAlbum()
                + ", year = " + getYear() + ", playbacks = " + getPlaybacks() + ", rating = " + rating;

        str += ", tags : [";

        for (String tag : getTags()) {
            str += tag + ", ";
        }

        str += " ]";

        return str;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        String regex = "\\d+";
        
        if (year.matches(regex)) {
            this.year = year;
        }
        else {
            this.year = "0";
        }
    }

    public int getPlaybacks() {
        return playbacks;
    }

    public void setPlaybacks(int playbacks) {
        this.playbacks = playbacks;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
