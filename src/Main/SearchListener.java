package Main;

import Search.SearchQuery;

/**
 * An interface implemented by classes listening for search events.
 * 
 * @author Peter
 */
public interface SearchListener {
    public void onSearch(SearchQuery ps);
}
