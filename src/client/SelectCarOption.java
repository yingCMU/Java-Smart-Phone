package client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import project2.Adapter.BuildAuto;
import project2.exceptions.MissingChoiceException;
import project2.exceptions.MissingModelException;
import project2.exceptions.MissingOptionException;
import project2.exceptions.MissingSetException;
import project2.model.Automobile;

public class SelectCarOption {
	
	BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	Client client = null;
	public SelectCarOption(Client client){
		this.client = client;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void selectOptions(){
		listModels();
		System.out.println("please select one:");
		String model=null;
		try {
			model = stdIn.readLine();
			client.sendCMD(model);
			Object fromServer= client.ois.readObject();
			Automobile auto=(Automobile)fromServer;
			auto.print();
			auto.SetChoice();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.exit(1);
			e.printStackTrace();
		}
		 catch(ClassCastException e){
			 System.err.println("model not found->"+model);
				
		 }
	}
	@SuppressWarnings("unchecked")
	public void listModels(){
		if(!client.connected) {
			return;
		}

		
			client.sendCMD("1b");
		
		ArrayList<String> fromServer;
		try {
			System.out.println("Wating for relay...");
			fromServer = (ArrayList<String>)client.ois.readObject();
			for(String each:fromServer)
			System.out.println("Server has: "+each );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
		
}
