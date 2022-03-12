package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {
	public static void main(String[] args) {
		
		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
		// Upcasting (convertendo um ojeto da subclasse para a superclasse, implicita)
		
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
		
		// Downcasting (convertendo um ojeto da superclasse para a subclasse, explicita)
		
		BusinessAccount acc4 = (BusinessAccount) acc2;
		//BusinessAccount acc5 = (BusinessAccount) acc3;
		
		// Instanceof
		
		if (acc2 instanceof BusinessAccount) {
			BusinessAccount bacc1 = (BusinessAccount) acc2;
			bacc1.loan(500.0);
			System.out.println("Loan");
		}
		
		if (acc3 instanceof SavingsAccount) {
			SavingsAccount sacc1 = (SavingsAccount) acc3;
			sacc1.updateBalance();
			System.out.println("Updated balance");
		}
		
	}
}
