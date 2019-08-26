package br.com.bruno.order.example1;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bruno.order.common.Product;

public class OrderTest {
	
	public static void main(String[] args) {
		
		Product product1 = new Product(1, "Notebook Samsung", new BigDecimal("1200.00"));
		Product product2 = new Product(2, "Notebook Dell", new BigDecimal("1200.00"));
		Product product3 = new Product(3, "TV", new BigDecimal("3100.00"));
		Product product4 = new Product(4, "Sofá", new BigDecimal("2500.00"));
		
		orderUsualWay(Arrays.asList(product1, product2, product3, product4));
		orderJava8Test1(Arrays.asList(product1, product2, product3, product4));
		orderJava8Test2(Arrays.asList(product1, product2, product3, product4));
		orderJava8Test3(Arrays.asList(product1, product2, product3, product4));
		orderJava8Test4(Arrays.asList(product1, product2, product3, product4));
		orderJava8Test5(Arrays.asList(product1, product2, product3, product4));
	}
	
	private static void orderUsualWay(List<Product> products) {
		 
		Comparator<Product> comparator = new Comparator<>() {
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getName().compareTo(p2.getName());
			}
		};
		
		Collections.sort(products, comparator);
		
		System.out.println(products);
	}
	
	private static void orderJava8Test1(List<Product> products) {
		
		Comparator<Product> comparator = (p1, p2) -> p1.getName().compareTo(p2.getName());
		
		Collections.sort(products, comparator);
		
		System.out.println(products);
	}

	private static void orderJava8Test2(List<Product> products) {
		
		Collections.sort(products, (p1, p2) -> p1.getName().compareTo(p2.getName()));
		
		System.out.println(products);
	}
	
	private static void orderJava8Test3(List<Product> products) {
		
		products.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
		
		System.out.println(products);
	}
	
	private static void orderJava8Test4(List<Product> products) {
		
		products.sort(Comparator.comparing(u -> u.getName()));
		
		System.out.println(products);
	}
	
	private static void orderJava8Test5(List<Product> products) {
		
		products.sort(Comparator.comparing(Product::getName));
		
		System.out.println(products);
	}
}
