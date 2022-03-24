package application;

import java.util.Scanner;

import model.services.PrintService;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PrintService<String> ps = new PrintService<>();
		int n;
		
		System.out.print("How many values? ");
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String value = sc.next();
			ps.addValue(value);
		}
		
		ps.print();
		
		String value = ps.first();
		System.out.println("First: " + value);
		
		sc.close();
		
	}
}
