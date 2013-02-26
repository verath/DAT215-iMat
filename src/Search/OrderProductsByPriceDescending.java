package Search;

import java.util.Comparator;
import se.chalmers.ait.dat215.project.Product;

/**
 * Orders a search by price, high-low
 * @author Peter
 */
public class OrderProductsByPriceDescending implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o2.getPrice(), o1.getPrice());
    }
}
