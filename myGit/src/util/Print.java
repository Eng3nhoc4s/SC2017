package util;

public class Print {

	/**
	 * Client's usage parameters
	 */
	public static void pClientUsage() {
		System.out.println("myGit usage: ");
		System.out.println("myGit -init <rep_name>");
		System.out.println("myGit <localUser> <serverAddress> [ -p <password> ]");
		System.out.println("myGit <localUser> <serverAddress> [ -p <password> ] -push <rep_name | file_name>");
		System.out.println("myGit <localUser> <serverAddress> [ -p <password> ] -pull <rep_name | file_name>");
		System.out.println("myGit <localUser> <serverAddress> [ -p <password> ] -share <rep_name> <userId>");
		System.out.println("myGit <localUser> <serverAddress> [ -p <password> ] -remove <rep_name> <userId>");
		System.out.println("\nWHERE");
		System.out.println("\t-init - Creates a local repository");
		System.out.println("\tlocalUser - The username");
		System.out.println("\tserverAdress - Server ip in ip:port format");
	}
	
	/**
	 * Closing all comms
	 */
	public static void pClosingAllComms(){
		System.out.println("Closing all communications...");
	}

	/**
	 * Confirm your password
	 */
	public static void pConfirmPassword() {
		System.out.println("Confirm your password: ");
	}
	
	/**
	 * Confirmation Yes or No
	 */
	public static void pConfirmationYesNo(){
		System.out.println("Write Y for Yes or N for No");
	}

	/**
	 * Create new user
	 */
	public static void pCreateNewUser() {
		System.out.println("This username is not registered. Do you wish to register?");
	}

	/**
	 * Incorrect parameters
	 */
	public static void pIncorrectParameters() {
		System.out.println("Incorrect parameters!");
	}

	/**
	 * Incorrect Password
	 */
	public static void pIncorrectPassword() {
		System.out.println("Your password doesn't match the one registered to this account");
	}

	/**
	 * Insert your password
	 */
	public static void pInsertPassword() {
		System.out.println("Insert your password:");
	}
	
	/**
	 * Insert your password
	 */
	public static void pInsertPasswordConfirmation() {
		System.out.println("Insert password confirmation:");
	}

	/**
	 * Invalid choice
	 */
	public static void pInvalidChoice(){
		System.out.println("Invalid choice, please try again.");
	}
	
	/**
	 * Invalid credentials
	 */
	public static void pInvalidCredentials() {
		System.out.println("The credentials provided are incorrect!");
	}
	
	/**
	 * Invalid Ip or Port
	 */
	public static void pInvalidIPorPort(){
		System.out.println("Invalid IP Adress or Port! Make sure you inserted the adress with ip:port and the port is bigger than 0 and lower or equal to 65535");
	}
	
	/**
	 * Program execution terminated
	 */
	public static void programExecutionTerminated() {
		System.out.println("Program execution terminated.");
	}
	
	/**
	 * Repository already exists
	 */
	public static void pRepositoryAlreadyExists(String rep_name) {
		System.out.println("Repository " + rep_name + " already exists!");
	}

	/**
	 * Repository created successfully
	 * @param rep_name The repository name
	 */
	public static void pRepositoryCreatedSuccessfully(String rep_name) {
		System.out.println("Repository " + rep_name + " created Successfully!");
	}

	/**
	 * Server's usage parameters
	 */
	public static void pServerUsage() {
		// TODO
	}

	/**
	 * Program execution terminated
	 */
	public static void endOfProgram() {
		System.out.println("Program execution terminated.");
	}

}
