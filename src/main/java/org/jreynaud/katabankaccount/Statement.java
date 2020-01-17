package org.jreynaud.katabankaccount;

import java.time.ZonedDateTime;


public final class Statement {

	public static final String DEPOSIT = "Deposit";
	public static final String WITHDRAW = "Withdraw";

	private final int amount;
	private final int balance;
	private final String operationType;
	private final ZonedDateTime date;

	public Statement(int amount, int balance, String operationType, ZonedDateTime date) {
		this.amount = amount;
		this.balance = balance;
		this.operationType = operationType;
		this.date = date;
	}

	public int getAmount() {
		return this.amount;
	}

	public int getBalance() {
		return this.balance;
	}

	public String getOperationType() {
		return this.operationType;
	}

	public ZonedDateTime getDate() {
		return this.date;
	}

}
