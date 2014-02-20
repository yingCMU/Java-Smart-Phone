package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import project2.Adapter.BuildAuto;
import project2.exceptions.MissingModelException;
import project2.model.Automobile;

public class ClientThread implements Runnable{
	Socket clientSocket;
	ObjectOutputStream oos ;
	ObjectInputStream ois;

	public ClientThread(Socket clientSocket) {
		this.clientSocket = clientSocket;
		try {
			this.oos =  new ObjectOutputStream(clientSocket.getOutputStream());
			this.ois=  new ObjectInputStream(clientSocket.getInputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void run() {
		
		System.out.println("creating thread for client");
		
			try {
				System.out.println("@@@@@@@@@\nwaiting to cmd");
				String cmd = (String)ois.readObject();
				System.out.println("cmd is "+cmd);
				if(cmd.equals("1a")) {
					makeModel();
				}
	
				else {
					System.out.println("!!!!!!\n\nrecving "+cmd);;
					selectAndConfig( );
				}
	
			//i++;	
			}catch(Exception e) {
				e.getStackTrace();
				try {
					clientSocket.close();
				} catch (Exception ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				}
			}
			/*
			finally{
				try {
					clientSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
		
		
	}

	public void makeModel( ) {
		BuildCarModelOptions buildCarModelOptions = new BuildCarModelOptions();
		try {
			System.out.println("here");
			Properties props = (Properties) ois.readObject();
			//System.out.println(props.getProperty("Make"));
			Automobile auto = buildCarModelOptions.createForClient(props);
			
			oos.writeObject(auto);
			
			//carCRUD.putAutomotive(buildCarModelOptions.receiveFromMake(clientSocket, oos, ois));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void selectAndConfig(){
		BuildAuto ba = new BuildAuto();
		ArrayList<String> models = ba.listModels();
		System.out.println("e.g. model-> \n\n\n"+models.get(0));
		try {
			oos.writeObject(models);
			String model = (String)ois.readObject();
			Automobile auto = ba.getAuto(model);
			oos.writeObject(auto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		carIO.sendAllAutomotiveNamesToUser(oos);
		String modelName = carIO.getSelectedModelNameFromUser(ois);
		System.out.println(modelName);
		carIO.sendOptionSetsToUser(modelName, oos);
		HashMap<String, String> optionChoices = carIO.getOptionChoicesFromUser(ois);
		CRUD carCRUD = (CRUD)carIO;
		carCRUD.setOptionChoices(modelName, optionChoices);
		Integer totalPrice = carCRUD.getTotalPrice(modelName);
		carIO.sendTotalPriceToUser(totalPrice, oos);*/ catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MissingModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				oos.writeObject("model not found");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
