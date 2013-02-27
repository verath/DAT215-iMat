/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import navigation.NavigationListener;
import navigation.NavigationEvent;
import Search.SearchQuery;
import java.util.ArrayList;
import java.util.List;
import navigation.NavigationSearchEvent;

/**
 * A singelton class for handling the major tasks in the UI on a high level,
 * such as performing a search or showing the main view.
 * 
 * @author Peter
 */
public enum MainController {

    /**
     * The MainController instance.
     */
    INSTANCE;
    /**
     * The NavigationListeners that is listening to the controllers events.
     */
    private List<NavigationListener> navigationListeners = new ArrayList<NavigationListener>();

    /**
     * Performs a search by displaying the search results panels.
     * 
     * @param sq 
     */
    public void search(SearchQuery sq) {
        notifyNavigationListeners(new NavigationSearchEvent(sq));
    }

    /**
     * Notifies all navigation listeners about a navigation in the UI
     * @param sq 
     */
    public void notifyNavigationListeners(NavigationEvent navigationEvent) {
        if (navigationEvent != null) {
            for (NavigationListener sl : navigationListeners) {
                sl.onNavigate(navigationEvent);
            }
        }
    }

    /**
     * Adds a NavigationListner to be notified when a navigation in
     * the UI is performed.
     * @param navigationListener 
     */
    public void addNavigationListener(NavigationListener navigationListener) {
        navigationListeners.add(navigationListener);
    }

    /**
     * Removes a NavigationListener.
     * @param navigationListener 
     */
    public void removeNavigationListener(NavigationListener navigationListener) {
        navigationListeners.remove(navigationListener);
    }
}
