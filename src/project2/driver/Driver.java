package project2.driver;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import project2.Adapter.BuildAuto;
import project2.exceptions.MissingModelException;
import project2.exceptions.MissingOptionException;
import project2.exceptions.MissingSetException;
import project2.model.Automobile;

import project2.util.FileIO;
import project2.util.FileUtil;



public class Driver {
	
	//Putting it altogether:
	public static void main(String [] args){
		
		/*if(args.length !=2){
			System.err.println("invalid args\n usage java Driver <inputfile> <serialization_file>");
			System.exit(0);
		}*/
		//String input = args[0];
		String serOut= "./auto.data";
		String input  ="./config" ;
		//String serOut = args[1];
		Automobile auto = new Automobile();
		 
		//objectSerializae(input, serOut,auto);
		runApp(auto);
	}

	
	public static void objectSerializae(String input,String serOut,Automobile auto ){
		try{
		
		//Build Automobile Object from a file
		
		
		new FileUtil().buildAutoObject(input,auto);
		//Print attributes before serialization
		System.out.println("#####print attributes before serialization#####\n");
		auto.print();
		FileIO.serializeAuto(auto, serOut);
		
		//Deserialize the object and read it into memory.
		Automobile newFordZTW = FileIO.DeserializeAuto(serOut);
		System.out.println("\n\n#####printing deserialized attributes####\n");
		newFordZTW.print();
		}
		catch(Exception e){ 
			System.out.print("Error: " + e);
			System.exit(1);
		}
	}
	public static void runApp(Automobile auto) {
		String input;
		BufferedReader inputReader = null;
		String filename="./config";
		float price=10;
		String model="Ford Focus Wagon ZTW";
		String set= "Transmission";
		String newset="Transmission";
		String opt="automatic";
			try {
				/* build auto from file*/
				{
					
					BuildAuto ba = new BuildAuto();
					
					ba.BuildAuto(filename);
					
					}
				
				/* print auto */
				{
					BuildAuto ba = new BuildAuto();
					ba.printAuto(model);
					
				}
				{
					BuildAuto ba = new BuildAuto();
					//ba.updateOptionSetName(model,set,newset);
				}
				

					//StringBuilder msg = new StringBuilder();
				{
					BuildAuto ba = new BuildAuto();
					
					ba.updateOptionPrice(model,set, opt, price);
				
					
					//System.out.println("-m: "+cmd.getOptionValue('m')+"\n-s:"+cmd.getOptionValues("s")+"\n-o:"+cmd.getOptionValue("o")+"\n-p:"+cmd.getOptionValue("p"));
				}
				 testSetChoice("Ford Focus Wagon ZTW");
				
				
				
					
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
	
	static void testSetChoice(String model){
		BuildAuto ba = new BuildAuto();
		try{
		Automobile auto = ba.getAuto(model);
		auto.setOptionChoice("Color", "Fort Knox Gold Clearcoat Metallic");
		auto.setOptionChoice("Transmission", "standard");
		auto.setOptionChoice("Brakes/Traction Control", "ABS");
		auto.setOptionChoice("Side Impact Air Bags", "selected");
		auto.setOptionChoice("Power Moonroof", "selected");
		System.out.println("!!!!total price: "+auto.getTotalPrice());
		}
		catch(MissingModelException e){
		System.err.println(e.getMessage());
			return;
			
		} catch (MissingSetException e) {
			System.err.println(e.getMessage());
			return;
		} catch (MissingOptionException e) {
			System.err.println(e.getMessage());
			return;
		}
		
	}
	

	
	

	
}