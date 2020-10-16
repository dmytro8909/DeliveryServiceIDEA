package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DBManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import db.SQLConstants;
import entities.Direction;
import static db.ConnectionPool.getConnection;
import static exception.Messages.*;

public class DirectionDAO implements AbstractDAO<Direction> {

	DBManager dbManager = new DBManager();
	private static final Logger LOGGER = LogManager.getLogger(DirectionDAO.class);

	@Override
	public List<Direction> getAll() {
	List<Direction> directions = new ArrayList<>();
		ResultSet rs;
		try (Connection connection = getConnection();
			 Statement stmt = connection.createStatement()) {

				rs = stmt.executeQuery(SQLConstants.GET_ALL_DIRECTIONS);
				while (rs.next()) {
					Direction direction = new Direction();
					direction.setId(rs.getInt("direction_id"));
					direction.setDirection(rs.getString("direction"));
					direction.setDistance(rs.getInt("distance"));
					directions.add(direction);
				}
			} catch (SQLException ex) {
				LOGGER.error(ERR_CANNOT_GET_LIST_OF_DIRECTIONS);
			}
			return directions;
	}

	public int getDistanceById(int id) {
		Direction direction = null;
		ResultSet rs = null;
		try (Connection connection = getConnection();
			 PreparedStatement pstmt =
					 connection.prepareStatement(SQLConstants.GET_DISTANCE_BY_ID)) {
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				direction = new Direction();
				direction.setId(rs.getInt("direction_id"));
				direction.setDirection(rs.getString("direction"));
				direction.setDistance(rs.getInt("distance"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ERR_CANNOT_GET_DISTANCE);
		} finally {
			dbManager.close(rs);
		}
		return direction.getDistance();
	}

	@Override
	public Direction get(int id) {
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
