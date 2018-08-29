import java.util.Scanner;

public class AtmClientApp {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		Atm firstUserAccount = new Atm(10000, "5672");
		
		boolean isEnteredPinCorrect = false;
		int attemptsAtEnteringPin = 3;
		System.out.println("Hello ATM user.");
		do {
			System.out.print("Please enter your 4-digit PIN code: ");
			String enteredPin = input.nextLine();
			isEnteredPinCorrect = firstUserAccount.allowAccess(enteredPin);
			if (!isEnteredPinCorrect) {
				attemptsAtEnteringPin--;
				System.out.print("PIN Incorrect. You have " + attemptsAtEnteringPin);
				if (attemptsAtEnteringPin == 1) {
					System.out.println(" attempt remaining.");
				} else {
					System.out.println(" attempts remaining.");
				}
			}
		} while (!isEnteredPinCorrect && attemptsAtEnteringPin > 0);
		
		if (attemptsAtEnteringPin == 0) {
			System.out.println("You have exhausted your attempts.\nPlease call the bank to unlock your account.");
			System.exit(0);
		}

		System.out.println("Welcome to the Bank of We Can Code IT!");
		
//		String atmMenuInput = "";
//		do {
//			
//		} while(!atmMenuInput.equals("4"));
		
		
		
		input.close();
	}

}
