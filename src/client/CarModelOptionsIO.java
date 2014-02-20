package client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import project2.model.Automobile;

public class CarModelOptionsIO {
	/*Socket serverSocket = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	Boolean connected = true;
*/
	Client client = null;
	public CarModelOptionsIO(Client client){
		this.client = client;
	}
	
	public void loadModelToServer(String file) {
		if(!client.connected) {
			return;
		}

		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(file));
			System.out.println("!11"+properties.getProperty("Make"));
			sendCMD("1a");
			client.oos.writeObject(properties);
			client.oos.flush();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to sent to server");
		}
		 
		Automobile fromServer;
		try {
			System.out.println("Wating for relay...");
			fromServer = (Automobile)client.ois.readObject();
			System.out.println("Server added: " + fromServer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void sendCMD(String cmd) {
		try {
			client.oos.writeObject(cmd);
			client.oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
