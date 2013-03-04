package Views.ShoppingCart;

import Main.MainController;
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

        // On first load, update items in cart
        view.setItemsInCart(ShoppingCartWrapper.INSTANCE.getItems());
    }

    public void listenForShoppingEvents() {
        ShoppingCartWrapper.INSTANCE.addShoppingCartListener(this);
    }

    /**
     * Called when an item in the shoppingCart is somehow changed.
     * If there was a new item added, redraw our shopping cart.
     * @param ce 
     */
    public void shoppingCartChanged(CartEvent ce) {
        if (ce.isAddEvent()) {
            view.setItemsInCart(ShoppingCartWrapper.INSTANCE.getItems());
        } else {
            view.shoppingCartItemUpdated(ce.getShoppingItem());
        }
    }

    /**
     * Called when the checkout button is clicked.
     * @param evt 
     */
    public void onCheckoutButtonActionPerformed(ActionEvent evt) {
        MainController.INSTANCE.showCheckout();
    }

    /**
     * Called when the Save button is clicked.
     * Ask the user for a name and save the current ShoppingCart as a new
     * ShoppingList.
     * @param evt 
     */
    void onSaveCartButtonActionPerformed(ActionEvent evt) {
        String listName = (String) JOptionPane.showInputDialog("Ange namn som listan ska sparas som:");
        if (listName == null) {
            // user clicked cancel.
            return;
        }
        if(ShoppingCartWrapper.INSTANCE.getItems().isEmpty()) {
            // If the shoppingCart is empty.
            return;
        }
        ShoppingList list = new ShoppingList(listName);

        // Add all items to our ShoppingList
        for (ShoppingItem si : ShoppingCartWrapper.INSTANCE.getItems()) {
            list.addItem(new ShoppingListItem(si));
        }

        // Add the ShoppingList itself to the ShoppingListHandler
        ShoppingListsHandler.INSTANCE.addShoppingList(list);
    }
}
