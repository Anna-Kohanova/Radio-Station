package parserUtils;

import java.util.ArrayList;

public interface Parseable <T> {
    ArrayList<T> parser(Object obj);
}
