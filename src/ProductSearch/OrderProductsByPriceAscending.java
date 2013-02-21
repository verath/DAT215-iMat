package ProductSearch;

import java.util.Comparator;
import se.chalmers.ait.dat215.project.Product;

/**
 * Orders a search by price, low-high
 * @author Peter
 */
public class OrderProductsByPriceAscending implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
