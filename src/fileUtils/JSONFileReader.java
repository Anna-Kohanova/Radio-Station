package fileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class JSONFileReader {

    private File file;
    private FileInputStream stream;
    
    public String readerFromJSON(String fileName) throws FileNotFoundException, IOException {
        
        file = new File(fileName);
        if(!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
        stream = new FileInputStream(file);
        
        byte[] data = new byte[(int) file.length()];
        stream.read(data);
        stream.close();
        
        return new String(data, "UTF-8");
    }
}
