package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static exception.Messages.*;
import static db.ConnectionPool.getConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import db.SQLConstants;
import db.DBManager;
import entities.User;

public class UserDAO implements AbstractDAO<User> {
	
	private DBManager dbManager = new DBManager();
	private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		ResultSet rs = null;
		try (Connection connection = getConnection();
			 Statement stmt = connection.createStatement()) {
			
				rs = stmt.executeQuery(SQLConstants.GET_ALL_USERS);
				while (rs.next()) {
					User user = new User();
					user.setId(rs.getLong("user_id"));
					user.setName(rs.getString("name"));
					user.setLastName(rs.getString("last_name"));
					user.setLogin(rs.getString("login"));
					user.setPassword(rs.getString("password"));
					user.setRole(rs.getString("role"));
					user.setLocal(rs.getString("local"));
				}
			
		} catch (SQLException ex) {
			LOGGER.error(ERR_CANNOT_GET_LIST_OF_USERS);
		} finally {
			dbManager.close(rs);
		}
		return users;
	}

	@Override
	public User get(Long id) {
		return null;
	}

	@Override
	public User update(User user) {
		return null;
	}

	@Override
	public User delete(User user) {
		return null;
	}
	
	public User findUserByLogin(String login) {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(SQLConstants.SQL_FIND_USER_BY_LOGIN);
			pstmt.setString(1, login);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = extractUser(rs);
			}
		} catch (SQLException ex) {
			LOGGER.error(ERR_CANNOT_GET_USER);
			dbManager.rollback(connection);
		} finally {
			dbManager.close(connection, pstmt, rs);
		}
		return user;
	}
	
	private User extractUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("user_id"));
		user.setLogin(rs.getString("login"));
		user.setPassword(rs.getString("password"));
		user.setName(rs.getString("name"));
		user.setLastName(rs.getString("last_name"));
		user.setRole(rs.getString("role"));
		return user;
	}
	
	public void insertUser(String name, 
			               String lastName, 
			               String login,
			               String password) throws SQLException {

		int i = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(SQLConstants.INSERT_USER);
			pstmt.setString(i++, name);
			pstmt.setString(i++, lastName);
			pstmt.setString(i++, login);
			pstmt.setString(i++, password);
			pstmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			LOGGER.error(ERR_CANNOT_INSERT_USER);
			dbManager.rollback(connection);
		} finally {
			dbManager.close(connection);
			dbManager.close(pstmt);
		}
	}
	
}
