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

/**
 * Class for realizing a part of DAO-pattern.
 * Special for Bill entity.
 */
public class BillDAO implements AbstractDAO<Bill> {

    DBManager dbManager = new DBManager();
    private static final Logger LOGGER = LogManager.getLogger(BillDAO.class);

    /**
     * Method for getting list of all
     * bills from the database.
     * @return list of bills.
     */
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

    /**
     * Method for inserting new bill to the database.
     * @param orderId - order's id in the bill.
     * @param userId - user's id in the bill.
     * @param directionId - direction's id in the bill.
     * @param description - description in the bill.
     * @param address - address in the bill.
     * @param direction - direction in the bill.
     * @param cost - cost of the order.
     * @param shippingDate - shipping date of the order.
     * @param name - user's name.
     */
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

    /**
     * Method for transforming type of date.
     * @param shDate - date from java.util.Date;
     * @return date from java.sql.Date;
     */
    private static java.sql.Date getDBdate(Date shDate) {
        java.sql.Date sqlDate = new java.sql.Date(shDate.getTime());
        return sqlDate;
    }

    /**
     * Method for getting bill by order id.
     * @param orderId - order's id.
     * @return bill which was found.
     */
    public Bill getBillByOrderId(int orderId) {
        Bill bill = null;
        ResultSet rs = null;
        try (Connection connection = getConnection();
             PreparedStatement pstmt =
                     connection.prepareStatement(SQLConstants.GET_BILL_BY_ORDER_ID)) {
            pstmt.setInt(1, orderId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                bill = new Bill();
                bill.setId(rs.getInt("bill_id"));
                bill.setUserId(rs.getInt("orders_users_user_id"));
                bill.setDirectionId(rs.getInt("orders_directions_direction_id"));
                bill.setOrderDescription(rs.getString("order_description"));
                bill.setOrderAddress(rs.getString("order_address"));
                bill.setOrderDirection(rs.getString("order_direction"));
                bill.setOrderShippingDate(rs.getDate("order_shipping_date"));
                bill.setOrderCost(rs.getBigDecimal("order_cost"));
                bill.setOrderUserName(rs.getString("order_user_name"));
                bill.setStatus("status");
            }

        } catch (SQLException ex) {
            LOGGER.error(ERR_CANNOT_GET_BILL, ex);
        } finally {
            dbManager.close(rs);
        }
        return bill;
    }

    /**
     * Method for changing status of the bill.
     * @param billId - bill's id.
     */
    public void updateStatusOnPaid(int billId) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(SQLConstants.UPDATE_STATUS_ON_PAID);
            pstmt.setInt(1, billId);
            pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            LOGGER.error(ERR_CANNOT_UPDATE_BILL_STATUS, ex);
            dbManager.rollback(connection);
        } finally {
            dbManager.close(connection);
            dbManager.close(pstmt);
        }
    }

    /**
     * Method for getting a bill by id.
     * @param id - bill's id.
     * @return bill which was found.
     */
    @Override
    public Bill get(int id) {
        Bill bill = null;
        ResultSet rs = null;
        try (Connection connection = getConnection();
             PreparedStatement pstmt =
                     connection.prepareStatement(SQLConstants.GET_BILL_BY_ID)) {
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                bill = new Bill();
                bill.setId(rs.getInt("bill_id"));
                bill.setUserId(rs.getInt("orders_users_user_id"));
                bill.setDirectionId(rs.getInt("orders_directions_direction_id"));
                bill.setOrderDescription(rs.getString("order_description"));
                bill.setOrderAddress(rs.getString("order_address"));
                bill.setOrderDirection(rs.getString("order_direction"));
                bill.setOrderShippingDate(rs.getDate("order_shipping_date"));
                bill.setOrderCost(rs.getBigDecimal("order_cost"));
                bill.setOrderUserName(rs.getString("order_user_name"));
                bill.setStatus("status");
            }

        } catch (SQLException ex) {
            LOGGER.error(ERR_CANNOT_GET_BILL, ex);
        } finally {
            dbManager.close(rs);
        }
        return bill;
    }

    /**
     * Method for deleting the bill by id.
     * @param id - bill's id.
     */
    @Override
    public void delete(int id) {
        try (Connection connection = getConnection();
             PreparedStatement pstmt =
                     connection.prepareStatement(SQLConstants.GET_BILL_BY_ID)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.error(ERR_CANNOT_DELETE_BILL, ex);
        }
    }
}
