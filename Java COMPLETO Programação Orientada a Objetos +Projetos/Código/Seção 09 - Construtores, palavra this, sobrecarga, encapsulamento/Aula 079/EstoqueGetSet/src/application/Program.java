package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner (System.in);
		
		Product product1;
		Product product2;
		Product product3;
		String name;
		double price;
		int quantity;
		
		System.out.println("Enter product data:");
		System.out.print("Name: ");
		name = sc.nextLine();
		System.out.print("Price: ");
		price = sc.nextDouble();
		System.out.print("Quantity in stock: ");
		quantity = sc.nextInt();
		
		product1 = new Product();
		product2 = new Product(name, price, quantity);
		product3 = new Product(name, price);
		
		System.out.println();
		System.out.println("Product1 data: " + product1);
		System.out.println("Product2 data: " + product2);
		System.out.println("Product3 data: " + product3);
		
		sc.close();
		
	}
}