package radioStation;

import java.io.IOException;
import java.text.ParseException;
import musicCollection.data.PlayList;
import musicCollection.data.Song;

public class RadioStation {

    public static void main(String[] args) throws IOException, ParseException {
        
        PlayList playList = new PlayList("playlist.json");
        
        for (Song s: playList.getPlayList()) {
            System.out.println(s.toString());
        }
     
    }
    
}
