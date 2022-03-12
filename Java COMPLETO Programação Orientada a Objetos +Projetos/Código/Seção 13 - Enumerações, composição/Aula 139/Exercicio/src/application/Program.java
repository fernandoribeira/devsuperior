package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String name;
		String email;
		Date birthDate;
		OrderStatus status;
		Integer items;
		Order order;
		Client client;
		
		System.out.println("Enter cliente data:");
		
		System.out.print("Name: ");
		name = sc.nextLine();
		System.out.print("Email: ");
		email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		birthDate = sdf.parse(sc.next());	
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		status = OrderStatus.valueOf(sc.next());
		
		client = new Client(name, email, birthDate);
		order = new Order(new Date(), status, client);

		System.out.print("How many items to this order? ");
		items = sc.nextInt();
		
		for (int i = 0; i < items; i++) {
			
			String productName;
			Double productPrice;
			Product product;
			Integer quantity;
			OrderItem orderItem;
			
			System.out.println("Enter #" + (i + 1) + " item data:");
			System.out.print("Product name: ");
			productName = sc.next();
			System.out.print("Product price: ");
			productPrice = sc.nextDouble();
			
			product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			quantity = sc.nextInt();
			
			orderItem = new OrderItem(quantity, productPrice, product);
			
			order.addItem(orderItem);
			
		}
		
		System.out.println();
		
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}
}
