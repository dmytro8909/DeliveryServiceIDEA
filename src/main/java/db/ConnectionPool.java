package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool {

	private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
	private static ConnectionPool instance = null;
	private static DataSource dataSource;

	private ConnectionPool() {}

	static {
		Context initCtx;
		Context envCtx;
		try {
			initCtx = new InitialContext();
			envCtx = (Context) initCtx.lookup("java:comp/env");
		// delivery_service - the name of data source
		dataSource = (DataSource)envCtx.lookup("jdbc/DeliveryService");
		} catch (NamingException e) {
			LOGGER.error("NamingException", e);
		}
	}

	public static synchronized ConnectionPool getInstance() {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}
	
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
