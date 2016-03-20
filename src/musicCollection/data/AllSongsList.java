package musicCollection.data;

import fileUtils.JSONFileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import parserUtils.JSONFileParser;

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
        JSONParser jsonParser = new JSONParser();
        JSONFileParser parser = new JSONFileParser();

        try {
            Object obj = jsonParser.parse(JSONFileReader.readerFromJSON(fileName));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get(fileName.substring(0, fileName.length() - 5));
            Iterator<JSONObject> iterator = jsonArray.iterator();

            ArrayList<Song> allSongsList = new ArrayList<Song>();

            while (iterator.hasNext()) {
                Song song = parser.parseSongInfo(iterator.next(), new Song());
                this.allSongsList.add(song);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void addSong(String title, String artist, String album, int year, int playbacks,
            double rating, ArrayList<String> tags) {

        Song song = new Song(title, artist, album, year, playbacks, rating, tags);
        this.allSongsList.add(song);

        //writer
    }

    public void editSong(Song song, String title, String artist, String album, int year, int playbacks,
            double rating, ArrayList<String> tags) {

        song.setTitle(title);
        song.setArtist(artist);
        song.setAlbum(album);
        song.setYear(year);
        song.setPlaybacks(playbacks);
        song.setRating(rating);
        song.setTags(tags);

        //writer
    }

    public void deleteSong() { // Признак?
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

}
