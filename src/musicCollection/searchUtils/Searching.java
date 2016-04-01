package musicCollection.searchUtils;

import java.util.ArrayList;
import musicCollection.data.Song;

public class Searching {  // class static? или передавать список всех песен в каждую функцию?

    private ArrayList<Song> allSongsList;

    public Searching(ArrayList<Song> allSongsList) {
        this.allSongsList = allSongsList;
    }

    public ArrayList<Song> searchByArtist(String artist) {

        ArrayList<Song> searchingSongsByParameter = new ArrayList<>();

        for (Song song : allSongsList) {
            if (artist.equalsIgnoreCase(song.getArtist())) {
                searchingSongsByParameter.add(song);
            }
        }
        return searchingSongsByParameter;
    }

    public ArrayList<Song> searchByYear(int year) {

        ArrayList<Song> searchingSongsByParameter = new ArrayList<>();

        for (Song song : allSongsList) {
            if (year == song.getYear()) {
                searchingSongsByParameter.add(song);
            }
        }
        return searchingSongsByParameter;
    }

    public ArrayList<Song> searchByTag(String tag) {

        ArrayList<Song> searchingSongsByParameter = new ArrayList<>();

        for (Song song : allSongsList) {
            if (song.getTags().contains(tag.toLowerCase())) {
                searchingSongsByParameter.add(song);
            }
        }
        return searchingSongsByParameter;
    }

    public ArrayList<Song> searchByRating(Double rating) {
        
        ArrayList<Song> searchingSongsByParameter = new ArrayList<>();
        
        for (Song song : allSongsList) {
            if (rating == song.getRating()) {
                searchingSongsByParameter.add(song);
            }
        }
        return searchingSongsByParameter;
    }
}
