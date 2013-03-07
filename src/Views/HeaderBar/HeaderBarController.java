package Views.HeaderBar;

import Main.MainController;
import Search.SearchQuery;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import navigation.NavigationEvent;
import navigation.NavigationListener;
import navigation.NavigationSearchEvent;

/**
 * Controller for the HeaderBar view
 * 
 * @author Peter
 */
public class HeaderBarController implements NavigationListener {

    /**
     * Placeholder for the search bar.
     */
    public static final String SEARCH_PLACEHOLDER_TEXT = "Sök efter en vara...";
    /**
     * The view
     */
    private HeaderBarView view;

    public HeaderBarController(HeaderBarView view) {
        this.view = view;
        MainController.INSTANCE.addNavigationListener(this);
    }

    /**
     * Performs a new search from the content of the search bar.
     */
    private void doSearch() {
        String searchString = view.getSearchText();

        if (searchString.isEmpty() || searchString.equals(
                HeaderBarController.SEARCH_PLACEHOLDER_TEXT)) {
            System.out.println("Not Searching: Search string is "
                    + "empty or placeholder default.");
            return;
        }

        SearchQuery searchQuery = new SearchQuery(searchString, null, null);

        MainController.INSTANCE.search(searchQuery);

    }

    /**
     * Called when the search field is focused.
     * Remove placeholder text if it is currently the text.
     * @param evt 
     */
    void onSearchFieldFocusGained(FocusEvent evt) {
        if (view.getSearchText().equals(HeaderBarController.SEARCH_PLACEHOLDER_TEXT)) {
            view.setSearchText("");
        }
    }

    /**
     * Called when the focus of the search text field is lost.
     * Sets the text to the placeholder text if the field is empty
     * @param evt 
     */
    void onSearchFieldFocusLost(FocusEvent evt) {
        if (view.getSearchText().isEmpty()) {
            view.setSearchText(HeaderBarController.SEARCH_PLACEHOLDER_TEXT);
        }
    }

    /**
     * When a key is typed in the search field.
     * @param evt 
     */
    void onSearchFieldKeyUp(KeyEvent evt) {
        // If enter is pressed do same as if search button was clicked
        /*if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        doSearch();
        }*/

        // Instant search!
        doSearch();
    }

    /**
     * Called when search button is clicked.
     * @param evt 
     */
    void onSearchButtonActionPerformed(ActionEvent evt) {
        doSearch();
    }

    public void onNavigate(NavigationEvent navEvent) {
        if (navEvent instanceof NavigationSearchEvent) {
            SearchQuery sq = ((NavigationSearchEvent) navEvent).getSearchQuery();
            if (!sq.getSearchString().equals(view.getSearchText())) {
                view.removeFocus();
                view.setSearchText(SEARCH_PLACEHOLDER_TEXT);
            }
        } else {
            view.removeFocus();
            view.setSearchText(SEARCH_PLACEHOLDER_TEXT);
        }
    }
}
