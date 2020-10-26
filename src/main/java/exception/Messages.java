package exception;

/**
 * Class for storage error messages
 */
public class Messages {
	private Messages() {}

	// User
	public static final String ERR_CANNOT_GET_LIST_OF_USERS =
			"Cannot get a list of users from database";
	public static final String ERR_CANNOT_GET_USER =
			"Cannot get a user from database";
	public static final String ERR_CANNOT_INSERT_USER =
			"Cannot insert a user to the database";
	public static final String ERR_CANNOT_DELETE_USER =
			"Cannot delete an user from the database";

	// Bill
	public static final String ERR_CANNOT_GET_LIST_OF_BILLS =
			"Cannot get a list of bills from database";
	public static final String ERR_CANNOT_GET_BILL =
			"Cannot get a bill from the database";
	public static final String ERR_CANNOT_INSERT_BILL =
			"Cannot insert a bill to the database";
	public static final String ERR_CANNOT_UPDATE_BILL_STATUS =
			"Cannot update a bill's status in the database";
	public static final String ERR_CANNOT_DELETE_BILL =
			"Cannot delete a bill from the database";

	// Rate
	public static final String ERR_CANNOT_GET_LIST_OF_RATES =
			"Cannot get a list of rates from the database";
	public static final String ERR_CANNOT_GET_RATE =
			"Cannot get a rate from the database";
	public static final String ERR_CANNOT_DELETE_RATE =
			"Cannot delete a rate from the database";

	// Order
	public static final String ERR_CANNOT_GET_LIST_OF_ORDERS =
			"Cannot get a list of orders from database";
	public static final String ERR_CANNOT_INSERT_ORDER =
			"Cannot insert an order to the database";
	public static final String ERR_CANNOT_GET_ORDER =
			"Cannot get an order from the database";
	public static final String ERR_CANNOT_DELETE_ORDER =
			"Cannot delete an order from the database";

	// Direction
	public static final String ERR_CANNOT_GET_LIST_OF_DIRECTIONS =
			"Cannot get a list of directions from the database";
	public static final String ERR_CANNOT_GET_DIRECTION =
			"Cannot get a direction from the database";
	public static final String ERR_CANNOT_GET_DISTANCE =
			"Cannot get a distance from the database";
	public static final String ERR_CANNOT_DELETE_DIRECTION =
			"Cannot delete a direction from the database";

	// General
	public static final String ERR_CANNOT_OPEN_PAGE = "Cannot open the page";
	public static final String ERR_CANNOT_CLOSE_CONNECTION =
			"Cannot close a connection";
	public static final String ERR_CANNOT_CLOSE_RESULTSET =
			"Cannot close a result set";
	public static final String ERR_CANNOT_CLOSE_STATEMENT =
			"Cannot close a statement";
	public static final String ERR_CANNOT_CLOSE_PREPARED_STATEMENT =
			"Cannot close a prepared statement";
	public static final String ERR_CANNOT_ROLLBACK_TRANSACTION =
			"Cannot rollback transaction";
	public static final String EER_CANNOT_COMMIT_AND_CLOSE_TRANSACTION =
			"Cannot commit and close transaction";
	public static final String EER_CANNOT_ROLLBACK_AND_CLOSE_TRANSACTION =
			"Cannot rollback and close transaction";
}
