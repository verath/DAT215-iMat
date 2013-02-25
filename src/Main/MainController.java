/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import ProductSearch.ProductSearch;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Peter
 */
public enum MainController {
    INSTANCE;
    
    private List<SearchListener> searchListeners = new ArrayList<SearchListener>();
    
    /**
     * Performs a search by displaying the search results panels.
     * 
     * @param ps 
     */
    public void search(ProductSearch ps){
        notifySearchListeners(ps);
    }
    
    public void notifySearchListeners(ProductSearch ps){
        for(SearchListener sl : searchListeners){
            sl.onSearch(ps);
        }
    }
    
    public void addSearchListener(SearchListener sl){
        searchListeners.add(sl);
    }
    
    public void removeSearchListener(SearchListener sl) {
        searchListeners.remove(sl);
    }
}
