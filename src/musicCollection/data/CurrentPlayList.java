package musicCollection.data;

import java.util.ArrayList;

public class CurrentPlayList /*extends AllSongsList */{
    private ArrayList<Song> currentPlayList;
    
    public CurrentPlayList() {
        currentPlayList = new ArrayList<Song>();
    }

    public ArrayList<Song> getCurrentPlayList() {
        return currentPlayList;
    }
    
    public void addSong() {  // override methods from the AllSongsClass (parent)
        
    }
    
    public void deleteSong() {  // override methods from the AllSongsClass (parent)
        
    }    
    
    
}
