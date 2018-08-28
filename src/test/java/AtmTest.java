import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AtmTest {

	@Test
	public void shouldHaveDefaultBalanceOf100() {
		Atm underTest = new Atm(100);
		int balance = underTest.getBalance();
		assertEquals(100, balance);
	}
	
	@Test
	public void shouldHaveDefaultBalanceOf200() {
		Atm underTest = new Atm(200);
		int balance = underTest.getBalance();
		assertEquals(200, balance);
	}
	
	
	
}
