package PartA;

public class Simulation {
	/**
	 * @author Ying Li
	 * program demonstrates the Coin class
	 */
		int heads = 0, tails = 0;
	public  Simulation(Coin myCoin){
		/*
		 *  create an instance of the class and display the 
		 *  side that is initially facing up
		 */
		
		System.out.println("----------- initializing ---------");
		System.out.println("coin sideup initialized as "+myCoin.getSideUp());

	}
	/*
	 * use the a loop to toss the coin 20 times. Each time the coin 
	 * is tossed, display the side that is facing up;
	 * The program should keep count of the number of times heads is 
	 * facing up and the number of times the tails is facing up, 
	 * 
	 */
	public void toss(Coin myCoin){
		myCoin.toss();
		System.out.println("coin sideup is "+myCoin.getSideUp());
		if(myCoin.getSideUp().equals("heads"))
			heads++;
		else
			tails++;
	}
	/*
	 * display those values after the loop finishes
	 */
	public void statistics(){
		System.out.println("heads: "+ heads+"\ttails: "+tails);
		
	}

	
	

}
