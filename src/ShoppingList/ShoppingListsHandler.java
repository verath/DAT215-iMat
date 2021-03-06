package ShoppingList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
     * Notifies all ShoppingListChangeListener about a list being added/removed
     * @param sq 
     */
    public void notifyChangeListeners() {
        for (ShoppingListChangeListener changeListener : changeListeners) {
            changeListener.onChange();
        }
    }

    /**
     * Adds a ShoppingListChangeListener to be notified when a list is added or
     * removed
     * @param changeListener 
     */
    public void addChangeListener(ShoppingListChangeListener changeListener) {
        changeListeners.add(changeListener);
    }

    /**
     * Removes a ShoppingListChangeListener.
     * @param changeListener 
     */
    public void removeChangeListener(ShoppingListChangeListener changeListener) {
        changeListeners.remove(changeListener);
    }
}
