package utils;

import dao.UserDao;
import model.User;

public class DaoUtils {

	public static boolean isUserExists(String username) {
		boolean userExists = false;
//		UserDao userdao = new UserDao();
		User user = UserDao.selectUser(username);
		System.out.println("user: "+ user);
		

		if (user != null) {
			userExists = true;
		}
		return userExists;
	}
	
	
	public static void main(String[] main) {
		System.out.println(isUserExists("usernamedao"));
	}

}
