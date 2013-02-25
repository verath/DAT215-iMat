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
    private boolean onlyFavourites;

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
            Set<ProductCategory> categoryFilter, boolean onlyFavourites) {
        // Null as search string is not accepted by the backend
        this.searchString = (searchString == null) ? "" : searchString;
        this.sortBy = sortBy;
        this.categoryFilter = categoryFilter;
        this.onlyFavourites = onlyFavourites;

        doSearch();
    }

    public ProductSearch(String searchString, Comparator<Product> sortBy,
            Set<ProductCategory> categoryFilter) {
        this(searchString, sortBy, categoryFilter, false);

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

    private List<Product> filterProductsFavourites(List<Product> products, boolean onlyFavourites) {
        if (!onlyFavourites) {
            return products;
        }

        List<Product> filteredProducts = new LinkedList<Product>();
        for (Product p : products) {
            if (IMatDataHandler.getInstance().isFavorite(p)) {
                filteredProducts.add(p);
            }
        }
        return filteredProducts;
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

        if (sortBy == this.sortBy) {
            // No point in sorting if already sorted.
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

        // If we only want favourites, filter them first
        searchResult = filterProductsFavourites(searchResult, onlyFavourites);

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
     * Sets the sorting option for the resulting products.
     * @param sortBy 
     */
    public void setSortBy(Comparator<Product> sortBy) {
        this.resultingProducts = sortProducts(resultingProducts, sortBy);
        this.sortBy = sortBy;
    }

    /**
     * Returns a List of Products that matched the search criteria.
     * 
     * @return The Products matching the search query.
     */
    public List<Product> getResultProducts() {
        return this.resultingProducts;
    }

    /**
     * Returns a List of Products that matched the search criteria and 
     * is contained in the provided filter.
     * 
     * @return The Products matching the search query.
     */
    public List<Product> getResultProducts(Set<ProductCategory> filter) {
        return filterProductsByCategory(resultingProducts, filter);
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
    
    /**
     * Getter for the onlyFavourites.
     * 
     * @return
     */
    public boolean getOnlyFavourites(){
        return this.onlyFavourites;
    }
}
