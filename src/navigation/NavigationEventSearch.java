package navigation;

import Search.SearchQuery;

/**
 * A class representing the more specific NavigationSearchEvent that
 * is used when a search is performed.
 * 
 * @author Peter
 */
public class NavigationEventSearch extends NavigationEvent{
    SearchQuery searchQuery;
    
    public NavigationEventSearch(SearchQuery searchQuery) {
        super();
        this.searchQuery = searchQuery;
    }

    /**
     * Getter for the SearchQuery
     * @return 
     */
    public SearchQuery getSearchQuery() {
        return searchQuery;
    }

    /**
     * Setter for the SearchQuery
     * @param searchQuery 
     */
    public void setSearchQuery(SearchQuery searchQuery) {
        this.searchQuery = searchQuery;
    }
}
