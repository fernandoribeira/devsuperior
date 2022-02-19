package application;

import java.util.Locale;
import java.util.Scanner;

import util.CurrencyConverter;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		double dollarPrice;
		double dollarQuantity;
		
		System.out.print("What is the dollar price? ");
		dollarPrice = sc.nextDouble();
		System.out.print("How many dollars will be bought? ");
		dollarQuantity = sc.nextDouble();
		
		System.out.printf("Amount to be paid in reais = %.2f",
				CurrencyConverter.dollarToReal(dollarPrice, dollarQuantity));
		
		sc.close();
		
	}
}
