package ProductSearch;
import java.util.Comparator;

import se.chalmers.ait.dat215.project.Product;


public class OrderProductsByNameDescending implements Comparator<Product>{
	@Override
	public int compare(Product o1, Product o2) {
		 return o2.getName().compareTo(o1.getName());
	}
	
}
