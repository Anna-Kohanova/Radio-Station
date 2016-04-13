package parserUtils;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import musicCollection.data.Song;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SongParser implements Parser<Song> {

    @Override
    public ArrayList<Song> parser(String str) {
        ArrayList<Song> songList = new ArrayList<Song>();

        Gson gson = new Gson();
        Song[] songs = gson.fromJson(str, Song[].class);
        
        for (Song song : songs) {
            songList.add(song);
        }

        return songList;
    }
}
