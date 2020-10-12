package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entities.User;
import exception.Messages;

public class DBManager {
	
	private ConnectionPool pool = ConnectionPool.getInstance();
	private static final Logger LOGGER = LogManager.getLogger(DBManager.class);

	public String getManagerLogin() {
		String login = null;
		try (Connection con = pool.getConnection();
			 Statement statement = con.createStatement();
			 ResultSet resultSet = 
					 statement.executeQuery(SQLConstants.FIND_MANAGER_LOGIN)) {
				
			if(resultSet.next()) {
    			login = resultSet.getString("login");
    		}	
			
		} catch (SQLException e) {
			LOGGER.error("SQLException");
		}
		return login;
	}
	
	public String getManagerPassword() {
		String password = null;
		try (Statement statement = 
				pool.getConnection().createStatement();
			 ResultSet resultSet = 
				statement.executeQuery(SQLConstants.FIND_MANAGER_PASSWORD)) {
				
			if(resultSet.next()) {
				password = resultSet.getString("password");
    		}	
			
		} catch (SQLException e) {
			LOGGER.error("SQLException");
		}
		return password;
	}
	
	
	
//	public String getUserLogin() {
//		
//	}
//	
//	public String getUserPassword() {
//		
//	}
	
	
	
	// //////////////////////////////////////////////////////////
	// DB util methods
	// //////////////////////////////////////////////////////////

	public void rollback(Connection con) {
		if (con != null) {
			try {
				con.rollback();
			} catch (SQLException ex) {
				LOGGER.error("Cannot rollback transaction", ex);
			}
		}
	}
	
	/**
	 * Closes a connection.
	 * 
	 * @param con
	 *            Connection to be closed.
	 */
	public void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException ex) {
				LOGGER.error(Messages.ERR_CANNOT_CLOSE_CONNECTION, ex);
			}
		}
	}

	/**
	 * Closes a statement object.
	 */
	public void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
				LOGGER.error(Messages.ERR_CANNOT_CLOSE_STATEMENT, ex);
			}
		}
	}
	
	public void close(PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException ex) {
				LOGGER.error(Messages.ERR_CANNOT_CLOSE_PREPARED_STATEMENT, ex);
			}
		}
	}
	
	/**
	 * Closes a result set object.
	 */
	public void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				LOGGER.error(Messages.ERR_CANNOT_CLOSE_RESULTSET, ex);
			}
		}
	}
	
	/**
	 * Closes resources.
	 */
	public void close(Connection con, Statement stmt, ResultSet rs) {
		close(rs);
		close(stmt);
		close(con);
	}
	
	/**
	 * Commits and close the given connection.
	 * 
	 * @param con
	 *            Connection to be committed and closed.
	 */
	public void commitAndClose(Connection con) {
		try {
			con.commit();
			con.close();
		} catch (SQLException ex) {
			LOGGER.error("SQLException");
		}
	}

	/**
	 * Rollbacks and close the given connection.
	 * 
	 * @param con
	 *            Connection to be rollbacked and closed.
	 */
	public void rollbackAndClose(Connection con) {
		try {
			con.rollback();
			con.close();
		} catch (SQLException ex) {
			LOGGER.error("SQLException");
		}
	}
	
}
