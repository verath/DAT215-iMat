package ProductSearch;
import java.util.Comparator;

import se.chalmers.ait.dat215.project.Product;

/**
 * Orders a search by name, A-Z
 * @author Peter
 */
public class OrderProductsByNameAscending implements Comparator<Product>{
	@Override
	public int compare(Product o1, Product o2) {
		 return o1.getName().compareTo(o2.getName());
	}
	
}
