/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HeaderBar;

import ProductSearch.ProductSearch;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;

/**
 * Controller for the HeaderBar view
 * @author Peter
 */
public class HeaderBarController {

    public static final String SEARCH_PLACEHOLDER_TEXT = "Sök efter en vara...";
    private HeaderBar view;

    public HeaderBarController(HeaderBar view) {
        this.view = view;
    }

    private void doSearch() {
        // TODO: Only dummy behaviour so far.
        String searchString = view.getSearchText();

        if (searchString.isEmpty() || searchString.equals(HeaderBarController.SEARCH_PLACEHOLDER_TEXT)) {
            System.out.println("Not Searching: Search string is empty or placeholder default.");
            return;
        }

        System.out.println("Searching");
        System.out.println("Search string: " + view.getSearchText());
        
        ProductSearch ps = new ProductSearch(searchString, null, null);
        
        System.out.println();
        System.out.print("Categories: ");
        for( ProductCategory pc : ps.getResultCategories()){
            System.out.print(pc.toString() + " ");
        }
        
        System.out.println();
        List<Product> resultProds = ps.getResultProducts();
        System.out.print(resultProds.size() + " results; \n");
        for( int i = 0; i <  resultProds.size(); i ++){
            System.out.print("#" + (i+1) + "\t");
            System.out.print(resultProds.get(i).getName());
            System.out.print(" ");
            System.out.println(resultProds.get(i).getCategory());
        }

    }

    void onSearchFieldFocusGained(FocusEvent evt) {
        if (view.getSearchText().equals(HeaderBarController.SEARCH_PLACEHOLDER_TEXT)) {
            view.setSearchText("");
        }
    }

    void onSearchFieldFocusLost(FocusEvent evt) {
        if (view.getSearchText().isEmpty()) {
            view.setSearchText(HeaderBarController.SEARCH_PLACEHOLDER_TEXT);
        }
    }

    void onSearchFieldKeyUp(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // If enter is pressed do same as if search button was clicked
            doSearch();
        }
    }

    void SearchButtonActionPerformed(ActionEvent evt) {
        doSearch();
    }
}
