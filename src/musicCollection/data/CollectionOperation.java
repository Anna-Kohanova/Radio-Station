package musicCollection.data;

import java.util.ArrayList;

public interface CollectionOperation <T> {
    void sort(ArrayList<T> collection, String sortKeyword);
    ArrayList<T> search(ArrayList<T> collection, String searchKeyword);
    // ArrayList<T> fillCollection();
}
