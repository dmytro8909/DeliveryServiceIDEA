package commands;

import dao.BillDAO;
import entities.Bill;
import exception.AppException;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Class for realizing specified business-logic
 * of command.
 */
public class ShowBillCommand implements ActionCommand {

    private static final String PARAM_NAME_ORDER_ID = "orderId";

    /**
     * Method for realizing specified business-logic
     * of command for displaying page with a bill.
     * @param request - an instance of HttpServletRequest with
     *                  request parameters;
     * @return path to the necessary page;
     * @throws AppException
     */
    @Override
    public String execute(HttpServletRequest request) throws AppException {
        String page = null;

        String oId = request.getParameter(PARAM_NAME_ORDER_ID);
        int orderId = Integer.parseInt(oId);

        BillDAO billDAO = new BillDAO();
        Bill bill = billDAO.getBillByOrderId(orderId);

        int id = 0;
        String description = "";
        Date date = null;
        String address = "";
        BigDecimal cost = new BigDecimal("0");
        int userId = 0;
        String userName = "";
        String direction = "";

        if (!bill.equals(null)) {
            id = bill.getId();
            description = bill.getOrderDescription();
            date = bill.getOrderShippingDate();
            address = bill.getOrderAddress();
            cost = bill.getOrderCost();
            userId = bill.getUserId();
            userName = bill.getOrderUserName();
            direction = bill.getOrderDirection();
        } else {
            throw new NullPointerException("Order equals null!");
        }

        if (request != null) {
            page = ConfigurationManager.getProperty("path.page.bill");
            request.setAttribute("billId", id);
            request.setAttribute("orderDescription", description);
            request.setAttribute("orderDate", date);
            request.setAttribute("orderAddress", address);
            request.setAttribute("orderCost", cost);
            request.setAttribute("orderUserId", userId);
            request.setAttribute("orderUserName", userName);
            request.setAttribute("orderDirection", direction);
        }

        return page;
    }
}
