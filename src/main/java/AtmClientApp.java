import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class AtmClientApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
		Atm firstUserAccount = new Atm(10000, "5672");

		boolean isEnteredPinCorrect = false;
		int attemptsReaminAtEnteringPin = 3;
		System.out.println("Hello ATM user.");
		do {
			System.out.print("Please enter your 4-digit PIN code: ");
			String enteredPin = input.nextLine();
			isEnteredPinCorrect = firstUserAccount.allowAccess(enteredPin);
			if (!isEnteredPinCorrect) {
				attemptsReaminAtEnteringPin--;
				System.out.print("PIN Incorrect. You have " + attemptsReaminAtEnteringPin);
				if (attemptsReaminAtEnteringPin == 1) {
					System.out.println(" attempt remaining.");
				} else {
					System.out.println(" attempts remaining.");
				}
			}
		} while (!isEnteredPinCorrect && attemptsReaminAtEnteringPin > 0);

		if (attemptsReaminAtEnteringPin == 0) {
			System.out.println("You have exhausted your attempts.\nPlease call the bank to unlock your account.");
			System.exit(0);
		}

		System.out.println("Welcome to the Bank of We Can Code IT!");

		String atmMenuInput = "";
		double amount;
		do {
			System.out.println("ATM Account Menu:");
			System.out.println("Press 1 to deposit funds.\nPress 2 with withdraw funds.");
			System.out.println("Press 3 to check your current balance.\nPress 4 to exit.");
			atmMenuInput = input.nextLine();
			if (atmMenuInput.equals("1")) {
				System.out.println("How much would you like to deposit?");
				amount = input.nextDouble();
				firstUserAccount.deposit(amount);
				input.nextLine();
				System.out.println(currency.format(amount) + " deposited.  Current balance is "
						+ currency.format(firstUserAccount.getBalance()));
			} else if (atmMenuInput.equals("2")) {
				System.out.println("How much would you like to withdraw?");
				amount = input.nextDouble();
				input.nextLine();
				if (amount > firstUserAccount.getBalance()) {
					System.out.println(currency.format(amount) + " exceeds current balance.  Will withdraw balance of " 
							+ currency.format(firstUserAccount.getBalance()));
				}
				firstUserAccount.withdraw(amount);
				System.out.println("Money withdrawn.");
			} else if (atmMenuInput.equals("3")) {
				System.out.println("Current balance is " + currency.format(firstUserAccount.getBalance()));
			} else if (!atmMenuInput.equals("4")) {
				System.out.println("Invalid menu input.");
			}
		} while (!atmMenuInput.equals("4"));

		System.out.println("Thanks for banking with us!");

		input.close();
	}

}
