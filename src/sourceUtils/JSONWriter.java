package sourceUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import musicCollection.data.Song;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONWriter {

    private FileWriter file;
    private JSONObject obj;
    private String fileName;

    public JSONWriter(String fileName) throws IOException {
        file = new FileWriter(fileName);
        obj = new JSONObject();
        this.fileName = fileName;
    }

    public void writerToJSON(ArrayList<Song> allSongsList) throws IOException {
        JSONArray arr = new JSONArray();

        for (Song song : allSongsList) {
            JSONObject obj = new JSONObject();
            obj.put("title", song.getTitle());
            obj.put("artist", song.getArtist());
            obj.put("album", song.getAlbum());
            obj.put("year", song.getYear());
            obj.put("playbacks", song.getPlaybacks());
            obj.put("rating", song.getRating());
            obj.put("tags", song.getTags());
            arr.add(obj);
        }
        this.obj.put(fileName.substring(0, fileName.length() - 5), arr);

        try (FileWriter file = new FileWriter(fileName)) {
            file.write(this.obj.toJSONString());
        }
    }
}
