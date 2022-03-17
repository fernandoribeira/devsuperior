package application;

import java.util.ArrayList;
import java.util.List;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {
	public static void main(String[] args) {

		//Account acc1 = new Account(1001, "Bob", 1000.0);
		Account acc2 = new BusinessAccount(1002, "Maria", 1000.0, 500.0);
		Account acc3 = new SavingsAccount(1003, "Bolacha", 1000.0, 0.01);
		BusinessAccount acc4 = new BusinessAccount(1002, "Maria", 1000.0, 500.0);
		SavingsAccount acc5 = new SavingsAccount(1003, "Bolacha", 1000.0, 0.01);
		
		List<Account> list = new ArrayList<>();
		list.add(acc2);
		list.add(acc3);
		list.add(acc4);
		list.add(acc5);
		
		double total = 0.0;
		
		for (Account acc : list) {
			total += acc.getBalance();
		}
		
		System.out.println(total);
		
	}
}
