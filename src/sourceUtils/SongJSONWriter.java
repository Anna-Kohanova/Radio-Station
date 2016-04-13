package sourceUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import musicCollection.data.Song;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SongJSONWriter {

    private FileWriter file;
    private String fileName;

    public SongJSONWriter(String fileName) throws IOException {
        file = new FileWriter(fileName);
        this.fileName = fileName;
    }

    public void writerToJSON(ArrayList<Song> musicCollection) throws IOException {
     
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String str = gson.toJson(musicCollection);
        
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(str);
        }
    }
}
