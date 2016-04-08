package radioStation;

import fileUtils.JSONFileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import musicCollection.data.SongList;
import musicCollection.data.Song;
import musicCollection.searchUtils.Searchable;
import musicCollection.searchUtils.Searching;

public class RadioStation {

    public static void main(String[] args) throws IOException, ParseException {
        String fileName = "allSongs.json";        
        SongList allSongsList = new SongList(fileName);
        
        // Print all songs
//        for (Song s: allSongsList.getAllSongsList()) {
//            System.out.println(s.toString());
//        }
        
        Searching search = new Searching(allSongsList.getAllSongsList());
        ArrayList<Song> foundingSongs = search.search("rock singer");
        
        // Print all songs with keyword
//        for (Song s: foundingSongs) {
//            System.out.println(foundingSongs.toString());
//        }
        
        JSONFileWriter jsonWriter = new JSONFileWriter(fileName);
        jsonWriter.writerToJSON(allSongsList.getAllSongsList());     
    }    
}
