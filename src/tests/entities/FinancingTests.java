package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import tests.factory.FinancingFactory;

public class FinancingTests {
	
	@Test
	public void constructorShouldCreateObjectWhenValidData() {
		
		// Arrange
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		
		// Action
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);
		
		// Assert
		Assertions.assertEquals(totalAmount, financing.getTotalAmount());
		Assertions.assertEquals(income, financing.getIncome());
		Assertions.assertEquals(months, financing.getMonths());
	}
	
	@Test
	public void constructorShouldThrowExceptionWhenInvalidData() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 20;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);
		});
	}
	
	@Test
	public void setTotalAmountShouldUpdateAmountWhenValidData() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		double expectedValue = 99000.0;
		
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);
		financing.setTotalAmount(expectedValue);
		
		Assertions.assertEquals(expectedValue, financing.getTotalAmount());
	}
	
	@Test
	public void setTotalAmountShouldThrowExceptionWhenInvalidData() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		double expectedValue = 110000.0;
				
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);
			financing.setTotalAmount(expectedValue);
		});
	}
	
	@Test
	public void setIncomeShouldUpdateIncomeWhenValidData() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		double expectedValue = 21000.0;
		
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);
		financing.setIncome(expectedValue);
		
		Assertions.assertEquals(expectedValue, financing.getIncome());
	}
	
	@Test
	public void setIncomeShouldThrowExceptionWhenInvalidData() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		double expectedValue = 1950.0;
				
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);
			financing.setIncome(expectedValue);
		});
	}
	
	@Test
	public void setMonthsShouldUpdateMonthsWhenValidData() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		int expectedValue = 85;
		
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);
		financing.setMonths(expectedValue);
		
		Assertions.assertEquals(expectedValue, financing.getMonths());
	}
	
	@Test
	public void setMonthsShouldThrowExceptionWhenInvalidData() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		int expectedValue = 79;
				
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);
			financing.setMonths(expectedValue);
		});
	}
	
	@Test
	public void entryShouldCalculateEntryCorrectly() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		double expectedValue = 20000.0;
		
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);
		double resultEntry = financing.entry();
		
		Assertions.assertEquals(expectedValue, resultEntry);
	}
	
	@Test
	public void quotaShouldCalculateQuotaCorrectly() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		double expectedValue = 1000.0;
		
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);
		double resultQuota = financing.quota();
		
		Assertions.assertEquals(expectedValue, resultQuota);
	}
}
