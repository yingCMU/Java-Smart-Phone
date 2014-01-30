package PartB.Tests;

import PartB.ParkedCar;
import PartB.ParkingMeter;
import PartB.ParkingTicket;
import PartB.PoliceOfficer;

public class Test {
	/**
	 * @author Ying Li
	 */
	static ParkingMeter meter = new ParkingMeter();
	
	public static void main(String[] args) {
		PoliceOfficer officer = new PoliceOfficer("Jim","12345");
		ParkedCar car = new ParkedCar("Toyoto", "Camery", "White", "123abc");
		/*purchase 90 min*/
		meter.buy(car.getLicense(), 90);
		/*
		 * Ticketing under 1 hour and more than 1 hour test cases.
		 */
		testOneHourTicket(car,officer);
		testTwoHourTicket(car,officer);
		testThreeHourTicket(car,officer);
		/*
		 *  ParkedVehicle is with in, out of and just in the parking time purchased.
		 */
		testWithin(car,officer);
		testOutof(car,officer);
		testJustIn(car,officer);
		
		/*
		 * boundary cases
		 */
		
		testNullCar(null,officer);
		testMinusMinutes(car,officer);
		
		
	}
	private static void testThreeHourTicket(ParkedCar car, PoliceOfficer officer) {
		car.setMinutes(179+90);
		System.out.println("test Three Hour Ticket: ");
		int fine = officer.examine(car, meter);
		if(fine>0){
		ParkingTicket tik = officer.issueTicket(car, fine);
		tik.reportFine();
		tik.reportCar();
		tik.reportOfficer();
		}
		else
			System.out.println("no ticket issued");
		System.out.println("--------------");
	}
	public static void testNullCar(ParkedCar car,PoliceOfficer officer){
		
		int fine = officer.examine(car, meter);
		System.out.println("test null car: ");
		if(fine>0){
			ParkingTicket tik = officer.issueTicket(car, fine);
			tik.reportFine();
			tik.reportCar();
			tik.reportOfficer();
			}
		else
			System.out.println("no ticket issued");
		System.out.println("--------------");
	}
	/*
	 * when car minutes is minus
	 */
	public static void testMinusMinutes(ParkedCar car,PoliceOfficer officer){
		car.setMinutes(-80);
		System.out.println("test minus minutes: ");
		int fine = officer.examine(car, meter);
		if(fine>0){
		ParkingTicket tik = officer.issueTicket(car, fine);
		tik.reportFine();
		tik.reportCar();
		tik.reportOfficer();
		}
		else
			System.out.println("no ticket issued");
		System.out.println("--------------");
	}
	
	public static void testWithin(ParkedCar car,PoliceOfficer officer){
		car.setMinutes(80);
		int fine = officer.examine(car, meter);
		System.out.println("test within purchase hour: ");
		if(fine>0){
			ParkingTicket tik = officer.issueTicket(car, fine);
			tik.reportFine();
			tik.reportCar();
			tik.reportOfficer();
			}
		else
			System.out.println("no ticket issued");
		System.out.println("--------------");
	}
	
	public static void testOutof(ParkedCar car,PoliceOfficer officer){
		car.setMinutes(100);
		int fine = officer.examine(car, meter);
		System.out.println("test out of purchase hour: ");
		if(fine>0){
			ParkingTicket tik = officer.issueTicket(car, fine);
			tik.reportFine();
			tik.reportCar();
			tik.reportOfficer();
			}
		else
			System.out.println("no ticket issued");
		System.out.println("--------------");
	}
	public static void testJustIn(ParkedCar car,PoliceOfficer officer){
		car.setMinutes(90);
		int fine = officer.examine(car, meter);
		System.out.println("test just in purchase hour: ");
		if(fine>0){
			ParkingTicket tik = officer.issueTicket(car, fine);
			tik.reportFine();
			tik.reportCar();
			tik.reportOfficer();
			}
		else
			System.out.println("no ticket issued");
		System.out.println("--------------");
	}
	public static void testOneHourTicket(ParkedCar car,PoliceOfficer officer){
		car.setMinutes(150);
		int fine = officer.examine(car, meter);
		System.out.println("test One Hour Ticket: ");
		if(fine>0){
			ParkingTicket tik = officer.issueTicket(car, fine);
			tik.reportFine();
			tik.reportCar();
			tik.reportOfficer();
			}
		else
			System.out.println("no ticket issued");
		System.out.println("--------------");
	}
	public static void testTwoHourTicket(ParkedCar car,PoliceOfficer officer){
		car.setMinutes(151);
		int fine = officer.examine(car, meter);
		System.out.println("test Two Hour Ticket: ");
		if(fine>0){
			ParkingTicket tik = officer.issueTicket(car, fine);
			tik.reportFine();
			tik.reportCar();
			tik.reportOfficer();
			}
		else
			System.out.println("no ticket issued");
		System.out.println("--------------");
	}

}
