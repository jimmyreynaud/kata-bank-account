package org.jreynaud.katabankaccount;

import static org.junit.jupiter.api.Assertions.*;

import org.jreynaud.katabankaccount.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

	private Account account;
	
	@BeforeEach
	public void setup() {
		account = new Account();
	}
	
	@Test
	public void should_ReturnBalanceOf0_when_AccountIsCreated() {
		assertEquals(0, account.getBalance());
	}
	
	@Test
	public void should_ReturnBalanceOf0_when_DepositOf0() {
		account.deposit(0);
		assertEquals(0, account.getBalance());
	}

	@Test
	public void should_ReturnBalanceOf150_when_OneDepositOf150() {
		account.deposit(150);
		assertEquals(150, account.getBalance());
	}

	@Test
	public void should_ReturnBalanceOf400_when_DepositOf150then250() {
		account.deposit(150);
		account.deposit(250);
		assertEquals(400, account.getBalance());
	}

	@Test
	public void should_ThrowException_when_NegativeDeposit() {
		assertThrows(IllegalArgumentException.class,
				() -> {	account.deposit(-150);});
	}

	@Test
	public void should_ReturnBalanceOf0_when_WithdrawOf0() {
		account.withdraw(0);
		assertEquals(0, account.getBalance());
	}
	
	@Test
	public void should_ReturnBalanceOf20_when_WithdrawOf50() {
		account.deposit(70);
		account.withdraw(50);
		assertEquals(20, account.getBalance());
	}

	@Test
	public void should_ReturnBalanceOf10_when_WithdrawOf50Then10() {
		account.deposit(70);
		account.withdraw(50);
		account.withdraw(10);
		assertEquals(10, account.getBalance());
	}

	@Test
	public void should_ThrowException_when_WithdrawIsNegative() {
		assertThrows(IllegalArgumentException.class,
				() -> {account.withdraw(-150);});
	}

	@Test
	public void should_ThrowException_when_BalanceIsNegative() {
		assertThrows(IllegalStateException.class,
				() -> {account.withdraw(150);});
	}
}
