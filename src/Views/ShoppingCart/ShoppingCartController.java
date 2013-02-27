package Views.ShoppingCart;

import Main.ShoppingCartWrapper;
import ShoppingList.ShoppingList;
import ShoppingList.ShoppingListItem;
import ShoppingList.ShoppingListsHandler;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 * Controller for the ShoppingCartView
 * 
 * @author Peter
 */
public class ShoppingCartController implements ShoppingCartListener {

    private ShoppingCartView view;

    /**
     * Creates a new ShoppingCartController for the provided view
     *
     * @param view 
     */
    public ShoppingCartController(ShoppingCartView view) {
        this.view = view;

        // Make sure we are listening for events that change the shopping cart
        ShoppingCartWrapper.INSTANCE.addShoppingCartListener(this);

        // On first load, update items in cart
        view.setItemsInCart(ShoppingCartWrapper.INSTANCE.getItems());
    }

    /**
     * Called when an item in the shoppingCart is somehow changed.
     * Simply redraw our ShoppingCart when this happens.
     * @param ce 
     */
    public void shoppingCartChanged(CartEvent ce) {
        view.setItemsInCart(ShoppingCartWrapper.INSTANCE.getItems());
    }

    /**
     * Called when the checkout button is clicked.
     * @param evt 
     */
    public void onCheckoutButtonActionPerformed(ActionEvent evt) {
        // TODO: Implement real behaviour
    }

    /**
     * Called when the Save button is clicked.
     * Ask the user for a name and save the current ShoppingCart as a new
     * ShoppingList.
     * @param evt 
     */
    void onSaveCartButtonActionPerformed(ActionEvent evt) {
        String listName = (String) JOptionPane.showInputDialog("Ange namn som listan ska sparas som:");
        ShoppingList list = new ShoppingList(listName);

        // Add all items to our ShoppingList
        for (ShoppingItem si : ShoppingCartWrapper.INSTANCE.getItems()) {
            list.addItem(new ShoppingListItem(si));
        }

        // Add the ShoppingList itself to the ShoppingListHandler
        ShoppingListsHandler.INSTANCE.addShoppingList(list);
    }
}
