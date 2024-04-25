package utils;

import dao.CarDao;
//import model.Car;

public class PriceCalculation {
	
	public static double singleDayPriceCalculation(int carId) {
//		Car car = new Car();
		double price = CarDao.selectCar(carId).getPricePerDay();
		return price;
		
		
	}

}
