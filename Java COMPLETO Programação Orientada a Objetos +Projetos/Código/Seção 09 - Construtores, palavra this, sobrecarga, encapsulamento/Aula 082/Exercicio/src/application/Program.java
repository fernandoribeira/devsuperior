package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		Account account;
		int number;
		String holder;
		char initialDeposit;
		double amount;
		
		System.out.print("Enter account number: ");
		number = sc.nextInt();
		System.out.print("Enter account holder: ");
		sc.nextLine();
		holder = sc.nextLine();
		
		System.out.print("Is there na initial deposit (y/n)? ");
		initialDeposit = sc.next().charAt(0);
		
		if (initialDeposit == 'y') {
			System.out.print("Enter initial deposit value: ");
			amount = sc.nextDouble();
			account = new Account(number, holder, amount);
		} else {
			account = new Account(number, holder);
		}
		
		System.out.println();
		System.out.println("Account data:");
		System.out.println(account);
		
		System.out.println();
		System.out.print("Enter a deposit value: ");
		amount = sc.nextDouble();
		account.deposit(amount);
		System.out.println("Updated account data:");
		System.out.println(account);
		
		System.out.println();
		System.out.print("Enter a withdraw value: ");
		amount = sc.nextDouble();
		account.withdraw (amount);
		System.out.println("Updated account data:");
		System.out.println(account);
		
		sc.close();
		
	}
}
