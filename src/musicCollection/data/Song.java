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

    // Validation
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @param artist the artist to set
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * @return the album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * @param album the album to set
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the playbacks
     */
    public int getPlaybacks() {
        return playbacks;
    }

    /**
     * @param playbacks the playbacks to set
     */
    public void setPlaybacks(int playbacks) {
        this.playbacks = playbacks;
    }

    /**
     * @return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * @return the tags
     */
    public ArrayList<String> getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
