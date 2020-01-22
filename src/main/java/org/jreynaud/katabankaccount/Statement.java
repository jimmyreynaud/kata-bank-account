package org.jreynaud.katabankaccount;

import java.time.ZonedDateTime;
import java.util.Objects;


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
		this.operationType = Objects.requireNonNull(operationType, "operationType must not be null");
		this.date = Objects.requireNonNull(date, "date must not be null");
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
