package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class for connection pool realization
 * and implements Singleton-pattern.
 */
public class ConnectionPool {

	private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
	private static ConnectionPool instance = null;
	private static DataSource dataSource;

	/**
	 * Default constructor
	 */
	private ConnectionPool() {}

	static {
		Context initCtx;
		Context envCtx;
		try {
			initCtx = new InitialContext();
			envCtx = (Context) initCtx.lookup("java:comp/env");
		dataSource = (DataSource)envCtx.lookup("jdbc/DeliveryService");
		} catch (NamingException e) {
			LOGGER.error("NamingException", e);
		}
	}

	/**
	 * Synchronized method for getting the instance
	 * of connection pool just once;
	 * @return instance of connection pool.
	 */
	public static synchronized ConnectionPool getInstance() {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}

	/**
	 * Method for getting connection
	 * to the database.
	 * @return instance of connection.
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
		} 
		return connection;
	}
	
}
