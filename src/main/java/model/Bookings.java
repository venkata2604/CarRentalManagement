package model;

public class Bookings {
	private int bookingId;
	private int userId;
	private int carId;
	private String startDate;
	private String endDate;
	private double totalPrice;
	private String status;
	private String bookingTimeStamp;

	// Default Constructor
	public Bookings() {
		// TODO Auto-generated constructor stub
	}

	// Get and Set methods
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBookingTimeStamp() {
		return bookingTimeStamp;
	}

	public void setBookingTimeStamp(String bookingTimeStamp) {
		this.bookingTimeStamp = bookingTimeStamp;
	}

}
