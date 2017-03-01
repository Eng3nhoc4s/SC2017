package auth;

import java.util.Scanner;

import util.Print;

public class Passwds {

	/**
	 * Reads a string from standard input
	 * 
	 * @return The password in string form
	 */
	public static String askForPassword() {
		Scanner scan = new Scanner(System.in);
		Print.pInsertPassword();
		scan.close();
		return scan.nextLine();
	}
	
	/**
	 * Reads a string from standard input and asks for confirmation
	 * 
	 * @return The password in string form 
	 */
	public static String askForPasswordWithConfirmation() {

		String pass1, pass2;
		Scanner scan = new Scanner(System.in);
		do{
			
			Print.pInsertPassword();
			pass1 = scan.nextLine();
			Print.pInsertPasswordConfirmation();
			pass2 = scan.nextLine();
		
		}while(pass1 != pass2);
		
		scan.close();

		return pass1;
	}
}
