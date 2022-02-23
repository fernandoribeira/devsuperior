package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		int n;
		Product[] vect;
		double sum;
		double averagePrice;
		
		n = sc.nextInt();
		vect = new Product[n];
		
		for (int i = 0; i < vect.length; i++) {

			String name;
			double price;
			
			sc.nextLine();
			name = sc.nextLine();
			price = sc.nextDouble();
			
			vect[i] = new Product(name, price);
			
		}
		
		sum = 0.0;
		
		for (int i = 0; i < vect.length; i++) {
			sum += vect[i].getPrice();
		}
		
		averagePrice = sum / vect.length;
		
		System.out.printf("AVERAGE PRICE = %.2f", averagePrice);
		
		sc.close();
		
	}
}
