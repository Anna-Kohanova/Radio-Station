package parserUtils;

import java.util.ArrayList;

public interface Parser <T> {
    ArrayList <T> parser(Object obj);
}
