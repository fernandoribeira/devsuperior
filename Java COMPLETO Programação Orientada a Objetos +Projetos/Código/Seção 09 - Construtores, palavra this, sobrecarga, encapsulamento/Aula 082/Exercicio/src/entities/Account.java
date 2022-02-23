package entities;

public class Account {
	
	// Constant
	
	private final double TAX = 5.00;

	// Variables
	
	private int number;
	private String holder;
	private double balance;

	// Constructor
	
	public Account(int number, String holder, double initialDeposit) {
		this.number = number;
		this.holder = holder;
		this.balance = initialDeposit;
	}
	
	public Account(int number, String holder) {
		this.number = number;
		this.holder = holder;
		this.balance = 0.0;
	}

	// Getters and setters
	
	public int getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	// Others methods
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount + TAX;
	}

	@Override
	public String toString() {
		return "Account "
				+ number
				+ ", Holder: "
				+ holder
				+ ", Balance: $ "
				+ String.format("%.2f", balance);
	}

}
