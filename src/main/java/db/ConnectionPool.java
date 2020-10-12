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

	private ConnectionPool() {}
	
	public static synchronized ConnectionPool getInstance() {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}
	
	public Connection getConnection() {
		Context initCtx;
		Context envCtx;
		Connection connection = null;
		try {
			initCtx = new InitialContext();
			envCtx = (Context) initCtx.lookup("java:comp/env");
			// delivery_service - the name of data source
			DataSource dataSource = 
					(DataSource)envCtx.lookup("jdbc/DeliveryService");
			connection = dataSource.getConnection();
		} catch (NamingException e) {
			LOGGER.error("Naming exception");
		} catch (SQLException e) {
			LOGGER.error("SQLException");
		} 
		return connection;
	}
	
}
