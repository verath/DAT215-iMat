package Search;

import Main.LocaleHandler;
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
public class SearchQuery {

    /**
     * The products returned when the query was run towards the backend
     */
    private List<Product> resultingProducts;
    /**
     * The categories that the resulting products were contained in
     */
    private Set<ProductCategory> resultCategories;
    /**
     * The free-text search string
     */
    private String searchString;
    /**
     * The comparator used to order the results
     */
    private Comparator<Product> sortBy;
    /**
     * A "white list" filter of ProductCategories applied to the result.
     */
    private Set<ProductCategory> categoryFilter;
    /**
     * Whether or not the result only should contain favorites.
     */
    private boolean onlyFavorites;
    /**
     * The (optional) name of this SearchQuery
     */
    private String name;

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
     * @param onlyFavorites If this search should return only favorites.
     * @param name Name of the search.
     */
    public SearchQuery(String searchString, Comparator<Product> sortBy,
            Set<ProductCategory> categoryFilter, boolean onlyFavorites, String name) {
        // Null as search string is not accepted by the backend
        this.searchString = (searchString == null) ? "" : searchString;
        this.sortBy = sortBy;
        this.categoryFilter = categoryFilter;
        this.onlyFavorites = onlyFavorites;
        this.name = name;

        doSearch();
    }

    public SearchQuery(String searchString, Comparator<Product> sortBy,
            Set<ProductCategory> categoryFilter, boolean onlyFavorites) {
        this(searchString, sortBy, categoryFilter, onlyFavorites, null);
    }

    public SearchQuery(String searchString, Comparator<Product> sortBy,
            Set<ProductCategory> categoryFilter) {
        this(searchString, sortBy, categoryFilter, false, null);

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
     * Filters a list of Products, excluding all but favorites if the 
     * onlyFavorites parameter is true.
     * @param products
     * @param onlyFavourites
     * @return 
     */
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
        searchResult = filterProductsFavourites(searchResult, onlyFavorites);

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
    public boolean getOnlyFavorites() {
        return this.onlyFavorites;
    }

    /**
     * Getter for the optional name of the search
     */
    public String getName() {
        if (name != null) {
            return name;
        } else if (onlyFavorites) {
            return "Dina favoriter";
        } else if (searchString.isEmpty() && categoryFilter != null) {
            // If we have an empty search and a category filter, we are browsing
            // categories
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (ProductCategory pc : categoryFilter) {
                if (first) {
                    sb.append(LocaleHandler.INSTANCE.getProductCategoryName(pc));
                } else {
                    sb.append(", ").append(LocaleHandler.INSTANCE.getProductCategoryName(pc));
                }
            }
            return String.format("Varor från: %s", sb.toString());
        } else {
            return String.format("Sökresultat för: \"%s\"", searchString);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Equals for the SearchQuery. Only look at the input parameters, as the 
     * results are not part of this object and doesn't make sense to compare.
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SearchQuery other = (SearchQuery) obj;
        if ((this.searchString == null) ? (other.searchString != null) : !this.searchString.equals(other.searchString)) {
            return false;
        }
        if (this.categoryFilter != other.categoryFilter && (this.categoryFilter == null || !this.categoryFilter.equals(other.categoryFilter))) {
            return false;
        }
        if (this.onlyFavorites != other.onlyFavorites) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.searchString != null ? this.searchString.hashCode() : 0);
        hash = 79 * hash + (this.categoryFilter != null ? this.categoryFilter.hashCode() : 0);
        hash = 79 * hash + (this.onlyFavorites ? 1 : 0);
        return hash;
    }
}
