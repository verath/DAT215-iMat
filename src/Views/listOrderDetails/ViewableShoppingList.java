package Views.listOrderDetails;

import ShoppingList.ShoppingList;
import ShoppingList.ShoppingListsHandler;
import java.util.Set;
import javax.swing.AbstractListModel;

/**
 *
 * @author Peter
 */
public class ViewableShoppingList extends AbstractListModel {

    Set<ShoppingList> shoppingLists = ShoppingListsHandler.INSTANCE.getShoppingLists();

    public int getSize() {
        return shoppingLists.size();
    }

    public Object getElementAt(int i) {
        int count = 0;
        for (ShoppingList sl : shoppingLists) {
            if (count == i) {
                return sl;
            }
            count++;
        }
        return null;
    }
}
