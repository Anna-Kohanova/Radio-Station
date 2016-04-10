package radioStation;

import java.awt.Dimension;
import java.awt.Font;
import sourceUtils.JSONReader;
import sourceUtils.JSONWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import musicCollection.data.CollectionOperation;
import musicCollection.data.Song;
import org.json.simple.parser.JSONParser;
import parserUtils.SongParser;

public class RadioStation extends JFrame implements CollectionOperation <Song>{

    public RadioStation(ArrayList<Song> musicCollection) {

        createTable(musicCollection);

        this.setTitle("Radio Station");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();        
        this.setSize(new Dimension(1100, 500));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void createTable(ArrayList<Song> musicCollection) {
        
        JTable table = new JTable();
        table.setFont(new Font("Serif", Font.BOLD, 18));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 20));
        
        DefaultTableModel model = new DefaultTableModel(new Object[]{ "Title", "Artist", "Album", "Year", "playbacks", "rating", "tags"}, 0);

        for (Song song : musicCollection) {
            model.addRow(new Object[]{song.getTitle(), song.getArtist(), song.getAlbum(), song.getYear(), song.getPlaybacks(), song.getRating()
            , song.getTags()});
        }        
        table.setModel(model);

        //add the table to the frame
        this.add(new JScrollPane(table));
    }
    

    public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
        String fileName = "allSongs.json";
        JSONParser jsonParser = new JSONParser();
        SongParser parser = new SongParser();
        JSONReader reader = new JSONReader();

        Object obj = jsonParser.parse(reader.load(fileName));
        final ArrayList<Song> musicCollection = parser.parser(obj);

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RadioStation(musicCollection);
            }
        });

//        RadioJFrame app = new RadioJFrame(musicCollection); //Создаем экземпляр нашего приложения
//        app.setVisible(true); //С этого момента приложение запущено!
        
        
        ///////////// PRINT MUSIC COLLECTION //////////////
        for (Song s : musicCollection) {
            System.out.println(s.toString());
        }

        ///////////// SEARCHING ///////////// 
        // ArrayList<Song> findingSongs = search(musicCollection, "kicker");     
//        for (Song s: findingSongs) {
//            System.out.println(findingSongs.toString());
//        }       
        
        ////////////// SORTING //////////////
//        sort(musicCollection, "artist");
//        for (Song s : musicCollection) {
//            System.out.println(s.toString());
//        }
        ////////////// WRITING IN JSON  //////////////
//        JSONWriter jsonWriter = new JSONWriter(fileName);
//        jsonWriter.writerToJSON(allSongsList.getAllSongsList());     
    }
    
    @Override
     public void sort(ArrayList<Song> collection, String sortKeyword) {
         switch (sortKeyword) {
            case "album": {
                Collections.sort(collection, new Comparator<Song>() {

                    public int compare(Song s1, Song s2) {
                        return s1.getAlbum().compareTo(s2.getAlbum());
                    }
                });
            }
            break;

            case "artist": {
                Collections.sort(collection, new Comparator<Song>() {

                    public int compare(Song s1, Song s2) {
                        return s1.getArtist().compareTo(s2.getArtist());
                    }
                });
            }
            break;

            case "title": {
                Collections.sort(collection, new Comparator<Song>() {

                    public int compare(Song s1, Song s2) {
                        return s1.getTitle().compareTo(s2.getTitle());
                    }
                });
            }
            break;
        }
    }
     
    @Override
    public ArrayList<Song> search(ArrayList<Song> collection, String searchKeyword) {
        
        ArrayList<Song> findingSongs = new ArrayList<>();

        for (Song song : collection) {
            if (song.getAlbum().toLowerCase().contains(searchKeyword.toLowerCase()) || song.getArtist().toLowerCase().contains(searchKeyword.toLowerCase())
                    || song.getTitle().toLowerCase().contains(searchKeyword.toLowerCase())) {
                findingSongs.add(song);
            }
        }
        return findingSongs;
    }    
    
}
