package PartA;

public class Coin {

	/**
	 * @author Ying Li
	 
	 */
	/*
	 * The sideUp field will hold either "heads" or "tails"  
	 */
	private String sideUp;
	/*
	 * A no-arg constructor that randomly determines the side of the
	 *  coin that is facing up ("heads" or "tails") 
	 * and initializes the sideUp field accordingly.
	 */
	public Coin(){
		if(Math.random() >=0.5)
			sideUp = "heads";
		else
			sideUp = "tails";
	}
	/*
	 * A void method named toss that simulates the tossing of a coin. 
	 * When the toss method is called, it randomly determines the side 
	 * of the coin that is facing up ("heads" or "tails") and set the 
	 * sideUp field accordingly.
	 */
	public void toss(){
		if(Math.random() >=0.5)
			sideUp = "heads";
		else
			sideUp = "tails";
	}
	/*
	 * A method named getSideUp that return the value of 
	 * the sideUp field
	 */
	public String getSideUp(){
		return sideUp;
	}
	
}
