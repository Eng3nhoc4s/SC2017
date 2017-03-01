package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Comms {

	/**
	 * Closes all comms
	 * 
	 * @param sock
	 *            Comm socket
	 * @param out
	 *            Comm output stream
	 * @param in
	 *            Comm input stream
	 */
	public static void closeAllComms(Socket sock, ObjectOutputStream out, ObjectInputStream in) {

		try {
			out.close();
			in.close();
			sock.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}
