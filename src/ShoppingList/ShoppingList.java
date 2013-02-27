package ShoppingList;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Shopping list object, holding one or more ShoppingListItems.
 * A ShoppingList can not contain multiple Items with the 
 * same product.
 * 
 * @author Peter
 */
public class ShoppingList implements Serializable {

    /**
     * A static counter used for generating default names.
     */
    private static int numLists = 0;
    /**
     * The Items in this list.
     */
    private Set<ShoppingListItem> items;
    /**
     *  The list's name.
     */
    private String name;

    /**
     * Creates a new ShoppingList with a specified name.
     * If the name is null or empty, a default name is generated.
     * @param name 
     */
    public ShoppingList(String name) {
        ShoppingList.numLists += 1;

        if (name == null || name.isEmpty()) {
            name = "Lista " + ShoppingList.numLists;
        }

        this.name = name;
        items = new HashSet<ShoppingListItem>();
    }

    /**
     * Attempts to add a ShoppingListItem, or if an item for the 
     * Product already exists, adds to that amount instead.
     * 
     * @param item 
     */
    public void addItem(ShoppingListItem item) {
        if (!items.contains(item)) {
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

    /**
     * Getter for the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name.
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
}
