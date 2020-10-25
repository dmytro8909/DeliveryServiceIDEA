package commands;

import dao.BillDAO;
import exception.AppException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateBillCommand implements ActionCommand {

    private static final String PARAM_NAME_ORDER_ID = "orderId";
    private static final String PARAM_NAME_USER_ID = "orderUserId";
    private static final String PARAM_NAME_DESCRIPTION = "orderDescription";
    private static final String PARAM_NAME_ADDRESS = "orderAddress";
    private static final String PARAM_NAME_DIRECTION_ID = "orderDirectionId";
    private static final String PARAM_NAME_DIRECTION = "orderDirection";
    private static final String PARAM_NAME_COST = "orderCost";
    private static final String PARAM_NAME_USER_NAME = "orderUserName";
    private static final String PARAM_NAME_SHIPPING_DATE = "orderShippingDate";

    BillDAO billDAO = new BillDAO();

    @Override
    public String execute(HttpServletRequest request) throws AppException, ParseException {
        String page = null;
        String oId = request.getParameter(PARAM_NAME_ORDER_ID);
        String oUId = request.getParameter(PARAM_NAME_USER_ID);
        String orderDescription = request.getParameter(PARAM_NAME_DESCRIPTION);
        String orderAddress = request.getParameter(PARAM_NAME_ADDRESS);
        String oDirId = request.getParameter(PARAM_NAME_DIRECTION_ID);
        String orderDirection = request.getParameter(PARAM_NAME_DIRECTION);
        String oCost = request.getParameter(PARAM_NAME_COST);
        String orderUserName = request.getParameter(PARAM_NAME_USER_NAME);
        String oSD = request.getParameter(PARAM_NAME_SHIPPING_DATE);

        int orderId = Integer.parseInt(oId);
        int orderUserId = Integer.parseInt(oUId);
        int orderDirectionId = Integer.parseInt(oDirId);
        BigDecimal orderCost = new BigDecimal(oCost);
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd");
        Date orderShippingDate = simpleDateFormat.parse(oSD);

        billDAO.insertBill(orderId, orderUserId, orderDirectionId,
                           orderDescription, orderAddress, orderDirection,
                           orderCost, orderShippingDate, orderUserName);

        if (request != null) {
            page = ConfigurationManager.getProperty("path.page.index");
        }
        return page;
    }
}
