/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HeaderBar;

import Main.MainController;
import ProductSearch.ProductSearch;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;

/**
 * Controller for the HeaderBar view
 * @author Peter
 */
public class HeaderBarController {

    public static final String SEARCH_PLACEHOLDER_TEXT = "Sök efter en vara...";
    private HeaderBarView view;

    public HeaderBarController(HeaderBarView view) {
        this.view = view;
    }

    private void doSearch() {
        String searchString = view.getSearchText();

        if (searchString.isEmpty() || searchString.equals(HeaderBarController.SEARCH_PLACEHOLDER_TEXT)) {
            System.out.println("Not Searching: Search string is empty or placeholder default.");
            return;
        }
        
        ProductSearch ps = new ProductSearch(searchString, null, null);
        
        MainController.INSTANCE.search(ps);

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

    void onSearchButtonActionPerformed(ActionEvent evt) {
        doSearch();
    }
}
