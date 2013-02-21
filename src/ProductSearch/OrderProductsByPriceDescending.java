package ProductSearch;
import java.util.Comparator;

import se.chalmers.ait.dat215.project.Product;


public class OrderProductsByPriceDescending implements Comparator<Product>{
	@Override
	public int compare(Product o1, Product o2) {
		return Double.compare(o2.getPrice(), o1.getPrice());
	}
	
}
