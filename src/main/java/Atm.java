
public class Atm {

	private int balance;

	public Atm(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void withdraw(int amount) {
		if (amount <= balance) {
			balance -= amount;
		} else {
			balance = 0;
		}
	}

	public void deposit(int amount) {
		balance += amount;
	}

}
