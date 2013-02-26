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
    private ShoppingListsHolder holder = null;
    /**
     * The file path where we are saving our object data.
     */
    public static final String FILE_PATH = System.getProperty("user.home")
            + "/.dat215/imat/shoppinglists.data";

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
        if (holder == null) {
            // If we haven't got anything to save, no point in saving.
            return;
        }

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
     * Gets all the shopping lists.
     * @return 
     */
    public Set<ShoppingList> getShoppingLists() {
        if (holder != null) {
            return holder.shoppingLists;
        } else {
            return null;
        }
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
