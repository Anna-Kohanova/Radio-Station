package sourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class JSONReader implements Loader {

    private File file;
    private FileInputStream stream;

    @Override
    public String load(String sourceName) {
        byte[] data;

        try {
            file = new File(sourceName);

            if (!file.exists()) {
                throw new FileNotFoundException(file.getName());
            }
            stream = new FileInputStream(file);

            data = new byte[(int) file.length()];
            stream.read(data);
            stream.close();
            return new String(data, "UTF-8");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSONReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSONReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
