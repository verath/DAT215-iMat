/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.ShoppingCart;

import Main.ShoppingCartWrapper;
import java.awt.event.ActionEvent;
import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.ShoppingCartListener;

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
        
        ShoppingCartWrapper.INSTANCE.addShoppingCartListener(this);
        
        // On first load, update items in cart
        view.setItemsInCart(ShoppingCartWrapper.INSTANCE.getItems());
    }
    
    
    public void onCheckoutButtonActionPerformed(ActionEvent evt) {
        // TODO: Implement real behaviour
        /*IMatDataHandler dh = IMatDataHandler.getInstance();
        ShoppingCartWrapper cart = ShoppingCartWrapper.INSTANCE;

        cart.addProduct(dh.getProduct(1), 20);*/
    }

    /**
     * Called when an item in the shoppingCart is somehow changed.
     * @param ce 
     */
    public void shoppingCartChanged(CartEvent ce) {
        view.setItemsInCart(ShoppingCartWrapper.INSTANCE.getItems());
    }
}
