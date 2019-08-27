package br.com.bruno.order.example3;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import br.com.bruno.order.common.ListFactory;
import br.com.bruno.order.common.Product;

public class OrderTest {

	public static void main(String[] args) {
		orderById();
		orderByIdAvoidAutoboxing();
	}

	private static void orderById() {
		/*
		 * O m�todo apply da Function extractId, 
		 * nesse caso recebe um Product e retorna um Integer ao inv�s de um int.
		 * Esse autoboxing ir� ocorrer toda vez que esse m�todo for invocado,
		 * e ele pode ser invocado muitas vezes durante o sort.
		 */
		List<Product> products = ListFactory.getProductList();
		
		Function<Product, Integer> extractId = p -> p.getId();
		Comparator<Product> comparator = Comparator.comparing(extractId);
		products.sort(comparator);
		
		System.out.println(products);
	}
	
	private static void orderByIdAvoidAutoboxing() {
		/*
		 * Usando ToIntFunction ao inv�s de Function e
		 * Comparator.comparingInt ao inv�s de Comparator.comparing
		 * evita as m�ltiplas ocorr�ncias de autoboxing do exemplo anterior.
		 */
		List<Product> products = ListFactory.getProductList();
		
		ToIntFunction<Product> extractId = p -> p.getId();
		Comparator<Product> comparator = Comparator.comparingInt(extractId);
		products.sort(comparator);
		
		System.out.println(products);
	}

}
