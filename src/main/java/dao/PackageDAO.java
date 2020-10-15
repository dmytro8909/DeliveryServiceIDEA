package dao;

import db.DBManager;
import db.SQLConstants;
import entities.Package;
import entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static exception.Messages.*;
import java.sql.*;
import java.util.List;

import static db.ConnectionPool.getConnection;

public class PackageDAO implements AbstractDAO<Package> {

    DBManager dbManager = new DBManager();
    private static final Logger LOGGER = LogManager.getLogger(PackageDAO.class);

    @Override
    public List<Package> getAll() {
        return null;
    }

    @Override
    public Package get(Long id) {
        Package pac = new Package();
        ResultSet rs = null;
        try (Connection connection = getConnection();
             PreparedStatement pstmt =
                     connection.prepareStatement(SQLConstants.GET_PACKAGE_BY_ID)) {
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                pac.setId(rs.getLong("package_id"));
                pac.setWeight(rs.getDouble("package_weight"));
                pac.setLength(rs.getDouble("package_length"));
                pac.setWidth(rs.getDouble("package_width"));
                pac.setHeight(rs.getDouble("package_height"));
            }
        } catch (SQLException ex) {
            LOGGER.error(ERR_CANNOT_GET_PACKAGE);
        } finally {
            dbManager.close(rs);
        }
        return pac;
    }

    public void insertPackage(Integer id, Double weight,
                              Double length,
                              Double width,
                              Double height) {

        int i = 0;
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(SQLConstants.INSERT_PACKAGE);
            pstmt.setInt(i++, id);
            pstmt.setDouble(i++, weight);
            pstmt.setDouble(i++, length);
            pstmt.setDouble(i++, width);
            pstmt.setDouble(i++, height);
            pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOGGER.error(ERR_CANNOT_INSERT_PACKAGE);
            dbManager.rollback(connection);
        } finally {
            dbManager.close(connection);
            dbManager.close(pstmt);
        }
    }

    @Override
    public Package update(Package aPackage) {
        return null;
    }

    @Override
    public Package delete(Package aPackage) {
        return null;
    }
}
