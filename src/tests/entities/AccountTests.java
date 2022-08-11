package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {
	
	@Test
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
		double amount = 1000.0;
		double expectedValue = 980.0;
		double initialBalance = 0.0;
		Account account = AccountFactory.createAccount(initialBalance);
		
		account.deposit(amount);
		
		Assertions.assertEquals(expectedValue, account.getBalance());
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		double amount = -500.0;
		double expectedValue = 980.0;
		double initialBalance = expectedValue;
		Account account = AccountFactory.createAccount(initialBalance);
		
		account.deposit(amount);
		
		Assertions.assertEquals(expectedValue, account.getBalance());
	}
	
	@Test
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
		double expectedValue = 0.0;
		double initialBalance = 1000.0;
		Account account = AccountFactory.createAccount(initialBalance);
		
		double result = account.fullWithdraw();
		
		Assertions.assertEquals(expectedValue, account.getBalance());
		Assertions.assertEquals(result, initialBalance);
	}
	
	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		double amount = 500.0;
		double initialBalance = 900.0;
		Account account = AccountFactory.createAccount(initialBalance);
		
		account.withdraw(amount);
		
		Assertions.assertEquals(400.0, account.getBalance());
	}
	
	@Test
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
		double amount = 1000.0;
		double initialBalance = 900.0;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account account = AccountFactory.createAccount(initialBalance);
			account.withdraw(amount);
		});
	}
}
