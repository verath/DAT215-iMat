package ProductSearch;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.util.*;

/**
 * An object representing a search towards the IMatDataHandler backend.
 * 
 * @author Peter
 * 
 */
public class ProductSearch {

    // These contain results, or info about results
    private List<Product> resultingProducts;
    private Set<ProductCategory> resultCategories;
    // The Search query parameters
    private String searchString;
    private Comparator<Product> sortBy;
    private Set<ProductCategory> categoryFilter;

    /**
     * Constructs a new search towards the IMatDataHandler backend.
     * 
     * @param searchString
     *            A case-insensitive search substring matched against names of
     *            the products.
     * @param sortBy
     *            An optional Comparator used for sorting the results. If null,
     *            the product list's default order will be preserved.
     * @param categoryFilter
     *            An optional set of ProductCategorys that, if present, will only
     *            display results in these categories. If null, the result will not
     *            be filtered by a category.
     */
    public ProductSearch(String searchString, Comparator<Product> sortBy,
            Set<ProductCategory> categoryFilter) {
        // Null as search string is not accepted by the backend
        this.searchString = (searchString == null) ? "" : searchString;
        this.sortBy = sortBy;
        this.categoryFilter = categoryFilter;

        doSearch();
    }

    /**
     * Filters a list of products to include only those with a 
     * ProductCategory in the provided ProductCategorySet.
     * 
     * @param products 
     * @param filter
     * @return
     */
    private List<Product> filterProductsByCategory(List<Product> products,
            Set<ProductCategory> filter) {
        if (filter == null) {
            return products;
        } else {
            List<Product> filteredProducts = new LinkedList<Product>();
            for (Product p : products) {
                if (filter.contains(p.getCategory())) {
                    filteredProducts.add(p);
                }
            }
            return filteredProducts;
        }
    }

    /**
     * Sorts a list of products by the provided Comperator.
     * 
     * @param products
     * @param sortBy
     * @return
     */
    private List<Product> sortProducts(List<Product> products,
            Comparator<Product> sortBy) {

        if (sortBy == null) {
            return products;
        }

        // No point in sorting less than two elements
        if (products == null || products.size() < 2) {
            return products;
        }

        Collections.sort(products, sortBy);

        return products;
    }

    /**
     * Takes a list of products and returns the different categories.
     * @param products
     * @return a list of ProductCategorys contained in a list of products.
     */
    private Set<ProductCategory> getCategoriesFromProducts(List<Product> products) {
        Set<ProductCategory> categories = new HashSet<ProductCategory>();
        for (Product p : products) {
            categories.add(p.getCategory());
        }
        return categories;
    }

    /**
     * Performs a search and saves the result.
     */
    private void doSearch() {
        IMatDataHandler dh = IMatDataHandler.getInstance();

        // Free text search
        List<Product> searchResult = dh.findProducts(this.searchString);

        // Filter by category
        searchResult = filterProductsByCategory(searchResult,
                this.categoryFilter);

        // Sort results
        searchResult = sortProducts(searchResult, this.sortBy);

        // Get the categories contained in the result
        this.resultCategories = getCategoriesFromProducts(searchResult);

        // Save the list of results
        this.resultingProducts = searchResult;

    }

    /**
     * Returns a List of Products that matched the search criteria.
     * @return The Products matching the search query.
     */
    public List<Product> getResultProducts() {
        return this.resultingProducts;
    }

    /**
     * Returns the Set of categories which the resulting Products were 
     * contained in
     * @return The ProductCategories represented in the search result.
     */
    public Set<ProductCategory> getResultCategories() {
        return this.resultCategories;
    }

    /**
     * Getter for the category filter used for this search.
     * @return The Set of ProductCategory used for the search query. 
     * Can be null.
     */
    public Set<ProductCategory> getCategoryFilter() {
        return categoryFilter;
    }

    /**
     * Getter for the free-text search string used for this search.
     * @return The search string used in the search query. Can be empty
     * but is never null.
     */
    public String getSearchString() {
        return searchString;
    }

    /**
     * Getter for the sort Comperator used.
     * @return The Comperator<Product> used in the search query 
     * for ordering the results. Can be null.
     */
    public Comparator<Product> getSortBy() {
        return sortBy;
    }
    
}
