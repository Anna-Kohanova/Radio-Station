package sourceUtils;

import java.util.ArrayList;

public interface Loader <T>{
    ArrayList <T> load(String sourceName);
}
