package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import db.ConnectionPool;
import db.SQLConstants;
import entities.Direction;

public class DirectionDAO implements AbstractDAO<Direction> {

	private static final Logger LOGGER = LogManager.getLogger(DirectionDAO.class);
	
	public DirectionDAO() {}
	
	@Override
	public List<Direction> getAll() {
		List<Direction> directions = new ArrayList<>();
		ResultSet rs = null;
		ConnectionPool pool = ConnectionPool.getInstance();
		try (Connection connection = pool.getConnection();
				 Statement stmt = connection.createStatement()) {
				
				rs = stmt.executeQuery(SQLConstants.GET_ALL_DIRECTIONS);
				while (rs.next()) {
					Direction direction = new Direction();
					direction.setId(rs.getLong("direction_id"));
					direction.setDirection(rs.getString("direction"));
					directions.add(direction);
				}
			} catch (SQLException ex) {
				LOGGER.error("SQLException");
			}
			return directions;
	}

	@Override
	public Direction get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Direction update(Direction t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Direction delete(Direction t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
