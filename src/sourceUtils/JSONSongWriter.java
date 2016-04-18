package sourceUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import musicCollection.data.Song;

public class JSONSongWriter {
    
     public void write (ArrayList<Song> musicCollection, String sourceName) {
         
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String str = gson.toJson(musicCollection);
        
        try (FileWriter file = new FileWriter(sourceName)) {
            file.write(str);
        } catch (IOException ex) {
            Logger.getLogger(JSONSongReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
