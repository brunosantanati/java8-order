package br.com.bruno.order.example2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bruno.order.common.ListFactory;

public class OrderTest {
	
	public static void main(String[] args) {
		orderUsualWay();
		naturalOrderTest();
		reverseOrderTest();
	}

	private static void orderUsualWay() {
		/*
		 * Como String implementa Comparable podemos ordenar
		 * uma lista de Strings passando-a para Collections.sort.
		 * Antes do Java 8 era feito dessa forma.
		 */
		List<String> series = ListFactory.getStringList();
		
		Collections.sort(series);
		
		System.out.println(series);		
	}
	
	private static void naturalOrderTest() {
		/*
		 * Agora no Java 8 podemos usar o List.sort 
		 * em conjunto com o Comparator.naturalOrder()
		 * para ordenar pela ordem natural.
		 */
		List<String> series = ListFactory.getStringList();
		
		series.sort(Comparator.naturalOrder());
		
		System.out.println(series);
	}
	
	private static void reverseOrderTest() {
		/*
		 * Agora no Java 8 também podemos usar o List.sort 
		 * em conjunto com o Comparator.reverseOrder()
		 * para ordenar de forma inversa.
		 */
		List<String> series = ListFactory.getStringList();
		
		series.sort(Comparator.reverseOrder());
		
		System.out.println(series);		
	}
	
}
