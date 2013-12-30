package PartA;

public class Coin {

	/**
	 * @param args
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
	public static void main(String[] args) {
		/*
		 *  create an instance of the class and display the 
		 *  side that is initially facing up
		 */
		Coin myCoin = new Coin();
		System.out.println("----------- initializing ---------");
		System.out.println("coin sideup initialized as "+myCoin.getSideUp());
		/*
		 * use the a loop to toss the coin 20 times. Each time the coin 
		 * is tossed, display the side that is facing up;
		 * The program should keep count of the number of times heads is 
		 * facing up and the number of times the tails is facing up, 
		 * and display those values after the loop finishes
		 */
		int heads = 0, tails = 0;
		System.out.println("------ tossing 20 times---------");
		for(int i=0; i <20; i++){
			myCoin.toss();
			System.out.println("coin sideup is "+myCoin.getSideUp());
			if(myCoin.getSideUp().equals("heads"))
				heads++;
			else
				tails++;
				
		}
		System.out.println("------ tossing end---------");
		System.out.println("heads: "+ heads+"\ttails: "+tails);
	}

}
