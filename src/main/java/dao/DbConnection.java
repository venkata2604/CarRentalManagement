package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static String jdbcURL = "jdbc:mysql://localhost:3306/car_rental?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String dbUsername = "root";
	private static String dbPassword = "1234";

//	private static final String INSERT_USERS_SQL = "INSERT INTO users"
//			+ "  (username, password, email, firstName,  lastName) VALUES " + " (?, ?, ?, ?, ?);";
//
//	private static final String SELECT_USER_BY_ID = "select username ,email, firstName, lastName, email from users where username =?";
//	private static final String SELECT_ALL_USERS = "select * from users";
//	private static final String DELETE_USERS_SQL = "delete from users where username = ?;";
//	private static final String UPDATE_USERS_SQL = "update users set username = ?, password = ?, firstName = ?, lastName = ?, email= ? where id = ?;";

	
	
	public static Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);
			System.out.println("connection from Db Class: "+connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public static void main(String[] args) {
//		DbConnection conn = new DbConnection();
		System.out.println(DbConnection.getConnection());
	}
}
