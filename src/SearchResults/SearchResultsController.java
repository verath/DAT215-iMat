package SearchResults;

import Main.LocaleHandler;
import ProductSearch.OrderProductsByNameAscending;
import ProductSearch.OrderProductsByNameDescending;
import ProductSearch.OrderProductsByPriceAscending;
import ProductSearch.OrderProductsByPriceDescending;
import ProductSearch.ProductSearch;
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
public enum SearchResultsController {

    INSTANCE;
    private ProductSearch productSearch;
    private Set<ProductCategory> selectedFilters = new HashSet<ProductCategory>();
    private List<Comparator<Product>> sortBy = new LinkedList<Comparator<Product>>();
    public final Comparator<Product> defaultSort = new OrderProductsByNameDescending();
    private SearchResultsView view;

    private SearchResultsController() {
        sortBy.add(new OrderProductsByNameAscending());
        sortBy.add(new OrderProductsByNameDescending());
        sortBy.add(new OrderProductsByPriceAscending());
        sortBy.add(new OrderProductsByPriceDescending());
    }

    public void setSearchResultsView(SearchResultsView view) {
        this.view = view;
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
    public void setProductSearch(ProductSearch ps) {
        productSearch = ps;
        selectedFilters = ps.getResultCategories();

        updateViewResultList();

        // Update our view's result list
        updateViewFilters(selectedFilters);

        view.resetSortBy();

        if (ps.getSearchString().isEmpty() && !ps.getCategoryFilter().isEmpty()) {
            // If we have an empty search and a category filter, we are browsing
            // categories
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (ProductCategory pc : ps.getCategoryFilter()) {
                if (first) {
                    sb.append(LocaleHandler.INSTANCE.getProductCategoryName(pc));
                } else {
                    sb.append(", ").append(LocaleHandler.INSTANCE.getProductCategoryName(pc));
                }
            }
            view.setHeader(String.format("Varor från: %s", sb.toString()));
        } else {
            view.setHeader(String.format("Sökresultat för: \"%s\"", ps.getSearchString()));
        }
    }

    /**
     * This methoiod is called when the sortBy field is changed
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
}
