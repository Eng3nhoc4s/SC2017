package client;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import auth.Passwds;
import util.Input;
import util.Print;
import config.Paths;
import network.Comms;
import network.IP;

public class myGit {

	private static Socket sock;
	private static ObjectOutputStream out;
	private static ObjectInputStream in;

	public static void main(String[] args) {

		// Check if there are sufficient arguments
		if (args.length < 2) {

			Print.pIncorrectParameters();

		} else { // There are more than two arguments

			if (args.length >= 2) {

				// Check for the -init <rep_name> clause
				if (args[0].equalsIgnoreCase("-init")) {
					String rep_name = args[1];

					// Create the directory if it doesn't exist
					File theDir = new File(Paths.REPOSITORY_PATH + File.separator + rep_name);

					if (!theDir.exists()) { // Create repo

						try {

							theDir.mkdirs();

						} catch (Exception e) {

							System.err.println(e.getMessage());

						}

						Print.pRepositoryCreatedSuccessfully(rep_name);

					} else { // Repo already exists
						Print.pRepositoryAlreadyExists(rep_name);
					}

					// Check for username and server
				} else {

					// Parse the IP Adress
					IP argsAddress = new IP(args[0]);

					if (argsAddress.isValid()) { // if IP is Valid

						// Open socket
						try {

							sock = new Socket(argsAddress.getIpAdress(), argsAddress.getPort());

						} catch (IOException e) {

							e.printStackTrace();

						}

						// Open streams
						try {

							out = new ObjectOutputStream(sock.getOutputStream());
							in = new ObjectInputStream(sock.getInputStream());

						} catch (IOException e) {

							e.printStackTrace();

						}

						String username = args[1];
						boolean isRegistered = false;

						try {

							// SEND USERNAME
							out.writeUTF(username); // << OUTCOMING

							// Receive if username is registered
							isRegistered = in.readBoolean(); 	// << 
																// INCOMING

							String password;

							if (isRegistered) { // User registered - Ask
												// password once

								password = Passwds.askForPassword();

							} else { // User not registered

								// Ask if user wants to register
								Print.pCreateNewUser();

								boolean wantsToRegister = Input.askForConfirmationYesNo();

								// SEND REGISTRY VEREDICT
								out.writeBoolean(wantsToRegister); 	// <<
																	// OUTCOMING

								if (wantsToRegister) {

									password = Passwds.askForPasswordWithConfirmation();

								} else { // Terminate Program

									Print.pClosingAllComms();
									Comms.closeAllComms(sock, out, in);

									Print.programExecutionTerminated();
									return;
								}
							}

							// SEND THE PASSWORD
							out.writeUTF(password); // << OUTCOMING

							// RECEIVE IF IS VALID
							boolean validPassword = in.readBoolean(); 	// <<
																		// INCOMING

							// ******************************************
							// MAIN PROGRAM EXECUTION
							// ******************************************

							if (validPassword) {
								// TODO: MAIN PROGRAM
							}

						} catch (IOException e) {
							e.printStackTrace();
						}

					} else { // IP OR PORT NOT VALID
						Print.pInvalidIPorPort();
						Print.programExecutionTerminated();
						return;
					}
				}
			}

		}
	}
}
