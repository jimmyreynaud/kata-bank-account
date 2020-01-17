package org.jreynaud.katabankaccount;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {

	private int balance;
	private final List<Statement> statements;
	
	public Account() {
		this.balance = 0;
		this.statements = new ArrayList<>();
	}
	
	public void deposit(int amount) {
		doOperation(amount, Statement.DEPOSIT);
	}

	public void withdraw(int amount) {	
		if (this.balance - amount < 0) throw new ArithmeticException("Balance is too low");
		doOperation(amount, Statement.WITHDRAW);
	}
	
	private void doOperation(int amount, String operationType) {
		if (amount < 0) throw new IllegalArgumentException("Amount value must be positive");
		if (operationType.equals(Statement.DEPOSIT))
			this.balance += amount;
		else
			this.balance -= amount;
		this.statements.add(new Statement(amount, this.balance, operationType, ZonedDateTime.now()));
	}
	
	public int getBalance() {
		return this.balance;
	}

	public List<Statement> getStatements() {
		return this.statements;
	}

}
