package musicCollection.sortUtils;

import java.util.Comparator;
import musicCollection.data.Song;

public class Sorting implements Comparator<Song> {
    private int parameterToCompare;
    
    public Sorting(int parameterToCompare) {
        this.parameterToCompare = parameterToCompare;
    }
    
      @Override
    public int compare(Song obj1, Song obj2) {
        String object1 = "";
        String object2 = "";
        
        switch(this.parameterToCompare) {
             case 1:
                object1 = obj1.getAlbum();
                object2 = obj2.getAlbum();
                break;
            case 2:
                object1 = obj1.getArtist();
                object2 = obj2.getArtist();
                break;
            case 3:
                object1 = obj1.getTitle();
                object2 = obj2.getTitle();
                break;
        }        
        return object1.compareToIgnoreCase(object2);
    }
    
}
