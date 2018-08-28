import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AtmTest {
	
	Atm underTest = new Atm(100, "1234");

	@Test
	public void shouldHaveDefaultBalanceOf100() {
		int balance = (int)underTest.getBalance();
		assertEquals(100, balance);
	}
	
	@Test
	public void shouldHaveDefaultBalanceOf200() {
		Atm underTest2 = new Atm(200, "1234");
		int balance = (int)underTest2.getBalance();
		assertEquals(200, balance);
	}
	
	@Test
	public void shouldHaveDefaultBalanceOf1000() {
		Atm underTest3 = new Atm(1000, "1234");
		int balance = (int)underTest3.getBalance();
		assertEquals(1000, balance);
	}
	
	@Test
	public void afterWithdraw50ShouldHaveBalanceOf50WithStartBalanceOf100() {
		underTest.withdraw(50);
		int balance = (int)underTest.getBalance();
		assertEquals(50, balance);
	}
	
	@Test
	public void afterWithdraw100ShouldHaveBalanceOf0WithStartBalanceOf100() {
		underTest.withdraw(100);
		int balance = (int)underTest.getBalance();
		assertEquals(0, balance);
	}
	
	@Test
	public void afterWithdraw200ShouldHaveBalanceOf0WithStartBalanceOf100() {
		underTest.withdraw(200);
		int balance = (int)underTest.getBalance();
		assertEquals(0, balance);
	}
	
	@Test
	public void afterDeposit100ShouldHaveBalanceOf200WithStartBalanceOf100() {
		underTest.deposit(100);
		int balance = (int)underTest.getBalance();
		assertEquals(200, balance);
	}
	
	@Test
	public void afterDeposit200ShouldHaveBalanceOf300WithStartBalanceOf100() {
		underTest.deposit(200);
		int balance = (int)underTest.getBalance();
		assertEquals(300, balance);
	}
	
	@Test
	public void shouldAllowAccessByPin() {
		boolean access = underTest.allowAccess("1234");
		assertTrue(access);
	}
	
	@Test
	public void shouldDenyAccessByBadPin() {
		boolean access = underTest.allowAccess("4567");
		assertFalse(access);
	}
	
}
