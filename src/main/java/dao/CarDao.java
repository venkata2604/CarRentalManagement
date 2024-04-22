package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Car;

public class CarDao {

	public static final String SELECT_A_CAR_BY_ID = "SELECT * FROM cars where carid =?";
	public static final String SELECT_ALL_CARS = "SELECT * FROM cars";
	public static final String UPDATE_A_CAR_STATUS = "UPDATE cars SET STATUS =? where carid = ?";

	public static Car selectCar(int carId) {

		Car car = new Car();
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_A_CAR_BY_ID);) {
			preparedStatement.setInt(1, carId);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
//				int carId = rs.getInt("carId");
				String make = rs.getString("make");
				String model = rs.getString("model");
				int year = rs.getInt("year");
				String registrationNumber = rs.getString("registrationnumber");
				int numberOfSeats = rs.getInt("numberofseats");
				double pricePerDay = rs.getDouble("priceperday");
				String status = rs.getString("status");

				car.setCarId(carId);
				car.setMake(make);
				car.setModel(model);
				car.setYear(year);
				car.setRegistrationNumber(registrationNumber);
				car.setNumberOfSeats(numberOfSeats);
				car.setPricePerDay(pricePerDay);
				car.setStatus(status);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return car;

	}

	public static List<Car> selectAllCars() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Car> cars = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = DbConnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CARS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Car car = new Car();

				int carId = rs.getInt("carId");
				String make = rs.getString("make");
				String model = rs.getString("model");
				int year = rs.getInt("year");
				String registrationNumber = rs.getString("registrationnumber");
				int numberOfSeats = rs.getInt("numberofseats");
				double pricePerDay = rs.getDouble("priceperday");
				String status = rs.getString("status");

				car.setCarId(carId);
				car.setMake(make);
				car.setModel(model);
				car.setYear(year);
				car.setRegistrationNumber(registrationNumber);
				car.setNumberOfSeats(numberOfSeats);
				car.setPricePerDay(pricePerDay);
				car.setStatus(status);

				cars.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}

	public static boolean updateCarStatus(Car car) throws SQLException {

		boolean carUpdated = false;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_A_CAR_STATUS)) {
			car.setStatus("Rented");
			preparedStatement.setString(1, car.getStatus());
			preparedStatement.setInt(2, car.getCarId());
			carUpdated = preparedStatement.executeUpdate() > 0;

		}

		return carUpdated;
	}

	public static void main(String[] args) {

		try {
			// Selection
			List<Car> cars = selectAllCars();
			for (Car carEach : cars) {
				System.out.println("################### car list  ##########################");
				System.out.println(carEach.getCarId());
				System.out.println(carEach.getMake());
				System.out.println(carEach.getModel());
				System.out.println(carEach.getNumberOfSeats());
				System.out.println(carEach.getPricePerDay());
				System.out.println(carEach.getRegistrationNumber());
				System.out.println(carEach.getStatus());
				System.out.println(carEach.getYear());
			}

			// Updating
			System.out.println("############# Update Result ##################################");
			Car car1 = new Car();
			car1.setCarId(1);
			car1.setStatus("Rented");
			System.out.println(updateCarStatus(car1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
