package dao;

import db.SQLConstants;
import entities.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static db.ConnectionPool.getConnection;

public class OrderDAO implements AbstractDAO<Order>{

    private static final Logger LOGGER = LogManager.getLogger(OrderDAO.class);

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        ResultSet rs;
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement()) {
            rs = stmt.executeQuery(SQLConstants.GET_ALL_ORDERS);
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getLong("order_id"));
                order.setDescription(rs.getString("description"));
                order.setShippingDate(rs.getDate("shipping_date"));
                order.setArivalDate(rs.getDate("arrival_date"));
                order.setCost(rs.getBigDecimal("cost"));
                orders.add(order);
            }
        } catch (SQLException ex) {
            LOGGER.error("SQLException");
        }
        return orders;
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
