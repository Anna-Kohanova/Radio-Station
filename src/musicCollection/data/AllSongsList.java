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

public class AllSongsList {

    private ArrayList<Song> allSongsList;

    public AllSongsList(String fileName) throws IOException, java.text.ParseException {
        allSongsList = new ArrayList<Song>();
        this.fillAllSongsList(fileName);
    }

    public ArrayList<Song> getAllSongsList() {
        return allSongsList;
    }

    public void setAllSongsList(ArrayList<Song> allSongsList) {
        this.allSongsList = allSongsList;
    }

    private void fillAllSongsList(String fileName) throws IOException, java.text.ParseException {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(JSONFileReader.readerFromJSON(fileName));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("playList");
            Iterator<JSONObject> iterator = jsonArray.iterator();

            ArrayList<Song> allSongsList = new ArrayList<Song>();

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

                ArrayList<String> stringDates = new ArrayList<>();
                ArrayList<Date> dateDates = new ArrayList<>();

                stringDates = (((ArrayList) songObject.get("playdate")));

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                for (String date : stringDates) {
                    dateDates.add(formatter.parse(date));
                }

                song.setPlaydate(dateDates);   // output like 2016-02-27 - formatter.format(date)

                allSongsList.add(song);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void addSong(String title, String artist, String album, int year, int playbacks,
            double rating, ArrayList<String> tags, ArrayList<Date> playdate) {

        Song song = new Song(title, artist, album, year, playbacks, rating, tags, playdate);
        this.allSongsList.add(song);
        
        //writer
    }

    ///// ???
    public void editSong(Song song, String title, String artist, String album, int year, int playbacks,
            double rating, ArrayList<String> tags, ArrayList<Date> playdate) {
        
        song.setTitle(title);
        song.setArtist(artist);
        song.setAlbum(album);
        song.setYear(year);
        song.setPlaybacks(playbacks);
        song.setRating(rating);
        song.setTags(tags);
        song.setPlaydate(playdate);
        
        //writer
    }

    public void deleteSong() { // Признак?
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

}
