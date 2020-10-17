package dao;

import db.DBManager;
import db.SQLConstants;
import entities.Bill;
import entities.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static db.ConnectionPool.getConnection;
import static exception.Messages.*;

public class BillDAO implements AbstractDAO<Bill> {

    DBManager dbManager = new DBManager();
    private static final Logger LOGGER = LogManager.getLogger(BillDAO.class);

    @Override
    public List<Bill> getAll() {
        List<Bill> bills = new ArrayList<>();
        ResultSet rs = null;
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement()) {
            rs = stmt.executeQuery(SQLConstants.GET_ALL_BILLS);
            while (rs.next()) {
                Bill bill = new Bill();
                Order order = new Order();
                UserDAO userDAO = new UserDAO();
                DirectionDAO directionDAO = new DirectionDAO();
                String userName =
                        userDAO.getUserNameById(rs.getInt("users_user_id"));
                String direction =
                        directionDAO.getDirectionById(rs.getInt("directions_direction_id"));
                bill.setId(rs.getInt("bill_id"));
                bill.setOrderId(rs.getInt("orders_order_id"));
                bill.setOrderShippingDate(rs.getDate("order_shipping_date"));
                bill.setOrderDescription(rs.getString("order_description"));
                bill.setOrderAddress(rs.getString("order_address"));
                bill.setOrderCost(rs.getBigDecimal("order_cost"));
                bill.setUserId(rs.getInt("orders_users_user_id"));
                bill.setOrderUserName(userName);
                bill.setDirectionId(rs.getInt("orders_directions_direction_id"));
                bill.setOrderDirection(direction);
                bills.add(bill);
            }
        } catch (SQLException ex) {
            LOGGER.error(ERR_CANNOT_GET_LIST_OF_BILLS, ex);
        } finally {
            dbManager.close(rs);
        }
        return bills;
    }

    public void insertBill(int orderId, int userId,
                           int directionId, String description,
                           String address, String direction,
                           BigDecimal cost, Date shippingDate,
                           String name) {

        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(SQLConstants.INSERT_BILL);
            pstmt.setInt(1, orderId);
            pstmt.setInt(2, userId);
            pstmt.setInt(3, directionId);
            pstmt.setString(4, description);
            pstmt.setString(5, address);
            pstmt.setString(6, direction);
            pstmt.setBigDecimal(7, cost);
            pstmt.setDate(8, getDBdate(shippingDate));
            pstmt.setString(9, name);
            pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOGGER.error(ERR_CANNOT_INSERT_BILL, e);
            dbManager.rollback(connection);
        } finally {
            dbManager.close(connection);
            dbManager.close(pstmt);
        }
    }

    private static java.sql.Date getDBdate(Date shDate) {
        Date date = new Date();
        return new java.sql.Date(date.getTime());
    }

    @Override
    public Bill get(int id) {
        return null;
    }

    @Override
    public Bill update(Bill bill) {
        return null;
    }

    @Override
    public Bill delete(Bill bill) {
        return null;
    }
}
