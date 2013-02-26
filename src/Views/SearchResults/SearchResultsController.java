package Views.SearchResults;

import Main.LocaleHandler;
import Main.MainController;
import Main.SearchListener;
import Search.OrderProductsByNameAscending;
import Search.OrderProductsByNameDescending;
import Search.OrderProductsByPriceAscending;
import Search.OrderProductsByPriceDescending;
import Search.SearchQuery;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;

/**
 *
 * @author Peter
 */
public class SearchResultsController implements SearchListener{
    
    /**
     * Default sorting order for result list.
     */
    public static final Comparator<Product> DEFAULT_SORT = new OrderProductsByNameDescending();
    
    /**
     * The current search represented by the view.
     */
    private SearchQuery productSearch;
    
    /**
     * The filters selected in the view.
     */
    private Set<ProductCategory> selectedFilters = new HashSet<ProductCategory>();
    
    /**
     * The sorting options available
     */
    private static List<Comparator<Product>> sortBy = new LinkedList<Comparator<Product>>();
    static{
        SearchResultsController.sortBy.add(new OrderProductsByNameAscending());
        SearchResultsController.sortBy.add(new OrderProductsByNameDescending());
        SearchResultsController.sortBy.add(new OrderProductsByPriceAscending());
        SearchResultsController.sortBy.add(new OrderProductsByPriceDescending());
    }
    
    /**
     * The search result view.
     */
    private SearchResultsView view;

    /**
     * Constructs a new search result controller for the provided view.
     * @param view 
     */
    public SearchResultsController(SearchResultsView view) {
        this.view = view;
        
        // Listen for searches.
        MainController.INSTANCE.addSearchListener(this);
    }

    /**
     * Updates the view's filters.
     * @param resultCategories 
     */
    private void updateViewFilters(Set<ProductCategory> resultCategories) {
        if (view != null) {
            view.setCategoryFilters(resultCategories);
        }
    }

    /**
     * Calls the view to update its display of result items to 
     * the provided products.
     * 
     * @param products 
     */
    private void updateViewResultList() {
        if (view != null) {
            view.setResultItems(productSearch.getResultProducts(selectedFilters));
        }
    }

    /**
     * Sets a product search to be displayed as the search results.
     * 
     * @param ps 
     */
    private void setProductSearch(SearchQuery ps) {
        productSearch = ps;
        selectedFilters = ps.getResultCategories();
        
        // Updates the result list of items
        updateViewResultList();

        // Set the category filter to all checked
        updateViewFilters(selectedFilters);

        // Set default sort by
        view.resetSortBy();

        // Set the search result header to the name of the search object.
        view.setHeader(ps.getName());
    }

    /**
     * This method is called when the sortBy field is changed
     */
    public void onSortByChanged() {
        if (view != null && sortBy != null && productSearch != null) {
            int selected = view.getSortBySelectedIndex();

            productSearch.setSortBy(sortBy.get(selected));
            updateViewResultList();
        }
    }

    /**
     * Called when a checkbox is selected or deselected. Updates the filters
     * and redraws the result items with the new filter
     * 
     * @param productCategory
     * @param selected 
     */
    void onFilterChanged(ProductCategory productCategory, boolean selected) {
        boolean changed;
        if (selected) {
            changed = selectedFilters.add(productCategory);
        } else {
            changed = selectedFilters.remove(productCategory);
        }

        if (changed) {
            updateViewResultList();
        }
    }
    
    /**
     * Called when a search is performed.
     * @param ps 
     */
    public void onSearch(SearchQuery ps) {
        setProductSearch(ps);
    }
}
