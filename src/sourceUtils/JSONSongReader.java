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
import parserUtils.SongParser;

public final class JSONSongReader implements Loader <Song> {

    @Override
    public ArrayList<Song> load(String sourceName) {
        
        SongParser songParser = new SongParser();
        
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
            
            ArrayList<Song> musicCollection = songParser.parser(new String(data, "UTF-8"));
            return musicCollection;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSONSongReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSONSongReader.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        
        return null;
    }
}
