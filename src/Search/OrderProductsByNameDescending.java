package Search;
import java.util.Comparator;

import se.chalmers.ait.dat215.project.Product;

/**
 * Orders a search by name, Z-A
 * @author Peter
 */
public class OrderProductsByNameDescending implements Comparator<Product>{
	@Override
	public int compare(Product o1, Product o2) {
		 return o2.getName().compareTo(o1.getName());
	}
	
}
