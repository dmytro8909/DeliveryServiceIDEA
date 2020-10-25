package commands;

import dao.DirectionDAO;
import dao.OrderDAO;
import entities.Order;
import exception.AppException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;

public class OrderReviewCommand implements ActionCommand {

    private static final Logger LOGGER = LogManager.getLogger(OrderReviewCommand.class);
    private static final String PARAM_NAME_ORDER_ID = "orderId";

    @Override
    public String execute(HttpServletRequest request) throws AppException {
        String page = null;
        String oId = request.getParameter(PARAM_NAME_ORDER_ID);
        int orderId = Integer.parseInt(oId);
        OrderDAO orderDAO = new OrderDAO();

        Order order = orderDAO.get(orderId);

        int id = 0;
        String description = "";
        Date date = null;
        String address = "";
        BigDecimal cost = new BigDecimal("0");
        int userId = 0;
        String userName = "";
        int directionId = 0;
        String direction = "";

        if (!order.equals(null)) {
            id = order.getId();
            description = order.getDescription();
            date = order.getShippingDate();
            address = order.getAddress();
            cost = order.getCost();
            userId = order.getUserId();
            userName = order.getUserName();
            directionId = order.getDirectionId();
            direction = order.getDirection();
        } else {
            throw new NullPointerException("Order equals null!");
        }
        if (request != null) {
            page = ConfigurationManager.getProperty("path.page.order_review");
            request.setAttribute("orderId", id);
            request.setAttribute("orderDescription", description);
            request.setAttribute("orderDate", date);
            request.setAttribute("orderAddress", address);
            request.setAttribute("orderCost", cost);
            request.setAttribute("orderUserId", userId);
            request.setAttribute("orderUserName", userName);
            request.setAttribute("orderDirectionId", directionId);
            request.setAttribute("orderDirection", direction);
        }
        return page;
    }
}
