package PartB;
/**
 * @author Ying Li
 * To know the name and badge number
 * To examine a parked car and parking meter object and determine whether the car's time has expired.
 * To issue a parking ticket if the car time has expired. 
 */
public class PoliceOfficer {
	private String name;
	private String badge;
	public PoliceOfficer(String name, String badge){
		this.name = name;
		this.badge = badge;
	}
	
	/*
	 * To examine a parked car and parking meter object and determine whether the car's time has expired.
     * calculate fine
	 * $25.00 for first hour plus $10.00 for each additional hour
	 * @param 
	 * @return fine value as integer
	 */
	public int examine(ParkedCar car, ParkingMeter meter){
		if(car == null)
			return 0;
		int dif = car.getMinutes()-meter.lookup(car.getLicense());
		if(dif <=0)
			return 0;
		else if(dif <=60)
			return 25;
		else{
			return 25 + (dif-60)/60*10+((dif-60)%60==0?0:10);
		}
	}
	public ParkingTicket issueTicket(ParkedCar car, int fine){
		if(fine < 0){
			System.out.println("invalid fine value as "+fine);
			return null;
		}
			
		return new ParkingTicket(car, this, fine);
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBadge() {
		return badge;
	}
	public void setBadge(String badge) {
		this.badge = badge;
	}
	
}
