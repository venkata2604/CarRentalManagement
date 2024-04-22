package model;

public class User {
	private int userId;
	private String username;
	private String password;
	private String email;
	private String role;
	private String registrationDate;
	private String firstName;
	private String LastName;
	private String MiddleName;

	// Default Constructor
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username2, String email2, String firstName2, String lastName2) {
		// TODO Auto-generated constructor stub
	}

	public User(String username2, String email2, String email3, String firstName2, String lastName2) {
		// TODO Auto-generated constructor stub
	}

	// Get and Set methods
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}

}
