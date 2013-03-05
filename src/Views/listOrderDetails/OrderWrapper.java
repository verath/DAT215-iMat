package Views.listOrderDetails;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import se.chalmers.ait.dat215.project.Order;

/**
 * A wrapper for the Order object, implementing the toString method...
 * @author Peter
 */
public class OrderWrapper {

    private Order order;

    OrderWrapper(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        DateFormat df = SimpleDateFormat.getInstance();
        String d = df.format(order.getDate());
        return "Order #" + order.getOrderNumber() + " (" + d + ")";
    }
}
