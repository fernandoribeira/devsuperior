package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Integer number;
		String holder;
		Double balance;
		Double withdrawLimit;
		Account account;
		Double amount;
		
		try {

			System.out.println("Enter account data");
			System.out.print("Number: ");
			number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			holder = sc.nextLine();
			System.out.print("Initial balance: ");
			balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			withdrawLimit = sc.nextDouble();
			
			account = new Account(number, holder, balance, withdrawLimit);
			
			System.out.println();
			
			System.out.print("Enter amount for withdraw: ");
			amount = sc.nextDouble();
			account.withdraw(amount);
			
			System.out.printf("New balance: %.2f", account.getBalance());
			
		} catch (DomainException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Unknown error!");
		} finally {
			sc.close();
		}

	}
}
