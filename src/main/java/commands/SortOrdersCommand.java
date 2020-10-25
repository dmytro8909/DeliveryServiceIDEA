package commands;

import dao.OrderDAO;
import dao.UserDAO;
import entities.User;
import exception.AppException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class SortOrdersCommand implements ActionCommand {

    private static final Logger LOGGER = LogManager.getLogger(SortOrdersCommand.class);

    private static final String PARAM_NAME_SORT_NAME = "sortName";
    private static final String PARAM_NAME_USER_ID = "userId";
    private static OrderDAO orderDAO = new OrderDAO();
    private UserDAO userDAO = new UserDAO();

    @Override
    public String execute(HttpServletRequest request) throws AppException, ParseException {
        String page = null;
        Integer userId = Integer.parseInt(request.getParameter(PARAM_NAME_USER_ID));
        String sortName = request.getParameter(PARAM_NAME_SORT_NAME);

        if (sortName.equals("sortByShippingDate")) {
            request.getSession().setAttribute("userOrders",
                    orderDAO.getUserOrdersSortedByShippingDate(userId));
        } else if (sortName.equals("sortByCost")) {
            request.getSession().setAttribute("userOrders",
                    orderDAO.getUserOrdersSortedByCost(userId));
        } else {
            request.getSession().setAttribute("userOrders",
                    orderDAO.getUserOrders(userId));
        }
        page = ConfigurationManager.getProperty("path.page.index");
        return page;
    }
}
