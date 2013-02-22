/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCart;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author Peter
 */
public class ShoppingCartWrapper {

    /**
     * Takes a list of ShoppingItem and combines all duplicate
     * @param items
     * @return 
     */
    public static List<ShoppingItem> combineIdenticalCartItems(List<ShoppingItem> items) {
        Map<Product, Double> productMap = new HashMap<Product, Double>();

        for (ShoppingItem si : items) {
            Product prod = si.getProduct();
            double amount = si.getAmount();

            if (productMap.containsKey(prod)) {
                amount += productMap.get(prod);
            }

            productMap.put(prod, amount);
        }

        List<ShoppingItem> combinedProducts = new LinkedList<ShoppingItem>();
        for (Product p : productMap.keySet()) {
            combinedProducts.add(new ShoppingItem(p, productMap.get(p)));
        }

        return combinedProducts;
    }
}
