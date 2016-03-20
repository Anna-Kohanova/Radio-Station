package parserUtils;

import java.util.ArrayList;
import musicCollection.data.Song;
import org.json.simple.JSONObject;

public class JSONFileParser {

    public Song parseSongInfo(JSONObject songObject, Song song) {

        song.setAlbum(songObject.get("album").toString());
        song.setArtist(songObject.get("artist").toString());
        song.setTitle(songObject.get("title").toString());
        song.setYear(((Long) songObject.get("year")).intValue());
        song.setPlaybacks(((Long) songObject.get("playbacks")).intValue());
        song.setRating((Double) songObject.get("rating"));
        song.setTags((ArrayList) songObject.get("tags"));

        return song;
    }
}
