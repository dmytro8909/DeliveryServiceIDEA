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
	public static final String GET_SORTED_ORDERS_BY_COST =
			"SELECT * FROM `orders` ORDER BY `cost` ASC";
	public static final String GET_SORTED_ORDERS_BY_SHIPPING_DATE =
			"SELECT * FROM `orders` ORDER BY `shipping_date` ASC";
	public static final String GET_ALL_BILLS = "SELECT * FROM `bills`";
	public static final String GET_RATE_BY_NAME =
			"SELECT * FROM `rates` WHERE `name`=?";
	public static final String GET_USER_BY_ID =
			"SELECT * FROM `users` WHERE `user_id`=?";
	public static final String GET_BILL_BY_ID =
			"SELECT * FROM `bills` WHERE `bill_id`=?";
	public static final String GET_RATE_BY_ID =
			"SELECT * FROM `rates` WHERE `rates_id`=?";
	public static final String GET_BILL_BY_ORDER_ID =
			"SELECT * FROM `bills` WHERE `orders_order_id`=?";
	public static final String GET_USER_ORDERS =
			"SELECT * FROM `orders` WHERE `users_user_id`=?";
	public static final String GET_SORTED_USER_ORDERS_BY_COST =
			"SELECT * FROM `orders` WHERE `users_user_id`=? ORDER BY `cost` ASC";
	public static final String GET_SORTED_USER_ORDERS_BY_SHIPPING_DATE =
			"SELECT * FROM `orders` WHERE `users_user_id`=? ORDER BY `shipping_date` ASC";
	public static final String GET_DISTANCE_BY_ID =
			"SELECT * FROM `directions` WHERE `direction_id`=?";
	public static final String GET_DIRECTION_BY_ID =
			"SELECT * FROM `directions` WHERE `direction_id`=?";
	public static final String GET_ORDER_BY_ID =
			"SELECT * FROM `orders` WHERE `order_id`=?";
	public static final String INSERT_USER =
			"INSERT INTO `users` (`name`,`last_name`,`login`,`password`) " +
					"VALUES (?,?,?,?)";
	public static final String INSERT_ORDER =
			"INSERT INTO `orders` (`description`, `address`, `shipping_date`, " +
					"`cost`, `users_user_id`, `directions_direction_id`) " +
					"VALUES (?,?,?,?,?,?)";
	public static final String INSERT_BILL =
			"INSERT INTO `bills` (`orders_order_id`,`orders_users_user_id`," +
								 "`orders_directions_direction_id`," +
								 "`order_description`,`order_address`," +
								 "`order_direction`,`order_cost`, " +
								 "`order_shipping_date`,`order_user_name`)" +
					"VALUES (?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_STATUS_ON_PAID =
			"UPDATE `bills` SET `status`='paid' WHERE `bill_id`=?";
}
