package Views.listOrderDetails;

import java.util.List;
import javax.swing.AbstractListModel;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;


/**
 *
 * @author Peter
 */
public class ViewableOrderList extends AbstractListModel {

    List<Order> orders = IMatDataHandler.getInstance().getOrders();

    public int getSize() {
        return orders.size();
    }

    public Object getElementAt(int i) {
        return new OrderWrapper(orders.get(i));
    }
}
