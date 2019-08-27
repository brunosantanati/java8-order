package br.com.bruno.order.example1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import br.com.bruno.order.common.ListFactory;
import br.com.bruno.order.common.Product;

public class OrderTest {
	
	public static void main(String[] args) {

		/*
		 * Abaixo todos os m�todos fazem a mesma ordena��o, por�m
		 * vemos formas diferentes de se fazer isso,
		 * tanto usando a maneira anterior ao Java 8 como tamb�m
		 * usando formas de se fazer com Java 8.
		 */
		orderUsualWay(ListFactory.getProductList());
		orderJava8Test1(ListFactory.getProductList());
		orderJava8Test2(ListFactory.getProductList());
		orderJava8Test3(ListFactory.getProductList());
		orderJava8Test4(ListFactory.getProductList());
		orderJava8Test5(ListFactory.getProductList());
		orderJava8Test6(ListFactory.getProductList());
	}
	
	private static void orderUsualWay(List<Product> products) {
		 
		/*
		 * Como nossa classe Product n�o implementa Comparable
		 * precisamos de um Comparator<Product> para passar para Collections.sort
		 * afim de que a lista de produtos seja ordenada(nesse caso por nome).
		 * Esse era o jeito usado antes do Java 8.
		 */
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
		
		/*
		 * Comparator � uma interface funcional, portanto
		 * podemos fazer uso de uma express�o Lambda do Java 8
		 * no lugar de usar uma classe an�nima.
		 */
		Comparator<Product> comparator = (p1, p2) -> p1.getName().compareTo(p2.getName());
		
		Collections.sort(products, comparator);
		
		System.out.println(products);
	}

	private static void orderJava8Test2(List<Product> products) {
		
		/*
		 * Mesmo exemplo acima mas simplificado em uma linha
		 * passando a express�o Lambda direto sem atribui��o pr�via.
		 */
		Collections.sort(products, (p1, p2) -> p1.getName().compareTo(p2.getName()));
		
		System.out.println(products);
	}
	
	private static void orderJava8Test3(List<Product> products) {
		
		/*
		 * No Java 8 foi adicionado um m�todo default chamado sort na interface List.
		 * Abaixo usamos ele ao inv�s de Collections.sort.
		 */
		products.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
		
		System.out.println(products);
	}
	
	private static void orderJava8Test4(List<Product> products) {
		
		/*
		 * No Java 8 tamb�m foram adicionados m�todos est�ticos na interface Comparator
		 * que funcionam como uma factory de Comparators.
		 * Por exemplo o Comparator.comparing que recebe uma Function e devolve um Comparator.
		 */
		Function<Product, String> extractName = p -> p.getName();
		
		products.sort(Comparator.comparing(extractName));
		
		System.out.println(products);
	}
	
	private static void orderJava8Test5(List<Product> products) {
		
		/*
		 * Mesmo exemplo acima(usando List.sort e Comparator.comparing)
		 * por�m em uma �nica linha.
		 */
		products.sort(Comparator.comparing(p -> p.getName()));
		
		System.out.println(products);
	}
	
	private static void orderJava8Test6(List<Product> products) {
		
		/*
		 * Mesmo exemplo acima mas usando tamb�m Method Reference: Product::getName.
		 * Method Reference foi introduzido no Java 8.
		 */
		products.sort(Comparator.comparing(Product::getName));
		
		System.out.println(products);
	}
}
