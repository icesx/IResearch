package com.javapatterns.templatemethod.InterestRate;

public abstract class Account {
	protected String accountNumber;

	public Account() {
		accountNumber = null;
	}

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public final double calculateInterest() {
		double interestRate = doCalculateInterestRate();
		String accountType = doCalculateAccountType();
		double amount = calculateAmount(accountType, accountNumber);

		return amount * interestRate;
	}

	protected abstract String doCalculateAccountType();

	protected abstract double doCalculateInterestRate();

	public final double calculateAmount(String accountType, String accountNumber) {
		// retrieve amount from database...here is only a mock-up
		return 7243.00D;
	}
}
