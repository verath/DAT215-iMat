package ShoppingList;

import java.io.Serializable;
import se.chalmers.ait.dat215.project.Product;

/**
 * A class representing a shopping list item.
 * 
 * A shopping list item is essentially a wrapper around a 
 * ShoppingItem, but is also Serializable so it can be stored
 * to file.
 * 
 * @author Peter
 */
public class ShoppingListItem implements Serializable {

    private Product product;
    private double amount;

    /**
     * Creates a ShopingListItem from the provided Product and amount 1.
     * @param product 
     */
    public ShoppingListItem(Product product) {
        this(product, 1);
    }

    /**
     * Creates a ShoppingListItem from the provided Product and amount.
     *
     * @param product
     * @param amount 
     */
    public ShoppingListItem(Product product, double amount) {
        this.product = product;
        this.amount = amount;
    }

    /**
     * Getter for the amount.
     * @return 
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Setter for the amount.
     * @param amount 
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Getter for the Product
     * @return 
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Setter for the Product
     * @param product 
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Returns the total value of this Item.
     * @return 
     */
    public double getTotal() {
        return amount * product.getPrice();
    }
    
    /**
     * Adds to the amount.
     * @param amount 
     */
    void addAmount(double amount) {
        this.amount += amount;
    }

    @Override
    /**
     * Equals method, only compares by Product as we don't want multiple
     * items for the same Product if they only differ in amount.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ShoppingListItem other = (ShoppingListItem) obj;
        if (this.product != other.product && (this.product == null || !this.product.equals(other.product))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.product != null ? this.product.hashCode() : 0);
        return hash;
    }
}
