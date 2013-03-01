package Views.listOrderDetails;

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
        return "Order #" + order.getOrderNumber();
    }
}
