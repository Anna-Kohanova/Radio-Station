package oop;

import data.PlayList;
import data.Song;

public class OOP {

    public static void main(String[] args) {
        PlayList playList = new PlayList();
        for (int i = 0; i < playList.getPlayList().size(); i++) {
            System.out.println(playList.getPlayList().get(i).toString());
        }
    }
    
}
