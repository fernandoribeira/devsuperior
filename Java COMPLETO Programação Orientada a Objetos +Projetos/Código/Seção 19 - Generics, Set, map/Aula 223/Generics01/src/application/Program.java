package application;

import java.util.Scanner;

import model.services.PrintService;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PrintService ps = new PrintService();
		int n;
		
		System.out.print("How many values? ");
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int value = sc.nextInt();
			ps.addValue(value);
		}
		
		ps.print();
		
		Integer value = ps.first();
		System.out.println("First: " + value);
		
		sc.close();
		
	}
}
