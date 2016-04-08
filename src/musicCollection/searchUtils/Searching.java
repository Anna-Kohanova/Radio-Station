package musicCollection.searchUtils;

import java.util.ArrayList;
import musicCollection.data.Song;

public class Searching implements Searchable <ArrayList<Song>>{ 

    private ArrayList<Song> allSongsList;

    public Searching(ArrayList<Song> allSongsList) {
        this.allSongsList = allSongsList;
    } 
    
    
//    public ArrayList<Song> searchByArtist(String artist) {
//
//        ArrayList<Song> searchingSongsByParameter = new ArrayList<>();
//
//        for (Song song : allSongsList) {
//            if (artist.equalsIgnoreCase(song.getArtist())) {
//                searchingSongsByParameter.add(song);
//            }
//        }
//        return searchingSongsByParameter;
//    }
//
//    public ArrayList<Song> searchByYear(int year) {
//
//        ArrayList<Song> searchingSongsByParameter = new ArrayList<>();
//
//        for (Song song : allSongsList) {
//            if (year == song.getYear()) {
//                searchingSongsByParameter.add(song);
//            }
//        }
//        return searchingSongsByParameter;
//    }
//
//    public ArrayList<Song> searchByTag(String tag) {
//
//        ArrayList<Song> searchingSongsByParameter = new ArrayList<>();
//
//        for (Song song : allSongsList) {
//            if (song.getTags().contains(tag.toLowerCase())) {
//                searchingSongsByParameter.add(song);
//            }
//        }
//        return searchingSongsByParameter;
//    }

    @Override
    public ArrayList<Song> search(String searchKeyword) {
       ArrayList<Song> selectedSongs = new ArrayList<Song>();
       
       for (Song song : allSongsList) {
           
            if (searchKeyword == song.getAlbum() || searchKeyword == song.getArtist() || song.getTags().contains(searchKeyword.toLowerCase()) ||
                    searchKeyword == song.getYear()) {
                selectedSongs.add(song);
            }
        }             
       return selectedSongs;
    }
}
