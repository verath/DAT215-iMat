package Main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 * A singleton wrapper class for the provided shopping cart. Handles
 * things such as merging duplicate entries to one.
 * @author Peter
 */
public enum ShoppingCartWrapper {

    /**
     * The ShoppingCartWrapper instance.
     */
    INSTANCE;
    /**
     * Our internal instance of the ShoppingCart backend
     */
    private ShoppingCart shoppingCart = IMatDataHandler.getInstance().getShoppingCart();
    
    /**
     * Returns the shoppingItem for a Product. There _SHOULD_ only be one
     * ShoppingItem per product if this adapter is used everywhere.
     * @param p The Product to find
     * @return The ShoppingItem for the product, or null if it couldn't be found.
     */
    private ShoppingItem getItemByProduct(Product p) {
        for (ShoppingItem si : shoppingCart.getItems()) {
            if (si.getProduct().equals(p)) {
                return si;
            }
        }
        return null;
    }

    /**
     * Updates a product already in the cart to a new amount.
     * @param p A Product in the shoppingCart.
     * @param amount The new amount for this Product.
     */
    public void updateProduct(Product p, double amount) {
        // Get the ShoppingItem from our ShoppingCart backend
        ShoppingItem si = getItemByProduct(p);

        if (si == null) {
            // Item didn't exist, add it instead
            addProduct(p, amount);
        } else if(amount <= 0){
            // If 0 or less amount, remove product
            removeProduct(p);
        } else {
            // Update to new amount
            si.setAmount(amount);
            fireShoppingCartChanged(si, false);
        }
    }

    /**
     * Removes a product from the shoppingCart.
     * @param product 
     */
    public void removeProduct(Product p) {
        ShoppingItem si = getItemByProduct(p);
        shoppingCart.removeItem(si);
        fireShoppingCartChanged(si, false);
    }

    /**
     * Adds a specified amount of Product to the shopping cart. If the Product
     * is already in the cart, the amount will instead be added to the current
     * amount of the Product.
     * @param p
     * @param amount 
     */
    public void addProduct(Product p, double amount) {
        // If the item exists already, update it instead
        ShoppingItem si = getItemByProduct(p);
        if (si != null) {
            amount += si.getAmount();
            updateProduct(p, amount);
        } else {
            si = new ShoppingItem(p, amount);
            shoppingCart.addItem(si);
            fireShoppingCartChanged(si, true);
        }
    }

    /**
     * Removes all Products in the shopping cart.
     */
    public void clear() {
        shoppingCart.clear();
    }

    public List<ShoppingItem> getItems() {
        List<ShoppingItem> items = new LinkedList<ShoppingItem>(shoppingCart.getItems());
        return items;
    }

    /**
     * Returns the value of all the products currently in the shoppingcart.
     * @return The total value of the products in the cart.
     */
    public double getTotal() {
        return shoppingCart.getTotal();
    }

    /**
     * Returns the number of ShoppingItems in the shopping cart
     * @return 
     */
    public int getNumItems() {
        return shoppingCart.getItems().size();
    }

    /**
     * Adds a shoppingcart listener.
     * @param scl 
     */
    public void addShoppingCartListener(ShoppingCartListener scl) {
        shoppingCart.addShoppingCartListener(scl);
    }

    /**
     * Removes a shoppingcart listener.
     * @param scl
     */
    public void removeShoppingCartListener(ShoppingCartListener scl) {
        shoppingCart.removeShoppingCartListener(scl);
    }
    
    /**
     * Notifies shopping cart listeners that the shopping cart has changed.
     * @param item
     * @param addEvent 
     */
    private void fireShoppingCartChanged(ShoppingItem item, boolean addEvent) {
        shoppingCart.fireShoppingCartChanged(item, addEvent);
    }
}
