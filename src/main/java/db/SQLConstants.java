package db;

public class SQLConstants {
	public static final String FIND_MANAGER_LOGIN = 
			"SELECT `login` FROM `users` WHERE `role`='manager'";
	public static final String FIND_MANAGER_PASSWORD = 
			"SELECT `password` FROM `users` WHERE `role`='manager'";
	public static final String SQL_FIND_USER_BY_LOGIN =
			"SELECT * FROM `users` WHERE `login`=?";
	public static final String GET_ALL_USERS =
			"SELECT * FROM `users`";
	public static final String GET_ALL_DIRECTIONS = "SELECT * FROM `directions`";
	public static final String GET_ALL_RATES = "SELECT * FROM `directions`";
	public static final String GET_ALL_ORDERS = "SELECT * FROM `orders`";
	public static final String GET_RATE_BY_NAME = "SELECT * FROM `rates` WHERE `name`=?";
	public static final String INSERT_USER =
			"INSERT INTO `users` (`name`,`last_name`,`login`,`password`) VALUES (?,?,?,?)";
}
