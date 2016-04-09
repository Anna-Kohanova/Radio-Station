package radioStation;

import fileUtils.JSONFileReader;
import fileUtils.JSONFileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import musicCollection.data.Song;
import org.json.simple.parser.JSONParser;
import parserUtils.SongParser;

public class RadioStation {

    public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
        String fileName = "allSongs.json";

        JSONParser jsonParser = new JSONParser();
        SongParser parser = new SongParser();
        JSONFileReader reader = new JSONFileReader();

        Object obj = jsonParser.parse(reader.readerFromJSON(fileName));
        ArrayList<Song> musicCollection = parser.parser(obj);

        ///////////// PRINT MUSIC COLLECTION //////////////
//        for (Song s: musicCollection) {
//            System.out.println(s.toString());
//        }
        
        ///////////// SEARCHING ///////////// 
//         ArrayList<Song> findingSong = search(musicCollection, "rock singer");
        
        /////////////// PRINT ALL FINDING SONGS //////////////
//        for (Song s: foundingSongs) {
//            System.out.println(foundingSongs.toString());
//        }       
        
        ////////////// SORTING //////////////
//        sort(musicCollection, "artist");

        
//        for (Song s : musicCollection) {
//            System.out.println(s.toString());
//        }
        
        ////////////// WRITING IN JSON  //////////////
//        JSONFileWriter jsonWriter = new JSONFileWriter(fileName);
//        jsonWriter.writerToJSON(allSongsList.getAllSongsList());     
    }

    static ArrayList<Song> search(ArrayList<Song> musicCollection, String searchKeyword) {
        ArrayList<Song> findingSongs = new ArrayList<Song>();

        for (Song song : musicCollection) {

            if (searchKeyword == song.getAlbum() || searchKeyword == song.getArtist() || song.getTags().contains(searchKeyword.toLowerCase())
                    || searchKeyword == song.getYear()) {
                findingSongs.add(song);
            }
        }
        return findingSongs;
    }

    static void sort(ArrayList<Song> musicCollection, String sortKeyword) {
        switch (sortKeyword) {
            case "album": {
                Collections.sort(musicCollection, new Comparator<Song>() {

                    public int compare(Song s1, Song s2) {
                        return s1.getAlbum().compareTo(s2.getAlbum());
                    }
                });
            }
            break;

            case "artist": {
                Collections.sort(musicCollection, new Comparator<Song>() {

                    public int compare(Song s1, Song s2) {
                        return s1.getArtist().compareTo(s2.getArtist());
                    }
                });
            }
            break;

            case "title": {
                Collections.sort(musicCollection, new Comparator<Song>() {

                    public int compare(Song s1, Song s2) {
                        return s1.getTitle().compareTo(s2.getTitle());
                    }
                });
            }
            break;
        }
    }
}
