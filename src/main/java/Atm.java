
public class Atm {

	private double balance;
	private String requiredPin;

	public Atm(int balance, String requiredPin) {
		this.balance = balance;
		this.requiredPin = requiredPin;
	}

	public double getBalance() {
		return balance;
	}

	public void withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
		} else {
			balance = 0;
		}
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public boolean allowAccess(String enteredPin) {
		return (enteredPin.equals(requiredPin));
	}

}
