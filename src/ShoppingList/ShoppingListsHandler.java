package ShoppingList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
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
    /** 
     * The ShoppingListsHolder holding our data so that it can be serialized.
     */
    private ShoppingListsHolder holder = new ShoppingListsHolder();
    /**
     * The file path where we are saving our object data.
     */
    public static final String FILE_PATH = System.getProperty("user.home")
            + "/.dat215/imat/shoppinglists.data";

    /**
     * Constructor, try to load data first time its used.
     */
    private ShoppingListsHandler() {
        load();
    }

    /**
     * Loads the user's shoppingLists from file.
     */
    public void load() {
        try {
            FileInputStream f = new FileInputStream(FILE_PATH);
            ObjectInputStream in = new ObjectInputStream(f);
            holder = (ShoppingListsHolder) in.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ShoppingListsHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShoppingListsHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Saves the user's shoppingLists to file.
     */
    public void save() {
        try {
            File f = new File(FILE_PATH);
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream out = new ObjectOutputStream(fo);
            out.writeObject(holder);
        } catch (IOException ex) {
            Logger.getLogger(ShoppingListsHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Removes a ShoppingList from the set of shopping lists.
     * 
     * @param sl The ShoppingList to remove
     * @return True if the list changed (ie. the list existed in the collection)
     */
    public boolean removeShoppingList(ShoppingList sl) {
        return holder.shoppingLists.remove(sl);
    }

    /**
     * Adds a ShoppingList to the set of shopping lists.
     * 
     * @param sl The ShoppingList to add.
     * @return True if the list changed (ie. the list existed in the collection)
     */
    public boolean addShoppingList(ShoppingList sl) {
        return holder.shoppingLists.add(sl);
    }

    /**
     * Getter for all the shopping lists.
     * @return 
     */
    public Set<ShoppingList> getShoppingLists() {
        return new HashSet<ShoppingList>(holder.shoppingLists);
    }

    /**
     * Inner Serializable class for holding lists. This is to enable
     * us to save the list of lists to a file.
     */
    private class ShoppingListsHolder implements Serializable {

        private Set<ShoppingList> shoppingLists;

        ShoppingListsHolder() {
            shoppingLists = new HashSet<ShoppingList>();
        }
    }
}
