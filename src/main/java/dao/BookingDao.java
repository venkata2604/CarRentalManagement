package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bookings;
import model.Car;
import model.User;

public class BookingDao {

	public static final String SELECT_A_BOOKING_BY_ID = "SELECT * FROM bookings where bookingid =?";
	
	private static final String INSERT_BOOKINGS_SQL = "INSERT INTO bookings"
			+ "  (userid, carid, startdate, enddate,  totalprice, status) VALUES " + " (?, ?, ?, ?, ?, ?);";
	public static final String SELECT_ALL_BOOKINGS = "SELECT * FROM bookings";
	public static final String UPDATE_A_BOOKING = "UPDATE bookings SET startdate=?, enddate=? WHERE bookingid = ?";
	
	public static final String SELECT_LATEST_BOOKING = "SELECT * FROM bookings ORDER BY bookingtimestamp DESC LIMIT 1";
	private static final String DELETE_BOOKING_SQL = "delete from bookings where bookingid = ?;";

	public static Bookings selectBooking(int bookingId) {

		Bookings booking = new Bookings();
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_A_BOOKING_BY_ID);) {
			preparedStatement.setInt(1, bookingId);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
//				int bookingId = rs.getInt("bookingId");
				int userid = rs.getInt("userid");
				int carid = rs.getInt("carid");
				String startDate = rs.getString("startDate");
				String endDate = rs.getString("endDate");
				double totalPrice = rs.getDouble("totalPrice");
				String Status = rs.getString("status");
				String bookingTimeStamp = rs.getString("bookingtimestamp");

				booking.setBookingId(bookingId);
				booking.setUserId(userid);
				booking.setCarId(carid);
				booking.setStartDate(startDate);
				booking.setEndDate(endDate);
				booking.setTotalPrice(totalPrice);
				booking.setStatus(Status);
				booking.setBookingTimeStamp(bookingTimeStamp);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booking;

	}
	
	
	public static boolean insertBooking(Bookings booking) throws SQLException {
		boolean bookingInserSuccessful = false;
		
		System.out.println(INSERT_BOOKINGS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKINGS_SQL)) {
			preparedStatement.setInt(1, booking.getUserId());
			preparedStatement.setInt(2, booking.getCarId());
			preparedStatement.setString(3, booking.getStartDate());
			preparedStatement.setString(4, booking.getEndDate());
			preparedStatement.setDouble(5, booking.getTotalPrice());
			preparedStatement.setString(6, booking.getStatus());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			bookingInserSuccessful = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bookingInserSuccessful;
	}

	public static List<Bookings> selectAllBookings() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Bookings> bookings = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = DbConnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKINGS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Bookings booking = new Bookings();

				int bookingId = rs.getInt("bookingId");
				int userid = rs.getInt("userid");
				int carid = rs.getInt("carid");
				String startDate = rs.getString("startDate");
				String endDate = rs.getString("endDate");
				double totalPrice = rs.getDouble("totalPrice");
				String Status = rs.getString("status");
				String bookingTimeStamp = rs.getString("bookingtimestamp");

				booking.setBookingId(bookingId);
				booking.setUserId(userid);
				booking.setCarId(carid);
				booking.setStartDate(startDate);
				booking.setEndDate(endDate);
				booking.setTotalPrice(totalPrice);
				booking.setStatus(Status);
				booking.setBookingTimeStamp(bookingTimeStamp);

				bookings.add(booking);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookings;
	}

	public static boolean updateBookingStatus(Bookings booking) throws SQLException {

		boolean bookingUpdated = false;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_A_BOOKING)) {
			System.out.println(preparedStatement);

			preparedStatement.setString(1, booking.getStartDate());
			preparedStatement.setString(2, booking.getEndDate());
			preparedStatement.setInt(3,  booking.getBookingId());
			bookingUpdated = preparedStatement.executeUpdate() > 0;

		}

		return bookingUpdated;
	}
	
	public static Bookings latestBooking() throws SQLException{
		Bookings booking = new Bookings();
		
		try (Connection connection = DbConnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LATEST_BOOKING);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				booking = new Bookings();

				int bookingId = rs.getInt("bookingId");
				int userid = rs.getInt("userid");
				int carid = rs.getInt("carid");
				String startDate = rs.getString("startDate");
				String endDate = rs.getString("endDate");
				double totalPrice = rs.getDouble("totalPrice");
				String Status = rs.getString("status");
				String bookingTimeStamp = rs.getString("bookingtimestamp");

				booking.setBookingId(bookingId);
				booking.setUserId(userid);
				booking.setCarId(carid);
				booking.setStartDate(startDate);
				booking.setEndDate(endDate);
				booking.setTotalPrice(totalPrice);
				booking.setStatus(Status);
				booking.setBookingTimeStamp(bookingTimeStamp);
			}
			
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return booking;
		
		
	}
	
	public static boolean deleteBooking(int bookingId) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_BOOKING_SQL);) {
			statement.setInt(1, bookingId);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public static void main(String[] args) {

		try {
			// Selection
			List<Bookings> bookings = selectAllBookings();
			for (Bookings booking : bookings) {
				System.out.println("################### car list  ##########################");
				System.out.println(booking.getBookingId());
				System.out.println(booking.getUserId());
				System.out.println(booking.getCarId());
				System.out.println(booking.getStartDate());
				System.out.println(booking.getEndDate());
				System.out.println(booking.getTotalPrice());
				System.out.println(booking.getStatus());
				System.out.println(booking.getBookingTimeStamp());
			}

			// Updating
			System.out.println("############# Update Result ##################################");
			Bookings booking = new Bookings();
			booking.setCarId(1);
			booking.setStatus("Rented");
			System.out.println(updateBookingStatus(booking));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
