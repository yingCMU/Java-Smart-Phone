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


import project2.Adapter.BuildAuto;
import project2.exceptions.MissingChoiceException;
import project2.exceptions.MissingModelException;
import project2.exceptions.MissingOptionException;
import project2.exceptions.MissingSetException;
import project2.model.Automobile;

import project2.util.FileIO;
import project2.util.FileUtil;
import scale.EditOptions;



public class Driver {
	
	//Putting it altogether:
	public static void main(String [] args){
		
		/*if(args.length !=2){
			System.err.println("invalid args\n usage java Driver <inputfile> <serialization_file>");
			System.exit(0);
		}*/
		//Automobile auto = new Automobile();
		try {
			//testMultiThread();
			
			testMultiThread2();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//objectSerializae(input, serOut,auto);
		//runApp("./goodAuto");
		//runApp(auto,"./autoNoPrice");
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
	public static void testMultiThread2() throws InterruptedException{
		/*
		 * 
		 */
		String filename = "./goodAuto";
		BuildAuto ba = new BuildAuto();
		
		ba.BuildAuto(filename);
		
		String model="Ford Focus Wagon ZTW";
		String OptSet = "Transmission";
		String newSetName1 ="T1set";
		String newSetName2 ="T2set";
		String opt="automatic";
		float newprice1=10;
		float newprice2=20;
		Thread thread1 = new Thread(new EditOptions(true,ba,model,OptSet,newSetName1,opt,newprice1)); 
		thread1.start();
		Thread.sleep(3000);
		
		Thread thread2 = new Thread(new EditOptions(false,ba,model,OptSet,newSetName2,opt,newprice2)); 
		
		thread2.start();
		System.err.println("Thread2 is waiting for the lock of automobile,\n which is being held by thread 1, so thread 2 can not update the options");
		
		Thread.sleep(3000);
		ba.printAuto(model);
	}
	public static void testMultiThread() throws InterruptedException{
		/*
		 * 
		 */
		String filename = "./goodAuto";
		BuildAuto ba = new BuildAuto();
		
		ba.BuildAuto(filename);
		
		String model="Ford Focus Wagon ZTW";
		String OptSet = "Power Moonroof";
		String newSetName1 ="T1set";
		String newSetName2 ="T2set";
		String opt="selected";
		float newprice1=100;
		float newprice2=200;
		Thread thread1 = new Thread(new EditOptions(false,ba,model,OptSet,newSetName1,opt,newprice1)); 
		Thread thread2 = new Thread(new EditOptions(false,ba,model,OptSet,newSetName2,opt,newprice2)); 
		thread1.start();
		thread2.start();
		System.out.println("tread sleeping for 2 sec");
		Thread.sleep(2000);
		ba.printAuto(model);
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
		} catch (MissingChoiceException e) {
			System.err.println(e.getMessage());
			return;
		} catch (MissingOptionException e) {
			System.err.println(e.getMessage());
			return;
		}
		
	}
	

	
	

	
}