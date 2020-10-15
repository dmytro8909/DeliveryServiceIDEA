package dao;

import db.SQLConstants;
import entities.Rate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static exception.Messages.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import db.DBManager;
import static db.ConnectionPool.getConnection;


public class RatesDAO implements AbstractDAO<Rate>{

    DBManager dbManager = new DBManager();
    private static final Logger LOGGER = LogManager.getLogger(RatesDAO.class);

    @Override
    public List<Rate> getAll() {
        List<Rate> rates = new ArrayList<>();
        ResultSet rs = null;
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement()) {
            rs = stmt.executeQuery(SQLConstants.GET_ALL_RATES);
            while (rs.next()) {
                Rate rate = new Rate();
                rate.setId(rs.getLong("rates_id"));
                rate.setName(rs.getString("name"));
                rate.setRate(rs.getBigDecimal("rate"));
                rates.add(rate);
            }
        } catch (SQLException ex) {
            LOGGER.error(ERR_CANNOT_GET_LIST_OF_RATES);
        } finally {
            dbManager.close(rs);
        }
        return rates;
    }

    @Override
    public Rate get(Long id) {
        return null;
    }

    public BigDecimal getRateByName(String name) {
        ResultSet rs = null;
        Rate rate = new Rate();
        try (Connection connection = getConnection();
             PreparedStatement pstmt =
                     connection.prepareStatement(SQLConstants.GET_RATE_BY_NAME)) {
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                rate.setId(rs.getLong("rates_id"));
                rate.setName(rs.getString("name"));
                rate.setRate(rs.getBigDecimal("rate"));
            }
        } catch (SQLException ex) {
            LOGGER.error(ERR_CANNOT_GET_RATE);
        } finally {
            dbManager.close(rs);
        }
        return rate.getRate();
    }

    @Override
    public Rate update(Rate rate) {
        return null;
    }

    @Override
    public Rate delete(Rate rate) {
        return null;
    }

}
