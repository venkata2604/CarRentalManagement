package model;

public class Car {
	private int carId;
	private String make;
	private String model;
	private int year;
	private String registrationNumber;
	private int numberOfSeats;
	private double pricePerDay;
	private String status;

	// Default Constructor
	public Car() {
		// TODO Auto-generated constructor stub
	}

	// Getter and Setter methods
	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Cars [carId=" + carId + ", make=" + make + ", model=" + model + ", year=" + year
				+ ", registrationNumber=" + registrationNumber + ", numberOfSeats=" + numberOfSeats + ", pricePerDay="
				+ pricePerDay + ", status=" + status + "]";
	}

}
