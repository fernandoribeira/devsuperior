package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import model.entities.Product;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("TV", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.00));
		list.add(new Product("HD Case", 80.00));
		
		//list.removeIf(p -> p.getPrice() >= 100.0);
		
		//list.removeIf(new ProductPredicate());
		
		//list.removeIf(Product::nonStaticProductPredicate);
		
		//Predicate<Product> pred = p -> p.getPrice() >= 100.0;
		
		//list.removeIf(pred);
		
		list.removeIf(p -> p.getPrice() >= 100.0);
		
		for (Product p : list) {
			System.out.println(p);
		}
		
	}
}
