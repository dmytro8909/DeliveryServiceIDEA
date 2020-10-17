package commands;

import dao.BillDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class CreateBillCommand implements ActionCommand {

    private static final Logger LOGGER = LogManager.getLogger(CreateBillCommand.class);

    private static final String PARAM_NAME_ORDER_ID = "orderId";
    private static final String PARAM_NAME_DESCRIPTION = "orderDescription";
    private static final String PARAM_NAME_ADDRESS = "orderAddress";
    private static final String PARAM_NAME_DIRECTION = "orderDirection";
    private static final String PARAM_NAME_COST = "orderCost";
    private static final String PARAM_NAME_USER_NAME = "orderUserName";
    private static final String PARAM_NAME_SHIPPING_DATE = "orderShippingDate";

    BillDAO billDAO = new BillDAO();

    @Override
    public String execute(HttpServletRequest request) throws Exception {
        String page = null;

        if (request != null) {
            page = ConfigurationManager.getProperty("path.page.create_bill");
        }
        return page;
    }
}
