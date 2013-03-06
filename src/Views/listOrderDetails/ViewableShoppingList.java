package Views.listOrderDetails;

import ShoppingList.ShoppingList;
import ShoppingList.ShoppingListsHandler;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Peter
 */
public class ViewableShoppingList extends AbstractListModel {

    private List<ShoppingList> shoppingLists = new LinkedList<ShoppingList>(
            ShoppingListsHandler.INSTANCE.getShoppingLists());

    public ViewableShoppingList() {
        Collections.sort(shoppingLists, new Comparator<ShoppingList>() {

            public int compare(ShoppingList t, ShoppingList t1) {
                // Latest modified first
                return t1.getDateModified().compareTo(t.getDateModified());
            }
        });
    }

    public int getSize() {
        return shoppingLists.size();
    }

    public Object getElementAt(int i) {
        return shoppingLists.get(i);
    }
}
