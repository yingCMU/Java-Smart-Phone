package PartB;

import java.util.HashMap;

/**
 * @author Ying Li
 * This class should simulate a parking meter. This class's only responsibility is as follows:
 * To know the number of minutes of parking time that has been purchased.
 */
public class ParkingMeter {
	/* number of minutes of parking time that has been purchased*/
	private  HashMap<String,Integer> purchased = null;
	public ParkingMeter(){
		purchased= new HashMap<String,Integer>();
		
	}
	
	public  HashMap<String,Integer> getPurchased() {
		return purchased;
	}
	
	/*
	 * lookup minutes purchased
	 */
	public  int lookup(String license){
		if(!purchased.containsKey(license))
			return 0;
		return purchased.get(license);
	}
	/*
	 * purchase some minutes
	 */
	public  void buy(String license, int min){
		if(min <=0 )
			purchased.put(license, 0);
		purchased.put(license, min);
		
	}
	
}
