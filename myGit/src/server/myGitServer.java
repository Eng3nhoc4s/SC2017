package server;

/***************************************************************************
 *   Seguranca e Confiabilidade 2016/17
 *
 *
 ***************************************************************************/

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import network.Comms;

//Servidor myServer

public class myGitServer {

	public static void main(String[] args) {
		
		System.out.println("servidor: main");
		myGitServer server = new myGitServer();
		server.startServer();
	}

	public void startServer() {
		ServerSocket sSoc = null;

		try {

			sSoc = new ServerSocket(23456);

		} catch (IOException e) {
			
			System.err.println(e.getMessage());
			System.exit(-1);
			
		}

		while (true) {
			
			try {
				Socket inSoc = sSoc.accept();
				ServerThread newServerThread = new ServerThread(inSoc);
				newServerThread.start();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		// sSoc.close();
	}

	// Threads utilizadas para comunicacao com os clientes
	class ServerThread extends Thread {

		private Socket sock = null;

		ServerThread(Socket inSoc) {
			sock = inSoc;
			System.out.println("Thread do server para cada cliente");
		}

		public void run() {
			
			try {
				
				ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(sock.getInputStream());

				String user = null;
				String passwd = null;

				//READ THE USERNAME
				user = in.readUTF();
				
				//CHECK IF IS REGISTERED
				boolean isRegisteredForDEBUG = true;
				
				//SEND ANSWER FOR REGISTRY
				out.writeBoolean(isRegisteredForDEBUG);
				
				//TODO WRITE AND READ CREDENTIALS FILE
				boolean wantsToRegister = false;
				
				//Check if unregistered user wants to register
				if(!isRegisteredForDEBUG){
					
					//READ IF USER WANTS TO REGISTER
					wantsToRegister = in.readBoolean();
					
					//if user doesn't want to register, stop
					if(!wantsToRegister){
						Comms.closeAllComms(sock, out, in);
					}
				}

				//RECEIVE THE PASSWORD
				passwd = in.readUTF();
				
				//SEND IF PASSWORD IS VALID
				//TODO WRITE AND READ CREDENTIALS FILE
				boolean isValidPassword = true;
				
				out.writeBoolean(isValidPassword);
				

			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
		}
	}
}