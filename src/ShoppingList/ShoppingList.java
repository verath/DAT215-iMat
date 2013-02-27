package ShoppingList;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Shopping list object, holding one or more ShoppingListItems.
 * A ShoppingList can, however, not contain multiple Items with the 
 * same product.
 * 
 * @author Peter
 */
public class ShoppingList implements Serializable {

    Set<ShoppingListItem> items;

    ShoppingList() {
        items = new HashSet<ShoppingListItem>();
    }

    /**
     * Attempts to add a ShoppingListItem, or if an item for the 
     * Product already exists, adds to that amount instead.
     * 
     * @param item 
     */
    public void addItem(ShoppingListItem item) {
        if (items.contains(item)) {
            items.add(item);
        } else {
            for (ShoppingListItem si : items) {
                if (si.equals(item)) {
                    si.addAmount(item.getAmount());
                    break;
                }
            }
        }
    }

    /**
     * Removes an item from the shopping list.
     * @param item
     * @return True if the element existed in the list.
     */
    public boolean removeItem(ShoppingListItem item) {
        return items.remove(item);
    }

    /**
     * Returns the Set of ShoppingItems in this ShoppingList.
     * @return A shallow-copied Set of ShoppingItem.
     */
    public Set<ShoppingListItem> getItems() {
        return new HashSet<ShoppingListItem>(items);
    }
}
