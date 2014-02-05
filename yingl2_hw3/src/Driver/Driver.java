package Driver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;


import Project.Model.Automotive;
import Project.Util.FileIO;
import Project.Util.FileUtil;

public class Driver {

	//Putting it altogether:
	public static void main(String [] args){
		//String serOut= "./auto.data";
		if(args.length !=2){
			System.err.println("invalid args\n usage java Driver <inputfile> <serialization_file>");
			System.exit(0);
		}
		String input = args[0];
		//String input  ="./config" ;
		String serOut = args[1];
		Automotive auto = new Automotive();
		 
		objectSerializae(input, serOut,auto);
		runApp(auto);
	}

	public static void usage(Constant errCode) {
		switch (errCode) {
		case INVALID_USAGE:
		default:
			System.out.println("Usage: java CommunicationInfra <config file> <host name> \n");
			break;
		case INVALID_CONFIG_FILE:
			System.out.println("Configuration file is invalid or incorrectly specified. \n");
			break;
		case INVALID_CONFIG_PARAMS:
			System.out.println("Configuration file has invalid parameters please revisit it. \n");
		}
		System.exit(-1);
	}
	public static void objectSerializae(String input,String serOut,Automotive auto ){
		try{
		
		//Build Automobile Object from a file
		
		
		new FileUtil().buildAutoObject(input,auto);
		//Print attributes before serialization
		System.out.println("#####print attributes before serialization#####\n");
		auto.print();
		FileIO.serializeAuto(auto, serOut);
		
		//Deserialize the object and read it into memory.
		Automotive newFordZTW = FileIO.DeserializeAuto(serOut);
		System.out.println("\n\n#####printing deserialized attributes####\n");
		newFordZTW.print();
		}
		catch(Exception e){ 
			System.out.print("Error: " + e);
			System.exit(1);
		}
	}
	public static void runApp(Automotive auto) {
		String input;
		BufferedReader inputReader = null;

		inputReader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.println("\n***********interaction console***********");
				System.out.println("to update, add or delete an option: \n" +
						"(1) update <optionSet> <optionName> <optionValue> or \n" +
						"(2) add <optionSet> <optionName> <optionValue> or\n" +
						"(2) delete <optionSet> <optionName> "+
						"(4) (Qq)uit");
				System.out.print("$>");
				input = inputReader.readLine();
				parseCommand(input,auto);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}

	
	public static void parseCommand(String input,Automotive auto) {
		if (input == null) {
			return;
		}
		int price=0;
		String tokens[] = input.trim().split(" ");
		if (tokens[0].equalsIgnoreCase("Q")) {
			System.out.println("Exiting...\n");
			System.exit(0);
		}
		if(tokens.length >= 4){
			try{
				price= Integer.parseInt(tokens[3]);
				}
				catch( NumberFormatException e){
					
					System.err.println("Error: invalid value of price, should be a number ");
					return;
				}
		}
		if (tokens[0].equalsIgnoreCase("update") && tokens.length >= 4) 
			auto.updateOpt(tokens[1], tokens[2], price);

			//StringBuilder msg = new StringBuilder();
		else if (tokens[0].equalsIgnoreCase("add") && tokens.length >= 4) 
			auto.addOpt(tokens[1], tokens[2], price);
		else if (tokens[0].equalsIgnoreCase("delete") && tokens.length >= 3) 
			auto.deleteOpt(tokens[1], tokens[2]);

			
		
		 
		System.out.println("\n\n****** after your update");
		auto.print();
	}

	public enum Constant {
		INVALID_USAGE,INVALID_CONFIG_FILE ,
		INVALID_CONFIG_PARAMS ,CONFIG_PARAMS 
	}
}