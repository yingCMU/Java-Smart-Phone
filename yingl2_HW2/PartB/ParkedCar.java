package PartB;

public class ParkedCar {
	

	/**
	 * @author Ying Li
	 * Class - ParkedCar has the following responsibilities:
     * the car's make, model, color, license number and number 
     * of minutes the car has been parked.
     * 
	 */
	private String make;
	private String model;
	private String color;
	private String license;
	private int minutes;//minutes already parked
	public ParkedCar(String make, String model, String color, String license){
		this.make = make;
		this.model = model;
		this.color = color;
		this.license = license;
		
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}

}
