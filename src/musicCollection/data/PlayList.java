package musicCollection.data;

import fileUtils.JSONFileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class PlayList {

    private ArrayList<Song> playList;

    public PlayList(String fileName) throws IOException, java.text.ParseException {

        playList = new ArrayList<Song>();
        this.fillPlayList(fileName);
    }

    public ArrayList<Song> getPlayList() {
        return playList;
    }

    public void setPlayList(ArrayList<Song> playList) {
        this.playList = playList;
    }

    private void fillPlayList(String fileName) throws IOException, java.text.ParseException {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(JSONFileReader.readerFromJSON(fileName));
            
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("playList");
            Iterator<JSONObject> iterator = jsonArray.iterator();
            
            ArrayList<Song> playList = new ArrayList<Song>();

            while (iterator.hasNext()) {  // имеет ли смысл переносить весь код из цикла в отдельный класс Parser?
                Song song = new Song();

                JSONObject songObject = iterator.next();
                song.setAlbum(songObject.get("album").toString());
                song.setArtist(songObject.get("artist").toString());
                song.setTitle(songObject.get("title").toString());
                song.setYear(((Long) songObject.get("year")).intValue());
                song.setPlaybacks(((Long) songObject.get("playbacks")).intValue());
                song.setRating((Double) songObject.get("rating"));
                song.setTags((ArrayList) songObject.get("tags"));

                ArrayList<String> stringDates = new ArrayList<String>();
                ArrayList<Date> dateDates = new ArrayList<Date>();

                stringDates = (((ArrayList) songObject.get("playdate")));

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                for (String date : stringDates) {
                    dateDates.add(formatter.parse(date));
                }

                song.setPlaydate(dateDates);   // output like 2016-02-27 - formatter.format(date)
                
                playList.add(song);              
                
            }
            
            this.setPlayList(playList);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void addSong() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editSong() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteSong() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
