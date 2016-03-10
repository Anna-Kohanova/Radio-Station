package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class PlayList implements Actions, Serializable {
    
    private ArrayList<Song> playList;
    
    public PlayList() {
        playList = new ArrayList<Song>();
        this.setPlayList(this.songGeneration());
    }
    
    public ArrayList<Song> getPlayList() {
        return playList;
    }

    public void setPlayList(ArrayList<Song> playList) {
        this.playList = playList;
    }
    
    

    @Override
    public void addSong() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editSong() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSong() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Song> songGeneration() {
        
       ArrayList<Song> playList = new ArrayList<Song>();       
       Random rd = new Random();
       int min = rd.nextInt(5);
       int max = 10;
       
       int songsAmount =  min + (int)(Math.random()*(max-min) + 1);
       
       for (int i = 0; i < songsAmount; i++) {
           
           ArrayList<String> tags = new ArrayList<String>();
           tags.add("tag1");
           tags.add("tag2");
           playList.add(new Song("title" + i, "artist" + i, "album" + i, i, i, tags));           
       }
        
        return playList;
    }

    
}
