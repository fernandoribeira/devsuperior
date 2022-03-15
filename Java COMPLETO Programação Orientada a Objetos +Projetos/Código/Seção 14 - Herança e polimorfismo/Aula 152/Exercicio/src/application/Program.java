package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();
		int n;
		double totalTaxes = 0.0;
		
		System.out.print("Enter the number of tax payer: ");
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			
			char type;
			String name;
			Double anualIncome;
			Double healthExpenditure;
			Integer numberOfEmployees;
			
			System.out.println("Tax payer #" + (i + 1) + " data:");
			System.out.print("Individual or company (i/c)? ");
			type = sc.next().charAt(0);
			System.out.print("Name: ");
			name = sc.next();
			System.out.print("Anual income: ");
			anualIncome = sc.nextDouble();
			
			if (type == 'i') {
				System.out.print("Health expenditures: ");
				healthExpenditure = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditure));
			} else {
				System.out.print("Number of employee: ");
				numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));	
			}
			
		}
		
		System.out.println();
		
		System.out.println("TAXES PAID:");
		for (TaxPayer taxPayer : list) {
			System.out.println(taxPayer);
			totalTaxes += taxPayer.tax();
		}
		
		System.out.println();
		
		System.out.printf("TOTAL TAXES: $ %.2f%n", totalTaxes);
		
		sc.close();
		
	}
}
