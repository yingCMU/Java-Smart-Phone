package PartA.Tests;

import PartA.Coin;
import PartA.Simulation;

public class Test {

	/**
	 * Coin test driver class which calls Simulation class
	 */
public static void main(String[] args) {
		Coin myCoin = new Coin();
		Simulation sim = new Simulation(myCoin);
		System.out.println("------ tossing 20 times---------");
		for(int i=0; i <20; i++){
			
			sim.toss(myCoin);	
		}
		System.out.println("------ tossing end---------");
		sim.statistics();
		}
}
