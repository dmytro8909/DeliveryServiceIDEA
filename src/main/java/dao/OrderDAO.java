package dao;

import db.DBManager;
import db.SQLConstants;
import entities.Order;
import entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static exception.Messages.*;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static db.ConnectionPool.getConnection;

public class OrderDAO implements AbstractDAO<Order>{

    DBManager dbManager = new DBManager();
    private static final Logger LOGGER = LogManager.getLogger(OrderDAO.class);

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        ResultSet rs = null;
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement()) {
            rs = stmt.executeQuery(SQLConstants.GET_ALL_ORDERS);
            while (rs.next()) {
                Order order = new Order();
                UserDAO userDAO = new UserDAO();
                DirectionDAO directionDAO = new DirectionDAO();
                String userName =
                        userDAO.getUserNameById(rs.getInt("users_user_id"));
                String direction =
                        directionDAO.getDirectionById(rs.getInt("directions_direction_id"));
                order.setId(rs.getInt("order_id"));
                order.setShippingDate(rs.getDate("shipping_date"));
                order.setDescription(rs.getString("description"));
                order.setAddress(rs.getString("address"));
                order.setCost(rs.getBigDecimal("cost"));
                order.setUserId(rs.getInt("users_user_id"));
                order.setUserName(userName);
                order.setDirectionId(rs.getInt("directions_direction_id"));
                order.setDirection(direction);
                orders.add(order);
            }
        } catch (SQLException ex) {
            LOGGER.error(ERR_CANNOT_GET_LIST_OF_ORDERS, ex);
        } finally {
            dbManager.close(rs);
        }
        return orders;
    }

    public List<Order> getUserOrders(int userId) {
        List<Order> orders = new ArrayList<>();
        ResultSet rs = null;
        try (Connection connection = getConnection();
             PreparedStatement pstmt =
                     connection.prepareStatement(SQLConstants.GET_USER_ORDERS)) {
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("order_id"));
                order.setShippingDate(rs.getDate("shipping_date"));
                order.setDescription(rs.getString("description"));
                order.setAddress(rs.getString("address"));
                order.setCost(rs.getBigDecimal("cost"));
                order.setUserId(rs.getInt("users_user_id"));
                order.setDirectionId(rs.getInt("directions_direction_id"));
                orders.add(order);
            }
        } catch (SQLException ex) {
            LOGGER.error(ERR_CANNOT_GET_LIST_OF_ORDERS, ex);
        } finally {
            dbManager.close(rs);
        }
        return orders;
    }

    public void insertOrder(String description,
                            String address,
                            Date shippingDate,
                            BigDecimal cost,
                            int userId,
                            int directionId) {

        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(SQLConstants.INSERT_ORDER);
            pstmt.setString(1, description);
            pstmt.setString(2, address);
            pstmt.setDate(3, getDBdate(shippingDate));
            pstmt.setBigDecimal(4, cost);
            pstmt.setInt(5, userId);
            pstmt.setInt(6, directionId);
            pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOGGER.error(ERR_CANNOT_INSERT_ORDER, e);
            dbManager.rollback(connection);
        } finally {
            dbManager.close(connection);
            dbManager.close(pstmt);
        }
    }

    private static java.sql.Date getDBdate(Date shDate) {
        java.sql.Date sqlDate = new java.sql.Date(shDate.getTime());
        return sqlDate;
    }

    @Override
    public Order get(int id) {
        Order order = null;
        ResultSet rs = null;
        try (Connection connection = getConnection();
             PreparedStatement pstmt =
                     connection.prepareStatement(SQLConstants.GET_ORDER_BY_ID)) {
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                order = new Order();
                UserDAO userDAO = new UserDAO();
                DirectionDAO directionDAO = new DirectionDAO();
                String userName =
                        userDAO.getUserNameById(rs.getInt("users_user_id"));
                String direction =
                        directionDAO.getDirectionById(rs.getInt("directions_direction_id"));
                order.setId(rs.getInt("order_id"));
                order.setShippingDate(rs.getDate("shipping_date"));
                order.setDescription(rs.getString("description"));
                order.setAddress(rs.getString("address"));
                order.setCost(rs.getBigDecimal("cost"));
                order.setUserId(rs.getInt("users_user_id"));
                order.setUserName(userName);
                order.setDirectionId(rs.getInt("directions_direction_id"));
                order.setDirection(direction);
            }

        } catch (SQLException ex) {
            LOGGER.error(ERR_CANNOT_GET_ORDER, ex);
        } finally {
            dbManager.close(rs);
        }
        return order;
    }

    @Override
    public void delete(int id) {
        try (Connection connection = getConnection();
             PreparedStatement pstmt =
                     connection.prepareStatement(SQLConstants.GET_ORDER_BY_ID)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.error(ERR_CANNOT_DELETE_ORDER, ex);
        }
    }

}
