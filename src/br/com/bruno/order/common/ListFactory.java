package br.com.bruno.order.common;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ListFactory {

	public static List<Product> getProductList() {
		Product product1 = new Product(4, "Notebook Samsung", new BigDecimal("1200.00"));
		Product product2 = new Product(3, "Notebook Dell", new BigDecimal("1200.00"));
		Product product3 = new Product(2, "TV", new BigDecimal("3100.00"));
		Product product4 = new Product(1, "Sofá", new BigDecimal("2500.00"));
		
		return Arrays.asList(product1, product2, product3, product4);
	}
	
	public static List<String> getStringList(){
		return Arrays.asList("Friends", "Prison Break", "Breaking Bad", "Black Mirror");
	}
	
}
