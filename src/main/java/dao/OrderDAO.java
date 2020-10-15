package dao;

import db.DBManager;
import db.SQLConstants;
import entities.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static exception.Messages.*;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static db.ConnectionPool.getConnection;
import static exception.Messages.ERR_CANNOT_INSERT_PACKAGE;

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
                order.setId(rs.getLong("order_id"));
                order.setDescription(rs.getString("description"));
                order.setShippingDate(rs.getDate("shipping_date"));
                order.setCost(rs.getBigDecimal("cost"));
                orders.add(order);
            }
        } catch (SQLException ex) {
            LOGGER.error(ERR_CANNOT_GET_LIST_OF_ORDERS);
        } finally {
            dbManager.close(rs);
        }
        return orders;
    }

    public void insertOrder(String description,
                            String address,
                            Long directionId,
                            Date shippingDate,
                            BigDecimal cost,
                            Long userId) {

        Connection connection = null;
        PreparedStatement pstmt = null;
        int i = 0;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(SQLConstants.INSERT_ORDER);
            pstmt.setString(i++, description);
            pstmt.setString(i++, address);
            pstmt.setLong(i++, directionId);
            pstmt.setDate(i++, getDBdate(shippingDate));
            pstmt.setBigDecimal(i++, cost);
            pstmt.setLong(i++, userId);
            pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOGGER.error(ERR_CANNOT_INSERT_ORDER);
            dbManager.rollback(connection);
        } finally {
            dbManager.close(connection);
            dbManager.close(pstmt);
        }
    }

    private static java.sql.Date getDBdate( Date shDate) {
        Date date = new Date();
        return new java.sql.Date(date.getTime());
    }

    @Override
    public Order get(Long id) {
        return null;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public Order delete(Order order) {
        return null;
    }
}
