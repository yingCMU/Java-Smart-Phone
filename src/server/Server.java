package server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class Server {

	//static IO carIO = new BuildAuto();
	//static CRUD carCRUD = (CRUD) carIO;
	Socket clientSocket = null;

	public Server(Socket clientSocket){
		this.clientSocket = clientSocket;
	}

	public static void main(String[] args)  {

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5445);
			Socket clientSocket = null;
			while (true) {
				try {
					System.out.println("Listening...");
					clientSocket = serverSocket.accept();
				} catch (IOException e) {
					System.err.println("Accept failed");
					System.exit(1);
				}
				ClientThread client = new ClientThread(clientSocket);
				new Thread(client).start();;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

	

}