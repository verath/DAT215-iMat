package Views.listOrderDetails;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.AbstractListModel;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;

/**
 *
 * @author Peter
 */
public class ViewableOrderList extends AbstractListModel {

    private List<Order> orders = new LinkedList<Order>(
            IMatDataHandler.getInstance().getOrders());

    ViewableOrderList() {
        Collections.sort(orders, new Comparator<Order>() {

            public int compare(Order t, Order t1) {
                // Higher order number > lower order number
                return t1.getOrderNumber() - t.getOrderNumber();
            }
        });
    }

    public int getSize() {
        return orders.size();
    }

    public Object getElementAt(int i) {
        return new OrderWrapper(orders.get(i));
    }
}
