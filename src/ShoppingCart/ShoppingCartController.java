/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCart;

import Main.ShoppingCartWrapper;
import java.awt.event.ActionEvent;
import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingCartListener;

/**
 * Controller for the ShoppingCartView
 * @author Peter
 */
public class ShoppingCartController implements ShoppingCartListener {
    private ShoppingCartView view;
    //private ShoppingCartWrapper cartModel;

    public ShoppingCartController(ShoppingCartView view) {
        this.view = view;
        
        ShoppingCartWrapper.INSTANCE.addShoppingCartListener(this);
    }
    
    public void onViewLoaded(){
        view.setItemsInCart(ShoppingCartWrapper.INSTANCE.getItems());
    }
    
    
    public void onCheckoutButtonActionPerformed(ActionEvent evt) {
        // TODO: Implement real behaviour
        IMatDataHandler dh = IMatDataHandler.getInstance();
        ShoppingCartWrapper cart = ShoppingCartWrapper.INSTANCE;

        cart.addProduct(dh.getProduct(1), 20);
    }

    public void shoppingCartChanged(CartEvent ce) {
        view.setItemsInCart(ShoppingCartWrapper.INSTANCE.getItems());
    }
}
