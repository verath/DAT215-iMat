package ShoppingList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A singelton class for handling the shopping lists of the user. 
 * Provides access to all the user's shopping lists, and also handles
 * saving and loading shopping lists to/from file.
 * 
 * @author Peter
 */
public enum ShoppingListsHandler {

    /**
     * The ShoppingListsHandler instance.
     */
    INSTANCE;
    
    private ShoppingListsHandler() {
        load();
    }
    /** 
     * The ShoppingListsHolder holding our data so that it can be serialized.
     */
    private ShoppingListsHolder holder = new ShoppingListsHolder();
    /**
     * Listeners for shoppingListChanges
     */
    private List<ShoppingListChangeListener> changeListeners = new LinkedList<ShoppingListChangeListener>();

    /**
     * Loads list from file.
     */
    public void load() {
        holder.load();
    }

    /**
     * Saves lists to file.
     */
    public void save() {
        holder.save();
    }

    /**
     * Removes a ShoppingList from the set of shopping lists.
     * 
     * @param sl The ShoppingList to remove
     * @return True if the list changed (ie. the list existed in the collection)
     */
    public boolean removeShoppingList(ShoppingList sl) {
        boolean change = holder.shoppingLists.remove(sl);
        if (change) {
            notifyChangeListeners();
        }
        return change;
    }

    /**
     * Adds a ShoppingList to the set of shopping lists.
     * 
     * @param sl The ShoppingList to add.
     * @return True if the list changed (ie. the list existed in the collection)
     */
    public boolean addShoppingList(ShoppingList sl) {
        boolean change = holder.shoppingLists.add(sl);
        if (change) {
            notifyChangeListeners();
        }
        return change;
    }

    /**
     * Getter for all the shopping lists.
     * @return A shallow-copied list of the ShoppingLists
     */
    public Set<ShoppingList> getShoppingLists() {
        return new HashSet<ShoppingList>(holder.shoppingLists);        
    }

    /**
     * Notifies all navigation listeners about a navigation in the UI
     * @param sq 
     */
    public void notifyChangeListeners() {
        for (ShoppingListChangeListener changeListener : changeListeners) {
            changeListener.onChange();
        }
    }

    /**
     * Adds a NavigationListner to be notified when a navigation in
     * the UI is performed.
     * @param navigationListener 
     */
    public void addChangeListener(ShoppingListChangeListener changeListener) {
        changeListeners.add(changeListener);
    }

    /**
     * Removes a NavigationListener.
     * @param navigationListener 
     */
    public void removeChangeListener(ShoppingListChangeListener changeListener) {
        changeListeners.remove(changeListener);
    }
}
