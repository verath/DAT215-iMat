/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import ProductSearch.ProductSearch;
import SearchResults.SearchResultsController;

/**
 *
 * @author Peter
 */
public enum MainController {
    INSTANCE;
    
    private SearchResultsController src = SearchResultsController.INSTANCE;
    
    /**
     * Performs a search by displaying the search results panels.
     * 
     * @param ps 
     */
    public void search(ProductSearch ps){
        src.setProductSearch(ps);
    }
}
