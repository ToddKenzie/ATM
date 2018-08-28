import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AtmTest {
	
	Atm underTest;

	@Test
	public void shouldHaveDefaultBalanceOf100() {
		underTest = new Atm(100);
		int balance = underTest.getBalance();
		assertEquals(100, balance);
	}
	
	@Test
	public void shouldHaveDefaultBalanceOf200() {
		underTest = new Atm(200);
		int balance = underTest.getBalance();
		assertEquals(200, balance);
	}
	
	@Test
	public void shouldHaveDefaultBalanceOf1000() {
		underTest = new Atm(1000);
		int balance = underTest.getBalance();
		assertEquals(1000, balance);
	}
	
	@Test
	public void afterWithdraw50ShouldHaveBalanceOf50WithStartBalanceOf100() {
		underTest = new Atm(100);
		underTest.withdraw(50);
		int balance = underTest.getBalance();
		assertEquals(50, balance);
	}
	
	@Test
	public void afterWithdraw100ShouldHaveBalanceOf0WithStartBalanceOf100() {
		underTest = new Atm(100);
		underTest.withdraw(100);
		int balance = underTest.getBalance();
		assertEquals(0, balance);
	}
	
	@Test
	public void afterWithdraw200ShouldHaveBalanceOf0WithStartBalanceOf100() {
		underTest = new Atm(100);
		underTest.withdraw(200);
		int balance = underTest.getBalance();
		assertEquals(0, balance);
	}
	
	@Test
	public void afterDeposit100ShouldHaveBalanceOf200WithStartBalanceOf100() {
		underTest = new Atm(100);
		underTest.deposit(100);
		int balance = underTest.getBalance();
		assertEquals(200, balance);
	}
	
	@Test
	public void afterDeposit200ShouldHaveBalanceOf300WithStartBalanceOf100() {
		underTest = new Atm(100);
		underTest.deposit(200);
		int balance = underTest.getBalance();
		assertEquals(300, balance);
	}
}
