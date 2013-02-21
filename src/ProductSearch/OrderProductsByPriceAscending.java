package ProductSearch;

import java.util.Comparator;

import se.chalmers.ait.dat215.project.Product;

public class OrderProductsByPriceAscending implements Comparator<Product> {
	@Override
	public int compare(Product o1, Product o2) {
		return Double.compare(o1.getPrice(), o2.getPrice());
	}

}
