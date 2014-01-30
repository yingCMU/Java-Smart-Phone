package PartB;
/**
 * @author Ying Li
 * To report the make, model, color and license number of an illegally parked car.
 * Report the fine - which is $25.00 for first hour plus $10.00 for each additional hour
 * Report the name and badge number of the police officer issuing the ticket.
 */
public class ParkingTicket {
	private ParkedCar car = null;
	private PoliceOfficer officer = null;
	private int fine = 0;
	public ParkingTicket(ParkedCar car, PoliceOfficer officer,int fine) {
		this.setCar(car);
		this.setOfficer(officer);
		this.fine = fine;
	}
	/*
	 * calculate fine
	 * $25.00 for first hour plus $10.00 for each additional hour
	 
	private void fine(String license,ParkingMeter meter){
		if(car == null)
			return;
		int dif = car.getMinutes()-meter.lookup(license);
		if(dif <=0)
			return;
		else if(dif <=60)
			fine = 25;
		else
			fine = 25 + (dif-60)/60*10;
	}*/
	public void reportFine(){
		if(this.car == null){
			System.out.println("no car set for this ticket");
			return;
		}
		System.out.println("fine is "+fine +" for "+this.car.getMinutes()+" minutes");
	}
	
	public void reportCar(){
		if(this.car == null){
			System.out.println("no car set for this ticket");
			return;
		}
		System.out.println("parkedcar : color "+car.getColor()+
				"\tmake: "+car.getMake()
				+"\tmodel: "+car.getModel());
	}
	public void reportOfficer(){
		if(this.officer == null){
			System.out.println("no officer set for this ticket");
			return;
		}
		System.out.println("officer is "+officer.getName()+" with badge "+officer.getBadge());
	}
	public PoliceOfficer getOfficer() {
		return officer;
	}
	public void setOfficer(PoliceOfficer officer) {
		this.officer = officer;
	}
	public ParkedCar getCar() {
		return car;
	}
	public void setCar(ParkedCar car) {
		this.car = car;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}

}
