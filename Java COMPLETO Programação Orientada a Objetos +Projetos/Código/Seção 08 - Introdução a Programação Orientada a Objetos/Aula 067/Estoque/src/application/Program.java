package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner (System.in);
		Product product = new Product();
		
		System.out.println("Enter product data:");
		System.out.print("Name: ");
		product.name = sc.nextLine();
		System.out.print("Price: ");
		product.price = sc.nextDouble();
		System.out.print("Quantity in stock: ");
		product.quantity = sc.nextInt();
		
		System.out.printf("Product data: %s, $ %.2f, %d units, Total: $ %.2f%n",
				product.name, product.price, product.quantity,
				product.totalvalueInStock());
		
		sc.close();
		
	}
}