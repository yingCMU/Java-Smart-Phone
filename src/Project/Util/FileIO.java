package Project.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Project.Model.Automotive;

public class FileIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void serializeAuto(Automotive FordZTW,String serOut){
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream(serOut));
			out.writeObject(FordZTW);
			out.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Error: can not find serialization out path-"+serOut);
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error: IOException "+e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	public static Automotive DeserializeAuto(String serOut){
		Automotive autoRead = null;
	try {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(serOut));
		
		autoRead = (Automotive) in.readObject();
	} catch (ClassNotFoundException e) {
		System.err.println("Error: "+e.getMessage());
		//e.printStackTrace();
		System.exit(0);
	} catch (IOException e) {
		System.err.println("Error: "+e.getMessage());
		//e.printStackTrace();
		System.exit(0);
	}
	return autoRead;
	
	}
}
