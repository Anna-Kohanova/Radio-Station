package radioStation;

import java.io.IOException;
import java.text.ParseException;
import musicCollection.data.AllSongsList;
import musicCollection.data.Song;

public class RadioStation {

    public static void main(String[] args) throws IOException, ParseException {
        String fileName = "playlist.json";
        
        AllSongsList allSongsList = new AllSongsList(fileName);
        
        for (Song s: allSongsList.getAllSongsList()) {
            System.out.println(s.toString());
        }
     
    }
    
}
