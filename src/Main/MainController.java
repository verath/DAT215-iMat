/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Search.SearchQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * A singelton class for handling the major tasks in the UI on a high level,
 * such as performing a search or showing the main view.
 * 
 * @author Peter
 */
public enum MainController {
    /**
     * The MainController instance.
     */
    INSTANCE;
    
    private List<SearchListener> searchListeners = new ArrayList<SearchListener>();
    
    /**
     * Performs a search by displaying the search results panels.
     * 
     * @param ps 
     */
    public void search(SearchQuery ps){
        notifySearchListeners(ps);
    }
    
    /**
     * Notifies all search listeners about a new ProductSearch
     * @param ps 
     */
    public void notifySearchListeners(SearchQuery ps){
        for(SearchListener sl : searchListeners){
            sl.onSearch(ps);
        }
    }
    
    /**
     * Adds a SearchListner to be notified when a search is performed.
     * @param sl 
     */
    public void addSearchListener(SearchListener sl){
        searchListeners.add(sl);
    }
    
    /**
     * Removes a SearchListener.
     * @param sl 
     */
    public void removeSearchListener(SearchListener sl) {
        searchListeners.remove(sl);
    }
}
