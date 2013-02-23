/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCart;

import Main.ShoppingCartWrapper;
import java.awt.event.ActionEvent;
import java.util.List;
import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

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
        
    }
    
    
    public void onCheckoutButtonActionPerformed(ActionEvent evt) {
        // TODO: Implement real behaviour
        IMatDataHandler dh = IMatDataHandler.getInstance();
        ShoppingCartWrapper cart = ShoppingCartWrapper.INSTANCE;

        cart.addProduct(dh.getProduct(1), 20);
    }

    public void shoppingCartChanged(CartEvent ce) {
        List<ShoppingItem> items = ShoppingCartWrapper.INSTANCE.getItems();
        
        System.out.println("Cart Changed, current items:");
        for( ShoppingItem i : items ){
            System.out.println("\t" + i.getProduct().getName() + " " + i.getAmount());
        }
    }
}
