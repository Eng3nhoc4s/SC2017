package util;

import java.util.Scanner;

public class Input {

	public static boolean askForConfirmationYesNo() {

		Scanner scan = new Scanner(System.in);

		boolean validAnswer = false;
		boolean theAnswer = false;

		String answer;

		Print.pConfirmationYesNo();

		do {

			answer = scan.nextLine();

			if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
				validAnswer = !validAnswer;
				theAnswer = true;
			} else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
				validAnswer = !validAnswer;
				theAnswer = false;
			}

			Print.pInvalidChoice();
			Print.pConfirmationYesNo();

		} while (!validAnswer);

		scan.close();
		
		return theAnswer;
	}
}
