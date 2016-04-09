package parserUtils;

import java.util.ArrayList;
import java.util.Iterator;
import musicCollection.data.Song;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SongParser implements Parseable <Song> {

    @Override
    public ArrayList<Song> parser(Object obj) {

        ArrayList<Song> songList = new ArrayList<>();

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("allSongs");
            Iterator<JSONObject> iterator = jsonArray.iterator();

            while (iterator.hasNext()) {
                Song song = new Song();
                
                JSONObject songIterator = iterator.next();

                song.setAlbum(songIterator.get("album").toString());
                song.setArtist(songIterator.get("artist").toString());
                song.setTitle(songIterator.get("title").toString());
                song.setYear(songIterator.get("year").toString());
                song.setPlaybacks(((Long) songIterator.get("playbacks")).intValue());
                song.setRating((Double) songIterator.get("rating"));
                song.setTags((ArrayList) songIterator.get("tags"));
                
                songList.add(song);
            }
        
        return songList;
    }
}
