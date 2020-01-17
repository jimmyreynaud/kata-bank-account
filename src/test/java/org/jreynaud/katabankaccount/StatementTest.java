package org.jreynaud.katabankaccount;

import static org.junit.jupiter.api.Assertions.*;

import org.jreynaud.katabankaccount.Account;
import org.jreynaud.katabankaccount.Statement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StatementTest {

	private Account account;
	
	@BeforeEach
	public void setup() {
		this.account = new Account();
	}
	
	@Test
	public void should_CreateOneStatement_when_OneDepositIsDone() {
		account.deposit(100);
		assertEquals(1, account.getStatements().size());
	}
	
	@Test
	public void should_HaveAmountOf100_when_DepositOf100() {
		account.deposit(100);
		assertEquals(100, account.getStatements().get(0).getAmount());
	}
	
	@Test
	public void should_HaveBalanceOf10_when_DepositOf10() {
		account.deposit(10);
		assertEquals(10, account.getStatements().get(0).getBalance());
	}
	
	@Test
	public void should_HaveDepositOperationType_when_DepositIsDone( ) {
		account.deposit(10);
		assertEquals(Statement.DEPOSIT, account.getStatements().get(0).getOperationType());
	}
	
	@Test
	public void should_HaveDate_when_DepositIsDone() {
		account.deposit(10);
		assertTrue(account.getStatements().get(0).getDate() != null);
	}
	
	@Test
	public void should_CreateTwoStatements_when_OneDepositIsDone_then_OneWithdrawIsDone() {
		account.deposit(20);
		account.withdraw(10);
		assertEquals(2, account.getStatements().size());
	}
	
	@Test
	public void should_HaveAmountOf10_when_WithdrawOf10() {
		account.deposit(20);
		account.withdraw(10);
		assertEquals(10, account.getStatements().get(1).getAmount());
	}
	
	@Test
	public void should_HaveBalanceOf20_when_WithdrawOf20() {
		account.deposit(40);
		account.withdraw(20);
		assertEquals(20, account.getStatements().get(1).getBalance());
	}
	
	@Test
	public void should_HaveWithdrawOperationType_when_WithdrawIsDone() {
		account.deposit(20);
		account.withdraw(10);
		assertEquals(Statement.WITHDRAW, account.getStatements().get(1).getOperationType());
	}
	
	@Test
	public void should_HaveDate_when_WithdrawIsDone() {
		account.deposit(100);
		account.withdraw(10);
		assertTrue(account.getStatements().get(1).getDate() != null);
	}
	
}
