package sourceUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import musicCollection.data.Song;

public final class SongJSONLoader implements Loader <Song> {

    @Override
    public String loadFrom(String sourceName) {
        byte[] data;

        try {
            File file = new File(sourceName);

            if (!file.exists()) {
                throw new FileNotFoundException(file.getName());
            }
            FileInputStream stream = new FileInputStream(file);

            data = new byte[(int) file.length()];
            stream.read(data);
            stream.close();
            return new String(data, "UTF-8");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SongJSONLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SongJSONLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void loadTo(ArrayList<Song> musicCollection, String sourceName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String str = gson.toJson(musicCollection);
        
        try (FileWriter file = new FileWriter(sourceName)) {
            file.write(str);
        } catch (IOException ex) {
            Logger.getLogger(SongJSONLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
