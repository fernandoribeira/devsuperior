package model.entities;

import model.exceptions.DomainException;

public class Account {
	
	Integer number;
	String holder;
	Double balance;
	Double withdrawLimit;
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	@Override
	public String toString() {
		return "Account [number=" 
				+ number 
				+ ", holder=" 
				+ holder 
				+ ", balance=" 
				+ balance 
				+ ", withdrawLimit="
				+ withdrawLimit 
				+ "]";
	}
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) throws DomainException {
		validateWithdraw(amount);
		balance -= amount;
	}

	public void validateWithdraw(Double amount) throws DomainException {
		if (amount > withdrawLimit) {
			throw new DomainException("Withdraw error: The amount exceeds withdraw limit!");
		}
		if (amount > balance) {
			throw new DomainException("Withdraw error: Not enough balance!");
		}
	}

}
