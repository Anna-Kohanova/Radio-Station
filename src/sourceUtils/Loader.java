package sourceUtils;

import java.util.ArrayList;

public interface Loader <T>{
    String loadFrom(String sourceName);
    void loadTo(ArrayList<T> collection, String sourceName);
}
