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

    private List<Product> resultingProducts;
    private Set<ProductCategory> resultCategories;
    private String searchString;
    private Comparator<Product> sortBy;
    private Set<ProductCategory> categoryFilter;

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
    private List<Product> sortProductsBy(List<Product> products,
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
    private Set<ProductCategory> getCategoriesFromProductList(List<Product> products) {
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
        searchResult = sortProductsBy(searchResult, this.sortBy);

        // Get the categories contained in the result
        this.resultCategories = getCategoriesFromProductList(searchResult);

        // Save the list of results
        this.resultingProducts = searchResult;

    }

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
     *            An optional ProductCategory that, if present, will only
     *            display results in this category. If null, the result will not
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
     * 
     *
     */
    public List<Product> getSearchResult() {
        return this.resultingProducts;
    }

    /**
     * Returns the categories represented in the search result.
     *
     */
    public Set<ProductCategory> getSearchCategories() {
        return this.resultCategories;
    }
}
