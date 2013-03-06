package ShoppingList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Serializable class for holding lists. This is to enable
 * us to save the list of lists to a file.
 */
class ShoppingListsHolder implements Serializable {

    protected Set<ShoppingList> shoppingLists = new HashSet<ShoppingList>();
    /**
     * The file path where we are saving our object data.
     */
    protected static final String FILE_PATH = System.getProperty("user.home")
            + "/.dat215/imat/shoppinglists.data";

    /**
     * Loads the user's shoppingLists from file.
     */
    protected void load() {
        System.out.println("LoadShoppingLists, starting...");

        try {
            FileInputStream f = new FileInputStream(FILE_PATH);
            ObjectInputStream in = new ObjectInputStream(f);
            ShoppingListsHolder holder = (ShoppingListsHolder) in.readObject();
            this.shoppingLists = holder.shoppingLists;

            // Update the static numList of ShoppingList, as static
            // vars are not saved/loaded when serializing.
            ShoppingList.numLists = shoppingLists.size();
        } catch (InvalidClassException ex) {
            // We have a different version saved, just don't load it.
        } catch (IOException ex) {
            Logger.getLogger(ShoppingListsHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShoppingListsHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Saves the user's shoppingLists to file.
     */
    protected void save() {
        System.out.println("saveShoppingLists()");

        try {
            File f = new File(FILE_PATH);
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream out = new ObjectOutputStream(fo);
            out.writeObject(this);
        } catch (IOException ex) {
            Logger.getLogger(ShoppingListsHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}