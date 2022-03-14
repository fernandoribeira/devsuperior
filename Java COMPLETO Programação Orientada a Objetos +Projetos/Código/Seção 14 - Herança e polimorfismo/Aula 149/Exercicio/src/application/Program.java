package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		Integer n;
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			
			Character type;
			String name;
			Double price;
			
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			type = sc.next().charAt(0);
			System.out.print("Name: ");
			name = sc.next();
			System.out.print("Price: ");
			price = sc.nextDouble();
			
			if (type.equals('i')) {			
				Double customsFee;
				System.out.print("Customs fee: ");
				customsFee = sc.nextDouble();
				products.add(new ImportedProduct(name, price, customsFee));
			} else if (type.equals('u')) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date manufactureDate;
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				manufactureDate = sdf.parse(sc.next());
				products.add(new UsedProduct(name, price, manufactureDate));
			} else {
				products.add(new Product(name, price));
			}
			
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product product : products) {
			System.out.println(product.priceTag());
		}
		
		sc.close();
		
	}
}
