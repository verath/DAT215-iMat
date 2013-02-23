/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import SearchResults.SearchResultsView;

/**
 *
 * @author Peter
 */
public enum MainController {
    INSTANCE;
    
    private SearchResultsView srv;
    
    public void setResultsView(SearchResultsView srv){
        this.srv = srv;
    }
    
    public SearchResultsView getResultsView(){
        return this.srv;
    }
}
