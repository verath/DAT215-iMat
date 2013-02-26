package ShoppingList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A singelton class for handling the shopping lists of the user. 
 * Provides access to all the user's shopping lists, and also handles
 * saving and loading shopping lists to/from a file.
 * @author Peter
 */
public enum ShoppingListsHandler {

    /**
     * The ShoppingListsHandler instance.
     */
    INSTANCE;
    private ShoppingListsHolder shoppingListHolder = null;
    public static final String FILE_PATH = System.getProperty("user.home") + "/.dat215/imat/shoppinglists.data";

    /**
     * Loads the user's shoppingLists from file.
     */
    public void load() {
        try {
            FileInputStream f = new FileInputStream(FILE_PATH);
            ObjectInputStream in = new ObjectInputStream(f);
            shoppingListHolder = (ShoppingListsHolder) in.readObject();
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
        if (shoppingListHolder == null) {
            return;
        }
        
        try {
            File f = new File(FILE_PATH);
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream out = new ObjectOutputStream(fo);
            out.writeObject(shoppingListHolder);
        } catch (IOException ex) {
            Logger.getLogger(ShoppingListsHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Inner Serializable class for holding lists. This is to enable
     * us to save the list of lists to a file.
     */
    private class ShoppingListsHolder implements Serializable {

        protected List<ShoppingList> shoppingLists;

        ShoppingListsHolder() {
            shoppingLists = new LinkedList<ShoppingList>();
        }
    }
}
